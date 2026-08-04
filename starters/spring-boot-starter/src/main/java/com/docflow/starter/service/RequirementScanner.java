package com.docflow.starter.service;

import com.docflow.starter.model.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequirementScanner {

    @Autowired
    private SyncService syncService;

    private List<Requirement> requirements = new ArrayList<>();

    @PostConstruct
    public void scan() {
        File folder = new File("src/main/resources/requirements");
        if (!folder.exists()) {
            folder.mkdirs();
            return;
        }

        try (Stream<Path> paths = Files.walk(folder.toPath())) {
            List<Path> markdownFiles = paths
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".md"))
                .collect(Collectors.toList());

            for (Path path : markdownFiles) {
                String content = Files.readString(path);
                String fileName = path.getFileName().toString();
                
                String title = fileName.replace(".md", "");
                
                Requirement req = new Requirement();
                req.setId(fileName.replace(".md", ""));
                req.setTitle(title);
                req.setContentMarkdown(content);
                req.setStatus("PENDING");
                req.setPriority("MEDIUM");
                
                requirements.add(req);
            }
            
            // Sincroniza com o Core Platform automaticamente
            syncService.syncRequirements(requirements);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }
}

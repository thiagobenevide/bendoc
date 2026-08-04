package com.docflow.starter.service;

import com.docflow.starter.model.Requirement;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class SyncService {

    private final RestTemplate restTemplate;
    private final String coreUrl = "http://localhost:9090/docflow/requirements";

    public SyncService() {
        this.restTemplate = new RestTemplate();
    }

    public void syncRequirements(List<Requirement> requirements) {
        for (Requirement req : requirements) {
            try {
                String response = restTemplate.postForObject(coreUrl, req, String.class);
                System.out.println("Synced: " + req.getId() + " | Response: " + response);
            } catch (Exception e) {
                System.err.println("Failed to sync requirement " + req.getId() + ": " + e.getMessage());
            }
        }
    }
}

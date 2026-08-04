package com.docflow.starter.controller;

import com.docflow.starter.model.Requirement;
import com.docflow.starter.service.RequirementScanner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/docflow")
public class RequirementController {

    private final RequirementScanner scanner;

    public RequirementController(RequirementScanner scanner) {
        this.scanner = scanner;
    }

    @GetMapping("/requirements")
    public List<Requirement> getRequirements() {
        return scanner.getRequirements();
    }
}

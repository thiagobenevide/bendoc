package com.docflow.starter.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Requirement {
    private String id;
    private String title;
    private String description;
    private String contentMarkdown;
    private String priority;
    private String status;
    private List<Connection> connections;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Connection {
        private String targetId;
        private String type; // ex: "implements", "depends_on", "conflicts_with"
    }
}

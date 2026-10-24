package com.example.task_manager.dto;

import jakarta.validation.constraints.Size;

public record UpdateTaskRequest(
        @Size(max=255) String title,
        @Size(max=2000) String description,
        Boolean completed) {
}

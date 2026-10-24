package com.example.task_manager.dto;

import com.example.task_manager.model.TaskEntity;

import java.time.Instant;

public record TaskResponse(Long id, String title, String description, boolean completed, Instant createdAt) {
    public static TaskResponse from(TaskEntity task){
        return new TaskResponse(task.getId(), task.getTitle(), task.getDescription(),
                task.isCompleted(), task.getCreatedAt());
    }
}

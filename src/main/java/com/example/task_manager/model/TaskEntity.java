package com.example.task_manager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "Tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(name = "status")
    private boolean completed;

    @Column
    private Instant createdAt;

    public TaskEntity(){}

    public TaskEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
    @PrePersist
    void onCreate(){
        if (createdAt == null) createdAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public boolean isCompleted() {return completed;}

    public void setCompleted(boolean completed) {this.completed = completed;}

    public Instant getCreatedAt() {return createdAt;}

    public void setCreatedAt(Instant createdAt) {this.createdAt = createdAt;}
}

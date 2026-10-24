package com.example.task_manager.repository;

import com.example.task_manager.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByCompleted(boolean completed);
}

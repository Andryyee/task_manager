package com.example.task_manager.service;

import com.example.task_manager.dto.CreateTaskRequest;
import com.example.task_manager.dto.TaskResponse;
import com.example.task_manager.dto.UpdateTaskRequest;
import com.example.task_manager.exception.TaskNotFoundException;
import com.example.task_manager.model.TaskEntity;
import com.example.task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    private TaskEntity getOrThrow(Long id){ return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id)); }

    @Transactional
    public TaskResponse create(CreateTaskRequest req) {
        TaskEntity task = new TaskEntity(req.title(), req.description());
        return TaskResponse.from(repository.save(task));
    }

    @Transactional(readOnly = true)
    public List<TaskResponse> findAll(Boolean completed){
        List<TaskEntity> tasks = completed == null ?
                repository.findAll()
                : repository.findByCompleted(completed);
        return tasks.stream().map(TaskResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public TaskResponse findById(Long id){
        return TaskResponse.from(getOrThrow(id));
    }

    @Transactional
    public TaskResponse updateTask(Long id, UpdateTaskRequest req){
        TaskEntity task = getOrThrow(id);
        if (req.title() != null) task.setTitle(req.title());
        if (req.description() != null) task.setDescription(req.description());
        if (req.completed() != null) task.setCompleted(req.completed());
        return TaskResponse.from(task);
    }

    @Transactional
    public void deleteById(Long id){
        repository.delete(getOrThrow(id));
    }
}

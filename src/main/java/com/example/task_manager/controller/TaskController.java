package com.example.task_manager.controller;

import com.example.task_manager.dto.CreateTaskRequest;
import com.example.task_manager.dto.TaskResponse;
import com.example.task_manager.dto.UpdateTaskRequest;
import com.example.task_manager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Задача", description = "Каталог задач")
@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @Operation(summary = "Найти все записи задач")
    @ApiResponse(responseCode = "200", description = "Задачи найдены (или задач нет, тода пустой список)")
    @ApiResponse(responseCode = "400", description = "Неверный запрос")
    @GetMapping("/tasks")
    public List<TaskResponse> findAll(@RequestParam(required = false) Boolean completed){ return service.findAll(completed); }

    @Operation(summary = "Найти задачу по id")
    @ApiResponse(responseCode = "200", description = "Задача найдена")
    @ApiResponse(responseCode = "400", description = "Неверный запрос")
    @ApiResponse(responseCode = "404", description = "Задача не найдена",
            content = @Content(mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetail.class)))
    @GetMapping("/tasks/{id}")
    public TaskResponse findById(@PathVariable Long id) { return service.findById(id); }

    @Operation(summary = "Создать задачу")
    @ApiResponse(responseCode = "201", description = "Задача создана")
    @ApiResponse(responseCode = "400", description = "Неверный запрос")
    @PostMapping("/tasks")
    public ResponseEntity<TaskResponse> create(@Valid @RequestBody CreateTaskRequest req){
        TaskResponse created = service.create(req);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id(), created.createdAt())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @Operation(summary = "Изменить задачу")
    @ApiResponse(responseCode = "200", description = "Задача изменена")
    @ApiResponse(responseCode = "400", description = "Неверный запрос",
            content = @Content(mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetail.class)))
    @ApiResponse(responseCode = "404", description = "Задача не найдена",
            content = @Content(mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetail.class)))
    @ApiResponse(responseCode = "409", description = "Конфликт версий",
            content = @Content(mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetail.class)))
    @PatchMapping("/tasks/{id}")
    public TaskResponse update(@PathVariable Long id, @Valid @RequestBody UpdateTaskRequest req){
        return service.updateTask(id, req);
    }

    @Operation(summary = "Удалить задачу")
    @ApiResponse(responseCode = "204", description = "Задача удалена")
    @ApiResponse(responseCode = "404", description = "Задача не найдена",
    content = @Content(mediaType = "application/problem+json",
            schema = @Schema(implementation = ProblemDetail.class)))
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

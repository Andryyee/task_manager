package com.example.task_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class TaskManagerApplication {
    private Map<Long, BookResponse> records;
    private List<Book> books;
    static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }
}

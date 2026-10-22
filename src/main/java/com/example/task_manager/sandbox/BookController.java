package com.example.task_manager.sandbox;

import com.example.task_manager.sandbox.hello.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/sandbox")
public class BookController {
    private final MemoryBookService service;

    public BookController(MemoryBookService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public Greeting getGreeting(@RequestParam String name){ return new Greeting(name, Instant.now());}
}

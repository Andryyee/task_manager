package com.example.task_manager.sandbox;

import com.example.task_manager.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GreetingRunner implements CommandLineRunner {
    private Greeter greet;
    private MemoryBookService service;

    public GreetingRunner(Greeter greet, MemoryBookService service) {
        this.greet = greet;
        this.service = service;
    }

    @Override
    public void run(String[] args){
        String name = "Андрей";
        System.out.println(greet.greet(name));
    }
}

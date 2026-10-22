package com.example.task_manager.sandbox;

import org.springframework.stereotype.Component;

@Component
public class RussianGreeter implements Greeter {
    public String greet(String name){
        return "Привет, " + name + "!";
    }
}

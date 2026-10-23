package com.example.task_manager.sandbox.hello;

import jakarta.persistence.*;

@Entity
@Table(name = "Notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String text;

    protected Note(){}
}

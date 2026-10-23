package com.example.task_manager.sandbox.books;

import com.example.task_manager.sandbox.echo.Genre;

public record CreateBookRequest(String title, String annotation, Genre genre) {}

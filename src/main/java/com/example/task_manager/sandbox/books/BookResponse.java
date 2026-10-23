package com.example.task_manager.sandbox.books;

import com.example.task_manager.sandbox.echo.Genre;

public record BookResponse(Long id, String title, String annotation, Genre genre, boolean available) {
    public static BookResponse from(Book b){
        return new BookResponse(b.getId(), b.getTitle(), b.getAnnotation(),
                b.getGenre(), b.isAvailable());
    }
}

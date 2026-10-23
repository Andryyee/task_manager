package com.example.task_manager.sandbox.books;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Книга с id: " + id + " не существует");
    }
}

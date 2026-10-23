package com.example.task_manager.sandbox.books;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MemoryBookService {
    private final MemoryBookStore repository;

    public MemoryBookService(MemoryBookStore repository) {
        this.repository = repository;
    }

    public Book save(Book book){
        return repository.save(book);
    }
    public Book findById(Long id) { return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id)); }
    public List<Book> findAll(){ return repository.findAll(); }
    public void deleteById(Long id) {
        if (repository.findById(id).isEmpty()) throw new BookNotFoundException(id);
        repository.deleteById(id);
    }
    public Book update(Long id, UpdateBookRequest request){
        Book book = findById(id);
        if (request.title() != null) book.setTitle(request.title());
        if (request.available() != null) book.setAvailable(request.available());
        return repository.save(book);
    }
    public Book create(CreateBookRequest request){
        Book book = new Book(request.title(), request.annotation());
        return repository.save(book);
    }
}

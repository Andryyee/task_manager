package com.example.task_manager.sandbox;

import com.example.task_manager.Book;
import org.springframework.stereotype.Service;

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
}

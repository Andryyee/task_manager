package com.example.task_manager.sandbox;

import com.example.task_manager.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryBookStore {
    private final Map<Long, Book> storage = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public Book save(Book book){
        if (book.getId() == null) book.setId(nextId.getAndIncrement());
        storage.put(book.getId(), book);
        return book;
    }
    public Optional<Book> findById(Long id) { return Optional.ofNullable(storage.get(id)); }
    public List<Book> findAll(){ return storage.values().stream().toList(); }
    public void deleteById(Long id) { storage.remove(id); }
}

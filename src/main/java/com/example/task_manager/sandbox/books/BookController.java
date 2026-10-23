package com.example.task_manager.sandbox.books;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/sandbox")
public class BookController {
    private final MemoryBookService service;

    public BookController(MemoryBookService service) {
        this.service = service;
    }

    @PatchMapping("/books/{id}")
    public BookResponse update(@PathVariable Long id, @RequestBody UpdateBookRequest request){
        return BookResponse.from(service.update(id, request));
    }

    @PostMapping("/books")
    public ResponseEntity<BookResponse> create(@RequestBody CreateBookRequest request){
        Book book = service.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();
        return ResponseEntity.created(location).body(BookResponse.from(book));
    }
}

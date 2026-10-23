package com.example.task_manager.sandbox.hello;

import com.example.task_manager.sandbox.books.Book;
import com.example.task_manager.sandbox.books.BookResponse;
import com.example.task_manager.sandbox.books.UpdateBookRequest;
import com.example.task_manager.sandbox.echo.CreateBookRequest;
import com.example.task_manager.sandbox.echo.Genre;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/sandbox")
public class HelloController {
    @GetMapping("/hello")
    public Greeting getGreeting(@RequestParam(defaultValue = "мир") String name){ return new Greeting("Привет, "
            + name + "!", Instant.now());}

    @PostMapping("/echo")
    public CreateBookRequest echo(@RequestBody CreateBookRequest request){
        return request;
    }

    @GetMapping("/book")
    public Book getBook(){
        Book book = new Book("A", "a");
        return book;
    }

    @GetMapping("/bookfrom")
    public BookResponse getBookFrom(){
        Book book = new Book("A", "a");
        return BookResponse.from(book);
    }
}

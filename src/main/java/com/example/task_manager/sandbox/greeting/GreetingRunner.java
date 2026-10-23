package com.example.task_manager.sandbox.greeting;

import com.example.task_manager.sandbox.books.Book;
import com.example.task_manager.sandbox.books.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GreetingRunner implements CommandLineRunner {
    private final Greeter greet;
    private final BookRepository repo;

    public GreetingRunner(Greeter greet, BookRepository repo) {
        this.greet = greet;
        this.repo = repo;
    }

    @Override
    public void run(String[] args){
        String name = "Андрей";
        System.out.println(greet.greet(name));
        Book book = new Book("A", "a");
        System.out.println("Book id: " + book.getId());
        Book saved = repo.save(book);
        System.out.println("Saved id: " + saved.getId());
        Book book1 = new Book("B", "b");
        Book book2 = new Book("C", "c");
        Book saved1 = repo.save(book1);
        Book saved2 = repo.save(book2);
        System.out.println(repo.count() + " " + repo.findAll());
        repo.deleteById(999L);
    }
}

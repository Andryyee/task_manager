package com.example.task_manager.sandbox.books;

import com.example.task_manager.sandbox.echo.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAvailable(boolean available);

    List<Book> findByGenreOrderByTitleAsc(Genre genre);

    List<Book> findByTitleContainingIgnoreCase(String part);

    boolean existsByTitle(String title);

    long countByAvailableFalse();
}

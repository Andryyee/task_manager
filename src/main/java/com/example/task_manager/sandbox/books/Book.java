package com.example.task_manager.sandbox.books;

import com.example.task_manager.sandbox.echo.Genre;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String title;
    @Column(length = 200)
    private String author;
    @Column(length = 2000)
    private String annotation;
    @Column(name = "publication_year")
    private Integer year;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Genre genre;
    @Column(nullable = false)
    private boolean available;
    @Column(nullable = false)
    private Instant addedAt;

    protected Book(){}

    public Book(String title, String annotation) {
        this.available = true;
        this.title = title;
        this.annotation = annotation;
    }

    @PrePersist
    void onCreate(){
        if (addedAt == null) addedAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Instant getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Instant addedAt) {
        this.addedAt = addedAt;
    }
}

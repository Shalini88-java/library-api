package com.example.demo.dto;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="book")
public class Book {

    @GeneratedValue(strategy = AUTO)
    @Column(name="id")
    @Id
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="author")
    private String author;

    @Column(name="library_id")
    private Long library_id;

    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false,insertable = false,updatable = false)
    private Library library;

    public Long getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(Long library_id) {
        this.library_id = library_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}

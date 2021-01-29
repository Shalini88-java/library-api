package com.example.demo.dto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="library")
public class Library {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long id;

    @Column(name="name")
    public String name;
    @Column(name="description")
    public String description;

    @OneToMany(mappedBy = "library")
    Set<Book> books;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

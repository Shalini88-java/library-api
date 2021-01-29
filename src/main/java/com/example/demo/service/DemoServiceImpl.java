package com.example.demo.service;

import com.example.demo.dto.Book;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.Library;
import com.example.demo.dto.LibraryDto;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LibraryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DemoServiceImpl implements  DemoService{
    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;
    @Override
    public List<LibraryDto> getAllLibrary() {
        Iterable<Library> libraries= libraryRepository.findAll();
        List<Library> result =
                StreamSupport.stream(libraries.spliterator(), false)
                        .collect(Collectors.toList());
        List<LibraryDto> librariesDto = new ArrayList<>();
        for (Library lib : result){
            LibraryDto libraryDto = new LibraryDto();
            libraryDto.setId(lib.getId());
            libraryDto.setName(lib.getName());
            libraryDto.setDescription(lib.getDescription());
            librariesDto.add(libraryDto);
        }
        return librariesDto;
    }

    @Override
    public Set<BookDto> getBooksForLibrary(String libraryid) {
        Optional<Library> libraryOptional = libraryRepository.findById(Long.parseLong(libraryid));
        if(libraryOptional.isPresent()){
            Library library = libraryOptional.get();
            Set<Book> books= library.getBooks();
            Set<BookDto> bookDtos = new HashSet<>();
            for(Book book : books){
                BookDto bookDto = new BookDto();
                bookDto.setId(book.getId());
                bookDto.setName(book.getName());
                bookDto.setAuthor(book.getAuthor());
                bookDto.setLibrary_id(book.getLibrary_id());
                bookDtos.add(bookDto);
            }
            return bookDtos;
        }
        return null;
    }

    @Override
    public BookDto getBook(String bookId) {
        Optional<Book> bookOptional = bookRepository.findById(Long.parseLong(bookId));
        if(bookOptional.isPresent()){
            Book book = bookOptional.get();
            BookDto bookDto = new BookDto();
            bookDto.setId(book.getId());
            bookDto.setName(book.getName());
            bookDto.setAuthor(book.getAuthor());
            bookDto.setLibrary_id(book.getLibrary_id());
            return bookDto;
        }
        return null;
    }

    @Override
    public Long createBook(Book book) {
        bookRepository.save(book);
        return book.getId();
    }

    @Override
    public Long updateBook(Book book) {
        bookRepository.save(book);
        return book.getId();
    }

    @Override
    public Long createLibrary(Library library) {
        libraryRepository.save(library);
        return library.getId();
    }
}

package com.example.demo.service;

import com.example.demo.dto.Book;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.Library;
import com.example.demo.dto.LibraryDto;


import java.util.List;
import java.util.Set;

public interface DemoService {
    List<LibraryDto> getAllLibrary();

    Set<BookDto> getBooksForLibrary(String libraryid);

    BookDto getBook(String bookId);

    Long createBook(Book book);

    Long updateBook(Book book);

    Long createLibrary(Library library);
}

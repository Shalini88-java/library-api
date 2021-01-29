package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.Library;
import com.example.demo.dto.LibraryDto;
import com.example.demo.service.DemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Book;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin({"http://localhost:4201","http://localhost:4200"})
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping("/v1/library")
    public ResponseEntity<List<LibraryDto>> getAllLibrary(){
        List<LibraryDto> libraries = demoService.getAllLibrary();
        if(null != libraries && !libraries.isEmpty()){
            return  new ResponseEntity<List<LibraryDto>>(libraries, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/v1/library")
    public ResponseEntity<Long> createLibrary(@RequestBody Library library){
        Long id = demoService.createLibrary(library);

        return new ResponseEntity<Long>(id,HttpStatus.CREATED);
    }


    @GetMapping("/v1/library/{libraryid}/books")
    public ResponseEntity<Set<BookDto>> getAllBooksForLibrary(@PathVariable(name ="libraryid")String libraryid){
        Set<BookDto> books = demoService.getBooksForLibrary(libraryid);
        if(null != books && !books.isEmpty()){
            return  new ResponseEntity<Set<BookDto>>(books, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/v1/books/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable(name ="id")String bookId){
        BookDto book = demoService.getBook(bookId);
        return  new ResponseEntity<BookDto>(book, HttpStatus.OK);

    }

    @PostMapping("/v1/books")
    public ResponseEntity<Long> createBook(@RequestBody Book book){
        Long bookId = demoService.createBook(book);
        return  new ResponseEntity<Long>(bookId, HttpStatus.CREATED);

    }

    @PutMapping("/v1/books/{id}")
    public ResponseEntity<Long> updateBook(@PathVariable(name ="id")String bookId,@RequestBody Book book){
        book.setId(Long.parseLong(bookId));
        demoService.updateBook(book);
        return  new ResponseEntity<Long>(book.getId(), HttpStatus.OK);
    }
}

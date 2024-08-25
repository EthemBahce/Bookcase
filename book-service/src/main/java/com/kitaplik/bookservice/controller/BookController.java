package com.kitaplik.bookservice.controller;


import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.bookservice.dto.BookIdDto;
import com.kitaplik.bookservice.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {


    Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping(value = "/isbn/{isbn}", produces="application/json")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable(value = "isbn")  String isbn){

       logger.info("Book requested by isbn :" + isbn);
       return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @GetMapping(value = "/book/{bookId}", produces="application/json")
    public ResponseEntity<BookDto> getBookById(@PathVariable(value = "bookId")  String bookId){

        return ResponseEntity.ok(bookService.findBookDetailsById(bookId));
    }

}

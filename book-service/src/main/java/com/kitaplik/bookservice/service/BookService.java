package com.kitaplik.bookservice.service;


import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.bookservice.dto.BookIdDto;
import com.kitaplik.bookservice.exception.BookNotFoundException;
import com.kitaplik.bookservice.mapper.BookMapper;
import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository repository;
    private BookMapper bookMapper;




    public BookService(BookRepository repository, BookMapper bookMapper){
        this.repository = repository;
        this.bookMapper = bookMapper;
    }

    public List<BookDto> getAllBooks(){
                return repository.findAll()
                .stream()
                .map(BookMapper.INSTANCE::bookToBookDto)
                .collect(Collectors.toList());


}

   public BookIdDto findByIsbn(String isbn){
        return repository.getBookByIsbn(isbn)
                .map(book -> new BookIdDto(book.getBookId(), book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn:" + isbn));
   }

   public BookDto findBookDetailsById(String bookId){

       return  repository.findById(bookId)
                .map(BookMapper.INSTANCE::bookToBookDto)
                .orElseThrow(()-> new BookNotFoundException("Book could not found by BookId: " + bookId));
   }

}
//BookMapperImpl.INSTANCE::bookToBookDto
//.map(BookMapper.INSTANCE::bookToBookDto)
//.map(X-> BookMapper.INSTANCE.bookToBookDto(X))
//.map(bookMapper::bookToBookDto)
// .map(X-> BookMapperImpl.INSTANCE.bookToBookDto(X))
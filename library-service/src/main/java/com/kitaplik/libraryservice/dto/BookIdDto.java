package com.kitaplik.libraryservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookIdDto {

     private String bookId;

     private String isbn;

    public BookIdDto() {
    }

    public BookIdDto(String bookId, String isbn) {

        this.bookId = bookId;
        this.isbn = isbn;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

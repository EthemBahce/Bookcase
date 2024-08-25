package com.kitaplik.bookservice.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
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

    @Override
    public String toString() {
        return "BookIdDto{" +
                "bookId='" + bookId + '\'' +
                ", title='" + isbn + '\'' +
                '}';
    }
}

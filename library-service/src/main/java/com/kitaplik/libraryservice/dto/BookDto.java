package com.kitaplik.libraryservice.dto;


import lombok.*;

@Data
@Builder
public class BookDto {

    private String id;

    private String title;

    private int bookYear;

    private String author;

    private String pressName;

    private String isbn;

    public  BookDto(){}

    public BookDto(BookIdDto bookIdDto){

        this.id = bookIdDto.getBookId();
        this.isbn = bookIdDto.getIsbn();

    }

    public BookDto(String bookId, String title, int bookYear, String author, String pressName) {
        this.id = bookId;
        this.title = title;
        this.bookYear = bookYear;
        this.author = author;
        this.pressName = pressName;
    }

    public String getBookId() {
        return id;
    }

    public void setBookId(String bookId) {
        this.id = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName;
    }
}

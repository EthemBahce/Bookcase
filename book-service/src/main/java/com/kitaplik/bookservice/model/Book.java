package com.kitaplik.bookservice.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "books")
@Builder
public class Book {


@Id
@GeneratedValue(generator = "UUID")
@Getter
@Setter
@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
private String bookId;
private String title;

private int bookYear;

private String author;

private String pressName;

private String isbn;

    public Book() {
    }

    public Book(String bookId, String title, int bookYear, String author, String pressName, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.bookYear = bookYear;
        this.author = author;
        this.pressName = pressName;
        this.isbn = isbn;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

package com.kitaplik.libraryservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library")
@Builder
public class Library {

    @Id
    @Column(name = "library_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ElementCollection
    @Column(name = "userBook")
    private List<String> userBooklist = new ArrayList<String>();

    public Library() {
    }

    public Library(String id, List<String> userBooklist) {
        this.id = id;
        this.userBooklist = userBooklist;
    }

    public String getId() {
        return id;
    }

    public void setId(String bookId) {
        this.id = id;
    }

    public List<String> getUserBook() {
        return userBooklist;
    }

    public void setUserBook(List<String> userBooklist) {
        this.userBooklist = userBooklist;
    }
}

package org.library.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private Long isbn;

    public Book(String title, String author, Long isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void displayDetails(){
        System.out.println("Title: " + this.getTitle());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("ISBN: " + Long.toString(this.getIsbn()));
    }
}

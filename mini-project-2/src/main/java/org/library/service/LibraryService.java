package org.library.service;

import org.library.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryService {
    List<Book> bookList = new ArrayList<Book>();

    public void addBook(Book book) {
        for (Book existingBook : bookList){
            if (existingBook.getTitle().equals(book.getTitle()) || existingBook.getIsbn().equals(book.getIsbn()))
                throw new RuntimeException("This book already exists.");
        }
        bookList.add(book);
        System.out.println("Book added to library.");
    }

    public void removeBook(Book forRemoval) {
        Book toRemove = null;
        for (Book book : bookList){
            if (Objects.nonNull(forRemoval.getTitle())) {
                if (book.getTitle().equals(forRemoval.getTitle())){
                    toRemove = book;
                    break;
                }
            } else if(Objects.nonNull(forRemoval.getIsbn())) {
                if (book.getIsbn().equals(forRemoval.getIsbn())){
                    toRemove = book;
                    break;
                }
            }
        }
        if (Objects.equals(toRemove,null))
            throw new NullPointerException("Sorry, the book you're trying to remove is not here.");
        else {
            bookList.remove(toRemove);
            System.out.println("Book removed from library.");
        }
    }

    public void retrieveBook(Book forRetrieval) {
        Book toRetrieve = null;
        List<Book> toRetrieveList = new ArrayList<Book>();

        for (Book book : bookList){
            if (Objects.nonNull(forRetrieval.getTitle())) {
                if (book.getTitle().equals(forRetrieval.getTitle())){
                    toRetrieve = book;
                    break;
                }
            } else if (Objects.nonNull(forRetrieval.getAuthor())) {
                if (book.getAuthor().equals(forRetrieval.getAuthor())) {
                    toRetrieveList.add(book);
                }
            } else if(Objects.nonNull(forRetrieval.getIsbn())) {
                if (book.getIsbn().equals(forRetrieval.getIsbn())){
                    toRetrieve = book;
                    break;
                }
            }
        }

        if (Objects.isNull(toRetrieve) && toRetrieveList.isEmpty()) {
            throw new NullPointerException("Sorry, the book/s you're trying to retrieve is not here.");
        } else if (Objects.nonNull(toRetrieve)){
            displayBook(toRetrieve);
        } else {
            displayBook(toRetrieveList);
        }
    }

    public void displayBook() {
        try {
            for (Book book : bookList) {
                System.out.println();
                book.displayDetails();
            }
        } catch (NullPointerException e) {
            System.out.println("There are no books to display.");
        }
    }

    public void displayBook(Book book) {
        try {
            book.displayDetails();
        } catch (NullPointerException e) {
            System.out.println("The book you're looking for is not here.");
        }
    }

    public void displayBook(List<Book> books) {
        try {
            for (Book book : books) {
                System.out.println();
                book.displayDetails();
            }
        } catch (NullPointerException e) {
            System.out.println("There are no books to display.");
        }
    }
}

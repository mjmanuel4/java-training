package org.library.service;

import org.library.book.Book;

import java.util.Scanner;

public class InputServiceImpl{
    Scanner scanner = new Scanner(System.in);

    public class AddBook implements InputService{
        String title;
        String author;
        Long isbn;

        @Override
        public Book getInput() {
            System.out.println("\nYou are adding a book.");
            System.out.print("Book title: ");
            title = scanner.nextLine();
            System.out.print("Book author: ");
            author = scanner.nextLine();
            System.out.print("ISBN: ");
            isbn = Long.parseLong(scanner.nextLine());

            return new Book(title, author, isbn);
        }
    }

    public class RemoveBook implements InputService{
        String inputString;
        Long inputLong;
        int inputInt;

        @Override
        public Book getInput() {
            boolean invalidInput = true;
            Book book = new Book(null, null, null);

            System.out.println("\nYou are removing a book. Please choose a method:");
            System.out.println("[1] By title");
            System.out.println("[2] By ISBN\n");

            while (invalidInput) {
                try {
                    inputInt = Integer.parseInt(scanner.nextLine());
                    invalidInput = false;

                    switch (inputInt) {
                        case 1:
                            System.out.println("\nYou are removing a book by title.");
                            System.out.print("Enter title: ");
                            inputString = scanner.nextLine();

                            book.setTitle(inputString);
                            break;
                        case 2:
                            System.out.println("\nYou are removing a book by ISBN.");
                            System.out.print("Enter ISBN: ");
                            inputLong = Long.parseLong(scanner.nextLine());

                            book.setIsbn(inputLong);
                            break;
                    }


                } catch (Exception e) {
                    System.out.println("\nInvalid inout, please enter a valid option.");
                }
            }

            return book;
        }
    }

    public class RetrieveBook implements InputService{
        String inputString;
        Long inputLong;
        int inputInt;

        @Override
        public Book getInput() {
            boolean invalidInput = true;
            Book book = new Book(null, null, null);

            System.out.println("\nYou are retrieving a book/s. Please choose a method:");
            System.out.println("[1] By title");
            System.out.println("[2] By author");
            System.out.println("[3] By ISBN\n");

            while (invalidInput) {
                try {
                    inputInt = Integer.parseInt(scanner.nextLine());
                    invalidInput = false;

                    switch (inputInt) {
                        case 1:
                            System.out.println("\nYou are removing a book by title.");
                            System.out.print("Enter title: ");
                            inputString = scanner.nextLine();

                            book.setTitle(inputString);
                            break;
                        case 2:
                            System.out.println("\nYou are removing a book by author.");
                            System.out.print("Enter author: ");
                            inputString = scanner.nextLine();

                            book.setAuthor(inputString);
                            break;
                        case 3:
                            System.out.println("\nYou are removing a book by ISBN.");
                            System.out.print("Enter ISBN: ");
                            inputLong = Long.parseLong(scanner.nextLine());

                            book.setIsbn(inputLong);
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("\nInvalid inout, please enter a valid option.");
                }
            }

            return book;
        }
    }
}



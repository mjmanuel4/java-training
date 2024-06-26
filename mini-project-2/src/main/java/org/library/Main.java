package org.library;

import org.library.service.InputServiceImpl;
import org.library.service.LibraryService;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: data persistence, readme
        Scanner scanner = new Scanner(System.in);
        LibraryService libraryService = new LibraryService();
        InputServiceImpl inputService = new InputServiceImpl();
        String proceed = "y";

        System.out.println("\nWelcome to the Library!");

        while (Objects.equals(proceed,"y")){
            boolean invalidInput = true;

            System.out.println("\nPlease choose the service:");
            System.out.println("[1] Add book");
            System.out.println("[2] Remove book");
            System.out.println("[3] Search library");
            System.out.println("[4] Display all books\n");

            while (invalidInput) {
                try {
                    int input = Integer.parseInt(scanner.nextLine());
                    invalidInput = false;

                    switch (input) {
                        case 1:
                            InputServiceImpl.AddBook addBook = inputService.new AddBook();
                            try {
                                libraryService.addBook(addBook.getInput());
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            InputServiceImpl.RemoveBook removeBook = inputService.new RemoveBook();
                            try {
                                libraryService.removeBook(removeBook.getInput());
                            } catch (NullPointerException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 3:
                            InputServiceImpl.RetrieveBook retrieveBook = inputService.new RetrieveBook();
                            try {
                                libraryService.retrieveBook(retrieveBook.getInput());
                            } catch (NullPointerException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 4:
                            libraryService.displayBook();
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("\nInvalid inout, please enter a valid option.");
                }
            }

            System.out.print("\nWould you like to continue? [y/n] ");
            proceed = scanner.nextLine();
        }

        scanner.close();
    }
}
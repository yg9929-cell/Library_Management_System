
package com.library.management;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    static class Book {
        int id;
        String title;
        String author;
        boolean available;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.available = true;
        }
    }

    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook(sc);
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    System.out.println("Search feature will be added next.");
                    break;

                case 4:
                    System.out.println("Issue feature will be added next.");
                    break;

                case 5:
                    System.out.println("Return feature will be added next.");
                    break;

                case 6:
                    System.out.println("Thank you for using the Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    static void addBook(Scanner sc) {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book book : books) {
            if (book.id == id) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book added successfully!");
    }

    static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("\n===== BOOK DETAILS =====");

        for (Book book : books) {
            System.out.println("Book ID: " + book.id);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Status: " +
                    (book.available ? "Available" : "Issued"));
            System.out.println("-------------------------");
        }
    }
}

package fr.pompey.dev.afpa;

import fr.pompey.dev.afpa.model.Book;
import fr.pompey.dev.afpa.model.Library;
import fr.pompey.dev.afpa.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Library Management System");
            System.out.println("1. Register a new user");
            System.out.println("2. Add a new book");
            System.out.println("3. List all the users");
            System.out.println("4. List all the books");
            System.out.println("5. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {

                case 1:
                    registerNewUser(library, scanner);
                    break;

                case 2:
                    addNewBook(library, scanner);
                    break;

                case 3:
                    library.displayAllUsers();
                    break;

                case 4:
                    library.displayAllBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");

            }

        }

    }

    // main method system

    // add new user
    private static void registerNewUser(Library library, Scanner scanner) {

        System.out.print("Enter first name: ");
        String firstname = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastname = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        User newUser = new User(firstname, lastname, email);
        library.addUser(newUser);

        System.out.println("User registered successfully:");
        System.out.println(newUser.toString());

    }

    // add new book
    private static void addNewBook(Library library, Scanner scanner) {

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter number of pages: ");
        Integer nbPages = scanner.nextInt();

        System.out.print("Is the book available? (yes/no): ");
        String availability = scanner.nextLine();
        boolean available = availability.equalsIgnoreCase("yes");

        Book newBook = new Book(title, author, nbPages, available);
        library.addBook(newBook);

        System.out.println("Book registered successfully:");
        System.out.println(newBook.toString());

    };

    private static Date parseDate(String dateStr) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return null;
        }

    }
}
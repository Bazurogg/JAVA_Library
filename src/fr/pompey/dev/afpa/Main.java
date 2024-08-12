package fr.pompey.dev.afpa;

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
            System.out.println("Library Management System");
            System.out.println("1. Register a new user");
            System.out.println("2. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerNewUser(library, scanner);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerNewUser(Library library, Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstname = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastname = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter birthdate (dd/MM/yyyy): ");
        String birthdateStr = scanner.nextLine();
        Date birthdate = parseDate(birthdateStr);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        User newUser = new User(firstname, lastname, email);
        library.addUser(newUser);

        System.out.println("User registered successfully:");
        System.out.println(newUser.toString());
    }

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
package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.entity.Book;
import fr.pompey.dev.afpa.entity.Library;
import fr.pompey.dev.afpa.entity.Rent;
import fr.pompey.dev.afpa.entity.User;
import fr.pompey.dev.afpa.exceptions.EmailAlreadyExistsException;
import fr.pompey.dev.afpa.exceptions.InputException;
import fr.pompey.dev.afpa.exceptions.InvalidEmailFormatException;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LibController {

    private final Library library;

    // Regex pattern for email validation
    private static final String REGEXEMAIL = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";

    public LibController(Library library) {

        this.library = library;

    }


    // add book method
    public void addBook(String title, String author, Integer nbPages, boolean available) {

        Book book = new Book(title, author, nbPages, available);

        library.addBook(book);

    }

    // add user method with some exception on the inputs
    public void addUser(String firstname, String lastname, String email) throws EmailAlreadyExistsException,
            InputException, InvalidEmailFormatException {

        // some throwing exceptions when user is created
        for (User user : library.getUsers()) {

            // Validate email format using regex
            if (!isValidEmail(email)) {

                throw new InvalidEmailFormatException("The email format is invalid: " + email);

            }

            // did email already exist
            if (user.getEmail().equals(email)) {

                throw new EmailAlreadyExistsException("The email " + email + " is already registered.");

            }

            // did the input is empty
            if (firstname == null || firstname.trim().isEmpty() ||

                    lastname == null || lastname.trim().isEmpty() ||

                    email == null || email.trim().isEmpty()) {

                throw new InputException("All fields must be filled out.");

            }

        }

        library.addUser(new User(firstname, lastname, email));

    }

    // Method to validate the email format using regex
    private boolean isValidEmail(String email) {

        Pattern pattern = Pattern.compile(REGEXEMAIL);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();

    }


    public void addRent(Book book, User user, LocalDate rentDate, LocalDate returnDate) {

        // Créez une nouvelle instance de Rent
        Rent rent = new Rent(book, user, rentDate, returnDate);

        // Ajoutez l'emprunt à la bibliothèque
        library.addRent(rent);

        // Marquez le livre comme indisponible
        book.setAvailable(false);

    }

}

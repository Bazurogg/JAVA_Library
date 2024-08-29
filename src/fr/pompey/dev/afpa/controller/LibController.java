package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.entity.Book;
import fr.pompey.dev.afpa.entity.Library;
import fr.pompey.dev.afpa.entity.Rent;
import fr.pompey.dev.afpa.entity.User;
import fr.pompey.dev.afpa.exceptions.EmailAlreadyExistsException;

import java.time.LocalDate;
import java.util.Date;

public class LibController {

    private final Library library;

    public LibController(Library library) {

        this.library = library;

    }


    // add book method
    public void addBook(String title, String author, Integer nbPages, boolean available) {
        Book book = new Book(title, author, nbPages, available);
        library.addBook(book);
    }

    // add user method
    public void addUser(String firstname, String lastname, String email) throws EmailAlreadyExistsException {

        for (User user : library.getUsers()) {

            if (user.getEmail().equals(email)) {

                throw new EmailAlreadyExistsException("The email " + email + " is already registered.");
            }

        }

        library.addUser(new User(firstname, lastname, email));

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

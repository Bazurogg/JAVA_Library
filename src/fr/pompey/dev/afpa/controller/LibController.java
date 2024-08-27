package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.entity.Book;
import fr.pompey.dev.afpa.entity.Library;
import fr.pompey.dev.afpa.entity.User;
import java.time.LocalDate;

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
    public void addUser(String firstname, String lastname, String email) {
        User user = new User(firstname, lastname, email);
        library.addUser(user);
    }


    public void borrowBook(String title, String userEmail, LocalDate returnDate) {

        Book book = library.findBookByTitle(title);

        User user = library.findUserByEmail(userEmail);

        if (book != null && user != null) {

            library.borrowBook(book, user, returnDate);

        } else {

            System.out.println("Book or user not found.");

        }

    }

}

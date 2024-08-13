package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.model.Book;
import fr.pompey.dev.afpa.model.Library;
import fr.pompey.dev.afpa.model.User;

public class LibController {

    private final Library library;

    public LibController(Library library) {
        this.library = library;
    }

    public void addBook(String title, String author, Integer nbPages, boolean available) {
        Book book = new Book(title, author, nbPages, available);
        library.addBook(book);
    }

    public void addUser(String firstname, String lastname, String email) {
        User user = new User(firstname, lastname, email);
        library.addUser(user);
    }

    public void borrowBook(String title, String userEmail) {
        Book book = library.findBookByTitle(title);
        User user = library.findUserByEmail(userEmail);
        if (book != null && user != null) {
            library.borrowBook(book, user);
        } else {
            System.out.println("Book or user not found.");
        }
    }

    public void returnBook(String title, String userEmail) {
        Book book = library.findBookByTitle(title);
        User user = library.findUserByEmail(userEmail);
        if (book != null && user != null) {
            library.returnBook(book, user);
        } else {
            System.out.println("Book or user not found.");
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : library.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public User findUserByEmail(String email) {
        for (User user : library.getUsers()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}

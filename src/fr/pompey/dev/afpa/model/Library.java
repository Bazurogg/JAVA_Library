// LIBRARY LOAN MANAGEMENT
package fr.pompey.dev.afpa.model;

import java.util.ArrayList;
import java.util.Date;

public class Library {

    private final ArrayList<Book> books;
    private final ArrayList<User> users;
    private final ArrayList<Loan> loans;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void borrowBook(Book book, User user) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            Loan loan = new Loan(book, user, new Date());
            loans.add(loan);
            System.out.println(user.getFirstname() + " " + user.getLastname() + " has borrowed the book: " + book.getTitle());
        } else {
            System.out.println("The book " + book.getTitle() + " is not available.");
        }
    }

    public void returnBook(Book book, User user) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book) && loan.getUser().equals(user) && loan.getReturnDate() == null) {
                loan.setReturnDate(new Date());
                book.setAvailable(true);
                System.out.println(user.getFirstname() + " " + user.getLastname() + " has returned the book: " + book.getTitle());
                break;
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    // Listing all register users
    public void displayAllUsers() {

        System.out.println("List of all users:");

        for (User user : users) {

            System.out.println(user.toString());

        }

    }

}

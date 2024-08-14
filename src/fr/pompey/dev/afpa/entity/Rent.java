// LOAN BOOK
package fr.pompey.dev.afpa.entity;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Date;

public class Rent {
    private Book book;
    private User user;
    private Date borrowDate;
    private LocalDate returnDate;

    public Rent(Book book, User user, Date borrowDate, LocalDate returnDate) {
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and setters

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedReturnDate = returnDate.format(formatter);
        return book.getTitle() +
                "\n" + user.getFirstname() + " " + user.getLastname() + " " + user.getEmail() +
                "\n" + borrowDate +
                "\n" + formattedReturnDate;
    }

}


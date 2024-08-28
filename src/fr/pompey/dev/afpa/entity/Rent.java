// LOAN BOOK
package fr.pompey.dev.afpa.entity;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Date;

public class Rent {
    public Book book;
    public User user;
    private final Date rentDate;
    private final LocalDate returnDate;

    public Rent(Book book, User user, Date rentDate, LocalDate returnDate) {
        this.book = book;
        this.user = user;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    // Getters and setters


    public Date getRentDate() {
        return rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedReturnDate = returnDate.format(formatter);
        return book.getTitle() +
                "\n" + user.getFirstname() + " " + user.getLastname() + " " + "[" + user.getEmail() + "]" +
                "\n" + rentDate +
                "\n" + formattedReturnDate;
    }

}


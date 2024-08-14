// LOAN BOOK
package fr.pompey.dev.afpa.entity;

import java.util.Date;

public class Rent {
    private Book book;
    private User user;
    private Date borrowDate;
    private Date returnDate;

    public Rent(Book book, User user, Date borrowDate, Date returnDate) {
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Rent{" +
                "book=" + book +
                ", user=" + user +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}


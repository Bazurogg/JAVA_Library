package fr.pompey.dev.afpa.model;

import java.util.Date;

/**
 * The type User.
 */
public class User extends Person {

    private String email;

    private Date registrationDate;

    // Constructor
    public User(String firstname, String lastname, String email) {

        super();

        this.setFirstname(firstname);

        this.setLastname(lastname);

        this.email = email;

        this.registrationDate = new Date(); // We use the current day for the "registration date".

    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets registrationDate.
     *
     * @return the registrationDate
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets registrationDate.
     *
     * @param registrationDate the registrationDate
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

/*
    // Méthodes spécifiques à User
    public void borrowBook(String bookTitle) {
        System.out.println(getFirstname() + " " + getLastname() + " has borrowed the book: " + bookTitle);
    }

    public void returnBook(String bookTitle) {
        System.out.println(getFirstname() + " " + getLastname() + " has returned the book: " + bookTitle);
    }
     */

    // Display user
    @Override
    public String toString() {

        return getFirstname() + " " + getLastname() + " - " + getEmail() + " -- " + getRegistrationDate();

    }

}


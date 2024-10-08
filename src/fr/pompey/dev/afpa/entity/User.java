package fr.pompey.dev.afpa.entity;
import java.time.LocalDate;
import java.util.Date;

/**
 * The type User.
 */
public class User extends Person {

    private String email;

    private LocalDate registrationDate;

    // Constructor
    public User(String firstname, String lastname, String email) {

        super();

        setFirstname(firstname);

        setLastname(lastname);

        setEmail(email);

        this.registrationDate = LocalDate.now(); // We use the current day for the "registration date".

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
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets registrationDate.
     *
     * @param registrationDate the registrationDate
     */
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }



    // Display user
    @Override
    public String toString() {

        return getFirstname() + " " + getLastname() + " - " + getEmail() + " - [" + getRegistrationDate() + "] " ;

    }

}


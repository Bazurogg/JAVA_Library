package fr.pompey.dev.afpa.entity;

public class Librarian extends Person {

    private String id;
    private boolean isConnected;

    public Librarian(String firstname, String lastname) {
        super();
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.id = generateId(firstname, lastname);
        this.isConnected = true; // is connected by default
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    // Generate ID
    private String generateId(String firstname, String lastname) {
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@nancyville-library.fr";
    }

    // Display librarian
    @Override
    public String toString() {

        return getFirstname() + " " + getLastname() + "[" + getId() + "]";

    }
}

package fr.pompey.dev.afpa.model;

public class Librarian extends Person {

    private String id;

    public Librarian(String firstname, String lastname, String id) {

        super();

        this.setFirstname(firstname);

        this.setLastname(lastname);

        this.id = generateId(firstname, lastname);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Generate ID
    private String generateId(String firstname, String lastname) {
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@nancyville-library.fr";
    }

    // Display librarian
    @Override
    public String toString() {
        return getFirstname() + "\t" + getLastname() + "\t;" + getId();
    }

}

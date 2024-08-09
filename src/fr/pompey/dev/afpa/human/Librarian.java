package fr.pompey.dev.afpa.human;

public class Librarian extends Person {

    private String id;

    public Librarian(String firstname, String lastname, String id) {

        super();

        this.setFirstname(firstname);

        this.setLastname(lastname);

        this.id = id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Display librarian
    @Override
    public String toString() {

        return getFirstname() + "\t" + getLastname() + "\t;" + getId();

    }

}

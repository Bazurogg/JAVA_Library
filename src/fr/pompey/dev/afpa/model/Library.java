// LIBRARY LOAN MANAGEMENT
package fr.pompey.dev.afpa.model;

import java.util.ArrayList;

import java.util.Date;

public class Library {

    private final ArrayList<Book> books;
    private final ArrayList<User> users;
    private final ArrayList<Rent> rents;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.rents = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addRent(Rent rent) {
        rents.add(rent);
    }



    public void borrowBook(Book book, User user, Date returnDate) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            Rent rent = new Rent(book, user, new Date(), returnDate);
            rents.add(rent);
            System.out.println(user.getFirstname() + " " + user.getLastname() + " has borrowed the book: " + book.getTitle() + " and must return it by: " + returnDate);
        } else {
            System.out.println("The book " + book.getTitle() + " is not available.");
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Rent> getRents() {
        return rents;
    }

    // Listing all register users
    public void displayAllUsers() {

        System.out.println("List of all users:");
        System.out.println("_________________________________________________________________________");

        for (User user : users) {

            System.out.println(user.toString());
            System.out.println("_________________________________________________________________________");

        }

    }

    // Listing all books
    public void displayAllBooks() {

        System.out.println("List of all books:");
        System.out.println("_________________________________________________________________________");


        for (Book book : books) {

            System.out.println(book.toString());
            System.out.println("_________________________________________________________________________");

        }

    }

    public void displayAllRent() {

        System.out.println("List of all rents:");
        System.out.println("_________________________________________________________________________");

        for (Rent rent : rents) {

            System.out.println(rent.toString());
            System.out.println("_________________________________________________________________________");

        }

    }

    // search user by email
    public User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    // search book by title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Library Init
    public void initializeLibrary() {

        // random user list
        addUser(new User("John", "Doe", "john.doe@example.com"));
        addUser(new User("Jane", "Smith", "jane.smith@example.com"));
        addUser(new User("Alice", "Smith", "alice.smith@example.com"));
        addUser(new User("Bob", "Johnson", "bob.johnson@example.com"));
        addUser(new User("Charlie", "Williams", "charlie.williams@example.com"));
        addUser(new User("David", "Brown", "david.brown@example.com"));
        addUser(new User("Eva", "Jones", "eva.jones@example.com"));
        addUser(new User("Frank", "Miller", "frank.miller@example.com"));
        addUser(new User("Grace", "Davis", "grace.davis@example.com"));
        addUser(new User("Hannah", "Garcia", "hannah.garcia@example.com"));
        addUser(new User("Ian", "Rodriguez", "ian.rodriguez@example.com"));
        addUser(new User("Julia", "Wilson", "julia.wilson@example.com"));
        addUser(new User("Kevin", "Smith", "kevin.smith@example.com"));
        addUser(new User("Linda", "Johnson", "linda.johnson@example.com"));
        addUser(new User("Michael", "Williams", "michael.williams@example.com"));
        addUser(new User("Olivia", "Brown", "olivia.brown@example.com"));
        addUser(new User("Patrick", "Jones", "patrick.jones@example.com"));
        addUser(new User("Quincy", "Miller", "quincy.miller@example.com"));
        addUser(new User("Rachel", "Davis", "rachel.davis@example.com"));
        addUser(new User("Steven", "Garcia", "steven.garcia@example.com"));
        addUser(new User("Tina", "Rodriguez", "tina.rodriguez@example.com"));
        addUser(new User("Ursula", "Wilson", "ursula.wilson@example.com"));

        // books list preset
        addBook(new Book("1984", "George Orwell", 328, true));
        addBook(new Book("To Kill a Mockingbird", "Harper Lee", 281, true));
        addBook(new Book("1984", "George Orwell", 328, true));
        addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 180, true));
        addBook(new Book("Pride and Prejudice", "Jane Austen", 279, true));
        addBook(new Book("The Catcher in the Rye", "J.D. Salinger", 214, true));
        addBook(new Book("Moby-Dick", "Herman Melville", 378, true));
        addBook(new Book("War and Peace", "Leo Tolstoy", 1225, true));
        addBook(new Book("The Odyssey", "Homer", 374, true));
        addBook(new Book("The Hobbit", "J.R.R. Tolkien", 310, true));
        addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1178, true));
        addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 320, true));
        addBook(new Book("The Da Vinci Code", "Dan Brown", 454, true));
        addBook(new Book("The Alchemist", "Paulo Coelho", 208, true));
        addBook(new Book("The Shining", "Stephen King", 447, true));
        addBook(new Book("The Hunger Games", "Suzanne Collins", 374, true));
        addBook(new Book("The Road", "Cormac McCarthy", 287, true));
        addBook(new Book("The Fault in Our Stars", "John Green", 313, true));
        addBook(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", 454, true));
        addBook(new Book("The Help", "Kathryn Stockett", 352, true));
        addBook(new Book("The Road to Wigan Pier", "George Orwell", 176, true));
    }

}

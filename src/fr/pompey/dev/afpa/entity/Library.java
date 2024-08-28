// LIBRARY LOAN MANAGEMENT
package fr.pompey.dev.afpa.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import java.time.format.DateTimeFormatter;
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



    public void borrowBook(Book book, User user, LocalDate returnDate) {

        if (book.isAvailable()) {

            book.setAvailable(false);

            Rent rent = new Rent(book, user, new Date(), returnDate);

            rents.add(rent);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            String formattedReturnDate = returnDate.format(formatter);

            System.out.println(user.getFirstname() + " " + user.getLastname() + " has borrowed the book: " + book.getTitle() + " and must return it by: " + formattedReturnDate);

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


        // Manga list preset
        addBook(new Book("One Piece", "Eiichiro Oda", 86, false));
        addBook(new Book("Naruto", "Masashi Kishimoto", 72, true));
        addBook(new Book("Dragon Ball", "Akira Toriyama", 519, true));
        addBook(new Book("Attack on Titan", "Hajime Isayama", 28, true));
        addBook(new Book("Death Note", "Tsugumi Ohba", 12, true));
        addBook(new Book("My Hero Academia", "Kohei Horikoshi", 25, true));
        addBook(new Book("Demon Slayer", "Koyoharu Gotouge", 19, true));
        addBook(new Book("Jujutsu Kaisen", "Gege Akutami", 18, true));
        addBook(new Book("Chainsaw Man", "Tatsuki Fujimoto", 12, true));
        addBook(new Book("Vinland Saga", "Makoto Yukimura", 22, true));
        addBook(new Book("Berserk", "Kentaro Miura", 34, true));
        addBook(new Book("Fullmetal Alchemist", "Hiromu Arakawa", 27, true));
        addBook(new Book("Hunter x Hunter", "Yoshihiro Togashi", 37, true));
        addBook(new Book("Black Clover", "Yuki Tabata", 25, true));
        addBook(new Book("The Promised Neverland", "Kaiu Shirai", 24, true));
        addBook(new Book("Tokyo Ghoul", "Sui Ishida", 14, true));
        addBook(new Book("Spy x Family", "Tatsuya Endo", 18, true));
        addBook(new Book("Kimetsu no Yaiba", "Koyoharu Gotouge", 19, true));
        addBook(new Book("The Seven Deadly Sins", "Nakaba Suzuki", 17, true));
        addBook(new Book("The God of High School", "Yon Jong-ik", 16, true));
    }

}

package fr.pompey.dev.afpa;

import fr.pompey.dev.afpa.entity.Librarian;
import fr.pompey.dev.afpa.entity.Library;
import fr.pompey.dev.afpa.vue.swing.Menu;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        // init a connected librarian
        Librarian librarian = new Librarian("Matt", "House");

        // call the method for the lib init
        library.initializeLibrary();

        Menu menu = new Menu(librarian, library);

        menu.setVisible(true);


// -------------------------------------- M E N U   C O N S O L E -------------------------------------------- //

//        // Logique menu CONSOLE

//        LibController libController = new LibController(library);

//        Scanner scanner = new Scanner(System.in);

//        while (true) {
//
//            System.out.println("Hello " + librarian);
//            System.out.println("Welcome to the Library Management System");
//            System.out.println("1. Register a new user");
//            System.out.println("2. Add a new manga");
//            System.out.println("3. Make a new rent");
//            System.out.println("4. List all the users");
//            System.out.println("5. List all the mangas");
//            System.out.println("6. List all the mangas rent");
//            System.out.println("7. Exit");
//            System.out.print("Please choose an option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            // switch case menu console
//            switch (choice) {
//
//                case 1:
//                    registerNewUser(libController, scanner);
//                    break;
//
//                case 2:
//                    addNewBook(libController, scanner);
//                    break;
//
//                case 3:
//                    makeNewRent(libController, scanner);
//                    break;
//
//                case 4:
//                    library.displayAllUsers();
//                    break;
//
//                case 5:
//                    library.displayAllBooks();
//                    break;
//
//                case 6:
//                    library.displayAllRent();
//                    break;
//
//                case 7:
//                    System.out.println("Exiting...");
//                    return;
//
//                default:
//                    System.out.println("Invalid option. Please try again.");
//
//            }
//
//        }
//
//    }
//
//    // main system method system
//
//    // add new user
//    private static void registerNewUser(LibController libController, Scanner scanner) {
//
//        System.out.print("Enter first name: ");
//        String firstname = scanner.nextLine();
//
//        System.out.print("Enter last name: ");
//        String lastname = scanner.nextLine();
//
//        System.out.print("Enter email: ");
//        String email = scanner.nextLine();
//
//        User newUser = new User(firstname, lastname, email);
//
//        libController.addUser(firstname, lastname, email);
//
//        System.out.println("User registered successfully.");
//
//        JOptionPane.showMessageDialog(null, "User registered successfully: " + "\n" + newUser.getEmail() , "User " +
//                "Registered ", JOptionPane.INFORMATION_MESSAGE);
//
//    }
//
//    // add new book
//    private static void addNewBook(LibController libController, Scanner scanner) {
//
//        System.out.print("Enter title: ");
//        String title = scanner.nextLine();
//
//        System.out.print("Enter author: ");
//        String author = scanner.nextLine();
//
//        System.out.print("Enter number of pages: ");
//        Integer nbPages = scanner.nextInt();
//
//        System.out.print("Is the book available? (yes/no): ");
//        String availability = scanner.nextLine();
//        boolean available = availability.equalsIgnoreCase("yes");
//
//        libController.addBook(title, author, nbPages, available);
//
//        System.out.println("Book registered successfully.");
//
//    }
//
//    private static void makeNewRent(LibController libController, Scanner scanner) {
//
//        System.out.print("Enter user email: ");
//        String email = scanner.nextLine();
//
//        System.out.print("Enter book title: ");
//        String title = scanner.nextLine();
//
//        System.out.print("Enter return date (dd/MM/yyyy): ");
//
//        String returnDateStr = scanner.nextLine();
//
//        LocalDate returnDate = LocalDate.parse(returnDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//
//        libController.borrowBook(title, email, returnDate);
//    }
//
//
//    // Exception sur le format de date à l'input.
//    private static Date parseDate(String dateStr) {
//
//        try {
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            return dateFormat.parse(dateStr);
//
//        } catch (ParseException e) {
//
//            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
//            return null;
//
//        }
//
//    }

// -------------------------------------- (F I N) M E N U   C O N S O L E ---------------------------------------- //


    }

}
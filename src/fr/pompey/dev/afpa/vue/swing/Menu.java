package fr.pompey.dev.afpa.vue.swing;

import fr.pompey.dev.afpa.entity.*;
import fr.pompey.dev.afpa.tablemodel.TableModel;
import fr.pompey.dev.afpa.tablemodel.UserTableModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Menu extends JFrame {

    private JPanel Home;  // Le panneau principal généré par l'IDE
    private JButton newUserButton;
    private JButton mangasListButton;
    private JTextArea welcomeTextArea;
    private JButton usersListButton;
    private JButton newBookButton;
    private JButton rentListButton;
    private JButton newRentButton;
    private Library library;

    public Menu(Librarian librarian, Library library) {

        this.library = library;

        // Définir les paramètres de base de la fenêtre
        setTitle("Library Management System");
        setSize(800, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Créer un JLayeredPane pour superposer les composants
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 640));

        // Créer un JLabel pour l'image de fond
        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\Fabulous\\Pictures\\affichemanga01.jpg"));
        backgroundLabel.setBounds(0, 0, 800, 640);  // Définir la position et la taille du JLabel

        // Ajouter le JLabel à la couche inférieure du JLayeredPane
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        // Configurer le panneau Home avec une taille et position adéquate
        Home.setBounds(0, 0, 800, 640);
        Home.setOpaque(false);  // Rendre le panneau transparent pour voir l'image de fond

        // Ajouter le panneau Home à la couche supérieure du JLayeredPane
        layeredPane.add(Home, Integer.valueOf(1));

        // Définir le panneau de contenu de la fenêtre sur le JLayeredPane
        setContentPane(layeredPane);

        // Configurer le message de bienvenue
        String welcomeMessage = "Welcome to the Library Management System!\n\n" +
                "Hello, " + librarian.getFirstname() + " " + librarian.getLastname() + "!\n" +
                "Here you can manage books, users, and book's rent.";
        welcomeTextArea.setText(welcomeMessage);
        welcomeTextArea.setOpaque(false); // Rendre le texte transparent pour voir l'image en arrière-plan

        // Ajout d'une action au bouton pour afficher la liste des livres
        mangasListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBookList(library);
            }

            private void showBookList(Library library) {
                // Obtenir l'instance de la bibliothèque
//                Library library = new Library();
//
//                // Initialiser la bibliothèque (ajouter des livres et des utilisateurs)
//                library.initializeLibrary();

                // Obtenir la liste de livres de la bibliothèque
                List<Book> books = library.getBooks();

                // Créer le modèle de la table en passant la liste de livres au constructeur
                TableModel model = new TableModel(books);

                // Créer le tableau en utilisant le modèle
                JTable table = new JTable(model);

                // Placer la table dans un JScrollPane pour permettre le défilement
                JScrollPane scrollPane = new JScrollPane(table);

                // Créer une nouvelle fenêtre pour afficher la table
                JFrame tableFrame = new JFrame("List of Books");
                tableFrame.setSize(600, 400);
                tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                tableFrame.add(scrollPane, BorderLayout.CENTER);
                tableFrame.setVisible(true);

            }

        });

        // Ajout d'une action au bouton pour afficher la liste des utilisateurs enregistrés
        usersListButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                showUserList(library);

            }

            public void showUserList(Library library) {
                // get the users list of this library
                List<User> users = library.getUsers();

                // Créer le modèle de la table en passant la liste d'utilisateurs au constructeur
                UserTableModel model = new UserTableModel(users);

                // Créer le tableau en utilisant le modèle
                JTable table = new JTable(model);

                // Placer la table dans un JScrollPane pour permettre le défilement
                JScrollPane scrollPane = new JScrollPane(table);

                // Création d'une nouvelle fenêtre pour afficher la table
                JFrame userListFrame = new JFrame("List of Users");
                userListFrame.setSize(600, 400);
                userListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userListFrame.add(scrollPane, BorderLayout.CENTER);
                userListFrame.setVisible(true);
            }

        });

        // Ajout d'une action au bouton pour afficher la fenêtre d'ajout d'utilisateur
        newUserButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                AddUser addUserFrame = new AddUser(library);

                addUserFrame.setVisible(true);

            }

        });

        // Ajout d'une action au bouton pour afficher la fenêtre d'ajout d'utilisateur
        newBookButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                AddBook addBookFrame = new AddBook(library);

                addBookFrame.setVisible(true);

            }

        });

        //
        newRentButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                // Créer une nouvelle instance de la fenêtre de création de location
                NewRent newRentFrame = new NewRent(library);

                // Rendre la fenêtre visible
                newRentFrame.setVisible(true);

            }

        });

    }

}





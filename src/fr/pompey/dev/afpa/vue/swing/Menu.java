//
//package fr.pompey.dev.afpa.vue.swing;
//
//import fr.pompey.dev.afpa.entity.Book;
//import fr.pompey.dev.afpa.entity.Librarian;
//import fr.pompey.dev.afpa.entity.Library;
//import fr.pompey.dev.afpa.tablemodel.TableModel;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class Menu extends JFrame {
//    private JPanel Home;  // Le panneau principal généré par l'IDE
//    private JButton newUserButton;
//    private JButton mangasListButton;
//    private JTextArea welcomeTextArea;
//
//
//    public Menu(Librarian librarian) {
//
//        // Définir les paramètres de base de la fenêtre
//        setTitle("Library Management System");
//        setSize(800, 640);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Créer un JLayeredPane pour superposer les composants
//        JLayeredPane layeredPane = new JLayeredPane();
//        layeredPane.setPreferredSize(new Dimension(800, 640));
//
//        // Créer un JLabel pour l'image de fond
//        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\Fabulous\\Pictures\\affichemanga01.jpg"));
//        backgroundLabel.setBounds(0, 0, 800, 640);  // Définir la position et la taille du JLabel
//
//        // Ajouter le JLabel à la couche inférieure du JLayeredPane
//        layeredPane.add(backgroundLabel, Integer.valueOf(0));
//
//        // Configurer le panneau Home avec une taille et position adéquate
//        Home.setBounds(0, 0, 800, 640);
//        Home.setOpaque(false);  // Rendre le panneau transparent pour voir l'image de fond
//
//        // Configurer le layout du panneau Home
//        Home.setLayout(new FlowLayout());  // Exemple d'un layout simple
//
//
//        // Ajouter le panneau Home à la couche supérieure du JLayeredPane
//        layeredPane.add(Home, Integer.valueOf(1));
//
//        // Définir le panneau de contenu de la fenêtre sur le JLayeredPane
//        setContentPane(layeredPane);
//
//        // Configurer le message de bienvenue
//        String welcomeMessage = "Welcome to the Library Management System!\n\n" +
//                "Hello, " + librarian.getFirstname() + " " + librarian.getLastname() + "!\n" +
//                "Here you can manage books, users, and book's rent.";
//        welcomeTextArea.setText(welcomeMessage);
//        welcomeTextArea.setOpaque(false); // Rendre le texte transparent pour voir l'image en arrière-plan
//
//        // Ajouter une action au bouton pour afficher la liste des livres
//        mangasListButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showBookList();
//            }
//
//            private void showBookList() {
//                // Obtenir l'instance de la bibliothèque
//                Library library = new Library();
//
//                // Initialiser la bibliothèque (ajouter des livres et des utilisateurs)
//                library.initializeLibrary();
//
//                // Obtenir la liste de livres de la bibliothèque
//                List<Book> books = library.getBooks();
//
//                // Créer le modèle de la table en passant la liste de livres au constructeur
//                TableModel model = new TableModel(books);
//
//                // Créer le tableau en utilisant le modèle
//                JTable table = new JTable(model);
//
//                // Placer la table dans un JScrollPane pour permettre le défilement
//                JScrollPane scrollPane = new JScrollPane(table);
//
//                // Créer une nouvelle fenêtre pour afficher la table
//                JFrame tableFrame = new JFrame("List of Books");
//                tableFrame.setSize(600, 400);
//                tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                tableFrame.add(scrollPane, BorderLayout.CENTER);
//                tableFrame.setVisible(true);
//            }
//        });
//
//        // Rendre la fenêtre visible
//        setVisible(true);
//    }
//}


package fr.pompey.dev.afpa.vue.swing;

import fr.pompey.dev.afpa.entity.Book;
import fr.pompey.dev.afpa.entity.Librarian;
import fr.pompey.dev.afpa.entity.Library;
import fr.pompey.dev.afpa.entity.User;
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

    public Menu(Librarian librarian) {

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
                showBookList();
            }

            private void showBookList() {
                // Obtenir l'instance de la bibliothèque
                Library library = new Library();

                // Initialiser la bibliothèque (ajouter des livres et des utilisateurs)
                library.initializeLibrary();

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

        // Ajout d'une action au bouton pour afficher la liste des livres
        usersListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUserList();
            }

            private void showUserList() {
                // Obtenir l'instance de la bibliothèque
                Library library = new Library();

                // Initialiser la bibliothèque (ajouter des livres et des utilisateurs)
                library.initializeLibrary();

                // Obtenir la liste de livres de la bibliothèque
                List<User> users = library.getUsers();

                // Créer le modèle de la table en passant la liste de livres au constructeur
                UserTableModel model = new UserTableModel(users);

                // Créer le tableau en utilisant le modèle
                JTable table = new JTable(model);

                // Placer la table dans un JScrollPane pour permettre le défilement
                JScrollPane scrollPane = new JScrollPane(table);

                // Créer une nouvelle fenêtre pour afficher la table
                JFrame tableFrame = new JFrame("List of registered User");
                tableFrame.setSize(600, 400);
                tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                tableFrame.add(scrollPane, BorderLayout.CENTER);
                tableFrame.setVisible(true);

            }

        });

        // Ajout d'une action au bouton pour afficher la fenêtre d'ajout d'utilisateur
        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddUserWindow();
            }

            private void showAddUserWindow() {
                // Créer une nouvelle instance de la fenêtre d'ajout d'utilisateur
                AddUser addUserFrame = new AddUser();

                // Définir la taille de la fenêtre
                addUserFrame.setSize(550, 350);

                // Définir l'opération de fermeture par défaut de la fenêtre
                addUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Rendre la fenêtre visible
                addUserFrame.setVisible(true);
            }
        });

    }

}





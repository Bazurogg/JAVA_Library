//package fr.pompey.dev.afpa.vue.swing;
//
//import fr.pompey.dev.afpa.entity.Librarian;
//
//import javax.swing.*;
//
//
//public class Menu extends JFrame {
//    private JPanel Home;
//    private JButton newUserButton;
//    private JTextArea welcomeTextArea;
//
//
//    // config manuel du menu via les param Swing
//    public Menu(Librarian librarian) {
//
//        // Set the content pane of the frame to the Home panel
//        setContentPane(Home);
//
//        // Set the title of the frame
//        setTitle("Library Management System");
//
//        // Set the size of the frame
//        setSize(800, 640);
//
//        // the app turn off when the user close the window
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Settings for the TextArea of the home menu
//        // Create a welcome message with the librarian's name
//        String welcomeMessage = "Welcome to the Library Management System!\n\n" +
//                "Hello, " + librarian.getFirstname() + " " + librarian.getLastname() + "!\n" +
//                "Here you can manage books, users, and book's rent.";
//
//        // set background color
//        welcomeTextArea.setOpaque(false);
//
//        // set own text
//        welcomeTextArea.setText(welcomeMessage);
//
//    }
//
//}





// MENU AVEC IMAGE
//
//package fr.pompey.dev.afpa.vue.swing;
//
//import fr.pompey.dev.afpa.entity.Librarian;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class Menu extends JFrame {
//    private JPanel Home;
//    private JButton newUserButton;
//    private JTextArea welcomeTextArea;
//
//    public Menu(Librarian librarian) {
//        // Créer un JLabel pour l'image de fond
//        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\Fabulous\\Pictures\\affichemanga01.jpg"));
//
//        // Configurer le panneau Home avec un layout approprié
//        Home.setLayout(new BorderLayout());
//
//        // Ajouter le JLabel au panneau Home
//        Home.add(backgroundLabel);
//        backgroundLabel.setLayout(new GridBagLayout()); // Utiliser un layout pour gérer les composants par-dessus
//
//        // Créer un panneau pour contenir les autres composants (texte et boutons)
//        JPanel contentPanel = new JPanel();
//        contentPanel.setOpaque(false); // Rendre le panneau transparent
//        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
//
//        // Ajouter le texte de bienvenue
//        String welcomeMessage = "Welcome to the Library Management System!\n\n" +
//                "Hello, " + librarian.getFirstname() + " " + librarian.getLastname() + "!\n" +
//                "Here you can manage books, users, and book's rent.";
//        welcomeTextArea.setText(welcomeMessage);
//        welcomeTextArea.setOpaque(false); // Rendre le texte transparent
//
//        // Ajouter les composants au contentPanel
//        contentPanel.add(welcomeTextArea);
//        contentPanel.add(newUserButton);
//
//        // Ajouter le contentPanel au backgroundLabel
//        backgroundLabel.add(contentPanel, new GridBagConstraints());
//
//        // Définir le panneau principal de la fenêtre
//        setContentPane(Home);
//
//        // Configuration de la fenêtre
//        setTitle("Library Management System");
//        setSize(800, 640);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//}





package fr.pompey.dev.afpa.vue.swing;

import fr.pompey.dev.afpa.entity.Librarian;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JPanel Home;  // Le panneau principal généré par l'IDE
    private JButton newUserButton;
    private JTextArea welcomeTextArea;

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

        // Rendre la fenêtre visible
        setVisible(true);
    }
}


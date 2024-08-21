package fr.pompey.dev.afpa.vue.swing;

import fr.pompey.dev.afpa.entity.Librarian;

import javax.swing.*;


public class Menu extends JFrame {
    private JPanel Home;
    private JButton newUserButton;
    private JTextArea welcomeTextArea;


    // config manuel du menu via les param Swing
    public Menu(Librarian librarian) {

        // Set the content pane of the frame to the Home panel
        setContentPane(Home);

        // Set the title of the frame
        setTitle("Library Management System");

        // Set the size of the frame
        setSize(800, 640);

        // the app turn off when the user close the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Settings for the TextArea of the home menu
        // Create a welcome message with the librarian's name
        String welcomeMessage = "Welcome to the Library Management System!\n\n" +
                "Hello, " + librarian.getFirstname() + " " + librarian.getLastname() + "!\n" +
                "Here you can manage books, users, and book's rent.";

        // set background color
        welcomeTextArea.setOpaque(false);

        // set own text
        welcomeTextArea.setText(welcomeMessage);

    }

}
package fr.pompey.dev.afpa.vue.swing;

import javax.swing.*;

public class Menu extends JFrame {
    private JPanel Home;
    private JButton newUserButton;
    private JTextArea hiWelcomeToTheTextArea;


    // config manuel du menu via les param Swing
    public Menu() {
        // Set the content pane of the frame to the Home panel
        setContentPane(Home);

        // Set the title of the frame
        setTitle("Library Management System");

        // Set the size of the frame
        setSize(800, 600);

        // Set the default close operation of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        hiWelcomeToTheTextArea.setBackground(getBackground());
    }

}
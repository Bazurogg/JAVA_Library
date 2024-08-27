package fr.pompey.dev.afpa.vue.swing;

import fr.pompey.dev.afpa.controller.LibController;
import fr.pompey.dev.afpa.entity.Library;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUser extends JFrame {
    private Library library;
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JTextField emailField;
    private JButton cancelButton;
    private JButton addButton;
    private JPanel AddUser;

    public AddUser(Library library) { // On accepte l'instance de "library" en paramètre

        this.library = library; // On enregistre cette instance pour l'utiliser plus tard

        // Set the title of the window
        setTitle("Add New User");

        // Set the size of the window
        setSize(600, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();

        AddUser.setBounds(0, 0, 800, 640);

        panel.add(AddUser);

        // Add the panel to the frame
        add(panel);


        // Add action to the button "Add"
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNewUser();
            }

            private void addNewUser() {

                // Recovering field data
                String firstname = firstnameField.getText();
                String lastname = lastnameField.getText();
                String email = emailField.getText();

                // using class LibController to add new user to the "Library"
                // using the same instance of library
                LibController libController = new LibController(library);
                libController.addUser(firstname, lastname, email);

                // confirm alert
                JOptionPane.showMessageDialog(null, "User added successfully!");

                // closing the add user panel
                dispose();

            }

        });

        // action on cancel button to close the panel
        cancelButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                dispose();

            }

        });

    }

}

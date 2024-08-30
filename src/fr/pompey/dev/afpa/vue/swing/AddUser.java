package fr.pompey.dev.afpa.vue.swing;

import fr.pompey.dev.afpa.controller.LibController;
import fr.pompey.dev.afpa.entity.Library;
import fr.pompey.dev.afpa.exceptions.EmailAlreadyExistsException;
import fr.pompey.dev.afpa.exceptions.InputException;
import fr.pompey.dev.afpa.exceptions.InvalidEmailFormatException;

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

                try {

                    addNewUser();

                    dispose();

                } catch (EmailAlreadyExistsException | InputException | InvalidEmailFormatException ex) {

                    // Show an error message dialog with the exception message
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                }

            }

            private void addNewUser() throws EmailAlreadyExistsException, InputException, InvalidEmailFormatException {

                // Recovering field data
                String firstname = firstnameField.getText().trim();

                String lastname = lastnameField.getText().trim();

                String email = emailField.getText().trim();

                // using class LibController to add new user to the "Library"
                // using the same instance of library
                LibController libController = new LibController(library);

                libController.addUser(firstname, lastname, email);

                // confirm alert
                JOptionPane.showMessageDialog(null, "User added successfully! test1");

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

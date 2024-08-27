package fr.pompey.dev.afpa.vue.swing;

import fr.pompey.dev.afpa.controller.LibController;
import fr.pompey.dev.afpa.entity.Library;

import javax.swing.*;
import java.awt.*;
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

//        // Add components to the panel
//        panel.add(new JLabel("First Name:"));
//        panel.add(firstnameField = new JTextField(20));
//        panel.add(new JLabel("Last Name:"));
//        panel.add(lastnameField = new JTextField(20));
//        panel.add(new JLabel("Email:"));
//        panel.add(emailField = new JTextField(20));
//        panel.add(cancelButton = new JButton("Cancel"));
//        panel.add(addButton = new JButton("Add"));



        // Add the panel to the frame
        add(panel);


        // Ajout d'une action au bouton "Add" pour ajouter un nouvel utilisateur
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNewUser();
            }

            private void addNewUser() {

                // Récupérer les entrées des champs
                String firstname = firstnameField.getText();
                String lastname = lastnameField.getText();
                String email = emailField.getText();

                // Ajouter le nouvel utilisateur à la bibliothèque en utilisant la classe LibController
                // On utilise la même instance de Library pour ajouter l'utilisateur
                LibController libController = new LibController(library);
                libController.addUser(firstname, lastname, email);

                // Afficher un message de confirmation
                JOptionPane.showMessageDialog(null, "User added successfully!");

                // Fermer la fenêtre d'ajout d'utilisateur
                dispose();

            }

        });


        // Ajout d'une action au bouton "Cancel" pour fermer la fenêtre d'ajout d'utilisateur
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });


    }
}

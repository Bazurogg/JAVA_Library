package fr.pompey.dev.afpa.vue.swing;

import fr.pompey.dev.afpa.controller.LibController;
import fr.pompey.dev.afpa.entity.Library;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBook extends JFrame {
    private Library library;
    private JPanel AddBook;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField pagesField;
    private JButton cancelButton;
    private JButton addButton;

    public AddBook(Library library) { // On accepte l'instance de "library" en paramètre

        this.library = library; // On enregistre cette instance pour l'utiliser plus tard

        // Set the title of the window
        setTitle("Add New Book");

        // Set the size of the window
        setSize(600, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();

        AddBook.setBounds(0, 0, 800, 640);

        panel.add(AddBook);

        // Add the panel to the frame
        add(panel);


        // Add action to the button "Add"
        addButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                addNewBook();

            }

            private void addNewBook() {

                // Recovering field data
                String title = titleField.getText();
                String author = authorField.getText();
                Integer pages = pagesField.getColumns();

                // the availability is set true by default
                boolean available = true;

                // using class LibController to add new book to the "Library"
                // using the same instance of library
                LibController libController = new LibController(library);
                libController.addBook(title, author, pages, available);

                // confirm alert
                JOptionPane.showMessageDialog(null, "Book added successfully!");

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

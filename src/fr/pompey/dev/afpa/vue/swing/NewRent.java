package fr.pompey.dev.afpa.vue.swing;

import fr.pompey.dev.afpa.entity.Book;
import fr.pompey.dev.afpa.entity.Library;
import fr.pompey.dev.afpa.entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NewRent extends JFrame {
    private JComboBox<Book> bookComboBox; // Menu déroulant pour sélectionner un livre
    private JComboBox<User> userComboBox; // Menu déroulant pour sélectionner un utilisateur
    private JButton rentButton;
    private JButton cancelButton;
    private JPanel newRent;
    private final Library library;

    public NewRent(Library library) {

        this.library = library;

        // Ajouter le panneau principal à la fenêtre

        // Set the title of the window
        setTitle("New Rent");

        // Set the size of the window
        setSize(600, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();

        newRent.setBounds(0, 0, 800, 640);

        panel.add(newRent);

        // Add the panel to the frame
        add(panel);

        // Récupérer la liste des livres et des utilisateurs
        List<Book> books = library.getBooks();
        List<User> users = library.getUsers();

        // Ajouter les livres dans le JComboBox
        for (Book book : books) {
            bookComboBox.addItem(book);
        }

        // Ajouter les utilisateurs dans le JComboBox
        for (User user : users) {
            userComboBox.addItem(user);
        }

//        // Configurer le layout
//        newRent = new JPanel(new GridLayout(3, 2));
//        newRent.add(new JLabel("Select Book:"));
//        newRent.add(bookComboBox);
//        newRent.add(new JLabel("Select User:"));
//        newRent.add(userComboBox);
//        newRent.add(rentButton);
//        newRent.add(cancelButton);



        // Ajouter l'action du bouton "Rent"
        rentButton.addActionListener(new MyActionListener());

        // action on cancel button to close the panel
        cancelButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                dispose();

            }

        });

    }

    private void performRent(Book book, User user) {
        // Logique pour la location du livre ici
        // Par exemple: marquer le livre comme loué, associer le livre à l'utilisateur, etc.

        JOptionPane.showMessageDialog(this, "Book '" + book.getTitle() + "' rented by " + user.getFirstname() + " " + user.getLastname());
    }


    private class MyActionListener implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {
            Book selectedBook = (Book) bookComboBox.getSelectedItem();
            User selectedUser = (User) userComboBox.getSelectedItem();

            // Logique pour effectuer la location ici (ex: update database, etc.)
            if (selectedBook != null && selectedUser != null) {
                performRent(selectedBook, selectedUser);
            } else {
                JOptionPane.showMessageDialog(null, "Please select both a book and a user.");
            }

        }

    }
}

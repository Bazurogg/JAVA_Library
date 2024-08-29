package fr.pompey.dev.afpa.vue.swing;

import fr.pompey.dev.afpa.entity.Book;
import fr.pompey.dev.afpa.entity.Library;
import fr.pompey.dev.afpa.entity.Librarian;
import fr.pompey.dev.afpa.entity.Rent;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReturnBook extends JFrame {

    private final Library library;
    private JComboBox<Rent> rentJComboBox;
    private JButton cancelButton;
    private JButton returnBookButton;
    private JPanel ReturnBook;
    private Librarian librarian;

    public ReturnBook(Library library) {

        this.library = library;

        // Set the title of the window
        setTitle("Return a Book");

        // Set the size of the window
        setSize(600, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();

        ReturnBook.setBounds(0, 0, 800, 640);

        panel.add(ReturnBook);

        // Add the panel to the frame
        add(panel);

        // Récupérer la liste des livres et des utilisateurs
        List<Rent> rents = library.getRents();

        // Ajouter les livres dans le JComboBox
        for (Rent rent : rents) {

            rentJComboBox.addItem(rent);

        }

        returnBookButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                returnBook();

            }

            private void returnBook() {
                // Récupérer l'emprunt sélectionné
                Rent selectedRent = (Rent) rentJComboBox.getSelectedItem();

                if (selectedRent != null) {
                    // Récupérer le livre associé à cet emprunt
                    Book book = selectedRent.book;

                    // Mettre à jour la disponibilité du livre
                    book.setAvailable(true);

                    // Supprimer l'emprunt de la bibliothèque (ou le marquer comme retourné)
                    library.getRents().remove(selectedRent);

                    // Afficher un message de confirmation
                    JOptionPane.showMessageDialog(null, "The book '" + book.getTitle() + "' has been returned " +
                            "successfully.");

                    // Fermer la fenêtre après l'opération
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a rent to return.");
                }
            }

        });

        // cancel button method
        cancelButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

            }

        });


    }

}

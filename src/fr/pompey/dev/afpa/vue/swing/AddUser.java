package fr.pompey.dev.afpa.vue.swing;

import javax.swing.*;
import java.awt.*;

public class AddUser extends JFrame {
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JTextField emailField;
    private JButton cancelButton;
    private JButton addButton;
    private JPanel AddUser;

    public AddUser() {
        // Set the title of the window
        setTitle("Add New User");

        // Set the size of the window
        setSize(400, 300);

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


    }
}

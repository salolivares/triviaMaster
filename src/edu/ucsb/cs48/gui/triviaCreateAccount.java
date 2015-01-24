package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;

public class triviaCreateAccount {
    JButton loginButton;
    JTextField loginField;
    JPasswordField passwordField;
    JFrame frame;
    JLabel loginLabel;
    JLabel passwordLabel;
    JPanel panOuter;
    JPanel panLeft;
    JPanel panRight;
    JPanel panBot;

    public void createWindow() {
        frame = new JFrame("Account Login");
        loginButton = new JButton("Login");
        loginField = new JTextField("Username", 20);
        passwordField = new JPasswordField("Password", 20);
        loginLabel = new JLabel("Login:");
        passwordLabel = new JLabel("Password:");
        panOuter = new JPanel(new BorderLayout());
        panLeft = new JPanel(new BorderLayout());
        panRight = new JPanel(new BorderLayout());
        panBot = new JPanel();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panRight.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panBot.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        panOuter.add(panLeft, BorderLayout.WEST);
        panOuter.add(panRight, BorderLayout.EAST);
        panOuter.add(panBot, BorderLayout.SOUTH);

        panLeft.add(loginLabel, BorderLayout.NORTH);
        panLeft.add(passwordLabel, BorderLayout.CENTER);
        panRight.add(loginField, BorderLayout.NORTH);
        panRight.add(passwordField, BorderLayout.CENTER);
        panBot.add(loginButton);

        frame.setContentPane(panOuter);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}

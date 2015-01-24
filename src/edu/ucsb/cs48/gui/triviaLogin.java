package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class triviaLogin {
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
        frame            = new JFrame("Account Login");
        loginButton      = new JButton("Login");
        loginField       = new JTextField("Username", 20);
        passwordField    = new JPasswordField("Password", 20);
        loginLabel       = new JLabel("Login:");
        passwordLabel    = new JLabel("Password:");
        panOuter         = new JPanel(new BorderLayout());
        panLeft          = new JPanel(new BorderLayout());
        panRight         = new JPanel(new BorderLayout());
        panBot           = new JPanel();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panLeft.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        panRight.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        panBot.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

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

        /* Event Managers */
        loginField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginField.setText("");
                passwordField.setText("");
            }
        });
        loginField.addKeyListener(new KeyAdapter() {
            boolean notPressed = true;
            @Override
            public void keyPressed(KeyEvent e) {
                if(notPressed) {
                    loginField.setText("");
                    notPressed = false;
                }
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            boolean notPressed = true;
            @Override
            public void keyPressed(KeyEvent e) {
                if(notPressed) {
                    passwordField.setText("");
                    notPressed = false;
                }
            }
        });

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    frame.dispose();
                    triviaMain.setCurrentPanel(new mainMenuPanel());
                }
            }
        });

    }
}

package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * triviaCreateAccount class that allows user to create their own account
 */

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
    JFrame createdAccount;

    /**
     * createWindow method that creates a new window for user
     * to input their desired username and password
     */
    public void createWindow() {
        frame = new JFrame("Create Account");
        loginButton = new JButton("Create Account");
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
                if(loginField.getText().equals("Username")){
                    JOptionPane.showMessageDialog(createdAccount,"Please choose a username","Account Creation",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String returnMessage = Main.player.createUser(loginField.getText(),passwordField.getText());
                showMessageDialog(returnMessage);
                frame.dispose();
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    if(loginField.getText().equals("Username")){
                        JOptionPane.showMessageDialog(createdAccount,"Please choose a username","Account Creation",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String returnMessage = Main.player.createUser(loginField.getText(),passwordField.getText());
                    showMessageDialog(returnMessage);
                    frame.dispose();
                }
            }
        });

    }

    /**
     * Returns message to user if account was successfully created or not
     * @param returnMessage string identifying if account was successfully created or not
     */
    public void showMessageDialog(String returnMessage){
        if(returnMessage == "CREATED"){
            JOptionPane.showMessageDialog(createdAccount,"Account Created","Account Creation",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(returnMessage == "NOTCREATED"){
            JOptionPane.showMessageDialog(createdAccount,"Error Trying To Create Account","Account Creation",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(createdAccount,"Account Already Exists","Account Creation",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

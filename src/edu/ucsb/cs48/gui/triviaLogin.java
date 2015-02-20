package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class that the login window look and behavior
 */
public class triviaLogin {

    //Declare gui components
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
    JFrame loginError;

    /**
     * createWindow method that creates the JFrame with correct look and behavior
     */
    public void createWindow() {
        // instantiate gui components
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

        // Define behavior for window when it is closed
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
        // When login field is first pressed clear the text
        loginField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginField.setText("");
                passwordField.setText("");
            }
        });

        //when login field is first pressed clear the text
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

        //when password is first pressed clear the text
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

        /**
         * When login button is pressed, check if user inputted username and password
         * is correct. If correct go to main menu. Else go display a prompt saying the
         * credentials are wrong
         */
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Authenticate User
                String username = loginField.getText();
                String password = passwordField.getText();
                if(Main.player.loginCheck(username,password)){
                    triviaMain.setCurrentPanel(new mainMenuPanel());
                    frame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(loginError,"Incorrect Password. Please try again","Login Incorrect",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        /**
         * When login button is pressed, check if user inputted username and password
         * is correct. If correct go to main menu. Else go display a prompt saying the
         * credentials are wrong
         */
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String username = loginField.getText();
                    String password = passwordField.getText();
                    if(Main.player.loginCheck(username,password)){
                        Main.player.setUsername(username);
                        triviaMain.setCurrentPanel(new mainMenuPanel());
                        frame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(loginError,"Incorrect Password. Please try again","Login Incorrect",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

    }
}

package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class the starts it all
 * This class is the one that first initializes the JFrame and is updated with a new panel each time
 */
public class triviaMain {

    //Java GUI components
    triviaLogin loginWindow;
    triviaCreateAccount createAccountWindow;
    JPanel mainPanel;
    JPanel topPanel;
    JPanel botPanel;
    JButton loginButton;
    JButton createAccountButton;
    JButton options;
    JLabel triviaTitle;
    GridBagConstraints gbc;

    // GUI constants
    public static JFrame mainFrame;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String pathToFileOnDisk = "icon_256.png";
    public static final ImageIcon icon = new ImageIcon(pathToFileOnDisk);

    public void createWindow(){
        // Instantiate objects
        mainFrame = new JFrame("Trivia Master");
        mainPanel = new JPanel(new GridLayout(2,1));
        topPanel = new JPanel(new BorderLayout());
        botPanel = new JPanel(new GridBagLayout());
        loginButton = new JButton("Account Login");
        createAccountButton = new JButton("Create Account");
        options = new JButton("Options");
        triviaTitle = new JLabel("Trivia Master");
        loginWindow = new triviaLogin();
        createAccountWindow = new triviaCreateAccount();
        gbc = new GridBagConstraints();

        // set jlabel properties
        triviaTitle.setFont(new Font("Serif", Font.BOLD, 64));
        triviaTitle.setVerticalAlignment(SwingConstants.CENTER);
        triviaTitle.setHorizontalAlignment(SwingConstants.CENTER);

        //add components to top panel
        topPanel.add(triviaTitle,BorderLayout.CENTER);

        //configure gridbaglayout and add to bot panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        botPanel.add(loginButton,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        botPanel.add(options,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        botPanel.add(createAccountButton,gbc);

        //add bot and top panels to main panel
        mainPanel.add(topPanel);
        mainPanel.add(botPanel);

        //add main panel to JFrame
        mainFrame.setContentPane(mainPanel);

        // Set Jframe properties
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setIconImage(icon.getImage());

        mainFrame.setVisible(true);

        /* Event manager */
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                loginWindow.createWindow();
            }
        });

        createAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                createAccountWindow.createWindow();
            }
        });

        options.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
    }

    /**
     * Helper function to set current panel in main JFrame to avoid window clutter
     * @param newPanel
     */
    public static void setCurrentPanel(JPanel newPanel){
        mainFrame.setContentPane(newPanel);
        mainFrame.revalidate();
    }

}

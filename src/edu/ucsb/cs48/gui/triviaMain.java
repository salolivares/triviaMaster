package edu.ucsb.cs48.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

/**
 * The very first GUI class to be called
 * This class is the one that first initializes the JFrame and is updated with a new panel each time
 */
public class triviaMain {

    //Java GUI components
    triviaLogin loginWindow;
    triviaCreateAccount createAccountWindow;
    JButton loginButton;
    JButton createAccountButton;
    JLabel background;
    JLabel triviaTitle;
    GridBagConstraints gbc;

    // GUI constants
    public static JFrame mainFrame;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    // Icon for GUI
    String pathToFileOnDisk = "assets/icon.png";
    ImageIcon icon = new ImageIcon(pathToFileOnDisk);

    /**
     * Create the GUI window
     */
    public void createWindow(){
        // Select a UI design
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        // background image
       // Image image = null;
        //try{
            //URL url = new URL("file:///C:/Users/brand_000/Documents/GitHub/triviaMaster/assets/background.jpg");
        //    URL url = new URL("file:/assets/background.jpg");
        //    image = ImageIO.read(url);
        //}
        //catch (IOException e) {
          //  e.printStackTrace();
        //}
        ///ImageIcon image = new ImageIcon("assets/Skip.jpg"));
        background = new JLabel(new ImageIcon("assets/background.jpg"));
        background.setOpaque(false);
        background.setLayout(new GridBagLayout());



        // Instantiate GUI components
        mainFrame = new JFrame("Trivia Master");
        loginButton = new JButton("Account Login");
        createAccountButton = new JButton("Create Account");

        triviaTitle = new JLabel("Trivia Master");
        loginWindow = new triviaLogin();
        createAccountWindow = new triviaCreateAccount();
        gbc = new GridBagConstraints();

        // set jlabel properties
        triviaTitle.setFont(new Font("Serif", Font.BOLD, 64));
        triviaTitle.setVerticalAlignment(SwingConstants.CENTER);
        triviaTitle.setHorizontalAlignment(SwingConstants.CENTER);

        //add background image
        mainFrame.add(background);


        //configure gridbaglayout and add to bot panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,170,0);
        background.add(triviaTitle, gbc);
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 20;
        gbc.ipadx = 45;
        background.add(loginButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 20;
        gbc.ipadx = 40;
        gbc.insets = new Insets(0,0,100,0);
        background.add(createAccountButton, gbc);

        //add main panel to JFrame
        mainFrame.setContentPane(background);

        // Set Jframe properties
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setIconImage(icon.getImage());


        mainFrame.setVisible(true);

        /* Event managers */

        /**
         * An event listen to create a login window when pressed
         */
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                loginWindow.createWindow();
            }
        });

        /**
         * An event listener to create a "create an account" window when pressed
         */
        createAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                createAccountWindow.createWindow();
            }
        });

    }

    /**
     * Helper function to set current panel in main JFrame to avoid window clutter
     * @param newPanel the panel to display on the GUI window
     */
    public static void setCurrentPanel(JPanel newPanel){
        mainFrame.setContentPane(newPanel);
        mainFrame.revalidate();
    }

}

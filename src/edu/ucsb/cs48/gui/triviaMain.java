package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The very first GUI class to be called
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

        // Instantiate GUI components
        mainFrame = new JFrame("Trivia Master");
        mainPanel = new JPanel(new GridLayout(2,1));
        topPanel = new JPanel(new BorderLayout());
        botPanel = new JPanel(new GridBagLayout());
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

        //add components to top panel
        topPanel.add(triviaTitle,BorderLayout.CENTER);

        //configure gridbaglayout and add to bot panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        botPanel.add(loginButton,gbc);
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

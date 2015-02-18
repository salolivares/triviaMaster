package edu.ucsb.cs48.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class optionsPanel extends JPanel {
    JPanel botPanel;
    JLabel title;
    JLabel volume;
    JButton menu;
    JButton test;
    JSlider slider;
    GridBagConstraints gbc;
    JLabel background;
    JPanel p;

    public optionsPanel() {

        Image image = null;
        try{
            URL url = new URL("http://www.oep.ucsb.edu/sites/www.oep.ucsb.edu/files/layout_images/19D_StorkePanorama001.jpg");
            image = ImageIO.read(url);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        background = new JLabel(new ImageIcon(image));
        background.setOpaque(false);
        add(background);
        background.setLayout(new GridBagLayout());

        title = new JLabel("Options");
        botPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();

        //set layout manager
        setLayout(new BorderLayout());

        //bottom panel
        title = new JLabel("Options");
        title.setFont(new Font("Courier New", Font.BOLD, 70));
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0,0,0,0);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        background.add(title, gbc);

        volume = new JLabel("Volume Control", JLabel.CENTER);
        volume.setFont(new Font("Corier New", Font.BOLD, 25));
        gbc.insets = new Insets(75,0,0,0);
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        background.add(volume, gbc);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBackground(Color.BLUE);
        slider.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLoweredBevelBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        gbc.insets = new Insets(20,0,0,0);
        gbc.ipady = 40;
        gbc.gridx = 0;
        gbc.gridy = 2;
        background.add(slider, gbc);

        menu = new JButton("Return to Main Menu");
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(50,600,0,0);
        gbc.ipady = 30;
        gbc.ipadx = 30;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        background.add(menu, gbc);

        botPanel.setBackground(Color.darkGray);
        add(background, BorderLayout.CENTER);

        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });


    }

}

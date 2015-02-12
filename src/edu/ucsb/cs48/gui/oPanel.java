package edu.ucsb.cs48.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class oPanel extends JPanel {
    JPanel topPanel;
    JPanel botPanel;
    JLabel title;
    JLabel volume;
    JButton menu;
    JButton test;
    JSlider slider;
    GridBagConstraints gbc;


    public oPanel() {

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("/Users/brand_000/Documents/GitHub/triviaMaster/src/edu/ucsb/cs48/gui/assets/water.jpg"));
        } catch (IOException ex) {

        }


        JLabel pic = new JLabel(new ImageIcon(image));

        JPanel e = new JPanel(new BorderLayout());
        e.add(pic, BorderLayout.NORTH);

        title = new JLabel("Options");
        //topPanel = new JPanel(new BorderLayout());
        botPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        //gbc.fill = GridBagConstraints.VERTICAL;

        //set layout manager
        setLayout(new BorderLayout());

        //add components to top panel
        //topPanel.add(title,BorderLayout.NORTH);

        //bottom panel
        title = new JLabel("Options");
        title.setFont(new Font("Papyrus", Font.BOLD, 55));
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0,0,0,0);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        botPanel.add(title, gbc);

        volume = new JLabel("Volume Control", JLabel.CENTER);
        volume.setFont(new Font("Papyrus", Font.BOLD, 25));
        gbc.insets = new Insets(75,0,0,0);
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        botPanel.add(volume, gbc);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLoweredBevelBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        gbc.insets = new Insets(20,0,0,0);
        gbc.ipady = 40;
        gbc.gridx = 0;
        gbc.gridy = 2;
        botPanel.add(slider, gbc);

        menu = new JButton("Return to Main Menu");
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(50,0,0,0);
        gbc.ipady = 30;
        gbc.ipadx = 50;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        botPanel.add(menu, gbc);

        test = new JButton(("Test"));

        //add the panels to the oPanel


        //add(e, BorderLayout.WEST);
        add(botPanel, BorderLayout.CENTER);

        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });





    }

}
/*
class iPanel extends JPanel {
    private BufferedImage image;
    public iPanel() {
        try {
            image = ImageIO.read(new File("/Users/brand_000/Documents/GitHub/triviaMaster/water.jpg"));
        } catch (IOException ex) {

        }

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        //g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
*/
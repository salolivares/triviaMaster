package edu.ucsb.cs48.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gameModePanel extends JPanel{
    JButton mode1;
    JButton mode2;
    JLabel selectMode;
    JPanel mainPanel;

    gameModePanel() {
        mode1 = new JButton("GAME MODE 1");
        mode2 = new JButton("GAME MODE 2");
        selectMode = new JLabel("Choose game mode");

        selectMode.setFont(new Font("Serif", Font.BOLD, 32));
        selectMode.setHorizontalAlignment(SwingConstants.CENTER);
        selectMode.setVerticalAlignment(SwingConstants.CENTER);

        mainPanel = new JPanel(new GridLayout(3,1));
        mainPanel.add(selectMode);
        mainPanel.add(mode1);
        mainPanel.add(mode2);

        add(mainPanel);

    }

}
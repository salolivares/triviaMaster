package edu.ucsb.cs48.gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class optionsPanel extends JPanel {
    JButton mainMenu;
    JLabel volume;
    JPanel panel;
    JLabel title;
    JSlider slider;

    JCheckBox yes;
    JCheckBox no;

    optionsPanel() {
        mainMenu = new JButton("Back to Main Menu");

        yes = new JCheckBox("ON");
        no = new JCheckBox("OFF");

        volume = new JLabel("Volume Control");
        volume.setFont(new Font("Serif", Font.ITALIC, 25));

        title = new JLabel("Options");
        title.setFont(new Font("Serif", Font.BOLD, 70));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        panel.add(title);
        panel.add(volume);
        panel.add(yes);
        panel.add(no);
        panel.add(slider);
        panel.add(mainMenu);
        //panel.setBackground(Color.darkGray);

        add(panel);

        mainMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });






    }

}

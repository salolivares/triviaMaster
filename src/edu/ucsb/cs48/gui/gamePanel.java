package edu.ucsb.cs48.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Jordan Nguyen on 2/9/2015.
 */
public class gamePanel extends JPanel{

    JPanel botPanel;
    JLabel question;
    JLabel noAnsSelected;
    JRadioButton answer1;
    JRadioButton answer2;
    JRadioButton answer3;
    JRadioButton answer4;
    JRadioButton answer5;
    JButton submit;
    Action pressedEnter;
    Action pressed1;
    Action pressed2;
    Action pressed3;
    Action pressed4;
    Action pressed5;

    public gamePanel(String q, String a1, String a2, String a3,
                     String a4, String a5) {

        // Instantiate Components
        botPanel      = new JPanel(new GridBagLayout());
        question      = new JLabel(q);
        answer1       = new JRadioButton(a1);
        answer2       = new JRadioButton(a2);
        answer3       = new JRadioButton(a3);
        answer4       = new JRadioButton(a4);
        answer5       = new JRadioButton(a5);
        submit        = new JButton("Submit Answer");
        noAnsSelected = new JLabel("Please select an answer!");
        setLayout(new BorderLayout());


        // Set font and allignment of question and answers
        question.setFont(new Font("Arial", Font.BOLD, 18));
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setVerticalAlignment(SwingConstants.CENTER);

        answer1.setFont(new Font("Arial", Font.PLAIN, 16));
        answer2.setFont(new Font("Arial", Font.PLAIN, 16));
        answer3.setFont(new Font("Arial", Font.PLAIN, 16));
        answer4.setFont(new Font("Arial", Font.PLAIN, 16));
        answer5.setFont(new Font("Arial", Font.PLAIN, 16));

        noAnsSelected.setFont(new Font("Arial", Font.BOLD, 16));
        noAnsSelected.setForeground(Color.RED);
        noAnsSelected.setHorizontalAlignment(SwingConstants.CENTER);
        noAnsSelected.setVerticalAlignment(SwingConstants.CENTER);
        noAnsSelected.setVisible(false);  //will set visible if user presses submit with no answer selected


        // Group the answers together so only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(answer1);
        group.add(answer2);
        group.add(answer3);
        group.add(answer4);
        group.add(answer5);

        // set up GBC and panels
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        botPanel.add(question,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        botPanel.add(answer1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        botPanel.add(answer2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        botPanel.add(answer3, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        botPanel.add(answer4, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        botPanel.add(answer5, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        botPanel.add(submit, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        botPanel.add(noAnsSelected, gbc);

        add(botPanel, BorderLayout.CENTER);



        // Allow user to hit ENTER to continue in addition to clicking enter
        pressedEnter = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(answer1.isSelected()) && !(answer2.isSelected()) && !(answer3.isSelected())
                        && !(answer4.isSelected()) && !(answer5.isSelected()))
                    noAnsSelected.setVisible(true);
                else
                    triviaMain.setCurrentPanel(new categoryPanel());

            }
        };

        submit.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        submit.getActionMap().put("pressed", pressedEnter);

        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (!(answer1.isSelected()) && !(answer2.isSelected()) && !(answer3.isSelected())
                        && !(answer4.isSelected()) && !(answer5.isSelected()))
                    noAnsSelected.setVisible(true);
                else
                    triviaMain.setCurrentPanel(new categoryPanel());
            }
        });


        // Allow user to hit 1,2,3,4,5 to select an answer in addition to clicking enter
        pressed1 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer1.setSelected(true);
            }
        };

        answer1.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("1"), "pressed");
        answer1.getActionMap().put("pressed", pressed1);

        pressed2 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer2.setSelected(true);
            }
        };

        answer2.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("2"), "pressed");
        answer2.getActionMap().put("pressed", pressed2);

        pressed3 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer3.setSelected(true);
            }
        };

        answer3.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("3"), "pressed");
        answer3.getActionMap().put("pressed", pressed3);

        pressed4 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer4.setSelected(true);
            }
        };

        answer4.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("4"), "pressed");
        answer4.getActionMap().put("pressed", pressed4);

        pressed5 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer5.setSelected(true);
            }
        };

        answer5.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("5"), "pressed");
        answer5.getActionMap().put("pressed", pressed5);




    }

}




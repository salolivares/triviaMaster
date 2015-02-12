package edu.ucsb.cs48.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Jordan Nguyen on 2/9/2015.
 */
public class gamePanel extends JPanel{

    JPanel mainPanel;
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
        mainPanel     = new JPanel();
        question      = new JLabel(q);
        answer1       = new JRadioButton(a1);
        answer2       = new JRadioButton(a2);
        answer3       = new JRadioButton(a3);
        answer4       = new JRadioButton(a4);
        answer5       = new JRadioButton(a5);
        submit        = new JButton("Submit Answer");
        noAnsSelected = new JLabel("Please select an answer!");


        // Set font and allignment of question and answers
        question.setFont(new Font("Arial", Font.PLAIN, 16));
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setVerticalAlignment(SwingConstants.CENTER);

        noAnsSelected.setFont(new Font("Arial", Font.BOLD, 16));
        noAnsSelected.setForeground(Color.RED);
        noAnsSelected.setHorizontalAlignment(SwingConstants.CENTER);
        noAnsSelected.setVerticalAlignment(SwingConstants.CENTER);
        noAnsSelected.setVisible(false);  //will set visible if user presses submit with no answer selected

        answer1.setHorizontalAlignment(SwingConstants.CENTER);
        answer1.setVerticalAlignment(SwingConstants.CENTER);

        answer2.setHorizontalAlignment(SwingConstants.CENTER);
        answer2.setVerticalAlignment(SwingConstants.CENTER);

        answer3.setHorizontalAlignment(SwingConstants.CENTER);
        answer3.setVerticalAlignment(SwingConstants.CENTER);

        answer4.setHorizontalAlignment(SwingConstants.CENTER);
        answer4.setVerticalAlignment(SwingConstants.CENTER);

        answer5.setHorizontalAlignment(SwingConstants.CENTER);
        answer5.setVerticalAlignment(SwingConstants.CENTER);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        // Group the answers together so only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(answer1);
        group.add(answer2);
        group.add(answer3);
        group.add(answer4);
        group.add(answer5);


        // Add all the components to the panel
        mainPanel.add(question);
        mainPanel.add(answer1);
        mainPanel.add(answer2);
        mainPanel.add(answer3);
        mainPanel.add(answer4);
        mainPanel.add(answer5);
        mainPanel.add(submit);
        mainPanel.add(noAnsSelected);
        add(mainPanel);



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




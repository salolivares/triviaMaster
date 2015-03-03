package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;
import edu.ucsb.cs48.util.Game;
import edu.ucsb.cs48.util.QuestionAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates the panel where the game is played.
 * This panel contains the question and potential answers.
 */
public class gamePanel extends JPanel{

    JPanel topPanel;
    JPanel botPanel;
    JLabel question;
    JLabel noAnsSelected;
    JLabel score;
    JRadioButton answer1;
    JRadioButton answer2;
    JRadioButton answer3;
    JRadioButton answer4;
    JRadioButton answer5;
    JButton submit;
    JButton next;
    JButton AutoAnswer;
    JButton QEliminator;
    Action pressedEnter;
    Action pressedEnterNext;
    Action pressed1;
    Action pressed2;
    Action pressed3;
    Action pressed4;
    Action pressed5;
    Action pressedQ;
    Action pressedW;
    String correctAnswer;
    JPanel southPanel;
    static final double VALUE = 10;

    /**
     * gamePanel constructor that sets up the panel with
     * questions and answers
     * @param q The question
     * @param a1 Potential answer 1
     * @param a2 Potential answer 2
     * @param a3 Potential answer 3
     * @param a4 Potential answer 4
     * @param a5 Potential answer 5
     * @param cAnswer Correct answer
     */

    public gamePanel(String q, String a1, String a2, String a3,
                     String a4, String a5,String cAnswer) {

        // Instantiate Components
        botPanel      = new JPanel(new GridBagLayout());
        topPanel      = new JPanel(new GridBagLayout());
        southPanel      = new JPanel(new GridBagLayout());
        question      = new JLabel(q);
        score         = new JLabel("Score: " + Main.game.getGameScore());
        answer1       = new JRadioButton(a1);
        answer2       = new JRadioButton(a2);
        answer3       = new JRadioButton(a3);
        answer4       = new JRadioButton(a4);
        answer5       = new JRadioButton(a5);
        AutoAnswer    = new JButton("Auto Answer (Q): 0");
        QEliminator   = new JButton("Question Eliminator (W): 0");
        submit        = new JButton("Submit Answer");
        next          = new JButton("Next");
        next.setVisible(false);
        noAnsSelected = new JLabel("Please select an answer!");
        correctAnswer = cAnswer;
        setLayout(new BorderLayout());


        // set button size
        AutoAnswer.setPreferredSize(new Dimension(300,100));
        QEliminator.setPreferredSize(new Dimension(300,100));

        // Set font and allignment of question and answers
        question.setFont(new Font("Arial", Font.BOLD, 16));
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setVerticalAlignment(SwingConstants.CENTER);

        score.setFont(new Font("Arial", Font.BOLD, 14));

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
        final ButtonGroup group = new ButtonGroup();
        group.add(answer1);
        group.add(answer2);
        group.add(answer3);
        group.add(answer4);
        group.add(answer5);

        // set up GBC and panels
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 3;
        gbc.gridy = 0;
        southPanel.add(QEliminator, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        southPanel.add(AutoAnswer, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        topPanel.add(score, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.CENTER;
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
        botPanel.add(next, gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        botPanel.add(noAnsSelected, gbc);

        add(topPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(botPanel, BorderLayout.CENTER);



        // Allow user to hit ENTER to continue in addition to clicking enter
        pressedEnter = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(answer1.isSelected()) && !(answer2.isSelected()) && !(answer3.isSelected())
                        && !(answer4.isSelected()) && !(answer5.isSelected()))
                    noAnsSelected.setVisible(true);
                else {
                    checkAnswer();
                }

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
                else {
                    checkAnswer();
                }
            }
        });


        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // gui signals to game controller that is is done
                Game.latch.countDown();
                }
            }
        );

        pressedEnterNext = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.latch.countDown();
            }
        };

        next.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        next.getActionMap().put("pressed", pressedEnterNext);

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

        pressedQ = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("STUB");
            }
        };

        AutoAnswer.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("Q"), "pressed");
        AutoAnswer.getActionMap().put("pressed", pressedQ);

        pressedW = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("STUB");
            }
        };

        QEliminator.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "pressed");
        QEliminator.getActionMap().put("pressed", pressedW);

    }

    /**
     * A helper function to check if the user input the correct answer.
     * Also sets font to green or red depending if selection is right or wrong.
     */
    public void checkAnswer() {
        if (answer1.isSelected()) {
            if (answer1.getText().equals(this.correctAnswer)) {
                answer1.setForeground(Color.GREEN);
                Main.game.addToGameScore(VALUE);
            }
            else
                answer1.setForeground(Color.RED);
            }
        if (answer2.isSelected()) {
            if (answer2.getText().equals(this.correctAnswer)) {
                answer2.setForeground(Color.GREEN);
                Main.game.addToGameScore(VALUE);
            }
            else
                answer2.setForeground(Color.RED);
            }
        if (answer3.isSelected()) {
            if (answer3.getText().equals(this.correctAnswer)) {
                answer3.setForeground(Color.GREEN);
                Main.game.addToGameScore(VALUE);
            }
            else
                answer3.setForeground(Color.RED);
            }
        if (answer4.isSelected()) {
            if (answer4.getText().equals(this.correctAnswer)) {
                answer4.setForeground(Color.GREEN);
                Main.game.addToGameScore(VALUE);
            }
            else
                answer4.setForeground(Color.RED);
            }
        if (answer5.isSelected()) {
            if (answer5.getText().equals(this.correctAnswer)) {
                answer5.setForeground(Color.GREEN);
                Main.game.addToGameScore(VALUE);
            }
            else
                answer5.setForeground(Color.RED);
            }

        submit.setVisible(false);
        next.setVisible(true);

        }



    }






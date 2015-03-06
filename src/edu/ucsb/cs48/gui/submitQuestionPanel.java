package edu.ucsb.cs48.gui;

import edu.ucsb.cs48.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * This panel allows user to submit their own questions
 */

public class submitQuestionPanel extends JPanel {

    JPanel mainPanel;
    JLabel title;
    JComboBox categoryList;
    JLabel categoryListLabel;
    JLabel questionLabel;
    JLabel choiceLabel1;
    JLabel choiceLabel2;
    JLabel choiceLabel3;
    JLabel choiceLabel4;
    JLabel choiceLabel5;
    JLabel correctAnswerLabel;
    JTextField question;
    JTextField choice1;
    JTextField choice2;
    JTextField choice3;
    JTextField choice4;
    JTextField choice5;
    JComboBox correctAnswer;
    JButton submit;
    JButton mainMenu;

    public submitQuestionPanel() {

        // instantiate all JComponents
        mainPanel          = new JPanel(new GridBagLayout());
        title              = new JLabel("Submit your own question!");
        questionLabel      = new JLabel("Question: ");
        choiceLabel1       = new JLabel("Choice 1: ");
        choiceLabel2       = new JLabel("Choice 2: ");
        choiceLabel3       = new JLabel("Choice 3: ");
        choiceLabel4       = new JLabel("Choice 4: ");
        choiceLabel5       = new JLabel("Choice 5: ");
        categoryListLabel  = new JLabel("Category: ");
        correctAnswerLabel = new JLabel("Answer #: ");
        question           = new JTextField(50);
        choice1            = new JTextField(50);
        choice2            = new JTextField(50);
        choice3            = new JTextField(50);
        choice4            = new JTextField(50);
        choice5            = new JTextField(50);
        submit             = new JButton("Submit");
        mainMenu           = new JButton("Main Menu");
        question.setDocument(new JTextFieldLimit(75));
        choice1.setDocument(new JTextFieldLimit(40));
        choice2.setDocument(new JTextFieldLimit(40));
        choice3.setDocument(new JTextFieldLimit(40));
        choice4.setDocument(new JTextFieldLimit(40));
        choice5.setDocument(new JTextFieldLimit(40));

        ArrayList<String> categories = Main.qa.getCategories();
        Collections.sort(categories);
        categoryList = new JComboBox(categories.toArray());
        categoryList.setMaximumRowCount(3);

        Integer[] answers = {1, 2, 3, 4, 5};
        correctAnswer = new JComboBox(answers);
        correctAnswer.setPreferredSize(new Dimension(40,20));

        // set up panel layout and constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,5,10,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(categoryListLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        mainPanel.add(categoryList, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(questionLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        mainPanel.add(question, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(choiceLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        mainPanel.add(choice1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(choiceLabel2, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        mainPanel.add(choice2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(choiceLabel3, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        mainPanel.add(choice3, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(choiceLabel4, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        mainPanel.add(choice4, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(choiceLabel5, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        mainPanel.add(choice5, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(correctAnswerLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        mainPanel.add(correctAnswer, gbc);
        gbc.gridx = 1;
        gbc.gridy = 8;
        mainPanel.add(submit, gbc);
        gbc.gridy = 9;
        mainPanel.add(mainMenu, gbc);

        add(mainPanel);

        // set action listeners for buttons
        mainMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                triviaMain.setCurrentPanel(new mainMenuPanel());
            }
        });

        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });

    }


    // inner class to limit JTextField character
    // class taken from online http://www.rgagnon.com/javadetails/java-0198.html
    public class JTextFieldLimit extends PlainDocument {
        private int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }

}

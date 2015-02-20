package edu.ucsb.cs48.util;


import edu.ucsb.cs48.Main;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class to hold one question and five answers at a time.
 * This class is used for all questions and all answers that will be used in the game.
 * It is created by the Game class controller and then used by the GUI
 * to set the name of the labels and radio buttons
 * @see edu.ucsb.cs48.util.Game
 * @see edu.ucsb.cs48.gui.gamePanel
 */
public class QuestionAndAnswers {
    private String question;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    private String answerFive;
    private String correctAnswer;

    private int numberOfQuestions;
    private ArrayList<Integer> questionIDList;
    private String [] listOfQuestions;


    /**
     * Only constructor for this class because it must only be passed a category indentifier
     * and nothing more or nothing less
     * @param category An ID that identifies a category in the database
     */
    public QuestionAndAnswers(int category){
        this.questionIDList = Main.qa.getQuestionIDs(category);
        this.numberOfQuestions = questionIDList.size();
    }

    /**
     * Selects a random question ID
     * @param q An arraylist that is passed that it filled with question IDs (integers)
     * @return Returns a random questions ID from the question ID array list
     */
    private int randomlySelectQuestionID(ArrayList<Integer> q){
        int arrayLength = q.size();
        System.out.println(arrayLength);
        Random rand = new Random();
        int randomIndexInt = rand.nextInt(arrayLength);
        int result = questionIDList.get(randomIndexInt);
        q.remove(randomIndexInt);
        return result;
    }

    /**
     * Fetch questions and answers from database and set the class's private String variables
     */
    private void fetchAndSetQuestionAndAnswers(){
        int selectedQuestionID = randomlySelectQuestionID(questionIDList);
        this.listOfQuestions = Main.qa.getQuestionAndAnswer(selectedQuestionID);

        setQuestion(listOfQuestions[0]);
        setAnswerOne(listOfQuestions[1]);
        setAnswerTwo(listOfQuestions[2]);
        setAnswerThree(listOfQuestions[3]);
        setAnswerFour(listOfQuestions[4]);
        setAnswerFive(listOfQuestions[5]);

        int correctAnswerIndex = Integer.parseInt(listOfQuestions[6]);
        setCorrectAnswer(listOfQuestions[correctAnswerIndex]);
    }

    /**
     * Each time the method is called it changes the question and the corresponding
     * answers it holds. So by calling this method you'll get a different question
     * each time you call it. Only call it when you need a random  question in the
     * database.
     * @return A random question from the database. Doesn't return a dupiclate question>
     */
    public String getQuestion() {
        fetchAndSetQuestionAndAnswers();
        System.out.println(question);
        return question;
    }

    /**
     * The rest of the methods are setters and getters for the rest of class's private
     * variables.
     */
    public String getAnswerOne() { return answerOne; }

    public String getAnswerTwo() { return answerTwo; }

    public String getAnswerThree() { return answerThree; }

    public String getAnswerFour() { return answerFour; }

    public String getAnswerFive() { return answerFive; }

    public String getCorrectAnswer(){ return correctAnswer; }

    public int getNumberOfQuestions(){ return this.numberOfQuestions; }

    public void setAnswerFive(String answerFive) { this.answerFive = answerFive; }

    public void setQuestion(String question) { this.question = question; }

    public void setAnswerOne(String answerOne) { this.answerOne = answerOne; }

    public void setAnswerTwo(String answerTwo) { this.answerTwo = answerTwo; }

    public void setAnswerThree(String answerThree) { this.answerThree = answerThree; }

    public void setAnswerFour(String answerFour) { this.answerFour = answerFour; }
    
    public void setCorrectAnswer(String correctAnswer){ this.correctAnswer = correctAnswer; }
}

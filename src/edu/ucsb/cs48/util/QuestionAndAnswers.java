package edu.ucsb.cs48.util;


import edu.ucsb.cs48.Main;

import java.util.ArrayList;
import java.util.Random;

public class QuestionAndAnswers {
    private String question;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    private String answerFive;

    private int category;
    private int numberOfQuestions;


    public QuestionAndAnswers(int category){
        ArrayList<Integer> questionIDList = Main.qa.getQuestionIDs(category);
        this.numberOfQuestions = questionIDList.size();
        this.category = category;
    }

    private int randomlySelectQuestionID(ArrayList<Integer> q){
        int arrayLength = q.size();
        System.out.println(arrayLength);
        Random rand = new Random();
        int result = rand.nextInt(arrayLength);

        q.remove(result);

        return result;
    }

    private void fetchAndSetQuestionAndAnswers(){
        ArrayList<Integer> questionIDList = Main.qa.getQuestionIDs(category);
        int selectedQuestionID = randomlySelectQuestionID(questionIDList);
        String [] listOfQuestions = Main.qa.getQuestionAndAnswer(selectedQuestionID);

        setQuestion(listOfQuestions[0]);
        setAnswerOne(listOfQuestions[1]);
        setAnswerTwo(listOfQuestions[2]);
        setAnswerThree(listOfQuestions[3]);
        setAnswerFour(listOfQuestions[4]);
        setAnswerFive(listOfQuestions[5]);
    }

    public String getQuestion() {
        fetchAndSetQuestionAndAnswers();
        return question;
    }
    public String getAnswerOne() {
        return answerOne;
    }
    public String getAnswerTwo() {
        return answerTwo;
    }
    public String getAnswerThree() {
        return answerThree;
    }
    public String getAnswerFour() {
        return answerFour;
    }
    public String getAnswerFive() {
        return answerFive;
    }
    public int getNumberOfQuestions(){ return this.numberOfQuestions; }

    public void setAnswerFive(String answerFive) {
        this.answerFive = answerFive;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

    public void setAnswerFour(String answerFour) {
        this.answerFour = answerFour;
    }
}

package edu.ucsb.cs48.util;


public class QuestionAndAnswers {
    private String question;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    private String answerFive;

    private String category;
    private int difficulty;

    private static int currentQuestion = 0;
    private int lastQuestion;

    public QuestionAndAnswers(String category, int difficulty){
        this.category = category;
        this.difficulty = difficulty;
        currentQuestion = 0;
    }

    private void fetchAndSetQuestionAndAnswers(){
        setQuestion("test");
        setAnswerOne("test");
        setAnswerTwo("test");
        setAnswerThree("test");
        setAnswerFour("test");
        setAnswerFive("test");

        currentQuestion++;
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

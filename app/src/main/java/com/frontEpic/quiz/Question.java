package com.frontEpic.quiz;

public class Question {

    private String questionText;
    private boolean correctAnswer;

    public Question(String questionText, boolean correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getquestionText() {
        return questionText;
    }

    public void setquestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean answerTrue) {
        this.correctAnswer = correctAnswer;
    }
}

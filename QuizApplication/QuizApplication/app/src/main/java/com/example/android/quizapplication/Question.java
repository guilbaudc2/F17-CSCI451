package com.example.android.quizapplication;

/**
 * Created by Android on 9/16/2017.
 */

public class Question {
    public String question;
    public String[] answers;
    public int pictureID;
    public String correctAnswer;


    public Question(String question, String[] answers, int pictureID, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.pictureID = pictureID;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

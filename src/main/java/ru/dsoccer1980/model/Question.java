package ru.dsoccer1980.model;

public class Question {

    private int id;
    private String question;
    private String answer;

    public Question(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return
                "[" + question + ", " + answer + "]";
    }
}

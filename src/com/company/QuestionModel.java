package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuestionModel implements Results {
    private String question;
    private ArrayList<String> options;
    private String correctAns;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        Collections.shuffle(options);
        this.options = options;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    @Override
    public String toString() {
        return question + "\nA) " + options.get(0) + "\nB) " + options.get(1) + "\nC) " + options.get(2) + "\nD) " + options.get(3);
    }

    @Override
    public int ansCorrect(int score) {
        score += 4;
        return score;
    }
    @Override
    public int ansIncorrect(int score) {
        score -= 1;
        return score;
    }

    @Override
    public boolean checkAns(char selectedOption, String correctAns) {
        switch (Character.toUpperCase(selectedOption)){
            case 'A' -> {
                return options.get(0).equalsIgnoreCase(correctAns);
            }
            case 'B' -> {
                return options.get(1).equalsIgnoreCase(correctAns);
            }
            case 'C' -> {
                return options.get(2).equalsIgnoreCase(correctAns);
            }
            case 'D' -> {
                return options.get(3).equalsIgnoreCase(correctAns);
            }
        }
        return false;
    }
}

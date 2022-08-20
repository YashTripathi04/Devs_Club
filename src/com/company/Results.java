package com.company;

public interface Results {
    int ansCorrect(int score);
    int ansIncorrect(int score);
    boolean checkAns(char selectedOption, String correctAns);
}

package com.company;

import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("""
                Grading Criteria:
                1] +4 for every correct answer.
                2] -1 for every incorrect answer.
                """);
        System.out.print("Select a topic: 1] Kotlin 2] Java 3] Exit\n---> ");
        int topicNum = in.nextInt();
        Topic kotlinQuiz, javaQuiz;
        char answer;
        int score, noOfQuestions;
        score = 0;

        while(topicNum != 3){
            switch (topicNum){
                case 1 -> {
                    kotlinQuiz = new Kotlin();
                    kotlinQuiz.setTopicName();
                    kotlinQuiz.setQuestions();
                    noOfQuestions = kotlinQuiz.questions.size();
                    for(int i = 0; i < noOfQuestions; i++){
                        System.out.print( "\n" + (i + 1) + "] " + kotlinQuiz.questions.get(i).toString() + "\n---> ");
                        answer = in.next().charAt(0);
                        if(kotlinQuiz.questions.get(i).checkAns(answer, kotlinQuiz.questions.get(i).getCorrectAns()))
                            score = kotlinQuiz.questions.get(i).ansCorrect(score);
                        else
                            score = kotlinQuiz.questions.get(i).ansIncorrect(score);
                    }
                }
                case 2 -> {
                    javaQuiz = new Java();
                    javaQuiz.setTopicName();
                    javaQuiz.setQuestions();
                    noOfQuestions = javaQuiz.questions.size();
                    for(int i = 0; i < noOfQuestions; i++){
                        System.out.print( "\n" + (i + 1) + "] " + javaQuiz.questions.get(i).toString() + "\n---> ");
                        answer = in.next().charAt(0);
                        if(javaQuiz.questions.get(i).checkAns(answer, javaQuiz.questions.get(i).getCorrectAns()))
                            score = javaQuiz.questions.get(i).ansCorrect(score);
                        else
                            score = javaQuiz.questions.get(i).ansIncorrect(score);
                    }
                }
            }
            System.out.println("-------x-------x-------x-------x------");
            System.out.println("Score = " + score);
            System.out.println("-------x-------x-------x-------x------");
            score = 0;
            System.out.print("""
                    
                    Select a topic to start again: 1] Kotlin 2] Java 
                    Enter 3 to EXIT
                    ---> """);
            topicNum = in.nextInt();
        }
    }

    static class Kotlin extends Topic{
        @Override
        public String getTopicName() {
            return this.topicName;
        }
        @Override
        public void setTopicName() {
            this.topicName = "Kotlin";
        }

        @Override
        public ArrayList<QuestionModel> getQuestions() {
            return this.questions;
        }
        @Override
        public void setQuestions(){
            ArrayList<QuestionModel> questionList = new ArrayList<>();
            ArrayList<String> options1 = new ArrayList<>();
            ArrayList<String> options2 = new ArrayList<>();
            ArrayList<String> options3 = new ArrayList<>();
            QuestionModel q1 = new QuestionModel();
            q1.setQuestion("Which of the following is true for Kotlin variables?");
            Collections.addAll(options1,"var can't be changed", "val can be changed", "val corresponds to final variable in Java", "All variables are immutable by default");
            q1.setOptions(options1);
            q1.setCorrectAns("val corresponds to final variable in Java");

            QuestionModel q2 = new QuestionModel();
            q2.setQuestion("Which keyword is used to declare a function?");
            Collections.addAll(options2,"func", "fun", "function", "define");
            q2.setOptions(options2);
            q2.setCorrectAns("fun");

            QuestionModel q3 = new QuestionModel();
            q3.setQuestion("Which of these features are available in Kotlin but not in Java?");
            Collections.addAll(options3,"Operator overloading", "Null safety", "Range expressions", "All the given options");
            q3.setOptions(options3);
            q3.setCorrectAns("All the given options");

            Collections.addAll(questionList, q1, q2, q3);
            Collections.shuffle(questionList);
            this.questions = questionList;
        }
    }

    static class Java extends Topic{
        @Override
        public String getTopicName() {
            return this.topicName;
        }
        @Override
        public void setTopicName() {
            this.topicName = "Java";
        }

        @Override
        public ArrayList<QuestionModel> getQuestions() {
            return this.questions;
        }
        @Override
        public void setQuestions() {
            ArrayList<QuestionModel> questionList = new ArrayList<>();
            ArrayList<String> options1 = new ArrayList<>();
            ArrayList<String> options2 = new ArrayList<>();
            ArrayList<String> options3 = new ArrayList<>();

            QuestionModel q1 = new QuestionModel();
            q1.setQuestion(" Which component is used to compile, debug and execute the java programs?");
            Collections.addAll(options1,"JRE", "JIT", "JVM", "JDK");
            q1.setOptions(options1);
            q1.setCorrectAns("JVM");

            QuestionModel q2 = new QuestionModel();
            q2.setQuestion(" Which one of the following is not a Java feature?");
            Collections.addAll(options2,"Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible");
            q2.setOptions(options2);
            q2.setCorrectAns("Use of pointers");

            QuestionModel q3 = new QuestionModel();
            q3.setQuestion("What is the extension of java code files?");
            Collections.addAll(options3,".js", ".kt", ".apk", ".java");
            q3.setOptions(options3);
            q3.setCorrectAns(".java");

            Collections.addAll(questionList, q1, q2, q3);
            Collections.shuffle(questionList);
            this.questions = questionList;
        }
    }
}




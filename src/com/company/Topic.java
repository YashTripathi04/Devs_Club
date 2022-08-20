package com.company;

import java.util.ArrayList;

abstract class Topic{
    String topicName;
    ArrayList<QuestionModel> questions;

    public abstract String getTopicName() ;
    public abstract void setTopicName();
    public abstract ArrayList<QuestionModel> getQuestions();
    public abstract void setQuestions();

}


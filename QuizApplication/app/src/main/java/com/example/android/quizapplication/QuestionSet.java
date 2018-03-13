package com.example.android.quizapplication;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Android on 9/16/2017.
 */

public class QuestionSet {
    private static QuestionSet questionSet;
    private static ArrayList<Question> questionList = new ArrayList<Question>();

    private QuestionSet() {
        //populate the ArrayList
        questionList.add(new Question("We'll start with an easy one! What state is this?", new String[]{"North Carolina", "South Dakota", "North Dakota", "South Carolina"}, R.drawable.question01, "South Carolina"));
        questionList.add(new Question("Getting a little more difficult. What country is the westernmost blue country?", new String[]{"The Gambia", "Senegal", "Ghana", "Mauritania"}, R.drawable.question02, "Senegal"));
        questionList.add(new Question("Alright, enough of Africa. What is the capital of France?", new String[]{"Berlin", "Nice", "Paris", "Lille"}, R.drawable.question03, "Paris"));
        questionList.add(new Question("Time to return back to our continent. What is this mountain range?", new String[]{"The Rocky Mountains", "The Alps", "The Appalachian Mountains", "The Himalayas"}, R.drawable.question04, "The Rocky Mountains"));
        questionList.add(new Question("Switching it up again! What is this ocean?", new String[]{"Pacific Ocean", "Arctic Ocean", "Indian Ocean", "Southern Ocean",}, R.drawable.question05, "Indian Ocean"));
    }

    public static QuestionSet getQuestions() {
        //return new phone book

        if (questionSet == null)
        {
            questionSet = new QuestionSet();
        }
        return questionSet;
    }

    public ArrayList getItems(){
        return questionList;
    }

}

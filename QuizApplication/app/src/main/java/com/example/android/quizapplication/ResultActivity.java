package com.example.android.quizapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher_round);

        ArrayList<String> ansCorrect = getIntent().getStringArrayListExtra(MainActivity.CORRECT);
        ArrayList<String> ansIncorrect = getIntent().getStringArrayListExtra(MainActivity.INCORRECT);
        ArrayList<String> contentCorrect = getIntent().getStringArrayListExtra(MainActivity.ANSCORRECT);
        ArrayList<String> contentIncorrect = getIntent().getStringArrayListExtra(MainActivity.ANSINCORRECT);

        TextView correct = (TextView)findViewById(R.id.correct_tv);
        TextView incorrect = (TextView)findViewById(R.id.incorrect_tv);

        if (ansCorrect.size() == 1) {
            correct.setText("You got question " + ansCorrect + " right. Could use a little more work." );
        } else if (ansCorrect.size() > 4){
            correct.setText("You rock!!!! You got all of them right!!");
        }

        else {

            correct.setText("You got these questions right: " + ansCorrect);
        }

        Iterator<String> it1 = ansIncorrect.iterator();
        Iterator<String> it2 = contentCorrect.iterator();
        Iterator<String> it3 = contentIncorrect.iterator();

        while (it1.hasNext() && it2.hasNext() && it3.hasNext()) {
            incorrect.setText(incorrect.getText() + "You missed Question " + it1.next() + ". You chose "+ it3.next() + ", but the correct answer was " + it2.next() + ". \n");

        }

    }
}

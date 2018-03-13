package com.example.android.quizapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

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

        TextView correct = (TextView)findViewById(R.id.correct_tv);
        TextView incorrect = (TextView)findViewById(R.id.incorrect_tv);

        correct.setText("You got these question(s) right: " + ansCorrect);
        incorrect.setText("You missed these question(s): " + ansIncorrect);
    }
}

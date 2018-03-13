package com.example.android.quizapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int questionNum = 0;
    ArrayList<String> correct = new ArrayList<String>();
    ArrayList<String> incorrect = new ArrayList<String>();
    ArrayList<String> ansCorrect = new ArrayList<String>();
    ArrayList<String> ansIncorrect = new ArrayList<String>();
    QuestionSet questionSet = QuestionSet.getQuestions();
    RadioGroup answers;

    String radioValue;
    int selectId;

    ArrayList<Question> questionList = questionSet.getItems();
    String[] answersList;

    public static final String CORRECT = "Correct";
    public static final String INCORRECT = "Incorrect";
    public static final String ANSCORRECT = "Correct answer";
    public static final String ANSINCORRECT = "Incorrect answer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher_round);

        initQuestion(questionNum);
        initButtonNext();
    }



    public void initQuestion(int questionNum){
        TextView questionText = (TextView)findViewById(R.id.question);
        ImageView questionImage = (ImageView)findViewById(R.id.question_image);

        questionText.setText(questionList.get(questionNum).getQuestion());
        questionImage.setImageResource(questionList.get(questionNum).getPictureID());

        answersList = questionList.get(questionNum).getAnswers();

        answers = (RadioGroup)findViewById(R.id.question_answers);

        for (int i = 0; i < answers.getChildCount(); i++) {
            ((RadioButton) answers.getChildAt(i)).setText(answersList[i]);
        }

    }

    public void initButtonNext(){
        Button nextBtn = (Button)findViewById(R.id.button_next);
        nextBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int intentQuestionNum = questionNum +1;

                selectId = answers.getCheckedRadioButtonId();
                RadioButton selected = (RadioButton)findViewById(selectId);
                radioValue = selected.getText().toString();

                if(radioValue.equals(questionList.get(questionNum).getCorrectAnswer())) {
                    correct.add(String.valueOf(intentQuestionNum));
                }else{
                    incorrect.add(String.valueOf(intentQuestionNum));
                    ansCorrect.add(questionList.get(questionNum).getCorrectAnswer());
                    ansIncorrect.add(radioValue);

                }

                if (questionNum < 4) {

                    answers.clearCheck();
                    questionNum++;
                    initQuestion(questionNum);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putStringArrayListExtra(CORRECT, correct);
                    intent.putStringArrayListExtra(INCORRECT, incorrect);
                    intent.putStringArrayListExtra(ANSCORRECT, ansCorrect);
                    intent.putStringArrayListExtra(ANSINCORRECT, ansIncorrect);
                    startActivity(intent);

                }
            }
        });
    }

}

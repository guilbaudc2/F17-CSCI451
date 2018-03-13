package com.example.plantep.javaforandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GuessingGame guessingGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessingGame = new GuessingGame();
        initRestartBtn();
        initGuessBtn();
    }

    private void initRestartBtn()
    {
        Button restartButton = (Button)findViewById(R.id.btn_restart);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvResult = (TextView)findViewById(R.id.tv_result);
                tvResult.setText("");
                guessingGame.restart();
            }
        });
    }

    private void initGuessBtn()
    {
     Button showButton = (Button)findViewById(R.id.btn_guess);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvResult = (TextView)findViewById(R.id.tv_result);
                EditText etGuess = (EditText)findViewById(R.id.et_guess);
                String guessText = etGuess.getText().toString().trim();
                if(guessText.equals(""))
                {
                    tvResult.setText("You must enter a valid number");
                    return;
                }
                int guess = Integer.parseInt(etGuess.getText().toString());
                etGuess.setText("");

                tvResult.setText("");
                tvResult.setText(guessingGame.guess(guess));
            }
        });
    }
}

package com.example.android.assignment04_guilbaud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstNameET;
    EditText lastNameET;
    TextView txtView;
    String booTV;
    String strFN;
    String strLN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //get values from EditText and TextView
        firstNameET = (EditText)findViewById(R.id.firstName);
        lastNameET = (EditText)findViewById(R.id.lastName);
        txtView = (TextView)findViewById(R.id.boo);


        initializeSubmitButton();

    }

    private void initializeSubmitButton() {


        Button pokeButton = (Button) findViewById(R.id.button_submit);

        pokeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //convert the two EditTexts to strings to add to the string boo
                strFN = firstNameET.getText().toString();
                strLN = lastNameET.getText().toString();

                if(strFN.equals("") || strFN.equals(null) || strLN.equals("") || strLN.equals(null)) {
                    booTV = "Come on! Put a name here!!";
                    txtView.setText(booTV);
                } else{
                    booTV = "Boo " + strFN + " " + strLN + "!";
                    txtView.setText(booTV);
                }

            }
        });
    }
}

package com.example.spal.generation2you;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    SpeechRecognizer stt;
    Bundle extras;
    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        TextView tv = (TextView) findViewById(R.id.username);

        extras = getIntent().getExtras();

        if (extras != null) {

            // This will be a true or false value hopefully.
            value = extras.getString("personType");

            if (tv != null) {
                tv.setText(value.toUpperCase() + " SIGN UP");
            }
        }


    }
}

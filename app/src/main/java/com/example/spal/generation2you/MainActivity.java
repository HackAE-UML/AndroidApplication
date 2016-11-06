package com.example.spal.generation2you;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    TextView username;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (TextView) findViewById(R.id.usernameInput);
        password = (TextView) findViewById(R.id.passwordInput);
    }

    public void signIn(View view) {

        try {
            if (!username.getText().toString().equals("") && !password.getText().toString().equals("")) {
                Intent intent = new Intent(context, SeniorList.class);
                intent.putExtra("personType", "senior");
                startActivity(intent);
            } else {
                Toast.makeText(
                        this, "Please enter a valid username and password", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Hello world");
        }
    }

    public void seniorSignUp(View view) {
        Intent intent = new Intent(context, SignUp.class);
        intent.putExtra("personType","senior");
        startActivity(intent);
    }

    public void volunteerSignUp(View view) {
        Intent intent = new Intent(context, SignUp.class);
        intent.putExtra("personType","volunteer");
        startActivity(intent);
    }
}

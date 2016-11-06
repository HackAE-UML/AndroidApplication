package com.example.spal.generation2you;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPage(View view) {
        Intent intent = new Intent(context, SeniorList.class);
        intent.putExtra("personType","senior");
        startActivity(intent);
    }

    public void seniorSignUp(View view) {
        Intent intent = new Intent(context, SeniorList.class);
        intent.putExtra("personType","senior");
        startActivity(intent);
    }

    public void volunteerSignUp(View view) {
        Intent intent = new Intent(context, SignUp.class);
        intent.putExtra("personType","volunteer");
        startActivity(intent);
    }
}

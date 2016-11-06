package com.example.spal.generation2you;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EnterLikes extends AppCompatActivity {

    final Context context = this;
    Bundle extras;
    String personType = "";
    String[] information = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_likes);

        extras = getIntent().getExtras();

        if (extras != null) {

            // This will be a true or false value hopefully.
            personType = extras.getString("personType");
            information = extras.getStringArray("previousProfile");
        }
    }

    public void pushToAWS(View view) {
        // Now we are clear to make a personObject and export to xml and then upload to AWS
        if (personType.equals("senior")) {
            // create a seniorProfile
            Intent intent = new Intent(context, SetupComplete.class);
            startActivity(intent);
        } else {
            // create a volunteerProfile
            Intent intent = new Intent(context, SeniorList.class);
            startActivity(intent);
        }
    }
}

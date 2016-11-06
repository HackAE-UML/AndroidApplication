package com.example.spal.generation2you;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SeniorList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_list);

        try {
            ReadFromAWS.main();
        } catch (Exception e) {
            System.out.print("FAILLLLLLLL ");
            System.out.println(e.getMessage());
        }
    }
}

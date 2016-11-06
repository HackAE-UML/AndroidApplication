package com.example.spal.generation2you;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {

    Bundle extras;
    String personType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        TextView tv = (TextView) findViewById(R.id.header);

        extras = getIntent().getExtras();

        if (extras != null) {

            // This will be a true or false value hopefully.
            personType = extras.getString("personType");

            if (tv != null) {
                tv.setText(personType.toUpperCase() + " SIGN UP");
            }
        }
    }

    public void uploadToAWS(View view) {

        List<EditText> allFields = new ArrayList<>();

        EditText username = (EditText)findViewById(R.id.username);
        EditText password1 = (EditText)findViewById(R.id.password);
        EditText password2 = (EditText)findViewById(R.id.confirmPassword);
        EditText fName = (EditText)findViewById(R.id.fName);
        EditText lname = (EditText)findViewById(R.id.lName);
        EditText street = (EditText)findViewById(R.id.street);
        EditText city = (EditText)findViewById(R.id.city);
        EditText state = (EditText)findViewById(R.id.state);

        allFields.add(username);
        allFields.add(fName);
        allFields.add(lname);
        allFields.add(street);
        allFields.add(city);
        allFields.add(state);

        // Make sure all fields are filled
        for (EditText field : allFields) {
            if (field.getText().toString().equals("")) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Make sure passwords match
        String p1 = password1.getText().toString();
        String p2 = password2.getText().toString();

        if(!p1.equals(p2)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Now we are clear to make a personObject and export to xml and then upload to AWS
        if (personType.equals("senior")) {
            // create a seniorProfile
        } else {
            // create a volunteerProfile
        }
    }
}

package com.example.spal.generation2you;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {

    final Context context = this;
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
        ArrayList<String> allFields = new ArrayList<>();

        EditText username = (EditText)findViewById(R.id.username);
        EditText password1 = (EditText)findViewById(R.id.password);
        EditText password2 = (EditText)findViewById(R.id.confirmPassword);
        EditText fName = (EditText)findViewById(R.id.fName);
        EditText lname = (EditText)findViewById(R.id.lName);
        EditText street = (EditText)findViewById(R.id.street);
        EditText city = (EditText)findViewById(R.id.city);
        EditText state = (EditText)findViewById(R.id.state);

        allFields.add(username.getText().toString());
        allFields.add(fName.getText().toString());
        allFields.add(lname.getText().toString());
        allFields.add(street.getText().toString());
        allFields.add(city.getText().toString());
        allFields.add(state.getText().toString());

        // Make sure all fields are filled
        for (String field : allFields) {
            if (field.equals("")) {
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

        String[] toPassOn = new String[allFields.size()];
        toPassOn = allFields.toArray(toPassOn);

        Intent intent = new Intent(context, EnterLikes.class);
        intent.putExtra("previousProfile", toPassOn);
        intent.putExtra("personType", personType);
        startActivity(intent);
    }
}

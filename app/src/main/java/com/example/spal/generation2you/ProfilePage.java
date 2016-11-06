package com.example.spal.generation2you;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfilePage extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        extras = getIntent().getExtras();

        if (extras != null) {

            // This will be a true or false value hopefully.
            String[] profile = extras.getStringArray("profiles");

            // name     == profile[0]
            // age      == Integer.parse(profile[1])
            // location == profile[2]
            // likes    == profile[3]

            final TextView name     = (TextView) findViewById(R.id.profileName);
            final TextView age      = (TextView) findViewById(R.id.profileAge);
            final TextView location = (TextView) findViewById(R.id.profileLocation);
            final TextView likes     = (TextView) findViewById(R.id.profileLikes);
            final ImageView img     = (ImageView) findViewById(R.id.profileImage);

            name.setText(profile[0]);
            age.setText(profile[1]);
            location.setText(profile[2]);
            likes.setText(profile[3].toString().replace("[", "").replace("]", "").trim());
        }
    }
}

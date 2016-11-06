package com.example.spal.generation2you;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SeniorList extends AppCompatActivity {

    List<ProfileSenior> profiles = new ArrayList<>();
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_list);

        try {
           profiles = ReadFromAWS.ReadAllSeniorFiles();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*** Now start with ListView stuff ***/
        final ArrayAdapter<ProfileSenior> adapter
                = new CustomAdapter(this, profiles.toArray(new ProfileSenior[0]));

        // Initialize ListView
        final ListView lv= (ListView) findViewById(R.id.listView);

        if (lv != null) {

            lv.setAdapter(adapter);

            lv.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            // Get item name (something from values list)
                            Intent intent = new Intent(context, ProfilePage.class);
                            intent.putExtra("profiles", profiles.get(position).toStringArray());
                            startActivity(intent);
                        }
                    }
            );
        }
    }
}

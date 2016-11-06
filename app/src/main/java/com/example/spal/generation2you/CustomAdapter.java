package com.example.spal.generation2you;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter< ProfileSenior > {

    CustomAdapter(Context context, ProfileSenior[] profileSeniors) {
        super(context, R.layout.custom_row, profileSeniors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.from(getContext()).inflate(R.layout.custom_row, parent, false);

        ProfileSenior profile = getItem(position);

        // Get TextViews for Header and Subtitle
        TextView rowName = (TextView) view.findViewById(R.id.rowName);
        TextView rowLocation = (TextView) view.findViewById(R.id.rowLocation);
        TextView rowActivity = (TextView) view.findViewById(R.id.rowActivity);

        // Populate both TextViews
        rowName.setText(profile.getName() + ", " + profile.getAge());
        rowLocation.setText(profile.getLocation().toString());
        rowActivity.setText("Activity: " + profile.getLikes().get(0));
        return view;
    }
}

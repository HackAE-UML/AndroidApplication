package com.example.spal.generation2you;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spal on 11/5/16.
 */
public class ProfileSenior {
    private String mName;
    private int mAge;
    private int mID;
    private String mGender;
    private Location location;
    private List<String> likes;
    private List<ProfileYoung> matches;
    
    /*Constructor */
    public ProfileSenior(){
    	likes = new ArrayList<String>();
    	matches = new ArrayList<ProfileYoung>();
    }
    /** Setters */
    public void setName(String name) {
        mName = name;
    }
    public void setAge(int age) {
        mAge = age;
    }
    public void setID(int id) { mID = id; }
    public void setGender(String gender) {
        mGender = gender.toLowerCase();
    }
    public void setLocation(String street, String city, String state) {
        location = new Location(street, city, state);
    }
    public void addLike(String like) {
        likes.add(like.toLowerCase());
    }
    public void addMatch(ProfileYoung profile) {
        matches.add(profile);
    }

    /** Getters */
    public String getName() {
        return mName;
    }
    public int getAge() {
        return mAge;
    }
    public int getID() { return mID; }
    public Location getLocation() {
        return location;
    }
    public List<String> getLikes() {
        return likes;
    }
    public List<ProfileYoung> getMatches() {
        return matches;
    }

    public String[] toStringArray() {
        ArrayList<String> temp = new ArrayList<>();

        temp.add(getName());
        temp.add(getAge() + "");
        temp.add(getLocation().toString());
        temp.add(getLikes().toString());

        String[] toReturn = new String[temp.size()];
        toReturn = temp.toArray(toReturn);

        return toReturn;
    }


    /**
     * Check to see if a certain profile is a match with current Senior Profile
     * @param profile The profile object of the volunteer
     * @return true if match exists
     */
    public boolean checkProfileMatch(ProfileYoung profile) {
        return matches.contains(profile);
    }
}
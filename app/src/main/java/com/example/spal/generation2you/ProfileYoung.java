package com.example.spal.generation2you;

import java.util.List;

/**
 * Created by spal on 11/5/16.
 */
public class ProfileYoung {
    private String mName;
    private int mAge;
    private Location location;
    private List<ProfileSenior> matches;

    /** Setters */
    public void setName(String name) {
        mName = name;
    }
    public void setAge(int age) {
        mAge = age;
    }
    public void setLocation(String street, String city, String state, int zipCode) {
        location = new Location(street, city, state, zipCode);
    }
    public void addMatch(ProfileSenior profile) {
        matches.add(profile);
    }

    /** Getters */
    public String getName() {
        return mName;
    }
    public int getAge() {
        return mAge;
    }
    public Location getLocation() {
        return location;
    }
    public List<ProfileSenior> getMatches() {
        return matches;
    }

    /**
     * Check to see if a certain profile is a match with current Volunteer Profile
     * @param profile The profile object of the senior
     * @return true if match exists
     */
    public boolean checkProfileMatch(ProfileSenior profile) {
        return matches.contains(profile);
    }
}
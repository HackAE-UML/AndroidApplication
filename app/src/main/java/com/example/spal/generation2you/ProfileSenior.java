package com.example.spal.generation2you;

import java.util.List;

/**
 * Created by spal on 11/5/16.
 */
public class ProfileSenior {
    private String mName;
    private int mAge;
    private Location location;
    private List<String> likes;
    private List<ProfileYoung> matches;

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
    public Location getLocation() {
        return location;
    }
    public List<String> getLikes() {
        return likes;
    }
    public List<ProfileYoung> getMatches() {
        return matches;
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

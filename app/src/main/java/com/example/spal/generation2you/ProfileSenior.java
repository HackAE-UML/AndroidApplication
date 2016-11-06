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
    public ProfileSenior(ProfileSenior another){
    	this.mName = another.mName;
    	this.mAge = another.mAge;
    	this.location = another.location;
    	this.matches = new ArrayList<ProfileYoung>(another.matches);
    	this.likes = new ArrayList<ProfileYoung>(another.likes);
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
    
    /*
     * Checks the matches of this senior against a list
     * of all the young profiles (supplied) and returns those that match
     * @param allYoung List of all ProfileYoungs in the system
     * @return a list of all profileYoungs that have matched with this senior
     */
    public List<ProfileYoung> getMatches(List<ProfileYoung> allYoung) {
        List<ProfileYoung> profiles = new ProfileYoung();
        
        //loops through all profileYoungs
        for( ProfileYoung iter : allYoung){
        	if( checkProfileMatch(iter) ) {
        		profiles.add(iter);
        	}
        }
    	return profiles;
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
     * Check to see if a passed young profile is a match with current Senior Profile by iD check
     * @param profile The profile object of the volunteer
     * @return true if match exists
     */
    public boolean checkProfileMatch(ProfileYoung profile) {
    	for( ProfileYoung iter : matches) {
    		if(iter.getId() == profiles.getId()){
    			return true;
    		}
    	}
    	
    	return false;
        
    }
}
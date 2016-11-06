package com.example.spal.generation2you;

/**
 * Created by spal on 11/5/16.
 */
public class Location {
    private String mStreet;
    private String mCity;
    private String mState;

    /** Setters */
    public Location(String street, String city, String state) {
        setStreet(street);
        setCity(city);
        setState(state);
    }
    public void setState(String state) {
        mState = state;
    }
    public void setCity(String city) {
        mCity = city;
    }
    public void setStreet(String street) {
        mStreet = street;
    }

    /** Getters */
    public String getState() {
        return mState;
    }
    public String getCity() {
        return mCity;
    }
    public String getStreet() {
        return mStreet;
    }

    /* Returns the string representation of this Class.*/
    @Override
    public String toString() {
        return mCity + ", " + mState;
    }
}

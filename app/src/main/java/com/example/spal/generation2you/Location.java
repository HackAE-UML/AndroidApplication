package com.example.spal.generation2you;

/**
 * Created by spal on 11/5/16.
 */
public class Location {
    private String mStreet;
    private String mCity;
    private String mState;
    private int mZipCode;

    /** Setters */
    public Location(String street, String city, String state, int zipCode) {
        setStreet(street);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
    }
    public void setState(String state) {
        mState = state;
    }
    public void setCity(String city) {
        mCity = city;
    }
    public void setZipCode(int zip) {
        mZipCode = zip;
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
    public int getZipCode() {
        return mZipCode;
    }
    public String getStreet() {
        return mStreet;
    }
}

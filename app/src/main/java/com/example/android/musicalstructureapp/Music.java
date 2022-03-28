package com.example.android.musicalstructureapp;

public class Music {

    //Item image of the item
    private int mImage;
    //Title item
    private String mTitle;
    //First heading of the item
    private String mHeading1;
    //Second heading of the item
    private String mHeading2;

    //Constructor
    public Music (int image, String title, String heading1, String heading2) {
        mImage = image;
        mTitle = title;
        mHeading1 = heading1;
        mHeading2 = heading2;
    }

    //Returning values
    public int getImage() {
        return mImage;
    }
    public String getTitle() {
        return mTitle;
    }
    public String getHeading1() {
        return mHeading1;
    }
    public String getHeading2() {
        return mHeading2;
    }
}

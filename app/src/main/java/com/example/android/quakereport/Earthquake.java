package com.example.android.quakereport;

/**
 * Created by Aakashon 3/22/2018.
 */

public class Earthquake {

    private double mMag;
    private String mLocation;
   // private String mDate;
    private long mTime;
    private String mUrl;

    public  Earthquake(Double mag, String location,  long time, String url){

        mMag = mag;
        mLocation = location;
       // mDate = date;
        mTime = time;
        mUrl = url;



    }

    public double getMag(){

        return mMag;
    }

    public String getLocation(){

        return mLocation;
    }


    public long getTime(){

        return mTime;
    }

    public String getUrl(){
        return mUrl;
    }



}

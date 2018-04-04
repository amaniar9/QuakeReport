package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.android.quakereport.Earthquake;
import com.example.android.quakereport.QueryUtils;

import java.net.URL;
import java.util.List;

/**
 * Created by Aakash on 3/28/2018.
 */



    public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

        private String mUrl;


        public EarthquakeLoader (Context context, String url){

            super(context);
            mUrl = url;
        }


        @Override
        public void onStartLoading(){
            forceLoad();

        }
        @Override
        public List<Earthquake> loadInBackground(){
            if (mUrl == null){
                return  null;
            }
            List<Earthquake> quakers = QueryUtils.fetchEarthquakeDate(mUrl);
            return  quakers;

        }



    }


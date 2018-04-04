package com.example.android.quakereport;

import android.app.Activity;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.graphics.drawable.GradientDrawable;
import java.util.ArrayList;



/**
 * Created by Aakash on 3/22/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);

    }


    @Override
    public View getView(int postion, View convertView, ViewGroup parent){

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        final Earthquake nEarthquake = getItem(postion);

        TextView magni = (TextView) listItemView.findViewById(R.id.magny);
        magni.setText(formatMag(nEarthquake.getMag()));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magni.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(nEarthquake.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);




        //Splitting local into near to and location
        String locale = nEarthquake.getLocation();
        String near;
        String place;
        String [] placeInTwo ;



        if (locale.contains("of")){
            placeInTwo = locale.split("of");
            near = placeInTwo[0] + " of";
            place = placeInTwo[1];

        } else {

            near = "Near the";
            place = locale;
        }

        TextView nearby = (TextView) listItemView.findViewById(R.id.near);
        nearby.setText(near);

        TextView local = (TextView) listItemView.findViewById(R.id.locale);
        local.setText(place);

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        //used for both time and date, takes primitive long
        Date dateObj = new Date(nEarthquake.getTime());
        // cast long time into String obj
        String fDate = formatDate(dateObj);
        date.setText(fDate);
        // casts long time into String obj but formatted differently
        TextView time = (TextView) listItemView.findViewById(R.id.timey);
        String fTime = formatTime(dateObj);
        time.setText(fTime);






        return listItemView;
    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMag (Double mag){

        DecimalFormat formatter = new DecimalFormat("0.0");
        String magOut = formatter.format(mag);
        return magOut;
    }

    private int getMagnitudeColor(double maggyC){
        int color = (int) maggyC;
        int newColor;

        switch (color){

            case 0:

            case 1:
                newColor = R.color.magnitude1;
                break;
            case 2:
                newColor = R.color.magnitude2;
                break;
            case 3:
                newColor = R.color.magnitude3;
                break;
            case 4:
                newColor = R.color.magnitude4;
                break;
            case 5:
                newColor = R.color.magnitude5;
                break;
            case 6:
                newColor = R.color.magnitude6;
                break;
            case 7:
                newColor = R.color.magnitude7;
                break;
            case 8:
                newColor = R.color.magnitude8;
                break;
            case 9:
                newColor = R.color.magnitude9;
                break;
            case 10:
                newColor = R.color.magnitude10plus;
                break;
            default:
                newColor = R.color.magnitude1;
                break;


        }





        return ContextCompat.getColor(getContext(), newColor);
    }
}

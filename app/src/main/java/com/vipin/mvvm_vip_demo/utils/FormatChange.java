package com.vipin.mvvm_vip_demo.utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by vipin on 6/7/18.
 */

 public  class FormatChange {

    public static String getdate(String mydate) {

        if(mydate != null && mydate.trim().length() > 0){

        Log.e("date",""+mydate);

        Date myDate = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            myDate = format.parse(mydate);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy  hh:mm a", Locale.getDefault());
        String finalDate = timeFormat.format(myDate);

        Log.e("date","converted:"+mydate);

        return String.valueOf(finalDate);
    }
    return "No date";
    }

    public static String getCount(int count){

        return String.valueOf(count+100);
    }
}

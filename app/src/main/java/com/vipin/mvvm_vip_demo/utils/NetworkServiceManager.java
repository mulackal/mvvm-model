package com.vipin.mvvm_vip_demo.utils;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkServiceManager {

    Context context;

    private static NetworkServiceManager networkServiceManager;


    public static final NetworkServiceManager getInstance(Context context) {
        if (networkServiceManager == null) {
            networkServiceManager = new NetworkServiceManager(context);
        }
        return networkServiceManager;
    }
    public NetworkServiceManager() {

    }

    public NetworkServiceManager(Context base) {
        context = base;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if(cm.getActiveNetworkInfo()!= null){
            networkInfo = cm.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }else {
            return false;
        }

    }
    public  boolean isGpsAvailable(){
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return  locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);
    }

}
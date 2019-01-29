package com.vipin.mvvm_vip_demo.data.apiManager;

import android.content.Context;
import android.util.Log;

public class Repository {

    private static final String TAG = Repository.class.getSimpleName();

    Context mContext;

    public Repository(Context context) {
        this.mContext = context;
    }


    public boolean login(String user, String pass) {

        if(user.trim().length() > 0 && !user.isEmpty()
                && pass.trim().length() > 0 && !pass.isEmpty()) {

            Log.e(TAG,"Logged in");

            return true;
        }
        Log.e(TAG,"Logged fail");
        return false;
    }
}
package com.vipin.mvvm_vip_demo;

import android.app.Activity;
import android.app.Application;

import com.vipin.mvvm_vip_demo.data.AppSessionManager;
import com.vipin.mvvm_vip_demo.data.apiManager.ApiDataManager;
import com.vipin.mvvm_vip_demo.data.apiManager.retrofit.ApiCleint;

public class BaseApplication extends Application {


    Activity mCurrentActivity = null;
    private static BaseApplication uniqInstance;


    @Override
    public void onCreate() {
        super.onCreate();


        AppSessionManager.getInstance().loadUser(getApplicationContext());

        ApiDataManager appDataManager = new ApiDataManager(getApplicationContext());

        ApiCleint appAPIClient=new ApiCleint();
    }


    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentActivity(Activity mCurrentActivity) {

        this.mCurrentActivity = mCurrentActivity;
    }


    public synchronized static BaseApplication getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new BaseApplication();
        }
        return uniqInstance;
    }

}

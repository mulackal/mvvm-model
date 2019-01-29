package com.vipin.mvvm_vip_demo.ui.activity.home;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.util.Log;
import android.widget.Toast;

import com.vipin.mvvm_vip_demo.BaseViewModel;
import com.vipin.mvvm_vip_demo.data.AppSessionManager;
import com.vipin.mvvm_vip_demo.data.apiManager.Repository;
import com.vipin.mvvm_vip_demo.data.model.network.HomeListResponds;
import com.vipin.mvvm_vip_demo.data.model.network.Result;
import com.vipin.mvvm_vip_demo.utils.NetworkServiceManager;


public class HomeViewModel extends BaseViewModel<HomeListener> {

    public ObservableList<Result> mDataList = new ObservableArrayList<>();

    public final ObservableField<String> sample = new ObservableField<>();

    Repository repository;
    Context context;
    HomeListener homeListener;


    public HomeViewModel(Application activity) {
        super(activity);

        this.context = activity;

        sample.set(AppSessionManager.getInstance().user.userName);

        repository = new Repository(activity);

        CallApiDatA(0);

    }

    public void CallApiDatA(int count){

        if(NetworkServiceManager.getInstance(context).isNetworkAvailable()) {
            setIsLoading(true);

            Log.e("call", "create-model");

            getDataManager().HomeDataList(this, count,getCompositeDisposable());
        }else
            sample.set("No Network");

    }

    public void setDataList(HomeListResponds DATA) {

        setIsLoading(false);

        mDataList.addAll(DATA.getResults());

        sample.set("Data Arrived-"+DATA.getResults().get(0).getVoteCount());

    }

    public void ShowErrorSnak(String message){

        Log.e("error",""+message);

        sample.set("Data Fetch Failed");

        setIsLoading(false);


    }

    public void OnClickAction(){

        sample.set("Clicked Me");
        getNavigator().openHomeFragment();
    }

    public void  OnLoadingData(){

        sample.set("Data Recall");
        CallApiDatA(0);
    }

}

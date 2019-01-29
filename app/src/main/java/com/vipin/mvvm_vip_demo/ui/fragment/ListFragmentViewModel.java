package com.vipin.mvvm_vip_demo.ui.fragment;


import android.app.Application;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.util.Log;

import com.vipin.mvvm_vip_demo.BaseViewModel;
import com.vipin.mvvm_vip_demo.data.AppSessionManager;
import com.vipin.mvvm_vip_demo.data.model.network.GetTicketListResponse;
import com.vipin.mvvm_vip_demo.data.model.network.Result;
import com.vipin.mvvm_vip_demo.data.model.network.TicketListModel;
import com.vipin.mvvm_vip_demo.utils.NetworkServiceManager;

import java.util.ArrayList;
import java.util.List;


public class ListFragmentViewModel extends BaseViewModel<ListListener> {

    public ObservableList<TicketListModel> mDataList = new ObservableArrayList<>();

    public final ObservableField<String> sample = new ObservableField<>();

    ListListener listListener;
    Context context;


    public ListFragmentViewModel(Application activity) {
        super(activity);
        this.context = activity;

        AppSessionManager.getInstance().user.userName = "Saved Order";
        AppSessionManager.getInstance().saveUser(context);

        sample.set(AppSessionManager.getInstance().user.userName);

        CallApiDatA(0);

    }

    public void CallApiDatA(int count){

        if(NetworkServiceManager.getInstance(context).isNetworkAvailable()) {
            setIsLoading(true);

            Log.e("call", "create-model");

            getDataManager().GetTicketListTask(this);
        }else
            sample.set("No Network");

    }

    public void setDataList(GetTicketListResponse DATA) {

        setIsLoading(false);

        mDataList.addAll(DATA.getModel().getNewOrderList());

        sample.set("Saved Data Arrived-"+DATA.getModel().getNewOrderList().get(0).getTicketName());

    }

    public void ShowErrorSnak(String message){

        Log.e("error",""+message);

        sample.set("Data Fetch Failed");

        setIsLoading(false);

    }


    public void  OnBackData(){
        getNavigator().openHome();
    }
}

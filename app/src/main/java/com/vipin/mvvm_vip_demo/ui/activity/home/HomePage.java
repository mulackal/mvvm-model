package com.vipin.mvvm_vip_demo.ui.activity.home;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;


import com.vipin.mvvm_vip_demo.BaseActivity;

import com.vipin.mvvm_vip_demo.R;
import com.vipin.mvvm_vip_demo.data.AppSessionManager;
import com.vipin.mvvm_vip_demo.databinding.HomeDataBinding;
import com.vipin.mvvm_vip_demo.ui.activity.login.LoginActivity;
import com.vipin.mvvm_vip_demo.ui.fragment.ListFragmentActivity;
import com.vipin.mvvm_vip_demo.ui.fragment.ListFragmentViewModel;
import com.vipin.mvvm_vip_demo.utils.EndlessRecyclerOnScrollListener;


public class HomePage extends BaseActivity implements HomeListener {


    HomeDataBinding myDataBinding;
    HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        myDataBinding.setHomeviewModel(ViewModelProviders.of(this).get(HomeViewModel.class));
        myDataBinding.getHomeviewModel().setNavigator(this);

        setupRecyclerView();
        ObservedLoader();

        AppSessionManager.getInstance().user.userName = "Vipin M T";
        AppSessionManager.getInstance().saveUser(this);

    }

    private void ObservedLoader() {

        myDataBinding.getHomeviewModel().getIsLoading().observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(@Nullable Boolean isLoading) {
                    if (isLoading != null) {
                        if (isLoading)
                            showLoadingDialog(HomePage.this);
                        else
                            hideaLoadingDialog();

                    }
                }
            });

        }


    private void setupRecyclerView() {

        mAdapter = new HomeAdapter(this);
        myDataBinding.dataList.setLayoutManager(new LinearLayoutManager(this));
        myDataBinding.dataList.setAdapter(mAdapter);

// page Nation recycle
        myDataBinding.dataList.addOnScrollListener(new EndlessRecyclerOnScrollListener(new LinearLayoutManager(this)) {
            @Override
            public void onLoadMore(int totalItemCount) {

                Log.e("SCROLL","ON");

                if (myDataBinding.getHomeviewModel().mDataList.size() >= totalItemCount) {
                    myDataBinding.getHomeviewModel().CallApiDatA(myDataBinding.getHomeviewModel().mDataList.size());
                }
            }

        });
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        myDataBinding.unbind();
        super.onDestroy();
    }


    @Override
    public void ShowWarningMessage(String str) {

    }

    public void openHomeFragment() {
        Intent intent = new Intent(this,ListFragmentActivity.class);
        startActivity(intent);
    }
}


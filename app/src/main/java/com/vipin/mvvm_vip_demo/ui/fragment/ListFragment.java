package com.vipin.mvvm_vip_demo.ui.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vipin.mvvm_vip_demo.BaseFragment;
import com.vipin.mvvm_vip_demo.R;

import com.vipin.mvvm_vip_demo.databinding.HomeFragmentDataBinding;
import com.vipin.mvvm_vip_demo.ui.activity.home.HomeAdapter;

import com.vipin.mvvm_vip_demo.ui.activity.home.HomePage;
import com.vipin.mvvm_vip_demo.utils.EndlessRecyclerOnScrollListener;


public class ListFragment extends BaseFragment implements ListListener {

    HomeFragmentDataBinding myDataBinding;
    ListAdapter mAdapter;
    
    public ListFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myDataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list, container, false);
        myDataBinding.setFragmenthomeviewModel(ViewModelProviders.of(this).get(ListFragmentViewModel.class));
        myDataBinding.getFragmenthomeviewModel().setNavigator(this);
        return myDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupRecyclerView();
        ObservedLoader();
    }


    private void ObservedLoader() {

        myDataBinding.getFragmenthomeviewModel().getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean isLoading) {
                if (isLoading != null) {
                    if (isLoading)
                        showLoadingDialog(getActivity());
                    else
                        hideaLoadingDialog();

                }
            }
        });
    }


    private void setupRecyclerView() {

        mAdapter = new ListAdapter(getActivity());
        myDataBinding.dataListF.setLayoutManager(new LinearLayoutManager(getActivity()));
        myDataBinding.dataListF.setAdapter(mAdapter);

// page Nation recycle
        myDataBinding.dataListF.addOnScrollListener(new EndlessRecyclerOnScrollListener(new LinearLayoutManager(getActivity())) {
            @Override
            public void onLoadMore(int totalItemCount) {

                Log.e("SCROLL","ON");

                if (myDataBinding.getFragmenthomeviewModel().mDataList.size() >= totalItemCount) {
                    myDataBinding.getFragmenthomeviewModel().CallApiDatA(myDataBinding.getFragmenthomeviewModel().mDataList.size());
                }
            }

        });
    }

    @Override
    public void onDestroy() {
        myDataBinding.unbind();
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void ShowWarningMessage(String str) {

    }

    @Override
    public void openHome() {
        Intent intent = new Intent(getActivity(),HomePage.class);
        startActivity(intent);
    }
}

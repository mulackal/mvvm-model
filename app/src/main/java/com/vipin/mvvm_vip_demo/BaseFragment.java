package com.vipin.mvvm_vip_demo;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

import com.vipin.mvvm_vip_demo.utils.widget.loading.ILoading;
import com.vipin.mvvm_vip_demo.utils.widget.loading.ProgressDialogLoading;


public class BaseFragment extends Fragment {

    // This is for showing the progress
    ILoading mLoading;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLoading = new ProgressDialogLoading(getActivity());
    }

    public Dialog mLoadingDialog;

    public void showLoadingDialog(Context context) {
        mLoading.show();

    }
    public void showSnackBar(View snackBarView, String message) {
        Snackbar snackbar;
        snackbar = Snackbar.make(snackBarView, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    // This is for hiding the progress
    public void hideaLoadingDialog() {
        mLoading.dismiss();
    }

}

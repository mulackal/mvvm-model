package com.vipin.mvvm_vip_demo.ui.activity.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.vipin.mvvm_vip_demo.BaseActivity;

import com.vipin.mvvm_vip_demo.R;
import com.vipin.mvvm_vip_demo.databinding.LoginDataBinding;
import com.vipin.mvvm_vip_demo.ui.activity.home.HomePage;


public class LoginActivity extends BaseActivity {

    LoginDataBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityMainBinding.setLogviewModel(ViewModelProviders.of(this).get(LoginViewModel.class));

        ObservedLoader();

    }

    private void ObservedLoader() {

        activityMainBinding.getLogviewModel().isLoading.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean isLoading) {
                if (isLoading != null) {
                    if (isLoading)
                        showLoadingDialog(LoginActivity.this);
                    else
                        hideaLoadingDialog();

                }
            }
        });

        activityMainBinding.getLogviewModel().gotoHome.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean gotoHome) {
                if (gotoHome != null) {
                    if (gotoHome){

                        hideKeyboard();

                        Toast.makeText(LoginActivity.this,"Login Successful!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,HomePage.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

}

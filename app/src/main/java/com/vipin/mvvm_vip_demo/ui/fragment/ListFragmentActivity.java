package com.vipin.mvvm_vip_demo.ui.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vipin.mvvm_vip_demo.BaseActivity;
import com.vipin.mvvm_vip_demo.R;

public class ListFragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment);


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_activity_content_frame, new ListFragment())
                .commit();

    }
}

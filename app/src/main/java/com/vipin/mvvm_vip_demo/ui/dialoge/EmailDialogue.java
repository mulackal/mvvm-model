package com.vipin.mvvm_vip_demo.ui.dialoge;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.vipin.mvvm_vip_demo.R;


public class EmailDialogue extends Dialog {


    private Activity home;

    RelativeLayout emailBtn;

    public EmailDialogue(Activity home) {
        super(home);
        this.home = home;
      // mView = (PreviousOrderContract.View) home;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.layout_items);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        OnInit();


    }

    private void OnInit() {

        EmailDialogue emailDialoge = new EmailDialogue(home);
        emailDialoge.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        emailDialoge.setCancelable(false);
        emailDialoge.show();

    }
}
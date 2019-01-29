package com.vipin.mvvm_vip_demo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.vipin.mvvm_vip_demo.data.AppSessionManager;
import com.vipin.mvvm_vip_demo.utils.widget.loading.ILoading;
import com.vipin.mvvm_vip_demo.utils.widget.loading.ProgressDialogLoading;

public class BaseActivity extends AppCompatActivity {

    ILoading mLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(AppSessionManager.getInstance().user==null)
            AppSessionManager.getInstance().loadUser(getApplicationContext());

        mLoading = new ProgressDialogLoading(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    public void showSnackBar(View snackBarView, String message) {
        Snackbar snackbar;
        snackbar = Snackbar.make(snackBarView, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }


    public void debugLogD(final String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }

    public void debugLogE(final String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message);
        }
    }


// This is for showing the progress

    public void showLoadingDialog(Context context) {
        mLoading.show();
    }

    // This is for hiding the progress
    public void hideaLoadingDialog() {
        mLoading.hide();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //	BaseApplication.getInstance().setCurrentActivity(BaseActivity.this);
    }



	public void showActivityCloseDialoge(Context context) {

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(context,
				R.style.AppTheme));

		// set title
		alertDialogBuilder.setTitle(Html.fromHtml("<font color='#ffa000'>Exit App</font>"));

		// set dialog message
		alertDialogBuilder
				.setMessage("close_app")
				.setCancelable(false)
				.setIcon(R.mipmap.ic_launcher_round)
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						finishAffinity();
					}
				})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

}

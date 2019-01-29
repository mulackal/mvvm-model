package com.vipin.mvvm_vip_demo.utils.widget.loading;

import android.content.Context;


public class ProgressDialogLoading implements ILoading {

    private DialogProgressLoading mPd;

    public ProgressDialogLoading(Context context) {
        mPd = new DialogProgressLoading(context);
    }

    @Override
    public void show() {
        mPd.show();
    }

    @Override
    public void hide() {
        mPd.dismiss();
    }

    @Override
    public void dismiss() {
        mPd.dismiss();
    }
}

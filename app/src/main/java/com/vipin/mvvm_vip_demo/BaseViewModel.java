

package com.vipin.mvvm_vip_demo;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.vipin.mvvm_vip_demo.data.apiManager.ApiDataManager;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;


public abstract class BaseViewModel<N> extends AndroidViewModel {

    private final ApiDataManager mDataManager;

    private final MutableLiveData<Boolean> mIsLoading = new MutableLiveData<>();

    private CompositeDisposable mCompositeDisposable;

    private WeakReference<N> mNavigator; //WeakReference is used to  avoid memory leaks

    public BaseViewModel(Application application) {
        super(application);
        this.mDataManager = new ApiDataManager(application);
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }


    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public ApiDataManager getDataManager() {
        return mDataManager;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.setValue(isLoading);
    }

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

}

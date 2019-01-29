package com.vipin.mvvm_vip_demo.data.apiManager;

import android.content.Context;


import com.vipin.mvvm_vip_demo.data.apiManager.retrofit.ApiCleint;
import com.vipin.mvvm_vip_demo.data.apiManager.retrofit.ApiInterface;
import com.vipin.mvvm_vip_demo.data.model.network.GetTicketListResponse;
import com.vipin.mvvm_vip_demo.data.model.network.HomeListResponds;
import com.vipin.mvvm_vip_demo.ui.activity.home.HomeViewModel;
import com.vipin.mvvm_vip_demo.ui.fragment.ListFragmentViewModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import retrofit2.Retrofit;


public class ApiDataManager {

    private static final String TAG = ApiDataManager.class.getSimpleName();
    ApiInterface apiInterface,apiInterface2;
    Retrofit mRetrofit_base,mRetrofit_base2;

    Context mContext;


    public ApiDataManager(Context context) {
        this.mContext = context;
        this.mRetrofit_base = ApiCleint.getClientServer();
        this.mRetrofit_base2 = ApiCleint.getClientServerDemo();
        apiInterface = mRetrofit_base.create(ApiInterface.class);
        apiInterface2 = mRetrofit_base2.create(ApiInterface.class);

    }


    public void HomeDataList(final HomeViewModel homeViewModel, int count, final CompositeDisposable compositeDisposable) {

        if (apiInterface == null) {
            apiInterface = mRetrofit_base.create(ApiInterface.class);
        }

        Observable<HomeListResponds> call = apiInterface.GetAllListRequest("7e8f60e325cd06e164799af1e317d7a7");

        call.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeListResponds>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HomeListResponds callListRespond) {

                        homeViewModel.setDataList(callListRespond);

                    }

                    @Override
                    public void onError(Throwable e) {

                        homeViewModel.ShowErrorSnak("Api Error");
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    public void FragmentHomeDataList(final ListFragmentViewModel listFragmentViewModel, int count) {


        if (apiInterface == null) {
            apiInterface = mRetrofit_base.create(ApiInterface.class);
        }

        Observable<HomeListResponds> call = apiInterface.GetAllListRequest("7e8f60e325cd06e164799af1e317d7a7");

        call.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeListResponds>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeListResponds callListRespond) {

                      //  listFragmentViewModel.setDataList(callListRespond);

                    }

                    @Override
                    public void onError(Throwable e) {

                        listFragmentViewModel.ShowErrorSnak("Api Error");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void GetTicketListTask(final ListFragmentViewModel listFragmentViewModel) {

        if (apiInterface2 == null) {
            apiInterface2 = mRetrofit_base2.create(ApiInterface.class);
        }

        Observable<GetTicketListResponse> getPosMenuItemResponseObservable = apiInterface2.GetAllListsaved(
                "0",
                "8",
                true,
                "733d53165fdb0450",
                true);

        getPosMenuItemResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetTicketListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetTicketListResponse getTicketListResponse) {
                        listFragmentViewModel.setDataList(getTicketListResponse);
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        listFragmentViewModel.ShowErrorSnak("Api Error");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
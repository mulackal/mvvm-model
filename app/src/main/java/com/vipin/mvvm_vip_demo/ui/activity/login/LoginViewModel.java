package com.vipin.mvvm_vip_demo.ui.activity.login;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.widget.Toast;


import com.vipin.mvvm_vip_demo.BaseViewModel;
import com.vipin.mvvm_vip_demo.data.apiManager.Repository;
import com.vipin.mvvm_vip_demo.ui.activity.home.HomePage;


public class LoginViewModel extends BaseViewModel {

    public ObservableField<String> usernmae = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");
    public ObservableField<String> heading = new ObservableField<>("MY MVVM");

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public MutableLiveData<Boolean> gotoHome = new MutableLiveData<>();


    Repository repository;
    Context context;

    public LoginViewModel(Application activity) {
        super(activity);
        this.context = activity;

        repository = new Repository(activity);

    }

    public void login() {

        boolean login = repository.login(usernmae.get(), password.get());

        if(login){
            gotoHome.setValue(true);
        }else {
            Toast.makeText(context,"Login Failed!",Toast.LENGTH_SHORT).show();
            heading.set("Login Failed");
        }

    }


 /*   public void login(String email, String password) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .doOnSuccess(response -> getDataManager()
                        .updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().openMainActivity();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }*/
}

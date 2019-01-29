package com.vipin.mvvm_vip_demo.data.apiManager.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.vipin.mvvm_vip_demo.BuildConfig;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiCleint {

    private static Retrofit retrofit = null;
    private static Retrofit retrofit2 = null;



    private static OkHttpClient okClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(7, TimeUnit.SECONDS)
                .writeTimeout(7, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .readTimeout(7, TimeUnit.SECONDS)
                .build();
    }

    private static OkHttpClient client(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
    }



    public static Retrofit getClientServer() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASEURL_LIVE)
                    .client(okClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getClientServerDemo() {

        if (retrofit2 == null) {
            retrofit2 = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASEURL_LIVE2)
                    .client(okClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit2;
    }



    private static OkHttpClient okHttpClient;

    public static Retrofit getClient() {
        if (okHttpClient == null)
            initOkHttp();

         retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASEURL_LIVE)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

    private static void initOkHttp() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor);

        okHttpClient = httpClient.build();
    }


}

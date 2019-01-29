package com.vipin.mvvm_vip_demo.data.apiManager.retrofit;


import com.vipin.mvvm_vip_demo.data.model.network.GetTicketListResponse;
import com.vipin.mvvm_vip_demo.data.model.network.HomeListResponds;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {


    @FormUrlEncoded
    @POST("movie/top_rated")
    Observable<HomeListResponds> GetAllListRequest(@Field("api_key") String key);


    @FormUrlEncoded
    @POST("possale/getOpenTicketsV1")
    Observable<GetTicketListResponse> GetAllListsaved(
            @Field("branchId") String key,
            @Field("stationId") String key1,
            @Field("shoWAllOrder") Boolean key2,
            @Field("deviceId") String key3,
            @Field("searchWithoutDate") Boolean key4);


}

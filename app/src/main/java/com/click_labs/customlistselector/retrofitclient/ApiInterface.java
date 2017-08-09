package com.click_labs.customlistselector.retrofitclient;

import com.click_labs.customlistselector.responsemodel.CommonData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Aman Singh on 08-07-2017.
 */

public interface ApiInterface {

    @GET("api/v1/app/constants")
    Call<CommonData> getCommonData();


}

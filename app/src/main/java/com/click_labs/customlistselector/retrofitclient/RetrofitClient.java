package com.click_labs.customlistselector.retrofitclient;


import com.click_labs.customlistselector.CustomListAdapter;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Rest Client
 */
public class RetrofitClient {

    public static Retrofit googleWebServices = null;
    public static Retrofit retrofit = null;
    private static String BASE_URL = "http://35.160.214.63:3001/";

    /**
     * @return
     */
    public static ApiInterface getApiInterface() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient().build())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }

    private static OkHttpClient.Builder httpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return httpClient;
    }

    public interface GetSelectedValue {
        void getSelectedValue(CustomListAdapter.ViewHolder viewHolder, int position);

    }

}

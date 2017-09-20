package com.zackeryrobinson.weatherappwithviewpager;

import com.zackeryrobinson.weatherappwithviewpager.OpenWeatherMapObjects.WeatherAppWithViewPager;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Zack on 9/19/2017.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "http://api.openweathermap.org";

    public static Retrofit create() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Call<WeatherAppWithViewPager> createCall(String zipcode, String weatherKey) {
        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService.getWeatherResponse(zipcode, weatherKey);
    }

    interface ApiService {
        @GET("data/2.5/forecast")
        Call<WeatherAppWithViewPager> getWeatherResponse(@Query("q") String zipcode, @Query("APPID") String APPID);
    }
}
package com.zackeryrobinson.weatherappwithviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zackeryrobinson.weatherappwithviewpager.OpenWeatherMapObjects.List;
import com.zackeryrobinson.weatherappwithviewpager.OpenWeatherMapObjects.WeatherAppWithViewPager;

import java.io.IOException;
import java.util.ArrayList;


// It was around now we discovered the weather API keys weren't working and had to contact customer support.

public class MainActivity extends AppCompatActivity {

    private static WeatherFragmentAdapter adapter;
    private static final String WEATHER_API_KEY = "6ef8aa3a2a3a349352f5af040c4a682f";
    private static final String ZIPCODE = "30067";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        final java.util.List weatherFragments = new ArrayList<>();

        final retrofit2.Call<WeatherAppWithViewPager> callRepos = RetrofitHelper.createCall(ZIPCODE,WEATHER_API_KEY);

        new Thread(new Runnable() {
            @Override
            public void run() {



                try {
                    WeatherAppWithViewPager forecast = callRepos.execute().body();

                    java.util.List<List> list = forecast.getList();


                    for (List wl : list){
                        weatherFragments.add(WeatherFragment.newInstance(wl));
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter = new WeatherFragmentAdapter(getSupportFragmentManager(), weatherFragments);
                            ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
                            pager.setAdapter(adapter);

                        }
                    });


                    //   super.run();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

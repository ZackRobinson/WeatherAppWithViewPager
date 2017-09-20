package com.zackeryrobinson.weatherappwithviewpager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WeatherFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private static final String ARG_WEATHER_LIST = "weatherList";
    private static final String ARG_WEATHER_DT_LIST = "weatherDTList";
    ImageView ivWeather;
    TextView tvWeather;
    TextView tvDate;
    TextView tvTime;
    private String weather;
    private String dateTime;

    public WeatherFragment() {
        // Required empty public constructor
    }

    public static WeatherFragment newInstance(com.zackeryrobinson.weatherappwithviewpager.OpenWeatherMapObjects.List list) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(ARG_WEATHER_LIST, list.getWeather().get(0).getDescription());
        args.putString(ARG_WEATHER_DT_LIST, list.getDtTxt().toString());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weather = (String) getArguments().get(ARG_WEATHER_LIST);
        dateTime = (String) getArguments().get(ARG_WEATHER_DT_LIST);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivWeather = view.findViewById(R.id.ivWeather);
        tvWeather = view.findViewById(R.id.tvWeather);
        tvDate = view.findViewById(R.id.tvDate);
        tvTime = view.findViewById(R.id.tvTime);

        String desc = weather;
        if(desc != null) {
            tvWeather.setText(desc);
            tvDate.setText(dateTime);
            if (desc.compareTo("clear sky") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.sunny_weather));
            } else if (desc.compareTo("few clouds") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.windy_weather1600));
            } else if (desc.compareTo("overcast clouds") == 0 || desc.compareTo("scattered clouds") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.scatterd_clouds));
            } else if (desc.compareTo("light rain") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.light_rain));
            } else if (desc.compareTo("moderate rain") == 0) {
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.light_rain));
            }
        }



    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}

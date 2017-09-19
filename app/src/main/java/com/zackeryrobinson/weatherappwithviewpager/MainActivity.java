package com.zackeryrobinson.weatherappwithviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



// It was around now we discovered the weather API keys weren't working and had to contact customer support.

public class MainActivity extends AppCompatActivity {
    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, updatedField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);



        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        humidity_field = (TextView)findViewById(R.id.humidity_field);
        pressure_field = (TextView)findViewById(R.id.pressure_field);
    }
}

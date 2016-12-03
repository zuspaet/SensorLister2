package com.example.christian.sensorlister2;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Christian on 02.12.2016.
 */

public abstract class ShowSensorInfoActivity extends AppCompatActivity {
    public SensorManager theSensorManager;
    public Sensor theSensor;
    public List<Sensor> sensorList;
    public String infoString;

    protected int sensorType;
    protected int contentViewId;
    protected TextView defaultSensorInfoTextView;
    protected TextView allSensorsInfoTextView;

    protected abstract int getContentViewId();

    protected abstract void setSensorType();

    protected abstract void setTextView();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        setSensorType();
        setTextView();

        //get default sensor object
        theSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        theSensor = theSensorManager.getDefaultSensor(sensorType);
        defaultSensorInfoTextView.setText(theSensor.toString());

        sensorList = theSensorManager.getSensorList(sensorType);

        infoString ="";
        for (Sensor s : sensorList){
            infoString +=s.toString();
            infoString += "ln";
            infoString += "ln";
        }

        allSensorsInfoTextView.setText(infoString);
    }

}

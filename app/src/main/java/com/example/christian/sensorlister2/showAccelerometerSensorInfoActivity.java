package com.example.christian.sensorlister2;

import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;


public class showAccelerometerSensorInfoActivity extends ShowSensorInfoActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_show_accelerometer_sensor_info;
    }

    @Override
    protected void setSensorType() {
        sensorType = Sensor.TYPE_ACCELEROMETER;

    }

    @Override
    protected void setTextView() {
        defaultSensorInfoTextView = (TextView) findViewById(R.id.AccelerometerDefaultSensorInfoTextView);
        allSensorsInfoTextView = (TextView) findViewById(R.id.allAccelerometerSensorsInfoTextView);

    }


}

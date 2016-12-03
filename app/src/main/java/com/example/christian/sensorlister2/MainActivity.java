package com.example.christian.sensorlister2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/*
**created by Christian on 02.12.2016
 */

public class MainActivity extends AppCompatActivity {
    private TextView txtAccStatus;

    private SensorManager mySensorManager;
    private Sensor myAccSensor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAccStatus=(TextView) findViewById(R.id.AccStatus);

        mySensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
      //  myAccSensor=mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        checkSensor(Sensor.TYPE_ACCELEROMETER, txtAccStatus);

        //if (myAccSensor!=null){
          //  txtAccStatus.setText("True!");
           // }
        //else{
         //   txtAccStatus.setText("False!");
           // }
        //}

    }

    private boolean hasSensor(int sensorType) {
        return mySensorManager.getDefaultSensor(sensorType)!=null;
    }
    private void checkSensor(int sensorType, TextView infoText) {
        if (hasSensor(sensorType)) {
            //Sensor vorhanden
            infoText.setText("TRUE!");
        } else {
            //sensor nicht vorhanden
            infoText.setText("FALSE!");
        }
    }
    public void clickBtnAccelInfo(){
        Intent theIntent= new Intent(this, showAccelerometerSensorInfoActivity.class);
        startActivity(theIntent);
    }
}



package com.example.onlineshop;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private List<SensorWrapper> sensors;
    private ListView sensorListView;
    private SensorWrapperArrayAdapter sensorArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensors = new ArrayList<SensorWrapper>();
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor s : sensorList) {
            sensors.add(new SensorWrapper(s.getName(), 0.0, s));
        }

        sensorListView = (ListView) findViewById(R.id.list_view_sensors);
        sensorArrayAdapter = new SensorWrapperArrayAdapter(this, android.R.layout.simple_list_item_1, sensors);
        sensorListView.setAdapter(sensorArrayAdapter);

        registerSensorChange();
    }

    protected void onResume() {
        super.onResume();
        registerSensorChange();
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    private void registerSensorChange()
    {
        for (SensorWrapper s : sensors) {
            sensorManager.registerListener(this, s.getSensor(), SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for (SensorWrapper s : sensors) {
            if (s.getSensor().getType() == event.sensor.getType()) {
                s.setValue((double)event.values[0]);
                sensorArrayAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

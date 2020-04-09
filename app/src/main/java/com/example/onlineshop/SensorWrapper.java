package com.example.onlineshop;

import android.hardware.Sensor;

public class SensorWrapper {
    private String name;
    private Double value;
    private Sensor sensor;

    public SensorWrapper(String name, Double value, Sensor sensor)
    {
        this.name = name;
        this.value = value;
        this.sensor = sensor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Sensor getSensor() {
        return sensor;
    }
}

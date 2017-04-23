package com.relayr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by azygm on 21.04.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sensor {
    @JsonProperty("id")
    private int id;
    @JsonProperty("engine")
    private String engineId;
    @JsonProperty("type")
    private String type;

    private Sensor masterSensor;

    @JsonProperty("master-sensor-id")
    private String masterStringSensorId;
    @JsonProperty("value")
    private int value;
    @JsonProperty("min_value")
    private int minValue;
    @JsonProperty("max_value")
    private int maxValue;


    public String getMasterStringSensorId() {
        return masterStringSensorId;
    }

    public void setMasterStringSensorId(String masterStringSensorId) {
        this.masterStringSensorId = masterStringSensorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEngineId() {
        return engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sensor getMasterSensor() {
        return masterSensor;
    }

    public void setMasterSensor(Sensor masterSensor) {
        this.masterSensor = masterSensor;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMaxValue() {
        return maxValue;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sensor sensor = (Sensor) o;

        if (id != sensor.id) return false;
        if (value != sensor.value) return false;
        if (minValue != sensor.minValue) return false;
        if (maxValue != sensor.maxValue) return false;
        if (engineId != null ? !engineId.equals(sensor.engineId) : sensor.engineId != null) return false;
        if (type != null ? !type.equals(sensor.type) : sensor.type != null) return false;
        if (masterSensor != null ? !masterSensor.equals(sensor.masterSensor) : sensor.masterSensor != null)
            return false;
        return masterStringSensorId != null ? masterStringSensorId.equals(sensor.masterStringSensorId) : sensor.masterStringSensorId == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (engineId != null ? engineId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (masterSensor != null ? masterSensor.hashCode() : 0);
        result = 31 * result + (masterStringSensorId != null ? masterStringSensorId.hashCode() : 0);
        result = 31 * result + value;
        result = 31 * result + minValue;
        result = 31 * result + maxValue;
        return result;
    }
}

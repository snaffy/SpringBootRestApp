package com.relayr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by azygm on 20.04.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sensor {
    @JsonProperty("id")
    private int id;
    @JsonProperty("engine")
    private int engineId;
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


    public Sensor() {
    }


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

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
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

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
//   private void setMasterStringSensorId(String masterStringSensorId, HashMap<String,Sensor> hashMap){
//
//        this
//   }
}

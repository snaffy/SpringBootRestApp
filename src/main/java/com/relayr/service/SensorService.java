package com.relayr.service;

import com.relayr.domain.Sensor;

import java.util.List;
import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */
public interface SensorService {
    Map<Integer,Sensor> getAllSensor();
    List<Integer> getInoperativeEngines (int pressureTreshold, int tempTreshold);
    void incrementSensorValue(Sensor sensor, int value);
    void decrementSensorValue(Sensor sensor, int value);
    void setSensorValue(Sensor sensor, int newValue);
    boolean checkSetPossibility(Sensor sensor, int value);
    boolean checkIncrementPossibility(Sensor sensor, int value);
    boolean checkDecrementPossibility(Sensor sensor, int value);
}

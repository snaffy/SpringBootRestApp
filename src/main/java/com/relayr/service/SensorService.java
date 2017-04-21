package com.relayr.service;

import com.relayr.domain.Sensor;

import java.util.List;
import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */
public interface SensorService {
    Map<Integer,Sensor> getAllSensor();
    void editSensor(Sensor sensor);
    List<Integer> getInoperativeEngines (int pressureTreshold, int tempTreshold);
}

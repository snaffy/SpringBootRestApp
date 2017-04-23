package com.relayr.service;

import com.relayr.domain.Query;
import com.relayr.domain.Sensor;

import java.util.List;
import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */
public interface SensorService {
    Map<Integer,Sensor> getAllSensor();
    Sensor getSensor(int sensorId);
    boolean checkModifyResourcesPossibility(Query query, Sensor sensor);
    void modifyResource(Query query, Sensor sensor);
    List<String> getInoperativeEngines(int pressureTreshold, int tempTreshold);

}

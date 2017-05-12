package org.restsensors.dao;

import org.restsensors.domain.Sensor;

import java.util.List;
import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */
public interface SensorDao {
    Map<Integer,Sensor> getAllSensor();
    Sensor getSensor(int sensorId);
    void incrementSensorValue(Sensor sensor, int newValue);
    void decrementSensorValue(Sensor sensor, int value);
    void setSensorValue(Sensor sensor, int value);
    List<String> getInoperativeEngines (int pressureTreshold, int tempTreshold);
}

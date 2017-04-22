package com.relayr.service;

import com.relayr.dao.LocalSensorDaoImp;
import com.relayr.domain.Query;
import com.relayr.domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */

@Service
public class SensorServiceImp implements SensorService {

    @Autowired
    private LocalSensorDaoImp localSensorDaoImp;

    @Override
    public Map<Integer, Sensor> getAllSensor() {
        return localSensorDaoImp.getAllSensor();
    }

    @Override
    public boolean checkSetPossibility(Sensor sensor, int value) {
        return value >= sensor.getMinValue() && value <= sensor.getMaxValue();
    }

    @Override
    public boolean checkIncrementPossibility(Sensor sensor, int value) {
        return sensor.getMaxValue() >= sensor.getValue() + value;

    }

    @Override
    public boolean checkDecrementPossibility(Sensor sensor, int value) {
        return sensor.getMinValue() <= sensor.getValue() - value;
    }

    @Override
    public List<Integer> getInoperativeEngines(int pressureTreshold, int tempTreshold) {
        return localSensorDaoImp.getInoperativeEngines(pressureTreshold,tempTreshold);
    }

    @Override
    public void incrementSensorValue(Sensor sensor, int value) {
       localSensorDaoImp.incrementSensorValue(sensor, value);
    }

    @Override
    public void decrementSensorValue(Sensor sensor, int value) {
        localSensorDaoImp.decrementSensorValue(sensor,value);
    }

    @Override
    public void setSensorValue(Sensor sensor, int newValue) {
        localSensorDaoImp.setSensorValue(sensor,newValue);
    }

    public Sensor getSensor(int sensorId){
        return localSensorDaoImp.getSensor(sensorId);
    }

    public boolean checkModifyResourcesPossibility(Query query, Sensor sensor) {
        switch (query.getOperation())
        {
            case "increment" : return checkIncrementPossibility(sensor, query.getValue());

            case "decrement" : return checkDecrementPossibility(sensor,query.getValue());

            case "set" : return checkSetPossibility(sensor,query.getValue());

            default: return false;
        }
    }

    public void modifyResource(Query query, Sensor sensor) {
        switch (query.getOperation())
        {
            case "increment" :  incrementSensorValue(sensor, query.getValue());
                                break;
            case "decrement" :  decrementSensorValue(sensor,query.getValue());
                                break;
            case "set" :  setSensorValue(sensor,query.getValue());
                                break;
        }
    }
}

package org.restsensors.service;

import org.restsensors.dao.LocalSensorDaoImp;
import org.restsensors.domain.Query;
import org.restsensors.domain.Sensor;
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
    public Sensor getSensor(int sensorId){
        return localSensorDaoImp.getSensor(sensorId);
    }

    @Override
    public boolean checkModifyResourcesPossibility(Query query, Sensor sensor) {
        switch (query.getOperation())
        {
            case "increment" : return checkIncrementPossibility(sensor, query.getValue());

            case "decrement" : return checkDecrementPossibility(sensor,query.getValue());

            case "set" : return checkSetPossibility(sensor,query.getValue());

            default: return false;
        }
    }

    @Override
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

    @Override
    public List<String> getInoperativeEngines(int pressureTreshold, int tempTreshold) {
        return localSensorDaoImp.getInoperativeEngines(pressureTreshold,tempTreshold);
    }

    private boolean checkSetPossibility(Sensor sensor, int value) {
        return value >= sensor.getMinValue() && value <= sensor.getMaxValue();
    }

    private boolean checkIncrementPossibility(Sensor sensor, int value) {
        return sensor.getMaxValue() >= sensor.getValue() + value;

    }

    private boolean checkDecrementPossibility(Sensor sensor, int value) {
        return sensor.getMinValue() <= sensor.getValue() - value;
    }

    private void incrementSensorValue(Sensor sensor, int value) {
       localSensorDaoImp.incrementSensorValue(sensor, value);
    }

    private void decrementSensorValue(Sensor sensor, int value) {
        localSensorDaoImp.decrementSensorValue(sensor,value);
    }

    private void setSensorValue(Sensor sensor, int newValue) {
        localSensorDaoImp.setSensorValue(sensor,newValue);
    }

}

package com.relayr.dao;

import com.relayr.domain.Sensor;
import com.relayr.service.FetchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */
@Repository
@PropertySource("classpath:/application.properties")
public class LocalSensorDaoImp  implements SensorDao{

    private Map<Integer, Sensor> hashMap = new HashMap<>();

    @Autowired
    private FetchData fetchData = new FetchData() ;

    public LocalSensorDaoImp(@Value("${uri}") String uri) {
        if (!uri.equals("false")) {
//            fetchData = new FetchData(uri);
            this.hashMap = fetchData.getDataByUri(uri);
        }
    }

    @Override
    public Map<Integer, Sensor> getAllSensor() {
        return hashMap;
    }

    @Override
    public Sensor getSensor(int sensorId) {
        return hashMap.get(sensorId);
    }

    @Override
    public void incrementSensorValue(Sensor sensor, int value) {
        sensor.setValue(sensor.getValue() + value);
    }

    @Override
    public void decrementSensorValue(Sensor sensor, int value) {
        sensor.setValue(sensor.getValue() - value);
    }

    @Override
    public void setSensorValue(Sensor sensor, int newValue) {
        sensor.setValue(newValue);
    }

    @Override
    public List<Integer> getInoperativeEngines(int pressureTreshold, int tempTreshold) {
       List<Integer> inoperativeEndineList = new ArrayList<>();

        for(Map.Entry<Integer, Sensor> entry : hashMap.entrySet()) {
            Sensor sensorTmp = entry.getValue();
            if (sensorTmp.getType().equals("temperature")) {
                if (sensorTmp.getValue() >= tempTreshold) {
                    Sensor masterSensor = sensorTmp.getMasterSensor();
                    if (masterSensor.getValue() <= pressureTreshold) {
                        Integer engineID = masterSensor.getEngineId();
                        if (!inoperativeEndineList.contains(engineID)) {
                            inoperativeEndineList.add(engineID);
                        }
                    }
                }
            }
        }
        return inoperativeEndineList;
    }

}

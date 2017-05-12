package org.restsensors.dao;

import org.restsensors.domain.Sensor;
import org.restsensors.service.FetchData;
import org.restsensors.service.FetchDataImp;
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
    private FetchData fetchData = new FetchDataImp() ;

    public LocalSensorDaoImp(@Value("${server}") String server) {
        if (!server.equals("false")) {
            String dataFromUri = fetchData.getDataByUri(server);
            this.hashMap = fetchData.parseData(dataFromUri);
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
    public List<String> getInoperativeEngines(int pressureTreshold, int tempTreshold) {
        List<String> inoperativeEndineList = new ArrayList<>();

        for(Map.Entry<Integer, Sensor> entry : hashMap.entrySet()) {
            Sensor sensor = entry.getValue();
            if (isEngineInoperative(sensor, pressureTreshold, tempTreshold) && !inoperativeEndineList.contains(sensor.getMasterSensor().getEngineId()))
                inoperativeEndineList.add(sensor.getMasterSensor().getEngineId());
        }
        return inoperativeEndineList;
    }

    private Boolean isEngineInoperative(Sensor sensor, int pressureTreshold, int tempTreshold)
    {
        return isTemperatureValid(sensor, tempTreshold) && isPressureValid(sensor, pressureTreshold);
    }

    private Boolean isPressureValid(Sensor sensor, int pressureTreshold)
    {
        Sensor masterSensor = sensor.getMasterSensor();
        return masterSensor.getValue() <= pressureTreshold;
    }

    private Boolean isTemperatureValid(Sensor sensor, int tempTreshold)
    {
        return sensor.getType().equals("temperature") && sensor.getValue() >= tempTreshold;
    }

}

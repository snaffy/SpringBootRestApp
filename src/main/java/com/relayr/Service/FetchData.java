package com.relayr.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.relayr.model.Sensor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by azygm on 20.04.2017.
 */
@Service
public class FetchData {

    private String tmp = "- id: \"3142\"\n" +
            "  engine: \"123\"\n" +
            "  type: \"pressure\"\n" +
            "  name: \"Engine 123\"\n" +
            "  value: 70\n" +
            "  min_value: 0\n" +
            "  max_value: 120\n" +
            "- id: \"32234\"\n" +
            "  master-sensor-id: \"3142\"\n" +
            "  type: \"temperature\"\n" +
            "  value: 82\n" +
            "  min_value: -50\n" +
            "  max_value: 150\n" +
            "- id: \"57230\"\n" +
            "  master-sensor-id: \"3142\"\n" +
            "  type: \"temperature\"\n" +
            "  value: 101\n" +
            "  min_value: 0\n" +
            "  max_value: 273\n" +
            "- id: \"5703\"\n" +
            "  engine: \"156\"\n" +
            "  location: \"\"\n" +
            "  type: \"pressure\"\n" +
            "  name: \"Engine 156\"\n" +
            "  value: 73\n" +
            "  min_value: 0\n" +
            "  max_value: 150\n" +
            "- id: \"89145\"\n" +
            "  master-sensor-id: \"5703\"\n" +
            "  type: \"temperature\"\n" +
            "  value: 99\n" +
            "  min_value: 0\n" +
            "  max_value: 100";

    private Map<Integer,Sensor> sensorMap = new HashMap<>() ;

    public Map<Integer, Sensor> getSensorMap() {
        return sensorMap;
    }

    private void setSensorMap(Map<Integer, Sensor> sensorMap) {
        this.sensorMap = sensorMap;
    }

    public FetchData()
    {
//        this.getFixedSensorHashMap();
    }

    public FetchData(String params)
    {
        this.setFixedSensorHashMap();
    }


    private Sensor[] getData() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(this.tmp,Sensor[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setFixedSensorHashMap()
    {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Sensor[] sensorArray =  mapper.readValue(this.tmp,Sensor[].class);
            Map<Integer,Sensor> sensorMap = new HashMap<>() ;
            for(Sensor element : sensorArray){
                sensorMap.put(element.getId(),element);
            }
            for(Map.Entry<Integer, Sensor> entry : sensorMap.entrySet()){

                if( entry.getValue().getMasterStringSensorId() != null) {
                    Integer tmpKey = Integer.parseInt(entry.getValue().getMasterStringSensorId());
                    Sensor tmpSensor = sensorMap.get(tmpKey);
                    sensorMap.get(entry.getKey()).setMasterSensor(tmpSensor);
                }
            }
           this.setSensorMap(sensorMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

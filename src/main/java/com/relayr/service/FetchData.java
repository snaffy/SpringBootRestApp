package com.relayr.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.relayr.controller.EngineController;
import com.relayr.domain.Sensor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by azygm on 20.04.2017.
 */
@Service
public class FetchData {

//    private static Logger logger = Logger.getLogger(EngineController.class);

    private String tmp = "- id: \"3142\"\n" +
            "  engine: \"123\"\n" +
            "  type: \"pressure\"\n" +
            "  name: \"Engine 123\"\n" +
            "  value: 27\n" +
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
            "  value: 55\n" +
            "  min_value: 0\n" +
            "  max_value: 100\n" +
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
            "  value: 65\n" +
            "  min_value: 0\n" +
            "  max_value: 100";

    // -Duri="https://raw.githubusercontent.com/relayr/pdm-test/master/sensors.yml" -q

    public FetchData()
    {
    }

    public Map<Integer,Sensor> getDataByUri(String uri){
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<Integer,Sensor> sensorMap = new HashMap<>();
        try {
            String result = restTemplate.getForObject(uri, String.class);
            Sensor[] sensorArray =  mapper.readValue(result,Sensor[].class);
            sensorMap = this.convertArrayToHashMap(sensorArray);
            sensorMap = this.convertStringMasterIdToObjectMaster(sensorMap);
            return sensorMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sensorMap;
    }

    private Map<Integer,Sensor> convertArrayToHashMap(Sensor[] sensorArray)
    {
        Map<Integer,Sensor> sensorMap = new HashMap<>();
        for(Sensor element : sensorArray){
            sensorMap.put(element.getId(),element);
        }
        return sensorMap;
    }

    private Map<Integer,Sensor> convertStringMasterIdToObjectMaster (Map<Integer,Sensor> sensorMap)
    {
        for(Map.Entry<Integer, Sensor> entry : sensorMap.entrySet()){
            if( entry.getValue().getMasterStringSensorId() != null) {
                Integer tmpKey = Integer.parseInt(entry.getValue().getMasterStringSensorId());
                Sensor tmpSensor = sensorMap.get(tmpKey);
                sensorMap.get(entry.getKey()).setMasterSensor(tmpSensor);
            }
        }
        return sensorMap;
    }

}

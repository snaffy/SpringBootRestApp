package org.restsensors.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.restsensors.domain.Sensor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */
@Service
public class FetchDataImp implements FetchData {
    private static Logger logger = Logger.getLogger(FetchData.class);

    @Override
    public Map<Integer,Sensor> parseData(String data){

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<Integer,Sensor> sensorMap;
        try {
            Sensor[] sensorArray =  mapper.readValue(data,Sensor[].class);
            sensorMap = convertArrayToHashMap(sensorArray);
            sensorMap = convertStringMasterIdToObjectMaster(sensorMap);
            return sensorMap;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new HashMap<>();
        }
    }

    @Override
    public String getDataByUri(String uri){
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(uri,String.class);
        }catch (Exception e){
            logger.error("There was a problem during load the data. " + e.getMessage());
            return "";
        }

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

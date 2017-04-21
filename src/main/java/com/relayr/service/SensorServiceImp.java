package com.relayr.service;

import com.relayr.dao.LocalSensorDaoImp;
import com.relayr.domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */

@Service
//@ComponentScan
//@PropertySource("classpath:/application.properties")
public class SensorServiceImp implements SensorService {

//    private Map<Integer, Sensor> hashMap = new HashMap<>();
//
//    @Autowired
//    private FetchData fetchData ;
//            // -Duri="TEST" -q
//
//    public SensorServiceImp(@Value("${uri}") String uri) {
//        if (!uri.equals("false")) {
//            fetchData = new FetchData(uri);
//            this.hashMap = fetchData.getSensorMap();
//        }
//    }

//    public Map<Integer,Sensor> getAll()
//    {
//        return hashMap;
//    }

    @Autowired
    private LocalSensorDaoImp localSensorDaoImp;

    @Override
    public Map<Integer, Sensor> getAllSensor() {
        return localSensorDaoImp.getAllSensor();
    }

    @Override
    public void editSensor(Sensor sensor) {

    }

    @Override
    public List<Integer> getInoperativeEngines(int pressureTreshold, int tempTreshold) {
        return localSensorDaoImp.getInoperativeEngines(pressureTreshold,tempTreshold);
    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}

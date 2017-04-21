package com.relayr.controller;

import com.relayr.service.SensorServiceImp;
import com.relayr.domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */
@RestController
public class EngineController {

    @Autowired
    private SensorServiceImp sensorService ;

    @RequestMapping("/all")
    public Map<Integer, Sensor> getAll(){
        return sensorService.getAllSensor();
    }

    @RequestMapping("/engines")
    public List<Integer> getInoperativeEngines(@RequestParam(value = "pressure_threshold") Integer pressureThreshold,
                                               @RequestParam(value = "temp_threshold") Integer tempTreshold){
        return sensorService.getInoperativeEngines(pressureThreshold,tempTreshold);
    }
}

package com.relayr.controller;

import com.relayr.Service.SensorService;
import com.relayr.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */
@RestController
@RequestMapping("/engine")
public class EngineController {

    @Autowired
    private SensorService sensorService ;

    @RequestMapping("/all")
    public Map<Integer, Sensor> getAll(){
        return sensorService.getAll();
    }
}

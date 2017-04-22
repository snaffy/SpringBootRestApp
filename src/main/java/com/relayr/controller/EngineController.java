package com.relayr.controller;

import com.relayr.domain.Query;
import com.relayr.service.SensorServiceImp;
import com.relayr.domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/engines",method = RequestMethod.GET)
    public List<Integer> getInoperativeEngines(@RequestParam(value = "pressure_threshold") Integer pressureThreshold,
                                               @RequestParam(value = "temp_threshold") Integer tempTreshold){
        return sensorService.getInoperativeEngines(pressureThreshold,tempTreshold);
    }

    @RequestMapping(value = "/sensor/{sensorId}",method = RequestMethod.POST)
    public ResponseEntity<?> getInoperativeEngines(@PathVariable Integer sensorId,
                                                   @RequestBody Query query){
        Sensor sensor = sensorService.getSensor(sensorId);
        if(sensor != null)
        {
            if(sensorService.checkModifyResourcesPossibility(query,sensor))
            {
                sensorService.modifyResource(query, sensor);
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }



}

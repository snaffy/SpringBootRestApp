/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relayr.service;

import com.relayr.dao.LocalSensorDaoImp;
import com.relayr.domain.Query;
import com.relayr.domain.Sensor;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by azygm on 22.04.2017.
 */
@RunWith(SpringRunner.class)
public class SensorServiceImpIT {

    /**
     * Test of checkSetPossibility method, of class SensorServiceImp.
     */
    @Test
    public void testCheckSetPossibility() {
        Sensor sensor = new Sensor();
        sensor.setMinValue(50);
        sensor.setMaxValue(100);
        int value = 55;
        SensorServiceImp instance = new SensorServiceImp();
        boolean expResult = true;
        
        boolean result = instance.checkSetPossibility(sensor, value);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkIncrementPossibility method, of class SensorServiceImp.
     */
    @Test
    public void testCheckIncrementPossibility() {
        Sensor sensor = new Sensor();
        sensor.setValue(20);
        sensor.setMaxValue(100);
        int value = 55;
        SensorServiceImp instance = new SensorServiceImp();
        boolean expResult = true;
        
        boolean result = instance.checkIncrementPossibility(sensor, value);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDecrementPossibility method, of class SensorServiceImp.
     */
    @Test
    public void testCheckDecrementPossibility() {
        Sensor sensor = new Sensor();
        sensor.setValue(20);
        sensor.setMinValue(10);
        int value = 5;
        SensorServiceImp instance = new SensorServiceImp();
        boolean expResult = true;
        
        boolean result = instance.checkDecrementPossibility(sensor, value);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of checkModifyResourcesPossibility method, of class SensorServiceImp.
     */
    @Test
    public void testCheckModifyResourcesPossibility() {
        Query query = new Query();
        query.setOperation("increment");
        query.setValue(5);
        Sensor sensor = new Sensor();
        sensor.setValue(5);
        sensor.setMaxValue(2);
        SensorServiceImp instance = new SensorServiceImp();
        boolean expResult = false;
        
        boolean result = instance.checkModifyResourcesPossibility(query, sensor);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of modifyResource method, of class SensorServiceImp.
     */
//    @Test
//    public void testModifyResource() {
//        Query query = new Query();
//        query.setOperation("increment");
//        query.setValue(5);
//        Sensor sensor = new Sensor();
//        sensor.setValue(5);
//        sensor.setEngineId("1");
//        sensor.setId(3);
//        sensor.setMasterSensor(new Sensor());
//        sensor.setMaxValue(100);
//        sensor.setMinValue(0);
//        sensor.setType("pressure");
//        SensorServiceImp instance = new SensorServiceImp();
//        int expResult = 10;
//
//        instance.modifyResource(query, sensor);
//
//
//        assertEquals(expResult, sensor.getValue());
//    }
    
}

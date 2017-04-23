/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relayr.dao;

import com.relayr.domain.Sensor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by azygm on 22.04.2017.
 */
public class LocalSensorDaoImpITests {

    /**
     * Test of incrementSensorValue method, of class LocalSensorDaoImp.
     */
    @Test
    public void testIncrementSensorValue() {
        Sensor sensor = new Sensor();
        sensor.setValue(10);
        int valueToIncrement = 10;
        int expectedValue = 20;
        LocalSensorDaoImp instance = new LocalSensorDaoImp("false");
        
        instance.incrementSensorValue(sensor, valueToIncrement);
        
        assertEquals(sensor.getValue(), expectedValue);
    }

    /**
     * Test of decrementSensorValue method, of class LocalSensorDaoImp.
     */
    @Test
    public void testDecrementSensorValue() {
        Sensor sensor = new Sensor();
        sensor.setValue(10);
        int valueToIncrement = 10;
        int expectedValue = 0;
        LocalSensorDaoImp instance = new LocalSensorDaoImp("false");
        
        instance.decrementSensorValue(sensor, valueToIncrement);
        assertEquals(sensor.getValue(), expectedValue);
    }

    
}

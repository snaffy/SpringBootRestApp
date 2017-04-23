/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relayr.service;

import com.relayr.domain.Sensor;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

/**
 * Created by azygm on 22.04.2017.
 */
public class FetchDataImpITests {
    /**
     * Test of testParseDataFileExists method, of class FetchDataImp.
     */
    @Test
    public void testParseDataFileExists() {
        String dataExample = "- id: \"3142\"\n" +
            "  engine: \"123\"\n" +
            "  type: \"pressure\"\n" +
            "  name: \"Engine 123\"\n" +
            "  value: 27\n" +
            "  min_value: 0\n" +
            "  max_value: 120\n";
        
        FetchDataImp instance = new FetchDataImp();
        Sensor sensor = new Sensor();
        sensor.setId(3142);
        sensor.setEngineId("123");
        sensor.setType("pressure");
        sensor.setValue(27);
        sensor.setMinValue(0);
        sensor.setMaxValue(120);
        Map<Integer, Sensor> expResult = new HashMap<>();
        expResult.put(3142,sensor);

        Map<Integer, Sensor> result = instance.parseData(dataExample);

        assertEquals(expResult, result);
    }

    /**
     * Test of testParseDataFileNotExists method, of class FetchDataImp.
     */
    @Test
    public void testParseDataFileNotExists() {
        String dataExample = "";
        Map<Integer, Sensor> expResult = new HashMap<>();
        FetchDataImp instance = new FetchDataImp();

        Map<Integer, Sensor> result = instance.parseData(dataExample);

        assertEquals(expResult, result);
    }

    /**
     * Test of getDataByUri method, of class FetchDataImp.
     */
    @Test
    public void testGetDataByUri() {
        String uri = "";
        FetchDataImp instance = new FetchDataImp();
        String result = instance.getDataByUri(uri);

        assertEquals(uri, result);
    }
    
}

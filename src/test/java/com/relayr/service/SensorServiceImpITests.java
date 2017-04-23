package com.relayr.service;
import com.relayr.domain.Query;
import com.relayr.domain.Sensor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by azygm on 22.04.2017.
 */
@RunWith(SpringRunner.class)
public class SensorServiceImpITests {

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

    
}

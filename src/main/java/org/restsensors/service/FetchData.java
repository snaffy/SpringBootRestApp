package org.restsensors.service;

import org.restsensors.domain.Sensor;

import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */
public interface FetchData {
    Map<Integer,Sensor> parseData(String uri);
    String getDataByUri(String uri);
}

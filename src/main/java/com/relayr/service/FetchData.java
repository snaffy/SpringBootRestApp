package com.relayr.service;

import com.relayr.domain.Sensor;

import java.util.Map;

/**
 * Created by azygm on 22.04.2017.
 */
public interface FetchData {
    Map<Integer,Sensor> getDataByUri(String uri);
}

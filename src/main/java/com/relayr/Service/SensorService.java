package com.relayr.Service;

import com.relayr.model.Sensor;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by azygm on 21.04.2017.
 */
@Service
@ComponentScan
@PropertySource("classpath:/application.properties")
public class SensorService {

    private Map<Integer, Sensor> hashMap = new HashMap<>();

    @Autowired
    private FetchData fetchData ;
            // -Duri="TEST" -q

    public SensorService(@Value("${uri}") String uri) {
        if (!uri.equals("false")) {
            fetchData = new FetchData(uri);
            this.hashMap = fetchData.getSensorMap();
        }
    }

    public Map<Integer,Sensor> getAll()
    {
        return hashMap;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

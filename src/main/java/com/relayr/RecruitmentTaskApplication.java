package com.relayr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.relayr.Service.FetchData;
import com.relayr.model.Sensor;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yaml.snakeyaml.Yaml;

import javax.xml.transform.Result;
import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class RecruitmentTaskApplication {

	@Autowired
	private static FetchData fetchData = new FetchData();

	public static void main(String[] args) throws IOException {

		Map<Integer,Sensor> map = fetchData.getFixedSensorHashMap();



//		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//		Sensor[] sensor = mapper.readValue(tmp,Sensor[].class);
//		Map<Integer,Sensor> hashMap = new HashMap<Integer,Sensor>();
//
//		for(Sensor element : sensor){
//			hashMap.put(element.getId(),element);
//		}
//
//		for(Map.Entry<Integer, Sensor> entry : hashMap.entrySet()){
//
//			if( entry.getValue().getMasterStringSensorId() != null) {
//				Integer tmpKey = Integer.parseInt(entry.getValue().getMasterStringSensorId());
//				Sensor tmpSensor = hashMap.get(tmpKey);
//				hashMap.get(entry.getKey()).setMasterSensor(tmpSensor);
//
//			}
//
//		}

		System.out.print("asf");

		SpringApplication.run(RecruitmentTaskApplication.class, args);
	}

	private void modifySensor(Map<Integer,Sensor> map){

	}

}

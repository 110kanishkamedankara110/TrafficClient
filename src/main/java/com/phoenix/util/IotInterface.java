package com.phoenix.util;

import com.phoenix.sensor.GpsTracker;
import com.phoenix.sensor.SpeedSensor;
import com.phoenix.sensor.TrafficLight;

import java.lang.reflect.Method;
import java.util.Map;

public abstract class IotInterface implements IotComponent<String>{
    private final IotComponent<Integer> speedSensor;
    private final IotComponent<Map<String, String>> gpsTracker;
    private final IotComponent<Integer> trafficLight;


    public IotInterface() {
        try {
            Method m = IotInterface.class.getDeclaredMethod("onTrafficLightChange", int.class);
            gpsTracker = new GpsTracker();
            trafficLight = new TrafficLight( this);
            speedSensor = new SpeedSensor(trafficLight);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getTrafficLightStatus() {
       return trafficLight.getData();
    }

    public Map<String,String> getGpsLocation() {
       return gpsTracker.getData();
    }

    public Integer getSpeed(){
        return speedSensor.getData();
    }

    @Override
    public final String getData() {
        return "{\"speed\":"+getSpeed()+",\"trafficLight\":"+getTrafficLightStatus()+",\"gps\":{\"latitude\":\""+getGpsLocation().get("Latitude")+"\",\"longitude\":\""+getGpsLocation().get("Longitude")+"\"}}";
    }
    public abstract void onTrafficLightChange(int status);
}

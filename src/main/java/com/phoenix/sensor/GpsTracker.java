package com.phoenix.sensor;

import com.phoenix.util.IotComponent;
import com.phoenix.util.Locations;

import java.util.Map;

public class GpsTracker implements IotComponent<Map<String, String>> {
    Map<String,String> location;

    public GpsTracker(){
        this.location = Locations.getRandomLocation();
    }

    public Map<String, String> getData() {
        return location;
    }
}

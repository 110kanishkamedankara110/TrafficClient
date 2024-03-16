package com.phoenix.util;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Locations {
    private final static List<Map<String, String>> locations=new LinkedList<>();


    static {
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> loc = new HashMap<>();
            DecimalFormat df = new DecimalFormat("#.##");
            String lat = (int) (Math.random() * (20 - 1) + 1) + "\u00B0" + (int) (Math.random() * (50 - 10) + 10) + "\u2032" + df.format((Math.random() * (100 - 1) + 1)) + "\u2033 N";
            String lon = (int) (Math.random() * (50 - 1) + 1) + "\u00B0" + (int) (Math.random() * (80 - 10) + 10) + "\u2032" + df.format((Math.random() * (90 - 1) + 1)) + "\u2033 W";

            loc.put("Latitude",lat);
            loc.put("Longitude",lon);

            locations.add(loc);

        }
    }
    public static Map<String,String> getRandomLocation(){
        int index=(int) (Math.random() * (locations.size()));
        Map<String,String> location=locations.get(index);
        locations.remove(index);
        return location;
    }
}

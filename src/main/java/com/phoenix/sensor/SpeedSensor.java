package com.phoenix.sensor;

import com.phoenix.util.IotComponent;

public class SpeedSensor implements IotComponent<Integer> {
   private final IotComponent<Integer> trafficLight;

    public SpeedSensor(IotComponent<Integer> trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public Integer getData() {
        int[] stopSpeeds={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,(int)(Math.random() * (260)),0,0,0};
        int[] slowingSpeeds={(int)(Math.random() * (20)),(int)(Math.random() * (10)),(int)(Math.random() * (30)),(int)(Math.random() * (260)),(int)(Math.random() * (10)),(int)(Math.random() * (10)),(int)(Math.random() * (10)),(int)(Math.random() * (10)),(int)(Math.random() * (10)),(int)(Math.random() * (10))};
        if(trafficLight.getData()==3){
            return stopSpeeds[(int)(Math.random() * (stopSpeeds.length))];
        }
        if(trafficLight.getData()==2){
            return slowingSpeeds[(int)(Math.random() * (slowingSpeeds.length))];
        }
        return (int)(Math.random() * (260 - 1) + 1);
    }
}

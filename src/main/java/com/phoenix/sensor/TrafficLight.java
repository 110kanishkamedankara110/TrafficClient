package com.phoenix.sensor;

import com.phoenix.util.IotComponent;
import com.phoenix.util.IotInterface;

import java.lang.reflect.Method;

public class TrafficLight implements IotComponent {
   private int status = (int)(Math.random() * (4 - 1) + 1);
   private final Method invoker;
    private final IotInterface in;

    public TrafficLight(IotInterface in) {
        try {
            this.invoker=IotInterface.class.getDeclaredMethod("onTrafficLightChange", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        this.in=in;

        new Thread(() -> {
            while (true) {
                if (status == 1) {
                    try {
                        onChange();
                        Thread.sleep(6000);
                        status = 2;
                        onChange();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                if (status == 2) {
                    try {
                        Thread.sleep(500);
                        status = 3;
                        onChange();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                if (status == 3) {
                    try {
                        Thread.sleep(6000);
                        status = 1;
                        onChange();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }).start();
    }

    @Override
    public final Object getData() {
        return status;
    }

    public void onChange() {
        try {
            invoker.invoke(in,status);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

package com.tutorial.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    @Override
    public String toString() {
        return "FourWheeler{" +
                "steeringWheel='" + steeringWheel + '\'' +
                '}';
    }
}

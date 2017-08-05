package com.tutorial.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
    private String handle;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return "TwoWheeler{" +
                "handle='" + handle + '\'' +
                '}';
    }
}

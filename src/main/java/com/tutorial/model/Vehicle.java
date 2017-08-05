package com.tutorial.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "VEHICLE_TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Commute")
public class Vehicle {
    @Id @GeneratedValue
    private int id;
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

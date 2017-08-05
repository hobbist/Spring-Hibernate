package com.tutorial.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="user_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name ="ADDRESS_LINE1")
    private String addressLine1;
    @Column(name ="ADDRESS_LINE2")
    private String addressLine2;
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<User> users=new ArrayList<User>();
    public Address(){}
    public Address(String addressLine1, String addressLine2) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getGetAddressLine2() {
        return addressLine2;
    }

    public void setGetAddressLine2(String getAddressLine2) {
        this.addressLine2 = getAddressLine2;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", getAddressLine2='" + addressLine2 + '\'' +
                '}';
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

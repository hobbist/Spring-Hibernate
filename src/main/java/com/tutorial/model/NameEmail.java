package com.tutorial.model;

/**
 * Created by Amit on 05-08-2017.
 */
public class NameEmail {
    private String name;
    private String email;

    public NameEmail(String name,String email){
        this.name=name;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NameEmail{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package com.tutorial.model;

import javax.persistence.*;

@Entity
@Table(name="credentials")
public class Credentials {
    @Id
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "user_id")
    private int user_id;

    public Credentials() {}

    public Credentials(int userId, String userName, String password) {
        this.userName = userName;
        this.password = password;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }




    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}


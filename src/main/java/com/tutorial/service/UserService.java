package com.tutorial.service;

import com.tutorial.model.Credentials;
import com.tutorial.model.User;

import java.util.List;


public interface UserService {
    public void addUser(User user);
    public void addCredential(Credentials cred);
    public List<User> getUsers();
    public List<User> getTypeFilteredUsers(int paramVal);
    public void removeUser(User user);
    public User getUserByName(String name);
    public List<User> getUserByCriteria(String name);
    public boolean updateUserEmail(String name,String email);

}

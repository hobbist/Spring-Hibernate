package com.tutorial.dao;


import com.tutorial.model.Credentials;
import com.tutorial.model.User;

import java.util.List;

public interface UserDao {
    public void insertUser(User user);
    public void insertCredential(Credentials cred);
    public List getUsers();
    public List getUsersWithFilter(int paramVal);
    public void deleteUser(User user);
    public User getUserByName(String name);
    public List<User> getUserByCriteria(String name);
    public boolean updateUserEmail(String name,String email);

}

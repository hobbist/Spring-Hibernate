package com.tutorial.service;


import com.tutorial.dao.UserDao;
import com.tutorial.model.Credentials;
import com.tutorial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;


    public void addUser(User user) {
        dao.insertUser(user);
    }

    public void addCredential(Credentials cred) {dao.insertCredential(cred);}

    public List<User> getUsers() {
        return dao.getUsers();
    }

    public List<User> getTypeFilteredUsers(int paramVal) {
        return dao.getUsersWithFilter(paramVal);
    }

    public void removeUser(User user) {
        dao.deleteUser(user);
    }

    public User getUserByName(String name) {
        return dao.getUserByName(name);
    }

    public List<User> getUserByCriteria(String name) {
         return dao.getUserByCriteria(name);
    }

    public boolean updateUserEmail(String name,String email){
        return dao.updateUserEmail(name, email);
    }
}

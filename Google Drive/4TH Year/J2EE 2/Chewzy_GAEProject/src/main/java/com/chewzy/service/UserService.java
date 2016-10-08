package com.chewzy.service;

import com.chewzy.model.User;

import java.util.List;

/**
 * Created by Misa on 9/14/2016.
 */
public interface UserService {
    public List<User> getAllUsers();
    public User getUserbyId(Long id);
    public boolean checkIfexist(User user);
    public boolean addUser(User user);
    public String checkAdduser(User user);
    public String checkPW(String password, String confirmpw);
    public User login(String username, String password);
}

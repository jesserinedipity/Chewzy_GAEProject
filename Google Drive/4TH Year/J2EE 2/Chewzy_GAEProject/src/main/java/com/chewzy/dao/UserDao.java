package com.chewzy.dao;

import com.chewzy.model.User;

import java.util.List;

/**
 * Created by Misa on 9/14/2016.
 */
public interface UserDao {
    public List<User> getAllUsers() throws Exception;
    public User getUserbyId(Long id) throws Exception;
    public void addUser(User user) throws Exception;
    public void updateUser(User user, String userid) throws Exception;
    public void deleteUser(String userid) throws Exception;
}

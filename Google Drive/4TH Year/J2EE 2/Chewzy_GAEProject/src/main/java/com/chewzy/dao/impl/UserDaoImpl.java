package com.chewzy.dao.impl;

import com.chewzy.dao.UserDao;
import com.chewzy.model.User;
import com.googlecode.objectify.ObjectifyService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Misa on 9/14/2016.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{

    public List<User> getAllUsers(){
        List<User> userList = ObjectifyService.ofy().load().type(User.class).list();

        return userList;
    }

    public User getUserbyId(Long id){
        User user =      ObjectifyService.ofy().load().type(User.class).id(id).now();

        return user;
    }


    public void addUser (User user){

        ObjectifyService.ofy().save().entity(user).now();
    }

    //Still not working
    public void updateUser(User user, String userid){
        Long u_id = Long.parseLong(userid);
        ObjectifyService.ofy().load().type(User.class).id(u_id).now();
    }

    public void deleteUser(String userid){
        Long u_id = Long.parseLong(userid);

    }
}
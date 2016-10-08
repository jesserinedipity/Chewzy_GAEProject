package com.chewzy.service.impl;

import com.chewzy.dao.UserDao;
import com.chewzy.model.User;
import com.chewzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Misa on 9/14/2016.
 */
@Component("userSrvc")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers(){
        List<User> userList = null;
        try {
            userList = userDao.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }

    return userList;
    }

    public User getUserbyId(Long userid){
        User getUser = null;
        System.out.println(userid);
        try {
            getUser = userDao.getUserbyId(userid);
            System.out.println(getUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getUser;
    }

    public boolean checkIfexist(User user){
        boolean exist=false;
        int loop; //for loop count purpose
        try{
            List<User> userList = userDao.getAllUsers();
            for(loop=0; loop<userList.size(); loop++){
                if(userList.get(loop).getUsername().equals(user.getUsername())){
                    exist=true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exist;
    }

    public boolean addUser(User user){
        boolean error=false;
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            error=true;
            e.printStackTrace();
        }
        return error;
    }

    public String checkAdduser(User user){
        String response="";
                if(addUser(user)){
                    response="Failed to add User";
                }
                else{
                    response="Success adding User.";
                }
        return response;
    }

    public String checkPW(String password, String confirmpw){
        boolean identical=false;
        String pw="";
        try {
            if(password.equals(confirmpw)){
                identical=true;
            }
            if(identical){
                pw=password;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return pw;
    }

    public User login(String username, String password){
        int loop;
        boolean exist=false; //checks if user is registered
        Long userId=null;
        User getUser = null;

        try {
            List<User> userlist = userDao.getAllUsers();
            for (loop = 0; loop < userlist.size(); loop++) {
                if (userlist.get(loop).getUsername().equals(username)) {
                    userId=userlist.get(loop).getUser_id();
                }
                else {
                    exist=false;
                }
            }

            //get User with user_id = userId
            getUser = getUserbyId(userId);

            if(getUser.getPassword().equals(password)){
                exist=true;
                System.out.println("Successfully logged in user "+userId);
            }else{
                exist=false;
                System.out.println("Password is incorrect");
            }

        }
        catch(Exception e){
            exist=false;
            e.printStackTrace();
        }


        return getUser;
    }
}

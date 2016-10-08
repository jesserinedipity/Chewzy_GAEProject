package com.chewzy.controller;


import com.chewzy.HashPassword;
import com.chewzy.model.User;
import com.chewzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Misa on 9/15/2016.
 */
@RestController
@RequestMapping(value="/api")
public class ChewzyWebServicesController {

    @Autowired
    UserService userSrvc;


    @Autowired
    private HttpServletRequest request;

//    @RequestMapping(value="/getUsers",  method = RequestMethod.GET)
//    public ResponseEntity<List<User>> getUsers(){
//        String allUsersJson="";
//
//        List<User> userList = userSrvc.getAllUsers();
//        Gson gson = new Gson();
//        allUsersJson = gson.toJson(userList);
//
//        if(userList.isEmpty()){
//            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
//        System.out.println("Fetching User with id " + id);
//        String userJson="";
//        User user = userSrvc.getUserbyId(id);
//        if(user==null){
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        Gson gson = new Gson();
//        userJson = gson.toJson(user);
//
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder){
        System.out.println("Creating User " + user.getFirstname());

        Date date = new Date();
        //GeocodingModel geocode = null;

        String firstname = request.getParameter("firstname");
        System.out.println(firstname);
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String contact_number = request.getParameter("contact_number");
        String username = request.getParameter("username");
        String address = request.getParameter("location");
        String datecreated = date.toString();
        String birthdate = request.getParameter("birthdate");
        String password = userSrvc.checkPW(HashPassword.MD5conversion(request.getParameter("password")), HashPassword.MD5conversion(request.getParameter("confirmpass")));
        Long badge_id = Long.parseLong("5840605766746112"); //For Newbie badge_id

        double latitude = Double.parseDouble(request.getParameter("latitude"));
        double longitude = Double.parseDouble(request.getParameter("longitude"));

        User adduser = new User(firstname, lastname, gender, email, contact_number, username, password, datecreated, address, 0, badge_id, latitude, longitude, true, birthdate);

        if(userSrvc.checkIfexist(user)){
            System.out.println("A User with username " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        userSrvc.addUser(adduser);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getUser_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}

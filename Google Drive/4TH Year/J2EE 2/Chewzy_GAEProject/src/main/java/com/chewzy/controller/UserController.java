package com.chewzy.controller;

import com.chewzy.HashPassword;
import com.chewzy.model.User;
import com.chewzy.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created by Misaw on 9/14/2016.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userSrvc;

    @Autowired
    HomeController homeController;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView login(User user, ModelMap modelMap, HttpServletResponse response) {
        HttpSession session = null;
        Gson gson = new Gson();
        ModelAndView mav = new ModelAndView("home");
        RestTemplate restTemplate = new RestTemplate();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hashPw = HashPassword.MD5conversion(password);
        System.out.println(username + " " + hashPw);

        User fetchedLogin = null;
        if ((fetchedLogin = userSrvc.login(username,hashPw)) != null) {
            session = request.getSession();
            session.setAttribute("user", fetchedLogin);
            String loginJson = gson.toJson(fetchedLogin);
            String fname = fetchedLogin.getFirstname();
            String lname = fetchedLogin.getLastname();
            fetchedLogin.setFirstname(fname.toUpperCase());
            fetchedLogin.setLastname(lname.toUpperCase());
            mav.addObject("user", fetchedLogin);
            return mav;
        } else {
            return new ModelAndView("index");
        }

    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        User adduser = null;
        Date date = new Date();
        //GeocodingModel geocode = null;

        String firstname = request.getParameter("firstname");
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

        adduser = new User(firstname, lastname, gender, email, contact_number, username, password, datecreated, address, 0, badge_id, latitude, longitude, true, birthdate);

        if (userSrvc.checkIfexist(adduser)) {
            System.out.println("A User with username " + adduser.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
            //return new ModelAndView("signUp", BindingResult.MODEL_KEY_PREFIX + "user", adduser);
        }

//        Gson gson = new Gson();
//        String adduserJson = gson.toJson(adduser);
//        System.out.println(adduserJson);

        userSrvc.addUser(adduser);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("user/api/getUser/{id}").buildAndExpand(adduser.getUser_id()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        //return new ModelAndView("index", BindingResult.MODEL_KEY_PREFIX + "user", headers);

    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout() {
        try {
            HttpSession session = request.getSession();

            session.invalidate();
            System.out.println("Logged out");

        } catch (Exception e) {
            System.out.println(e);
        }
        return new ModelAndView(homeController.index());
    }

    @RequestMapping(value="/profile")
    @Scope("session")
    public ModelAndView profile(){
        ModelAndView mav = new ModelAndView("userProfile");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        mav.addObject("user", user);
        return mav;
    }

//    @RequestMapping(value = "/welcome",
//            method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public MessageResponse welcome(@RequestBody Message message) {
//        System.out.println("Request received coming from :" + message.getMessage());
//        MessageResponse mr = new MessageResponse();
//        Message newMessage = new Message();
//        newMessage.setFlag(true);
//        newMessage.setMessage("Hello from the web service:" + message.getMessage());
//        mr.setMessage(newMessage);
//        return mr;
//    }

    @RequestMapping(value = "/api/getUsers", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        String allUsersJson = "";

        List<User> userList = userSrvc.getAllUsers();
        Gson gson = new Gson();
        allUsersJson = gson.toJson(userList);

        if (userList.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws  ServletException, IOException {

// [START example]
        URL url = new URL("https://chewzy-142101.appspot.com/user/api/getUsers");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer json = new StringBuffer();
        String line;

        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        System.out.println(json);
        reader.close();
// [END example]
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @RequestMapping(value = "/api/getUser/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("user_id") String user_id) {
        System.out.println("Fetching User with id " + user_id);
        String userJson = "";
        User user = userSrvc.getUserbyId(Long.parseLong(user_id));
        if (user == null) {
            System.out.println("User with id " + user_id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        Gson gson = new Gson();
        userJson = gson.toJson(user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}

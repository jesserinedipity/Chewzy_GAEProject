package com.chewzy.controller;

import com.chewzy.model.Foodtrip;
import com.chewzy.model.FoodtripList;
import com.chewzy.model.Transaction;
import com.chewzy.model.User;
import com.chewzy.service.DishService;
import com.chewzy.service.FoodtripService;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.repackaged.com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Misa on 10/10/2016.
 */
@RestController
@RequestMapping(value = "/foodtrip")
public class FoodtripController {
    @Autowired
    FoodtripService foodtripSrvc;

    @Autowired
    DishService dishSrvc;

    @Autowired
    private HttpServletRequest request;



    @RequestMapping(value="/api/getFoodtrips",  method = RequestMethod.GET)
    public ResponseEntity<List<Foodtrip>> getFoodtrips(){
        String addTransactionJson="";

        List<Foodtrip> transactionList = foodtripSrvc.getFoodtrips();
        Gson gson = new Gson();
        addTransactionJson = gson.toJson(transactionList);

        if(transactionList.isEmpty()){
            return new ResponseEntity<List<Foodtrip>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Foodtrip>>(transactionList, HttpStatus.OK);
    }

    @RequestMapping(value ="/foodtrips", method= RequestMethod.GET)
    @Scope("session")
    public ModelAndView showfoodtrips(){
        ModelAndView mav = new ModelAndView("userProfile");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        mav.addObject("user", user);

        List<Foodtrip> foodtrips = foodtripSrvc.getFoodtripbyUser(user.getUser_id());
        FoodtripList foodtripList = new FoodtripList();
        foodtripList.setFoodtrips(foodtrips);
        mav.addObject("foodtripList", foodtripList);
        return mav;
    }

    @RequestMapping(value="/addfoodtrip", method = RequestMethod.POST)
    @Scope("session")
    public ModelAndView addFoodtrip(@RequestBody Foodtrip foodtrip, UriComponentsBuilder uriComponentsBuilder) {
        ModelAndView mav = new ModelAndView("userProfile");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Transaction transaction = (Transaction)session.getAttribute("transaction");

        //Foodtrip(String date, Long transaction_id, Long user_id, Long business_id, Text review_content, float ambiance_rating, float food_rating, float cost_rating, float service_rating, float hygiene_rating, boolean isActive) {

        String foodtripcontent = request.getParameter("foodtripContent");
        Text foodtripText = new Text(foodtripcontent);
        Foodtrip newFoodtrip = new Foodtrip(transaction.getTransaction_date(), transaction.getTransaction_id(), user.getUser_id(), transaction.getBusiness_id(), foodtripText, 5,5,5,5,5, true);
        foodtripSrvc.addFoodtrip(newFoodtrip);
        return mav;
    }
}

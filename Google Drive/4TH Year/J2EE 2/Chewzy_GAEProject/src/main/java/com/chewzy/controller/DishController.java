package com.chewzy.controller;

import com.chewzy.model.Dish;
import com.chewzy.service.DishService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Misa on 9/28/2016.
 */
@RestController
@RequestMapping(value = "/dish")
public class DishController {

    @Autowired
    DishService dishSrvc;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/api/getDishes",  method = RequestMethod.GET)
    public ResponseEntity<List<Dish>> getDishes(){
        String allDishJson="";

        List<Dish> dishList = dishSrvc.getDishes();
        Gson gson = new Gson();
        allDishJson = gson.toJson(dishList);

        if(dishList.isEmpty()){
            return new ResponseEntity<List<Dish>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Dish>>(dishList, HttpStatus.OK);
    }

    @RequestMapping(value="api/getDish/{dish_id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> getUser(@PathVariable("dish_id") Long dish_id){
        System.out.println("Fetching Dish with id " + dish_id);
        String dishJson="";
        Dish dish = dishSrvc.getDishbyId(dish_id);
        if(dish==null){
            System.out.println("Dish with id " + dish_id + " not found");
            return new ResponseEntity<Dish>(HttpStatus.NOT_FOUND);
        }
        Gson gson = new Gson();
        dishJson = gson.toJson(dish);

        return new ResponseEntity<Dish>(dish, HttpStatus.OK);
    }

    //get by restaurant (business_id)
    @RequestMapping(value="api/getDishbyRes/{business_id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dish>> getDishbyRes(@PathVariable("business_id") Long business_id){
        List<Dish> dishListbyRes = dishSrvc.getDishbyResId(business_id);
        if(dishListbyRes.isEmpty()){
            return new ResponseEntity<List<Dish>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Dish>>(dishListbyRes, HttpStatus.OK);
    }


    //get by cuisine type (cuisine_id)
    @RequestMapping(value="api/getDishbyCuisine/{cuisine_id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dish>> getDishbyCuisine(@PathVariable("cuisine_id") Long cuisine_id){
        List<Dish> dishListbyCuisine = dishSrvc.getDishbyCuiId(cuisine_id);
        if(dishListbyCuisine.isEmpty()){
            return new ResponseEntity<List<Dish>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Dish>>(dishListbyCuisine, HttpStatus.OK);
    }

    //get by dish category (dishcat_id)
    @RequestMapping(value="api/getDishbyCategory/{dishCatid}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dish>> getDishbyCategory(@PathVariable("dishCatid") Long dishCatid){
        List<Dish> dishListbyCategory = dishSrvc.getDishbyCatId(dishCatid);
        if(dishListbyCategory.isEmpty()){
            return new ResponseEntity<List<Dish>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Dish>>(dishListbyCategory, HttpStatus.OK);
    }
}

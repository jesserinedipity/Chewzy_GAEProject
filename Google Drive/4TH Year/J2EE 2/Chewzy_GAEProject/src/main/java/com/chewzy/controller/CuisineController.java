package com.chewzy.controller;

import com.chewzy.model.Cuisine;
import com.chewzy.service.CuisineService;
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
@RequestMapping(value="/cuisine")
public class CuisineController {

    @Autowired
    CuisineService cuisineSrvc;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/api/getCuisines",  method = RequestMethod.GET)
    public ResponseEntity<List<Cuisine>> getCuisines(){
        String allCuisinesJson="";

        List<Cuisine> cuisineList = cuisineSrvc.getAllCuisines();
        Gson gson = new Gson();
        allCuisinesJson = gson.toJson(cuisineList);

        if(cuisineList.isEmpty()){
            return new ResponseEntity<List<Cuisine>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cuisine>>(cuisineList, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/getCuisine/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cuisine> getCuisine(@PathVariable("id") Long id){
        System.out.println("Fetching Cuisine with id " + id);
        String cuisineJson="";
        Cuisine cuisine = cuisineSrvc.getCuisinebyId(id);
        if(cuisine==null){
            System.out.println("Cuisine with id " + id + " not found");
            return new ResponseEntity<Cuisine>(HttpStatus.NOT_FOUND);
        }
        Gson gson = new Gson();
        cuisineJson = gson.toJson(cuisine);

        return new ResponseEntity<Cuisine>(cuisine, HttpStatus.OK);
    }
}

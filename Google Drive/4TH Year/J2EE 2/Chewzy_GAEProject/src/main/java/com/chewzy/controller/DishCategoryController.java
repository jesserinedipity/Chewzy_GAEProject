package com.chewzy.controller;

import com.chewzy.model.DishCategory;
import com.chewzy.service.DishCategoryService;
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
 * Created by Misa on 9/18/2016.
 */
@RestController
@RequestMapping(value="dishcategory")
public class DishCategoryController {

    @Autowired
    DishCategoryService dishCategorySrvc;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/api/getDishCategories",  method = RequestMethod.GET)
    public ResponseEntity<List<DishCategory>> getDishCategories(){
        String addDishCatJson="";

        List<DishCategory> dishCatList = dishCategorySrvc.getAllDishCategory();
        Gson gson = new Gson();
        addDishCatJson = gson.toJson(dishCatList);

        if(dishCatList.isEmpty()){
            return new ResponseEntity<List<DishCategory>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DishCategory>>(dishCatList, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/getDishCategory/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DishCategory> getDishCategory(@PathVariable("id") Long id){
        System.out.println("Fetching DishCategory with id " + id);
        String dishCatJson="";
        DishCategory dishCategory = dishCategorySrvc.getDishCatbyId(id);
        if(dishCategory==null){
            System.out.println("DishCategory with id " + id + " not found");
            return new ResponseEntity<DishCategory>(HttpStatus.NOT_FOUND);
        }
        Gson gson = new Gson();
        dishCatJson = gson.toJson(dishCategory);

        return new ResponseEntity<DishCategory>(dishCategory, HttpStatus.OK);
    }
}

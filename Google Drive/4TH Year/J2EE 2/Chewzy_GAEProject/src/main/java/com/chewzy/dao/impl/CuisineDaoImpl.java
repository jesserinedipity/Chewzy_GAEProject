package com.chewzy.dao.impl;

import com.chewzy.dao.CuisineDao;
import com.chewzy.model.Cuisine;
import com.googlecode.objectify.ObjectifyService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
@Repository("cuisineDao")
public class CuisineDaoImpl implements CuisineDao {

    public List<Cuisine> getAllCuisines(){
        List<Cuisine> cuisineList = ObjectifyService.ofy().load().type(Cuisine.class).list();
        return cuisineList;
    }

    public Cuisine getCuisinebyId(Long cuisineId){
        Cuisine cuisine = ObjectifyService.ofy().load().type(Cuisine.class).id(cuisineId).now();
        return cuisine;
    }

    public void addCuisine(Cuisine cuisine){
        ObjectifyService.ofy().save().entity(cuisine).now();
    }

}

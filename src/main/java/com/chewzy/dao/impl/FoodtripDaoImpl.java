package com.chewzy.dao.impl;

import com.chewzy.dao.FoodtripDao;
import com.chewzy.model.Foodtrip;
import com.googlecode.objectify.ObjectifyService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Misa on 10/10/2016.
 */

@Repository("foodtripDao")
public class FoodtripDaoImpl implements FoodtripDao{
    public List<Foodtrip> getFoodtrips(){
        List<Foodtrip> foodtripList = ObjectifyService.ofy().load().type(Foodtrip.class).list();

        return foodtripList;
    }

    public Foodtrip getUserbyId(Long id){
        Foodtrip foodtrip = ObjectifyService.ofy().load().type(Foodtrip.class).id(id).now();

        return foodtrip;
    }

    public void addFoodtrip (Foodtrip foodtrip){
        ObjectifyService.ofy().save().entity(foodtrip).now();
    }
}

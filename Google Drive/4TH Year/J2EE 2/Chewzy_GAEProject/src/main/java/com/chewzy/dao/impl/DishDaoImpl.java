package com.chewzy.dao.impl;

import com.chewzy.dao.DishDao;
import com.chewzy.model.Dish;
import com.googlecode.objectify.ObjectifyService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Misa on 9/28/2016.
 */
@Repository("dishDao")
public class DishDaoImpl implements DishDao {

    public List<Dish> getAllDishes(){
        List<Dish> dishList = ObjectifyService.ofy().load().type(Dish.class).list();

        return dishList;
    }

    public Dish getDishbyId(Long dishId){
        Dish dish = ObjectifyService.ofy().load().type(Dish.class).id(dishId).now();

        return dish;
    }
}

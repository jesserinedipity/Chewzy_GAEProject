package com.chewzy.dao;

import com.chewzy.model.Dish;

import java.util.List;

/**
 * Created by Misa on 9/28/2016.
 */
public interface DishDao {
    public List<Dish> getAllDishes() throws Exception;
    public Dish getDishbyId(Long dishId) throws Exception;

}

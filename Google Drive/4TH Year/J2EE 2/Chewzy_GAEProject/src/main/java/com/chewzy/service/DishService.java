package com.chewzy.service;

import com.chewzy.model.Dish;

import java.util.List;

/**
 * Created by Misa on 9/28/2016.
 */
public interface DishService {
    public List<Dish> getDishes();
    public Dish getDishbyId(Long dishId);
    public List<Dish> getDishbyResId(Long businessId);
    public List<Dish> getDishbyCuiId(Long cuisineId);
    public List<Dish> getDishbyCatId(Long dishCategoryId);
}

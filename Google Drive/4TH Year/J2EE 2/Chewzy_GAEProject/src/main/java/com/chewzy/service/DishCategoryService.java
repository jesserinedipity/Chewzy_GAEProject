package com.chewzy.service;

import com.chewzy.model.DishCategory;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
public interface DishCategoryService {
    public List<DishCategory> getAllDishCategory();
    public DishCategory getDishCatbyId(Long dishCatId);
}

package com.chewzy.dao;

import com.chewzy.model.DishCategory;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
public interface DishCategoryDao {
    public List<DishCategory> getAllDishcategory() throws Exception;
    public DishCategory getDishCatbyId(Long dishCatid) throws Exception;
    public void addDishCategory (DishCategory dishCategory) throws Exception;
}

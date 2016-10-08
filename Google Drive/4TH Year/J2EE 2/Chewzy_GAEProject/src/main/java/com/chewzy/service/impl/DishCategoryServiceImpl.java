package com.chewzy.service.impl;

import com.chewzy.dao.DishCategoryDao;
import com.chewzy.model.DishCategory;
import com.chewzy.service.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
@Component("dishCategorySrvc")
public class DishCategoryServiceImpl implements DishCategoryService{

    @Autowired
    DishCategoryDao dishCategoryDao;

    public List<DishCategory> getAllDishCategory(){
        List<DishCategory> dishCategoryList = null;

        try {
            dishCategoryList = dishCategoryDao.getAllDishcategory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dishCategoryList;
    }

    public DishCategory getDishCatbyId(Long dishCatId){
        DishCategory dishCategory = null;

        try {
            dishCategory = dishCategoryDao.getDishCatbyId(dishCatId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dishCategory;
    }
}

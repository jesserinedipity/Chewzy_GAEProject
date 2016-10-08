package com.chewzy.dao.impl;

import com.chewzy.dao.DishCategoryDao;
import com.chewzy.model.DishCategory;
import com.googlecode.objectify.ObjectifyService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
@Repository("dishCategoryDao")
public class DishCategoryDaoImpl implements DishCategoryDao {

    public List<DishCategory> getAllDishcategory(){
        List<DishCategory> dishCategoryList = ObjectifyService.ofy().load().type(DishCategory.class).list();

        return dishCategoryList;
    }
    public DishCategory getDishCatbyId(Long dishCatid) {
        DishCategory dishCategory = ObjectifyService.ofy().load().type(DishCategory.class).id(dishCatid).now();

        return dishCategory;
    }

    public void addDishCategory (DishCategory dishCategory){
        ObjectifyService.ofy().save().entity(dishCategory).now();
    }
}

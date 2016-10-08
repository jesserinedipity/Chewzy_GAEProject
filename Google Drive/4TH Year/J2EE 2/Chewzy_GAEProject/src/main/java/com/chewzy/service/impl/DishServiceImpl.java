package com.chewzy.service.impl;

import com.chewzy.dao.DishDao;
import com.chewzy.model.Dish;
import com.chewzy.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Misa on 9/28/2016.
 */
@Component("dishSrvc")
public class DishServiceImpl implements DishService {

    @Autowired
    private DishDao dishDao;

    public List<Dish> getDishes(){
        List<Dish> dishList = null;
        try {
            dishList = dishDao.getAllDishes();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dishList;
    }

    public Dish getDishbyId(Long dishId){
        Dish getDish = null;
        System.out.println(dishId);
        try {
            getDish = dishDao.getDishbyId(dishId);
            System.out.println(getDish);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getDish;
    }

    public List<Dish> getDishbyResId(Long businessId){
        List<Dish> dishList = DishServiceImpl.this.getDishes();
        List<Dish> dishListbyRes = null; //List of a certain restaurant menu
        int loop;
        try{
           for(loop=0; loop<dishList.size(); loop++){
               if(dishList.get(loop).getBusiness_id()==businessId){
                   dishListbyRes.add(dishList.get(loop));
                   System.out.println(dishListbyRes.get(loop).getDish_name());
               }
           }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return dishListbyRes;
    }


    public List<Dish> getDishbyCuiId(Long cuisineId){
        List<Dish> dishList = this.getDishes();
        List<Dish> dishListbyCuisine = null; //List dishes based on cuisine
        int loop;
        try{
            for(loop=0; loop<dishList.size(); loop++){
                if(dishList.get(loop).getCuisine_id()==cuisineId){
                    dishListbyCuisine.add(dishList.get(loop));
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return dishListbyCuisine;
    }

    public List<Dish> getDishbyCatId(Long dishCategoryId){
        List<Dish> dishList = this.getDishes();
        List<Dish> dishListbyCategory = null; //List of dishes based on dish category
        int loop;
        try{
            for(loop=0; loop<dishList.size(); loop++){
                if(dishList.get(loop).getCategory_id()==dishCategoryId){
                    dishListbyCategory.add(dishList.get(loop));
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return dishListbyCategory;
    }

}

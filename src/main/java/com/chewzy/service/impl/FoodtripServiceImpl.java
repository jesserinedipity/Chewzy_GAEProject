package com.chewzy.service.impl;

import com.chewzy.dao.FoodtripDao;
import com.chewzy.model.Foodtrip;
import com.chewzy.service.FoodtripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Misa on 10/10/2016.
 */
@Component("foodtripSrvc")
public class FoodtripServiceImpl implements FoodtripService {
    @Autowired
    private FoodtripDao foodtripDao;

    public List<Foodtrip> getFoodtrips(){
        List<Foodtrip> foodtripList = null;
        try {
            foodtripList = foodtripDao.getFoodtrips();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foodtripList;
    }

    public List<Foodtrip> getFoodtripbyUser(Long user_id){
        List<Foodtrip> foodtripList = null;
        List<Foodtrip> userfoodtrips = null;
        try {
            foodtripList = foodtripDao.getFoodtrips();
            for(int a=0; a<foodtripList.size(); a++){
                if(foodtripList.get(a).getUser_id()==user_id){
                    userfoodtrips.add(foodtripList.get(a));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userfoodtrips;
    }

    public boolean addFoodtrip(Foodtrip foodtrip){
        boolean error=false;
        try {
            foodtripDao.addFoodtrip(foodtrip);
            error=true; //successfully added
        } catch (Exception e) {
            error=false; //fail to add
            e.printStackTrace();
        }
        return error;
    }
}

package com.chewzy.service.impl;

import com.chewzy.dao.CuisineDao;
import com.chewzy.model.Cuisine;
import com.chewzy.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
@Component("cuisineSrvc")
public class CuisineServiceImpl implements CuisineService {

    @Autowired
    CuisineDao cuisineDao;

    public List<Cuisine> getAllCuisines(){
        List<Cuisine> cuisineList=null;

        try {
            cuisineList=cuisineDao.getAllCuisines();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cuisineList;
    }

    public Cuisine getCuisinebyId(Long cuisineId){
        Cuisine cuisine = null;

        try {
            cuisine = cuisineDao.getCuisinebyId(cuisineId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cuisine;
    }
}

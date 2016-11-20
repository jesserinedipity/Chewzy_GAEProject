package com.chewzy.dao;

import com.chewzy.model.Foodtrip;

import java.util.List;

/**
 * Created by Misa on 10/10/2016.
 */
public interface FoodtripDao {
    public List<Foodtrip> getFoodtrips() throws Exception;
    public Foodtrip getUserbyId(Long id) throws Exception;
    public void addFoodtrip (Foodtrip foodtrip) throws Exception;
}

package com.chewzy.service;

import com.chewzy.model.Foodtrip;

import java.util.List;

/**
 * Created by Misa on 10/10/2016.
 */
public interface FoodtripService {
    public List<Foodtrip> getFoodtrips();
    public List<Foodtrip> getFoodtripbyUser(Long user_id);
    public boolean addFoodtrip(Foodtrip foodtrip);
}

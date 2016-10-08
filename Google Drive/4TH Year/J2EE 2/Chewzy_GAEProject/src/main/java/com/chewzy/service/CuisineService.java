package com.chewzy.service;

import com.chewzy.model.Cuisine;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
public interface CuisineService {
    public List<Cuisine> getAllCuisines();
    public Cuisine getCuisinebyId(Long cuisineId);
}

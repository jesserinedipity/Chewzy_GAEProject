package com.chewzy.dao;

import com.chewzy.model.Cuisine;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
public interface CuisineDao {
    public List<Cuisine> getAllCuisines() throws Exception;
    public Cuisine getCuisinebyId(Long cuisineId) throws Exception;
    public void addCuisine(Cuisine cuisine) throws Exception;
}

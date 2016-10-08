package com.chewzy.service;

import com.chewzy.model.Business;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
public interface BusinessService {
    public List<Business> getAllBusiness();
    public Business getBusinessbyId(Long businessId);
    public Business getBusiness(String searchedKey);
}

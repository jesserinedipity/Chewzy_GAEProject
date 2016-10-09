package com.chewzy.dao;

import com.chewzy.model.Business;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
public interface BusinessDao {

    public List<Business> getAllBusiness() throws Exception;
    public Business getBusinessbyId(Long businessId) throws Exception;
    public void addBusiness (Business business) throws Exception;
    public void updateBusiness(Business business) throws Exception;
    public void deleteBusiness(Business business) throws Exception;
}

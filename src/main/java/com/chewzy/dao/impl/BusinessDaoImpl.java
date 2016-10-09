package com.chewzy.dao.impl;

import com.chewzy.dao.BusinessDao;
import com.chewzy.model.Business;
import com.googlecode.objectify.ObjectifyService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
@Repository("businessDao")
public class BusinessDaoImpl implements BusinessDao {


    public List<Business> getAllBusiness(){
        List<Business> businessList = ObjectifyService.ofy().load().type(Business.class).list();

        return businessList;
    }

    public Business getBusinessbyId(Long businessId){
        Business business = ObjectifyService.ofy().load().type(Business.class).id(businessId).now();

        return business;
    }

    public void addBusiness (Business business){

        ObjectifyService.ofy().save().entity(business).now();
    }

    //Still not working
    public void updateBusiness(Business business){
        ObjectifyService.ofy().load().type(Business.class).id(business.getBusiness_id()).now();
    }

    public void deleteBusiness(Business business){
        ObjectifyService.ofy().load().type(Business.class).id(business.getBusiness_id()).now();

    }
}

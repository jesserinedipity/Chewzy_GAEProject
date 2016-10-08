package com.chewzy.service.impl;

import com.chewzy.dao.BusinessDao;
import com.chewzy.model.Business;
import com.chewzy.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Misa on 9/18/2016.
 */
@Component("businessSrvc")
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessDao businessDao;

    public List<Business> getAllBusiness(){
        List<Business> businessList = null;

        try {
            businessList=businessDao.getAllBusiness();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return businessList;
    }

    public Business getBusinessbyId(Long businessId){
        Business business = null;

        try {
            business=businessDao.getBusinessbyId(businessId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return business;
    }

    public Business getBusiness(String searchedKey){
        Business business = null;
        List<Business> businessList = BusinessServiceImpl.this.getAllBusiness();
        for(int loop=0; loop<businessList.size(); loop++){
            if(businessList.get(loop).getBusiness_name().equalsIgnoreCase(searchedKey)){
                System.out.println(businessList.get(loop).getBusiness_name());
                business = businessList.get(loop);
            }
        }
        return business;
    }
}

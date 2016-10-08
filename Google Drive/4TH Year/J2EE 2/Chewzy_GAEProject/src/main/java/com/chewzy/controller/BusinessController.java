package com.chewzy.controller;

import com.chewzy.model.Business;
import com.chewzy.model.Dish;
import com.chewzy.model.DishForm;
import com.chewzy.model.User;
import com.chewzy.service.BusinessService;
import com.chewzy.service.DishService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Misa on 9/28/2016.
 */
@RestController
@RequestMapping(value="/business")
public class BusinessController {

    @Autowired
    BusinessService businessSrvc;

    @Autowired
    DishService dishSrvc;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value ="/search", method= RequestMethod.POST)
    @Scope("session")
    public ModelAndView searchrestaurant(){
        ModelAndView mav = new ModelAndView("restaurantindex");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        mav.addObject("user", user);

        String search = request.getParameter("searchedKey");
        Business business = businessSrvc.getBusiness(search);
        mav.addObject("business", business);

        System.out.println(business.getBusiness_id()+" "+business.getBusiness_name());
        List<Dish> dishList = dishSrvc.getDishbyResId(business.getBusiness_id());
        DishForm dishForm = new DishForm();
        dishForm.setDishes(dishList);
        for(int a=0; a<dishList.size(); a++){
            System.out.println(dishList.get(a).getDish_name()+" "+dishList.get(a).getBase_price());
        }
        mav.addObject("dishForm", dishForm);
        return mav;
    }

    @RequestMapping(value="/api/getBusinesses",  method = RequestMethod.GET)
    public ResponseEntity<List<Business>> getBusinesses(){
        String allBusinessJson="";

        List<Business> businessList = businessSrvc.getAllBusiness();
        Gson gson = new Gson();
        allBusinessJson = gson.toJson(businessList);

        if(businessList.isEmpty()){
            return new ResponseEntity<List<Business>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Business>>(businessList, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/getBusiness/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Business> getBusiness(@PathVariable("id") Long id){
        System.out.println("Fetching Business with id " + id);
        String businessJson="";
        Business business = businessSrvc.getBusinessbyId(id);
        if(business==null){
            System.out.println("Business with id " + id + " not found");
            return new ResponseEntity<Business>(HttpStatus.NOT_FOUND);
        }
        Gson gson = new Gson();
        businessJson = gson.toJson(business);

        return new ResponseEntity<Business>(business, HttpStatus.OK);
    }


}

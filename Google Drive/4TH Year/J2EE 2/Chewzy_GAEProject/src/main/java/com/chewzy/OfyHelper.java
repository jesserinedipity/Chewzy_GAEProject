package com.chewzy;

import com.chewzy.model.*;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Misa on 9/10/2016.
 */
public class OfyHelper implements ServletContextListener{
    public static void register() {
        //Insert model to create entity
        ObjectifyService.register(User.class);
        ObjectifyService.register(Badge.class);
        ObjectifyService.register(Business.class);
        ObjectifyService.register(BusinessCuisine.class);
        ObjectifyService.register(Cuisine.class);
        ObjectifyService.register(Dish.class);
        ObjectifyService.register(DishCategory.class);
        ObjectifyService.register(Foodtrip.class);
        ObjectifyService.register(Transaction.class);
        ObjectifyService.register(TransactionDetails.class);
        ObjectifyService.register(User.class);

    }

    public void contextInitialized(ServletContextEvent event) {
        // This will be invoked as part of a warmup request, or the first user
        // request if no warmup request was invoked.
        register();
    }

    public void contextDestroyed(ServletContextEvent event) {
        // App Engine does not currently invoke this method.
    }
}

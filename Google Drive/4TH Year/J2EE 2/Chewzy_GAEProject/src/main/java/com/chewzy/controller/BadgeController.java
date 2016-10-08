package com.chewzy.controller;

import com.chewzy.model.Badge;
import com.chewzy.service.BadgeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Misa on 9/14/2016.
 */

@Controller
@RequestMapping(value = "/badge")
public class BadgeController {

    @Autowired
    BadgeService badgeSrvc;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/api/getBadges",  method = RequestMethod.GET)
    public ResponseEntity<List<Badge>> getBadges(){
        String allBadgeJson="";

        List<Badge> badgeList = badgeSrvc.getAllBadges();
        Gson gson = new Gson();
        allBadgeJson = gson.toJson(badgeList);

        if(badgeList.isEmpty()){
            return new ResponseEntity<List<Badge>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Badge>>(badgeList, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/getBadge/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Badge> getBadge(@PathVariable("id") Long id){
        System.out.println("Fetching Badge with id " + id);
        String badgeJson="";
        Badge badge = badgeSrvc.getBadgebyId(id);
        if(badge==null){
            System.out.println("Business with id " + id + " not found");
            return new ResponseEntity<Badge>(HttpStatus.NOT_FOUND);
        }
        Gson gson = new Gson();
        badgeJson = gson.toJson(badge);

        return new ResponseEntity<Badge>(badge, HttpStatus.OK);
    }

}

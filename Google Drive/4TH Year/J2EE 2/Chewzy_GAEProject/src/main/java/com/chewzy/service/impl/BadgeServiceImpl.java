package com.chewzy.service.impl;

import com.chewzy.dao.BadgeDao;
import com.chewzy.model.Badge;
import com.chewzy.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Misa on 9/14/2016.
 */
@Component("badgeSrvc")
public class BadgeServiceImpl implements BadgeService {

    @Autowired
    private BadgeDao badgeDao;


    public List<Badge> getAllBadges(){
        List<Badge> badgeList = null;

        try {
            badgeList=badgeDao.getAllBadges();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return badgeList;
    }

    public Badge getBadgebyId(Long badgeId){
        Badge badge = null;

        try {
            badge=badgeDao.getBadgebyId(badgeId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return badge;
    }
}

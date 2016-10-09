package com.chewzy.dao.impl;

import com.chewzy.dao.BadgeDao;
import com.chewzy.model.Badge;
import com.chewzy.model.DishCategory;
import com.googlecode.objectify.ObjectifyService;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by Misa on 9/14/2016.
 */
@Repository("badgeDao")
public class BadgeDaoImpl implements BadgeDao {

    public List<Badge> getAllBadges(){
        List<Badge> badges = ofy().load().type(Badge.class).list();
//        for (Badge badge_l : badges) {
//            System.out.println(badge_l.getBadge_id()+" "+badge_l.getBadge_name()+" "+badge_l.getReview_count_min()+" "+badge_l.getReview_count_max());
//        }

        return badges;
    }


    public Badge getBadgebyId(Long badgeId){
        Badge badge = ObjectifyService.ofy().load().type(Badge.class).id(badgeId).now();

        return badge;
    }

    public void addBadge (Badge badge){

        ObjectifyService.ofy().save().entity(badge).now();
    }

    //Still not working
    public void updateBadge(Badge badge){
        ObjectifyService.ofy().load().type(Badge.class).id(badge.getBadge_id()).now();
    }

    public void deleteBadge(Badge badge){
        ObjectifyService.ofy().load().type(Badge.class).id(badge.getBadge_id()).now();

    }
}

package com.chewzy.dao.impl;

import com.chewzy.dao.BadgeDao;
import com.chewzy.model.Badge;
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


}

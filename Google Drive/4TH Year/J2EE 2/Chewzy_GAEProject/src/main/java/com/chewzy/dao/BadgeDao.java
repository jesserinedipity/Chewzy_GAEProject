package com.chewzy.dao;

import com.chewzy.model.Badge;

import java.util.List;

/**
 * Created by Misa on 9/14/2016.
 */
public interface BadgeDao {
    public List<Badge> getAllBadges() throws Exception;
    public Badge getBadgebyId(Long badgeId) throws Exception;
}

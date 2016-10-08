package com.chewzy.service;

import com.chewzy.model.Badge;

import java.util.List;

/**
 * Created by Misa on 9/14/2016.
 */
public interface BadgeService {
    public List<Badge> getAllBadges();
    public Badge getBadgebyId(Long badgeId);
}

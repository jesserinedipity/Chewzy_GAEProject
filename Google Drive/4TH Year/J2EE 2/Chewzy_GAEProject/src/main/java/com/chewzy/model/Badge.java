package com.chewzy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Misa on 9/10/2016.
 */

@Entity
public class Badge {
    @Id
    private Long badge_id;
    @Index
    private String badge_name;
    @Index
    private int review_count_min;
    @Index
    private int review_count_max;
    @Index
    private boolean isActive;

    public Badge(){}

    public Badge(String badge_name, int review_count_min, int review_count_max, boolean isActive) {
        this.badge_name = badge_name;
        this.review_count_min = review_count_min;
        this.review_count_max = review_count_max;
        this.isActive = isActive;
    }

    public Long getBadge_id() {
        return badge_id;
    }

    public void setBadge_id(Long badge_id) {
        this.badge_id = badge_id;
    }

    public String getBadge_name() {
        return badge_name;
    }

    public void setBadge_name(String badge_name) {
        this.badge_name = badge_name;
    }

    public int getReview_count_min() {
        return review_count_min;
    }

    public void setReview_count_min(int review_count_min) {
        this.review_count_min = review_count_min;
    }

    public int getReview_count_max() {
        return review_count_max;
    }

    public void setReview_count_max(int review_count_max) {
        this.review_count_max = review_count_max;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

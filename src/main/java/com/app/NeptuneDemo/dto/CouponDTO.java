package com.app.NeptuneDemo.dto;

import com.app.NeptuneDemo.model.Event;

import com.app.NeptuneDemo.model.Category;

public class CouponDTO {
    private long couponId;
    private String couponName;
    private double couponDiscount;
    private Long categoryId;
    private Long eventId;

    public CouponDTO() {
        super();
    }

    public CouponDTO(long couponId, String couponName, double couponDiscount, Long categoryId, Long eventId) {
        super();
        this.couponId = couponId;
        this.couponName = couponName;
        this.couponDiscount = couponDiscount;
        this.categoryId = categoryId;
        this.eventId = eventId;
    }

    public long getCouponId() {
        return this.couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return this.couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public double getCouponDiscount() {
        return this.couponDiscount;
    }

    public void setCouponDiscount(double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

}

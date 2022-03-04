package com.app.NeptuneDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupons")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "coupon_id")
	private Long couponId;
	@Column(name = "coupon_name", nullable = false)
	private String couponName;

	public Coupon() {
	}

	public Coupon(Long couponId, String couponName) {
		this.couponId = couponId;
		this.couponName = couponName;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long categoryId) {
		this.couponId = couponId;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

}


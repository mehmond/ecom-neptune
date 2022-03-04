package com.app.NeptuneDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.NeptuneDemo.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    
}

package com.app.NeptuneDemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.NeptuneDemo.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    public Coupon findByCouponName(Optional<String> couponName);
}

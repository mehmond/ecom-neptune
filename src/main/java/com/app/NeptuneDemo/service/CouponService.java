package com.app.NeptuneDemo.service;

import java.util.List;
import java.util.Optional;

import com.app.NeptuneDemo.model.Coupon;
import com.app.NeptuneDemo.repository.CouponRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepo;

    public List<Coupon> index() {
        return (List<Coupon>) couponRepo.findAll();
    }

    public void save(com.app.NeptuneDemo.model.Coupon coupon) {
    	couponRepo.save(coupon);
    }

    public com.app.NeptuneDemo.model.Coupon show(Long id) {
        Optional<Coupon> optional = couponRepo.findById(id);
        Coupon coupon = null;
        if (optional.isPresent()) {
        	coupon = optional.get();
        } else {
            throw new RuntimeException("Coupon not found for id : : " + id);
        }
        return coupon;
    }

    public void delete(Long id) {
    	couponRepo.deleteById(id);
    }
}

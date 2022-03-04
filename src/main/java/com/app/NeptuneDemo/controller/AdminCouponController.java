package com.app.NeptuneDemo.controller;

import com.app.NeptuneDemo.dto.CouponDTO;
import com.app.NeptuneDemo.model.Coupon;
import com.app.NeptuneDemo.service.CategoryService;
import com.app.NeptuneDemo.service.CouponService;
import com.app.NeptuneDemo.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminCouponController {

    @Autowired
    private CouponService couponService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private EventService eventService;

    @GetMapping("/admin/manage-coupon")
    public String index(Model model) {
        model.addAttribute("coupon", couponService.index());
        return "adminCoupon";
    }

    @GetMapping("/admin/insert-coupon")
    public String insert(Model model) {
        model.addAttribute("coupon", new CouponDTO());
        model.addAttribute("categories", categoryService.index());
        model.addAttribute("event", eventService.index());
        return "admin_form_coupon";
    }

    @PostMapping("/admin/save-coupon")
    public String save(Coupon coupon) {
        couponService.save(coupon);
        return "redirect:/admin/manage-coupon";
    }

    @GetMapping("/admin/edit-coupon/{id}")
    public String update(@PathVariable(value = "id") Long id, Model model) {
        Coupon coupon = couponService.show(id);
        CouponDTO couponDTO = new CouponDTO();
        couponDTO.setCouponId(coupon.getCouponId());
        couponDTO.setCouponName(coupon.getCouponName());
        couponDTO.setCouponDiscount(coupon.getCouponDiscount());
        model.addAttribute("coupon", couponDTO);
        model.addAttribute("categories", categoryService.index());
        model.addAttribute("event", eventService.index());
        return "admin_form_coupon";
    }

    @GetMapping("/admin/destroy-coupon")
    public String delete(Long id) {
        couponService.delete(id);
        return "redirect:/admin/manage-coupon";
    }
}

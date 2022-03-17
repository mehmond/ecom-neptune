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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminCouponController {

    @Autowired
    private CouponService couponService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private EventService eventService;

    @GetMapping("/admin/manage-coupons")
    public String index(Model model) {
        model.addAttribute("coupons", couponService.index());
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
    public String save(CouponDTO coupon, RedirectAttributes attributes) {
    	Coupon coup = new Coupon();
    	coup.setCouponId(coupon.getCouponId());
    	coup.setCategory(categoryService.show(coupon.getCategoryId()));
    	coup.setEvent(eventService.show(coupon.getEventId()));
    	coup.setCouponName(coupon.getCouponName());
    	coup.setCouponDiscount(coupon.getCouponDiscount());
        couponService.save(coup);
        String message = (coupon.getEventId() == null) ? "Record succesfully added!" : "Record succesfully updated!";
		attributes.addFlashAttribute("message", message);
        return "redirect:/admin/manage-coupons";
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
    public String delete(Long id, RedirectAttributes attributes) {
        couponService.delete(id);
        attributes.addFlashAttribute("deleteMessage", "Record succesfully deleted!");
        return "redirect:/admin/manage-coupons";
    }
}

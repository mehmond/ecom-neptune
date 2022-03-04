package com.app.NeptuneDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminTestController {
	@RequestMapping("admin")
	public String adminIndex() {
		return "adminIndex";
	}
	
	
	@RequestMapping("admin/manage-coupons")
	public String adminCoupon() {
		return "adminCoupon";
	}
	
	@RequestMapping("admin/manage-events")
	public String adminEvent() {
		return "adminEvent";
	}
	

}

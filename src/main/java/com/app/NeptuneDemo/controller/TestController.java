package com.app.NeptuneDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {
	
	public String index() {
		return "index";
	}
	
	@RequestMapping("about")
	public String about() {
		return "about";
	}
	@RequestMapping("shop")
	public String shop() {
		return "productList";
	}
	@RequestMapping("product-detail")
	public String productDetail() {
		return "productDetail";
	}
	@RequestMapping("cart")
	public String cart() {
		return "cart";
	}
	@RequestMapping("checkout")
	public String checkout() {
		return "checkout";
	}
	@RequestMapping("contact")
	public String contact() {
		return "contact";
	}
	@RequestMapping("sign-in")
	public String signin() {
		return "signin";
	}
	@RequestMapping("sign-up")
	public String signup() {
		return "signup";
	}
}

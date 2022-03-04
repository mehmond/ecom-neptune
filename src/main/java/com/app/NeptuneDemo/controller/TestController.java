package com.app.NeptuneDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.NeptuneDemo.service.CategoryService;
import com.app.NeptuneDemo.service.ProductService;

@Controller
@RequestMapping("/")
public class TestController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	public String index() {
		return "index";
	}

	@RequestMapping("about")
	public String about() {
		return "about";
	}

	@RequestMapping("shop")
	public String shop(Model model) {
		model.addAttribute("products", productService.index());
		model.addAttribute("categories", categoryService.index());
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

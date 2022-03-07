package com.app.NeptuneDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.NeptuneDemo.model.Product;
import com.app.NeptuneDemo.service.CategoryService;
import com.app.NeptuneDemo.service.ProductService;

@Controller

public class HomeController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("products", productService.index());
		model.addAttribute("categories", categoryService.index());
		return "productList";
	}

	@GetMapping("/shop/product-detail/{id}")
	public String productDetail(@PathVariable(value = "id") Long id, Model model) {
		Product product = productService.show(id);
		model.addAttribute("product", product);
		return "productDetail";
	}

	@RequestMapping("/cart")
	public String cart() {
		return "cart";
	}

	@RequestMapping("/checkout")
	public String checkout() {
		return "checkout";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
}

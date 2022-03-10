package com.app.NeptuneDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.NeptuneDemo.global.GlobalData;
import com.app.NeptuneDemo.model.Product;
import com.app.NeptuneDemo.service.ProductService;

@Controller
public class CartController {
//	@Autowired
//	ProductService productService;
//	@PostMapping("/add-to-cart/{id}")
//	public String addToCart(@PathVariable Long id) {
//		GlobalData.cart.add(productService.show(id));
//		return "redirect:/shop";
//	}
	
//	@GetMapping("/cart")
//	public String cart(Model model) {
//		model.addAttribute("cartCount", GlobalData.cart.size());
//		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getProductPrice).sum());
//		model.addAttribute("cartItem", GlobalData.cart);
//		return "cart";
//	}

}

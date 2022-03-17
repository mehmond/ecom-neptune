package com.app.NeptuneDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.NeptuneDemo.global.GlobalData;
import com.app.NeptuneDemo.model.CartItem;
import com.app.NeptuneDemo.model.Category;
import com.app.NeptuneDemo.model.OrderDetail;
import com.app.NeptuneDemo.model.Product;
import com.app.NeptuneDemo.model.User;
import com.app.NeptuneDemo.service.CategoryService;
import com.app.NeptuneDemo.service.OrderDetailService;
import com.app.NeptuneDemo.service.ProductService;
import com.app.NeptuneDemo.service.UserService;

@Controller

public class HomeController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	OrderDetailService orderDetailService;
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		return "about";
	}

	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("products", productService.index());
		model.addAttribute("categories", categoryService.index());
		return "productList";
	}
	
	@GetMapping("/shop/category/{id}")
	public String categoryFilter(@PathVariable(value = "id") Long id, Model model) {
		Category category = categoryService.show(id);
		model.addAttribute("categories", categoryService.index());
		model.addAttribute("products", productService.findAllByCategory(category));
		return "productList";
	}

	@GetMapping("/shop/product-detail/{id}")
	public String productDetail(@PathVariable(value = "id") Long id, Model model) {
		Product product = productService.show(id);
		CartItem cartItem = new CartItem();
		model.addAttribute("cartItem", cartItem);
		model.addAttribute("product", product);
		return "productDetail";
	}
	
	@GetMapping("/order-details")
	public String orderDetails(Model model) {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getAuthUser(auth);
		List<OrderDetail> orderDetail = orderDetailService.index(user);
		model.addAttribute("orderDetails", orderDetail);
		return "orderDetails";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
}

package com.app.NeptuneDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.NeptuneDemo.global.GlobalData;
import com.app.NeptuneDemo.model.CartItem;
import com.app.NeptuneDemo.model.CustomerUserDetail;
import com.app.NeptuneDemo.model.Product;
import com.app.NeptuneDemo.model.User;
import com.app.NeptuneDemo.repository.UserRepository;
import com.app.NeptuneDemo.service.CartItemService;
import com.app.NeptuneDemo.service.ProductService;
import com.app.NeptuneDemo.service.UserService;

@Controller
public class CartItemController {
	@Autowired
	CartItemService cartItemService;

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@PostMapping("/add-to-cart/{id}")
	public String addToCart(@PathVariable Long id, @RequestParam("quantity") int qty) {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Product product = productService.show(id);
		User user = userService.getAuthUser(auth);
		CartItem cart = new CartItem();
		cart.setProduct(product);
		cart.setUser(user);
		cart.setQuantity(qty);
		cartItemService.save(cart);
		return "redirect:/shop";
	}

	@GetMapping("/cart")
	public String showCart(Model model) {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getAuthUser(auth);
		List<CartItem> cartItems = cartItemService.index(user);
		if (cartItems.isEmpty()) {
			model.addAttribute("cartItems", "NoData");
		} else {
			model.addAttribute("cartItems", cartItems);
		}
		return "cart";
	}

	@GetMapping("/destroy-cart-item")
	public String delete(Long id) {
		cartItemService.delete(id);
		return "redirect:/cart";
	}
}

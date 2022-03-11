package com.app.NeptuneDemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.NeptuneDemo.global.GlobalData;
import com.app.NeptuneDemo.model.CartItem;
import com.app.NeptuneDemo.model.Coupon;
import com.app.NeptuneDemo.model.CustomerUserDetail;
import com.app.NeptuneDemo.model.Product;
import com.app.NeptuneDemo.model.User;
import com.app.NeptuneDemo.repository.UserRepository;
import com.app.NeptuneDemo.service.CartItemService;
import com.app.NeptuneDemo.service.CouponService;
import com.app.NeptuneDemo.service.ProductService;
import com.app.NeptuneDemo.service.UserService;

@Controller
public class CartItemController {
	private final int DISCOUNT_DIVIDER = 100;
	@Autowired
	CartItemService cartItemService;

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Autowired
	CouponService couponService;

	@PostMapping("/add-to-cart/{id}")
	public String addToCart(@PathVariable Long id, @RequestParam("quantity") int qty) {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Product product = productService.show(id);
		User user = userService.getAuthUser(auth);
		cartItemService.addProduct(product, qty, user);
		return "redirect:/shop";
	}

	@GetMapping("/cart")
	public String showCart(Model model, @RequestParam("couponName") Optional<String> couponName) {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getAuthUser(auth);
		Coupon coupon = couponService.findCoupon(couponName);
		double total = 0;
		List<CartItem> cartItems = cartItemService.index(user);
		if (cartItems.isEmpty()) {
			model.addAttribute("cartItems", "NoData");
		} else {
			total = cartItems.stream().map(item -> item.getProduct().getProductPrice() * item.getQuantity())
					.mapToDouble(num -> num.doubleValue()).sum();
			model.addAttribute("cartItems", cartItems);
		}
		if (coupon == null) {
			model.addAttribute("coupon", "Invalid coupon code");
		} else {
			double couponDiscount = coupon.getCouponDiscount();
			List<CartItem> qualifiedProduct = cartItems.stream()
					.filter(it -> it.getProduct().getCategory().equals(coupon.getCategory()))
					.collect(Collectors.toList());
			double totalOfQualifiedProduct = qualifiedProduct.stream()
					.map(item -> item.getProduct().getProductPrice() * item.getQuantity())
					.mapToDouble(num -> num.doubleValue()).sum();
			totalOfQualifiedProduct = totalOfQualifiedProduct * (couponDiscount / DISCOUNT_DIVIDER);
			total = total - totalOfQualifiedProduct;
			;
		}
		model.addAttribute("total", total);
		return "cart";
	}

	@GetMapping("/destroy-cart-item")
	public String delete(Long id) {
		cartItemService.delete(id);
		return "redirect:/cart";
	}
}

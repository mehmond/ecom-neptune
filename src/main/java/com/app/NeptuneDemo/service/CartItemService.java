package com.app.NeptuneDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.NeptuneDemo.model.CartItem;
import com.app.NeptuneDemo.model.Category;
import com.app.NeptuneDemo.model.Product;
import com.app.NeptuneDemo.model.User;
import com.app.NeptuneDemo.repository.CartItemRepository;
import com.app.NeptuneDemo.repository.ProductRepository;

@Service
public class CartItemService {
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	ProductRepository productRepo;
	
	
	public List<CartItem> index(User user, String status){
		return cartItemRepository.findByUserAndStatus(user, status);
	}
	
	public void addProduct(Product product, Integer quantity, User user) {
		Integer addedQuantity = quantity;
		CartItem cartItem = cartItemRepository.findByUserAndProductAndStatus(user, product, "IC");
		if(cartItem != null) {
			addedQuantity = cartItem.getQuantity() + quantity;
			cartItem.setQuantity(addedQuantity);
		}else {
			cartItem = new CartItem();
			cartItem.setQuantity(quantity);
			cartItem.setProduct(product);
			cartItem.setUser(user);
			cartItem.setStatus("IC");
		}
		cartItemRepository.save(cartItem);
	}
	
	public void save(CartItem cartItem) {
		cartItemRepository.save(cartItem);
	}
	
	public void saveAll(List<CartItem> cartItem) {
		cartItemRepository.saveAll(cartItem);
	}
	
	public CartItem show(Long id) {
		Optional<CartItem> optional = cartItemRepository.findById(id);
		CartItem cartItem = null;
		if (optional.isPresent()) {
			cartItem = optional.get();
		} else {
			throw new RuntimeException(" Cartitem not found for id :: " + id);
		}
		return cartItem;
	}
	
	public void delete(Long id) {
		cartItemRepository.deleteById(id);
	}
}

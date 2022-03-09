package com.app.NeptuneDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.NeptuneDemo.model.CartItem;
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
	
	
	public List<CartItem> index(User user){
		return cartItemRepository.findByUser(user);
	}
	
	public void addProduct(Product product, Integer quantity, User user) {
		Integer addedQuantity = quantity;
		CartItem cartItem = cartItemRepository.findByUserAndProduct(user, product);
		
		if(cartItem != null) {
			addedQuantity = cartItem.getQuantity() + quantity;
			cartItem.setQuantity(addedQuantity);
		}else {
			cartItem = new CartItem();
			cartItem.setQuantity(quantity);
			cartItem.setProduct(product);
			cartItem.setUser(user);
		}
		cartItemRepository.save(cartItem);
	}
	
	public void save(CartItem cartItem) {
		cartItemRepository.save(cartItem);
	}
	
	public void delete(Long id) {
		cartItemRepository.deleteById(id);
	}
}

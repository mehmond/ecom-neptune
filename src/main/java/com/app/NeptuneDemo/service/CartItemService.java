package com.app.NeptuneDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.NeptuneDemo.model.CartItem;
import com.app.NeptuneDemo.model.User;
import com.app.NeptuneDemo.repository.CartItemRepository;

@Service
public class CartItemService {
	@Autowired
	CartItemRepository cartItemRepository;
	
	public List<CartItem> index(User user){
		return cartItemRepository.findByUser(user);
	}
	
	public List<CartItem> getAll(){
		return cartItemRepository.findAll();
	}
	
	public void save(CartItem cartItem) {
		cartItemRepository.save(cartItem);
	}
	
	public void delete(Long id) {
		cartItemRepository.deleteById(id);
	}
}

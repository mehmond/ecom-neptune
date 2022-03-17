package com.app.NeptuneDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.NeptuneDemo.model.CartItem;
import com.app.NeptuneDemo.model.Product;
import com.app.NeptuneDemo.model.User;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	public List<CartItem> findByUserAndStatus(User user, String status);
	public CartItem findByUserAndProductAndStatus(User user, Product product, String status);
	
}

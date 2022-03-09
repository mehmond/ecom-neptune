package com.app.NeptuneDemo;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.NeptuneDemo.model.CartItem;
import com.app.NeptuneDemo.model.Product;
import com.app.NeptuneDemo.model.User;
import com.app.NeptuneDemo.repository.CartItemRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CartItemTest {
	@Autowired
	private	CartItemRepository cartItemRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testAddOneItem() {
		Product product = entityManager.find(Product.class, 119);
		User user = entityManager.find(User.class, 130);
		CartItem newItem = new CartItem();
		newItem.setUser(user);
		newItem.setProduct(product);
		newItem.setQuantity(4);
		CartItem savedCartItem = cartItemRepo.save(newItem);
		assertTrue(savedCartItem.getCartItemId() > 0);
	}
	
//	@Test
//	public void testGetUser() {
//		User user = new User();
//		user.setUserId((long)130);
//		List<CartItem> cartItems = cartItemRepo.findByUser(user);
//		assertEquals(0, cartItems.size());
//	}
}

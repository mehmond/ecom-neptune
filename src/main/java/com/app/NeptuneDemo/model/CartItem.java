package com.app.NeptuneDemo.model;

import javax.persistence.*;


@Entity
@Table(name = "cart_items")
public class CartItem {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "cart_item_id")
		private Long cartItemId;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name ="user_id", referencedColumnName ="user_id")
		private User user;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name ="product_id", referencedColumnName = "product_id")
		private Product product;
		
		private int quantity;
		@Column(columnDefinition = "varchar2(10) default 'IC'")
		private String status;
		
		
		public CartItem() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CartItem(Long cartItemId, User user, Product product, int quantity, String status) {
			super();
			this.cartItemId = cartItemId;
			this.user = user;
			this.product = product;
			this.quantity = quantity;
			this.status = status;
		}

		public Long getCartItemId() {
			return cartItemId;
		}

		public void setCartItemId(Long cartItemId) {
			this.cartItemId = cartItemId;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
}

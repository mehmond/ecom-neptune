package com.app.NeptuneDemo.dto;

import com.app.NeptuneDemo.model.Category;

public class ProductDTO {
	
	private Long productId;
	private String productName;
	private double productPrice;
	private String productImage;
	private Category category;
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(Long productId, String productName, double productPrice, String productImage, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.category = category;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}

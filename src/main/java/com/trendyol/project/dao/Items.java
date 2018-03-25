package com.trendyol.project.dao;


public class Items {
	
	private Long productId;
	private Long categoryId;
	private double price;
	private double discountedPrice;
	
	public Items() {
	}
	
	public Items(Long productId, Long categoryId, double price, double discountedPrice) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.price = price;
		this.discountedPrice = discountedPrice;
	}
	
	public Items(Long productId, Long categoryId, double price) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.price = price;
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

}

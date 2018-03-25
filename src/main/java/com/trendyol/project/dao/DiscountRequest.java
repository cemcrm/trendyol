package com.trendyol.project.dao;


public class DiscountRequest {
	
	private Long productId;
	private Long categoryId;
	private Long price;
	
	public DiscountRequest() {
	}
	
	public DiscountRequest(Long productId, Long categoryId, Long price) {
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
	
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}

}

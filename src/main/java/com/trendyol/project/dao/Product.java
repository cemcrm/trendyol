package com.trendyol.project.dao;


public class Product {
	
	private Long id;
	private String campaignName;
	private Long productId;
	private String productName;
	private Long categoryId;
	private String categoryName;
	private String type;
	private Long discount;
	private Long maxDiscount;
	
	public Product() {
	}
	
	public Product(Long id, String campaignName, Long productId, String productName, Long categoryId, String categoryName, String type,
			Long discount, Long maxDiscount) {
		super();
		this.id = id;
		this.campaignName = campaignName;
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.type = type;
		this.discount = discount;
		this.maxDiscount = maxDiscount;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
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

	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	public Long getMaxDiscount() {
		return maxDiscount;
	}
	public void setMaxDiscount(Long maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

}

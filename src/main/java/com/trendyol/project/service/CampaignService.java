package com.trendyol.project.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Service;

import com.trendyol.project.dao.DiscountRequest;
import com.trendyol.project.dao.ItemRequest;
import com.trendyol.project.dao.Items;
import com.trendyol.project.dao.Product;

@Service
public class CampaignService {
	
	
	private List<Product> products = new ArrayList<> (Arrays.asList(new Product(1L,"Ucuz iPhone", 5L ,"iPhone X", null, null, "ORAN", 5L, 100L),
				new Product(2L,"Mavi Tişört İndirimde",10L, "Mavi Tişört", null, null, "TUTAR", 50L, 0L),
				new Product(3L,"Kazaklar Daha Ucuz", null, null, 100L ,"Kazık", "ORAN", 10L, 30L),
				new Product(4L,"İndirimli Gömlekler", null, null, 200L,"Gömlek", "TUTAR", 50L, 0L)));

	
	public List<Product> getAllProduts() {
		List<Product> p = new ArrayList<Product>();
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getProductId() != null) {
				p.add(products.get(i));
			}
		}
		return p;
	}

	public List<Product> getAllCategories() {
		List<Product> p = new ArrayList<Product>();
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getCategoryId() != null) {
				p.add(products.get(i));
			}
		}
		return p;
	}
	
	public Product getProduct(Long id) {
		return products.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public Product getProductByProductId(Long productId) {
		for(int i = 0; i<products.size();i++) {
			Product product = products.get(i);
			if(product.getProductId() != null && product.getProductId().equals(productId)) {
				return product;
			}
		}
		return null;
	}

	public Product getProductByCategoryId(Long categoryId) {
		for(int i = 0; i<products.size();i++) {
			Product product = products.get(i);
			if(product.getCategoryId() != null && product.getCategoryId().equals(categoryId)) {
				return product;
			}
		}
		return null;
	}
	
	public Product getCategory(Long id) {
		return products.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addProduct(Product product) {
		product.setId(getCurrentId());
		products.add(product);
	}

	public void updateProduct(Product product, Long id) {
		for(int i=0; i<products.size(); i++ ) {
			Product p = products.get(i);
			if(p.getId().equals(id)) {
				products.set(i, product);
				return;
			}
		}
	}

	public void deleteProduct(Long id) {
		products.removeIf(t -> t.getId().equals(id));
	}
	
	public Long getCurrentId() {
		Long maxId = 0L;
		for(int i=0; i<products.size();i++) {
			if(products.get(i).getId()>maxId) {
				maxId = products.get(i).getId();
			}
		}
		return maxId+1;
		
	}

	public ItemRequest calculateDiscount(ItemRequest discountRequest) {
	//	List<Items> items = new ArrayList<> (Arrays.asList(new Items(3L,3L,5L,6L), new Items(23L,35L,5L,6L)));
		List<Items> items = discountRequest.getItems();
		setResponseItems(items);
		ItemRequest discountResponse = new ItemRequest();
		discountResponse.setItems(items);
		return discountResponse;
	}
	
	public List<Items> setResponseItems(List<Items> items) {
		for(int i=0; i<items.size();i++) {
			Items item = items.get(i);
			//item.setDiscountedPrice(calculateDiscountByItem(item));
			item.setDiscountedPrice(item.getPrice());
		}
		return items;
	}
	/*
	public double calculateDiscountByItem(Items item) {
		Long productDiscount = 0L;
		Long maxDiscount = 0L;
		Long price = item.getPrice();
		Product product = getProductByProductId(item.getProductId());
		Product category = getProductByCategoryId(item.getCategoryId());
		if(product != null) {
			productDiscount = product.getDiscount();
			maxDiscount = product.getMaxDiscount();
		}
		
		if(category != null) {
			productDiscount = product.getDiscount();
			maxDiscount = product.getMaxDiscount();
		}
		
		
		if(maxDiscount < category.getMaxDiscount()) {
			maxDiscount = category.getMaxDiscount();
		}
		double ratio = (double)price * (double) productDiscount/100;
		if(maxDiscount != 0L && maxDiscount.doubleValue()< ratio) {
			return maxDiscount.doubleValue();
		}
		return ratio;
	}*/
	
	


}

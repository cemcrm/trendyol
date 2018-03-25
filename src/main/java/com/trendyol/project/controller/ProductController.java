package com.trendyol.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.trendyol.project.dao.Product;
import com.trendyol.project.service.CampaignService;

@RestController
public class ProductController {
	
	@Autowired
	private CampaignService campaignService;
	
	@RequestMapping("/products")
	public ModelAndView mainPage(Model model) {
		List<Product> products = campaignService.getAllProduts();
		model.addAttribute("products", products);
		return new ModelAndView("products");
	}
	
	@RequestMapping("/addProductForm")
	public ModelAndView addPageProduct(Model model) {
		model.addAttribute("product", new Product()); 
		return new ModelAndView("new_product_form");
	}
	
	@RequestMapping("/deleteProduct/{id}")
	public ModelAndView deleteProduct(@PathVariable Long id, Model model) {
		campaignService.deleteProduct(id);
		return mainPage(model);
	}
	
	@RequestMapping("/updateProductForm/{id}")
	public ModelAndView updateProductForm(@PathVariable Long id, Model model) {
		Product product = campaignService.getProduct(id);
		model.addAttribute(product);
		return new ModelAndView("update_product_form");
	}

	@RequestMapping(method=RequestMethod.POST, value="/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute("product") Product product, Model model) {
		campaignService.updateProduct(product, product.getId());
		return mainPage(model);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addNewProduct")
	public ModelAndView addPageProduct(@ModelAttribute("product") Product product, Model model) {
		campaignService.addProduct(product);
		return mainPage(model);
	}


}

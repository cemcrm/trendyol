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
public class CategoryController {
	
	@Autowired
	private CampaignService campaignService;
	
	@RequestMapping("/categories")
	public ModelAndView mainPage(Model model) {
		List<Product> products = campaignService.getAllCategories();
		model.addAttribute("products", products);
		return new ModelAndView("categories");
	}
	
	@RequestMapping("/addCategoryForm")
	public ModelAndView addPageCategory(Model model) {
		model.addAttribute("product", new Product()); 
		return new ModelAndView("new_category_form");
	}
	
	@RequestMapping("/deleteCategory/{id}")
	public ModelAndView deleteCategory(@PathVariable Long id, Model model) {
		campaignService.deleteProduct(id);
		return mainPage(model);
	}
	
	@RequestMapping("/updateCategoryForm/{id}")
	public ModelAndView updateCategoryForm(@PathVariable Long id, Model model) {
		Product product = campaignService.getCategory(id);
		model.addAttribute(product);
		return new ModelAndView("update_category_form");
	}

	@RequestMapping(method=RequestMethod.POST, value="/updateCategory")
	public ModelAndView updateCategory(@ModelAttribute("product") Product product, Model model) {
		campaignService.updateProduct(product, product.getId());
		return mainPage(model);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addNewCategory")
	public ModelAndView addPageCategory(@ModelAttribute("product") Product product, Model model) {
		campaignService.addProduct(product);
		return mainPage(model);
	}


}

package com.trendyol.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.trendyol.project.dao.ItemRequest;
import com.trendyol.project.service.CampaignService;

@RestController
public class MenuController {
	
	@Autowired
	private CampaignService campaignService;

	@RequestMapping("/")
	public ModelAndView initMenu() {
		return new ModelAndView("menu");
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/calculateDiscounts")
	public ItemRequest itemResponse(@RequestBody ItemRequest item) {
		ItemRequest itemResponse =	campaignService.calculateDiscount(item);
		return itemResponse;
	}
	
}

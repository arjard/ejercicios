package com.arjard.cinemaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arjard.cinemaApp.service.BannerService;

@Controller
@RequestMapping("/banner")
public class BannerController {
	
	@Autowired
	BannerService bannerService;

	@GetMapping("/list")
	public String getListBanner(Model model) {
		
		model.addAttribute("banners", bannerService.getAllBanner());
		
		return "/banners/bannerList";
		
	}
	
}

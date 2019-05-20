package com.arjard.cinemaApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.arjard.cinemaApp.model.Banner;
import com.arjard.cinemaApp.service.BannerService;
import com.arjard.cinemaApp.util.Util;

@Controller
@RequestMapping("/banner")
public class BannerController {
	
	@Autowired
	private BannerService bannerService;

	@GetMapping(value = "/list")
	public String getListBanner(Model model) {
		
		model.addAttribute("banners", bannerService.getAllBanner());
		
		return "/banners/bannerList";
		
	}
	
	@GetMapping(value = "/create")
	public String createBanner(Model model, @ModelAttribute Banner banner) {
		return "/banners/bannerSave";
	}
	
	@PostMapping(value = "/save")
	public String saveBanner(@ModelAttribute Banner banner, BindingResult result,
							@RequestParam("archivo") MultipartFile multipart, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			
			for(ObjectError o : result.getAllErrors()) {
				if(!o.getCode().equals("typeMismatch")) {
					System.out.println(o.getDefaultMessage());
				}
			}
			
//			return "redirect:/banner/list";
		}
		
		if(!multipart.isEmpty()) {
			banner.setArchivo(Util.saveImage(multipart, request));
		}
		
		bannerService.insertBanner(banner);
		
		return "redirect:/banner/list";
	}
	
	
	
}

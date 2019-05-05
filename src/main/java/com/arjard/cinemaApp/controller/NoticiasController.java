package com.arjard.cinemaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arjard.cinemaApp.model.Noticia;
import com.arjard.cinemaApp.service.NoticiaService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private NoticiaService noticeService;

	@GetMapping(value = "create")
	public String createNotice() {
		return "noticias/create";
	}
	
	@PostMapping(value = "save")
	public String saveNotice(Noticia noticia) {
		
		noticeService.saveNotice(noticia);
		
		return "noticias/create";
	}
	
}

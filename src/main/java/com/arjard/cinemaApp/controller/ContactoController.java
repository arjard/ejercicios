package com.arjard.cinemaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arjard.cinemaApp.model.Contacto;
import com.arjard.cinemaApp.service.PeliculaService;

@Controller
@RequestMapping(value = "/contactos")
public class ContactoController {

	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping(value = "/form")
	public String goContacto(@ModelAttribute Contacto contacto, Model model) {
		
		model.addAttribute("generos", peliculaService.getGenero());
		
		return "contactos/FormContacto";
	}
	
	@PostMapping(value = "/form")
	public String getContacto(@ModelAttribute Contacto contacto, Model model) {
		
		model.addAttribute("generos", peliculaService.getGenero());
		
		System.out.println(contacto);
		
		return "contactos/FormContacto";
	}
	
}

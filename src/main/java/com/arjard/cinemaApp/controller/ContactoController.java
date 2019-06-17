package com.arjard.cinemaApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arjard.cinemaApp.model.Contacto;
import com.arjard.cinemaApp.model.Notificacion;
import com.arjard.cinemaApp.service.PeliculaService;

@Controller
@RequestMapping(value = "/contactos")
public class ContactoController {

	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping(value = "/form")
	public String goContacto(@ModelAttribute Contacto contacto, Model model) {
		
		model.addAttribute("generos", peliculaService.getGenero());
		model.addAttribute("notificaciones", getNotificaciones());
		
		return "contactos/FormContacto";
	}
	
	@PostMapping(value = "/form")
	public String getContacto(@ModelAttribute Contacto contacto, Model model) {
		
		model.addAttribute("generos", peliculaService.getGenero());
		model.addAttribute("notificaciones", getNotificaciones());
		
		System.out.println(contacto);
		
		return "contactos/FormContacto";
	}
	
	private List<Notificacion> getNotificaciones(){
		List<Notificacion> notificaciones = new ArrayList<Notificacion>();
		notificaciones.add(Notificacion.ESTRENOS);
		notificaciones.add(Notificacion.PROMOCIONES);
		notificaciones.add(Notificacion.NOTICIAS);
		notificaciones.add(Notificacion.PREVENTAS);
		
		return notificaciones;
	}
	
}

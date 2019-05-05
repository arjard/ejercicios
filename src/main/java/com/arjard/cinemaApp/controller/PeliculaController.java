package com.arjard.cinemaApp.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arjard.cinemaApp.model.Pelicula;
import com.arjard.cinemaApp.service.PeliculaService;
import com.arjard.cinemaApp.util.Util;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService;

	@GetMapping("/create")
	public String createPelicula() {
		return "/peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String savePalicula(Pelicula pelicula, BindingResult result, RedirectAttributes attributes
			, @RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			
			for(ObjectError o : result.getAllErrors()) {
				System.out.println(o.getDefaultMessage());
			}
			
			return "/peliculas/formPelicula";
		}

		if(!multipart.isEmpty()) {
			pelicula.setImagen(Util.saveImage(multipart, request));
		}
		
		peliculaService.insertPelicula(pelicula);
		
		attributes.addFlashAttribute("mensaje", "Pelicula introducida");

		return "redirect:/peliculas/list";
	}
	
	
	@GetMapping("/list")
	public String goListPelicula(Model model) {
		
		model.addAttribute("peliculas", peliculaService.getAllPeliculas());
		
		return "/peliculas/listPeliculas";
	}
	
	@InitBinder
	public void initBinding(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
	
}

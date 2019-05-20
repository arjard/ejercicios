package com.arjard.cinemaApp.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@GetMapping(value="/create")
	public String createPelicula(@ModelAttribute Pelicula pelicula) {
		return "/peliculas/formPelicula";
	}
	
	/**
	 * @param pelicula
	 * @param result
	 * @param attributes
	 * @param multipart
	 * @param request
	 * 
	 * nos permite guardar una nueva pelicula
	 * 
	 * @return
	 */
	@PostMapping(value="/save")
	public String savePalicula(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes
			, @RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request) {
		
//		Esto aplica cuando existen ecepciones en el bindeo del modelo
		if(result.hasErrors()) {
			
			for(ObjectError o : result.getAllErrors()) {
				System.out.println(o.getDefaultMessage());
			}
			
			return "/peliculas/formPelicula";
		}

//		Guardamos los archivos de imagen de manera fisica temporalmente
		if(!multipart.isEmpty()) {
			pelicula.setImagen(Util.saveImage(multipart, request));
		}
		
		peliculaService.insertPelicula(pelicula);
		
//		El RedirectAttributes nos permite redirigir parametros cuando la vista se redireccion
		attributes.addFlashAttribute("mensaje", "Pelicula introducida");

//		Redirecionamos pagina
		return "redirect:/peliculas/list";
	}
	
	
	@GetMapping(value="/list")
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

package com.arjard.cinemaApp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arjard.cinemaApp.model.Horario;
import com.arjard.cinemaApp.model.Pelicula;
import com.arjard.cinemaApp.service.HorarioService;
import com.arjard.cinemaApp.service.PeliculaService;

@Controller
@RequestMapping(value = "/horarios")
public class HorarioController {
	
	@Autowired
	private PeliculaService peliculaService;
	@Autowired
	private HorarioService horarioService;
	
	@GetMapping(value = "/create")
	public String goHorario(Model model, @ModelAttribute Horario horario) {
		
		model.addAttribute("peliculas", peliculaService.getAllPeliculas());
		
		return "/peliculas/formHorarioPelicula";
	}
	
	@PostMapping(value = "/save")
	public String setNewHorario(Model model, @ModelAttribute Horario horario) {
		
		List<Pelicula> peliculas = peliculaService.getAllPeliculas();
		
		model.addAttribute("peliculas", peliculas);
		
		horario.setPeliculas(peliculas);
		
		horarioService.saveHorario(horario);
		
		return "redirect:/horarios/list";
	}
	
	@GetMapping(value = "/list")
	public String goListHorarios(Model model) {
		
		List<Horario> horarios = horarioService.getAllHorarios();
		List<Pelicula> peliculas = peliculaService.getAllPeliculas();
		
		for (int i = 0; i < horarios.size(); i++) {
				horarios.get(i).setPeliculas(peliculas);
		}
		
		model.addAttribute("horarios", horarios);
		
		return "/peliculas/ListHorario";
	}
	
	@InitBinder
	public void initBinding(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}

}

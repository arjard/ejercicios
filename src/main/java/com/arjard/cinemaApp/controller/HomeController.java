package com.arjard.cinemaApp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arjard.cinemaApp.model.Banner;
import com.arjard.cinemaApp.model.Pelicula;
import com.arjard.cinemaApp.service.BannerService;
import com.arjard.cinemaApp.service.PeliculaService;
import com.arjard.cinemaApp.util.Util;

@Controller
public class HomeController {

	@Autowired
	private PeliculaService peliculaService;
	@Autowired
	private BannerService bannerService;
	private SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goIndex(Model model) {
		
		List<String> fechas = Util.getNextDates(5);
		List<Pelicula> listaPeliculas = peliculaService.getAllPeliculas();
		List<Banner> listaBanners = bannerService.getAllBanner();
		
		model.addAttribute("banners", listaBanners);
		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaSeleccionada", simpleDate.format(new Date()));
		model.addAttribute("peliculas", listaPeliculas);
		
		return "home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String findMovies(@RequestParam("fecha") String fecha, Model model) {

		List<String> fechas = Util.getNextDates(5);
		List<Pelicula> listaPeliculas = peliculaService.getPeliculasByDate(fecha);
		List<Banner> listaBanners = bannerService.getAllBanner();
		
		model.addAttribute("banners", listaBanners);
		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaSeleccionada", fecha);
		model.addAttribute("peliculas", listaPeliculas);
		
		return "home";
	}
	
//	@RequestMapping(value = "/detalle/{id}/{fecha}", method = RequestMethod.GET)
//	public String goDetails(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fechaActual) {
	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public String goDetails(Model model, @RequestParam("id") int idPelicula, @RequestParam("fecha") String fechaActual) {

		model.addAttribute("pelicula", peliculaService.getPeliculaById(idPelicula));
		
		return "detalle";
	}
	
}

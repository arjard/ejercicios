package com.arjard.cinemaApp.service;

import java.util.List;

import com.arjard.cinemaApp.model.Genero;
import com.arjard.cinemaApp.model.Pelicula;

public interface PeliculaService {
	
	public List<Pelicula> getAllPeliculas();
	public List<Pelicula> getPeliculasByDate(String date);
	public Pelicula getPeliculaById(int id);
	public boolean insertPelicula(Pelicula pelicula);
	public List<Genero> getGenero();

}

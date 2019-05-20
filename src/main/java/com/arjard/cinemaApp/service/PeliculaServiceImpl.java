package com.arjard.cinemaApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arjard.cinemaApp.model.Pelicula;

@Service
public class PeliculaServiceImpl implements PeliculaService{
	
	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
	
	PeliculaServiceImpl(){
		
	}
	
	private void fillPeliculas(){
		try {
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Harry Potter");
			pelicula1.setDuracion(136);
			pelicula1.setClasificacion("A");
			pelicula1.setFechaEstreno("22-04-2019");
			pelicula1.setGenero("Fantasia");
			pelicula1.setImagen("HarryPotter.jpg");
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Logan");
			pelicula2.setDuracion(136);
			pelicula2.setClasificacion("B-15");
			pelicula2.setFechaEstreno("24-04-2019");
			pelicula2.setGenero("Sciencia fiction");
			pelicula2.setImagen("Logan.jpg");
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Advengers");
			pelicula3.setDuracion(180);
			pelicula3.setClasificacion("B");
			pelicula3.setFechaEstreno("22-04-2019");
			pelicula3.setGenero("Sciencia fiction");
			pelicula3.setImagen("avengers.jpg");
			pelicula3.setEstatus("Inactiva");
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Power Rangers");
			pelicula4.setDuracion(134);
			pelicula4.setClasificacion("B");
			pelicula4.setFechaEstreno("24-04-2019");
			pelicula4.setGenero("Sciencia fiction");
			pelicula4.setImagen("estreno8.png");
			pelicula4.setEstatus("Inactiva");
			
			if(peliculas.size()==0) {
				peliculas.add(pelicula1);
				peliculas.add(pelicula2);
				peliculas.add(pelicula3);
				peliculas.add(pelicula4);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public List<Pelicula> getAllPeliculas() {
		fillPeliculas();
		
		return peliculas;
	}

	public List<Pelicula> getPeliculasByDate(String date) {
		
		fillPeliculas();
		
		if(date!=null) {
		
			int count = 0;
			
			while(peliculas.size()>0 && count<peliculas.size()) {
				if(!peliculas.get(count).getFechaEstreno().equals(date)) {
					peliculas.remove(count);
					count=0;
				}else {
					count++;
				}
			}
			
		}
		
		return peliculas;
	}

	public Pelicula getPeliculaById(int id) {

		for(Pelicula p : peliculas) {
			if(p.getId() == id) {
				return p;
			}
		}
		
		return null;
	}

	public boolean insertPelicula(Pelicula pelicula) {
		
		peliculas.add(pelicula);
		
		return false;
	}



}

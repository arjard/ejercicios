package com.arjard.cinemaApp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arjard.cinemaApp.model.Horario;

@Service
public class HorarioServiceImpl implements HorarioService{
	
	private List<Horario> horarios;

	public HorarioServiceImpl() {
		
		horarios = new ArrayList<Horario>();
		
		Horario h1 = new Horario();
		h1.setFecha(new Date());
		h1.setHora("9:10");
		h1.setSala("sala1");
		h1.setPrecio(43.50);
		h1.setIdPelicula(1);
		h1.setId(1);
		Horario h2 = new Horario();
		h2.setFecha(new Date());
		h2.setHora("21:30");
		h2.setSala("sala5");
		h2.setPrecio(53.50);
		h2.setIdPelicula(2);
		h2.setId(2);
		Horario h3 = new Horario();
		h3.setFecha(new Date());
		h3.setHora("15:00");
		h3.setSala("sala2");
		h3.setPrecio(63.50);
		h3.setIdPelicula(3);
		h3.setId(3);
		
		horarios.add(h1);
		horarios.add(h2);
		horarios.add(h3);
		
	}
	
	@Override
	public List<Horario> getAllHorarios() {
		
		return horarios;
	}

	@Override
	public boolean saveHorario(Horario horario) {
		
		this.horarios.add(horario);
		
		return false;
	}

	
}

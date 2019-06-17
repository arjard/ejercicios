package com.arjard.cinemaApp.service;

import java.util.List;

import com.arjard.cinemaApp.model.Horario;

public interface HorarioService {
	
	public List<Horario> getAllHorarios();
	public boolean saveHorario(Horario horario);

}

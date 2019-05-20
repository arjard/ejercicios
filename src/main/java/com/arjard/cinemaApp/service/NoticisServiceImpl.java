package com.arjard.cinemaApp.service;

import org.springframework.stereotype.Service;

import com.arjard.cinemaApp.model.Noticia;

@Service
public class NoticisServiceImpl implements NoticiaService{

	public boolean saveNotice(Noticia noticia) {
		
		System.out.println(noticia);
		
		return false;
	}

}

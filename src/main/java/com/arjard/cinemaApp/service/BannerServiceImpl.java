package com.arjard.cinemaApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arjard.cinemaApp.model.Banner;

@Service
public class BannerServiceImpl implements BannerService{
	
	private List<Banner> banners = new ArrayList<Banner>();
	
	BannerServiceImpl(){
		
		Banner banner1 = new Banner();
		banner1.setId(0);
		banner1.setTitulo("logan/kingkong");
		banner1.setArchivo("slide1.jpg");
		
		Banner banner2 = new Banner();
		banner2.setId(1);
		banner2.setTitulo("bellaBestia");
		banner2.setArchivo("slide2.jpg");
		banner2.setEstatus("Desactivo");
		
		Banner banner3 = new Banner();
		banner3.setId(2);
		banner3.setTitulo("spiderman");
		banner3.setArchivo("slide3.jpg");
		
		Banner banner4 = new Banner();
		banner4.setId(3);
		banner4.setTitulo("cars3");
		banner4.setArchivo("slide4.jpg");
		
		banners.add(banner1);
		banners.add(banner2);
		banners.add(banner3);
		banners.add(banner4);
		
	}

	public boolean insertBanner(Banner banner) {
		// TODO Auto-generated method stub
		return banners.add(banner);
	}


	public List<Banner> getAllBanner() {
		// TODO Auto-generated method stub
		return banners;
	}

}

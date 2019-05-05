package com.arjard.cinemaApp.service;

import java.util.List;

import com.arjard.cinemaApp.model.Banner;

public interface BannerService {
	
	public boolean insertBanner(Banner banner);
	public List<Banner> getAllBanner();

}

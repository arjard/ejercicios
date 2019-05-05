package com.arjard.cinemaApp.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Util {

	public static List<String> getNextDates(int count){
		List<String> fechas =new ArrayList<String>();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Date startDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = calendar.getTime();
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(startDate);
		
		while(!gregorianCalendar.getTime().after(endDate)) {
			fechas.add(simpleDateFormat.format(gregorianCalendar.getTime()));
			gregorianCalendar.add(Calendar.DATE, 1); // incrementamos los dias en 1
		}
		
		return fechas;
	}
	
	public static String saveImage(MultipartFile multipart, HttpServletRequest request) {
		
		String nombreOrigen = multipart.getOriginalFilename();
		String rutaDestino = request.getServletContext().getRealPath("/resources/images/");
		
		nombreOrigen = getRandomName(8)+nombreOrigen.replace(" ", "-");
		
		try {
			
			File archivoImagen = new File(rutaDestino+nombreOrigen);
			
			multipart.transferTo(archivoImagen);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return nombreOrigen;
		
	}
	
	public static String getRandomName(int count) {
		
		String cadena ="abcdefghijklnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder stringBuilder = new StringBuilder();
		
		while(count-- != 0) {
			int character = (int) (Math.random() * cadena.length());
			stringBuilder.append(cadena.charAt(character));
		}
		
		return stringBuilder.toString();
		
	}
	
}

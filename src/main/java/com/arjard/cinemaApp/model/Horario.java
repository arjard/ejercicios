package com.arjard.cinemaApp.model;

import java.util.Date;
import java.util.List;

public class Horario {
	
	private int id;
	private int idPelicula;
	private Pelicula pelicula;
	private Date fecha;
	private String hora;
	private String sala;
	private double precio;
	private List<Pelicula> peliculas;
	
	public Horario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}
	
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}
	
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		
		if(this.idPelicula!=0) {
			for(Pelicula p : peliculas) {
				if(p.getId() == this.idPelicula) {
					this.pelicula = p;
					break;
				}
			}
		}
		
		this.peliculas = peliculas;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", pelicula=" + pelicula + ", fecha=" + fecha + ", hora=" + hora + ", sala=" + sala
				+ ", precio=" + precio + "]";
	}

}

package com.arjard.cinemaApp.model;

import java.util.List;

public class Contacto {
	
	private int id;
	private String nombre;
	private String email;
	private int rating;
	private List<Genero> generos;
	private List<Notificacion> notificaciones;
	private String comentarios;
	
	public Contacto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	
	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", email=" + email + ", rating=" + rating + ", generos="
				+ generos + ", notificaciones=" + notificaciones + ", comentarios=" + comentarios + "]";
	}

	
}

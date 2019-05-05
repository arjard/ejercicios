package com.arjard.cinemaApp.model;

import java.util.Date;

public class Noticia {

	private int idNoticia;
	private String titulo;
	private Date fecha;
	private String detalle;
	private String estatus;
	
	public Noticia() {
		super();
		
		this.fecha = new Date();
		this.estatus = "Activa";
	}

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Noticia [idNoticia=" + idNoticia + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle
				+ ", estatus=" + estatus + "]";
	}
	
}

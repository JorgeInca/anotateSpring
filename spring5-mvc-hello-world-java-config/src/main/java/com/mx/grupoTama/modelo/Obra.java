package com.mx.grupoTama.modelo;

import java.util.Date;

public class Obra {
	
	private Long idObra;
	private String nombre;
	private String direccion;
	private Long idCliente;
	private Date fechaInicio;
	
	private String nombreCliente; 
	private String telefonoCliente;
	
	public Long getIdObra() {
		return idObra;
	}
	public void setIdObra(Long idObra) {
		this.idObra = idObra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	@Override
	public String toString() {
		return "Obra [idObra=" + idObra + ", nombre=" + nombre + ", direccion="
				+ direccion + ", idCliente=" + idCliente + ", fechaInicio="
				+ fechaInicio + ", nombreCliente=" + nombreCliente
				+ ", telefonoCliente=" + telefonoCliente + "]";
	}
	
}

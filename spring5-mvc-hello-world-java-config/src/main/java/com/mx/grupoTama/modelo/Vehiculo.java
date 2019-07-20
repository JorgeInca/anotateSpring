package com.mx.grupoTama.modelo;


public class Vehiculo {
	
	private Long idVehiculo;
	private String descripcion;
	private String marca;
	private String modelo;
	private String color;
	private String matricula;
	private Integer anio;
	private Integer estatus;
	
	public Long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", descripcion="
				+ descripcion + ", marca=" + marca + ", modelo=" + modelo
				+ ", color=" + color + ", matricula=" + matricula + ", anio="
				+ anio + ", estatus=" + estatus + "]";
	}
	
	
}
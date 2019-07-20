package com.mx.grupoTama.modelo;

import java.util.Date;

public class Revolvente {
	
	private Long idRevolvente;
	private boolean esIngreso;
	private Integer cantidad;
	private String descripcion;
	private Float monto;
	private Date fecha;
	private Integer estatus;
	private Long idObra;
	private Long idVehiculo;
	
	public Long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public Long getIdRevolvente() {
		return idRevolvente;
	}
	public void setIdRevolvente(Long idRevolvente) {
		this.idRevolvente = idRevolvente;
	}
	public boolean isEsIngreso() {
		return esIngreso;
	}
	public void setEsIngreso(boolean esIngreso) {
		this.esIngreso = esIngreso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public Long getIdObra() {
		return idObra;
	}
	public void setIdObra(Long idObra) {
		this.idObra = idObra;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Revolvente [idRevolvente=" + idRevolvente + ", esIngreso="
				+ esIngreso + ", cantidad=" + cantidad + ", descripcion="
				+ descripcion + ", monto=" + monto + ", fecha=" + fecha
				+ ", estatus=" + estatus + ", idObra=" + idObra
				+ ", idVehiculo=" + idVehiculo + "]";
	}
		 
}
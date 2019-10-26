package com.mx.grupoTama.modelo;

import java.util.Date;

public class Renta{
	
	public Long idRenta;
	public Long idEmpleado;
	public String descripcion;
	public Date fechaAlta;
	public Date fechaInicio;
	public Date fechaFin;
	public Float valor;
	public Integer estatus;
	
	
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public Long getIdRenta() {
		return idRenta;
	}
	public void setIdRenta(Long idRenta) {
		this.idRenta = idRenta;
	}
	public Long getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	@Override
	public String toString() {
		return "Renta [idRenta=" + idRenta + ", idEmpleado=" + idEmpleado
				+ ", descripcion=" + descripcion + ", fechaAlta=" + fechaAlta
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", valor=" + valor + ", estatus=" + estatus + "]";
	}
	
	
	
}
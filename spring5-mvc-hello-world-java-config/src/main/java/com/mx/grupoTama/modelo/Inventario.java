package com.mx.grupoTama.modelo;

import java.util.Date;

public class Inventario{
	
	public Long idInventario;
	public Integer cantidad;
	public String descripcion;
	public Long enRenta;
	private Float precioUnitario;
	private Float total;
	private Date fechaAlta;
	
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Long getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(Long idInventario) {
		this.idInventario = idInventario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getEnRenta() {
		return enRenta;
	}
	public void setEnRenta(Long enRenta) {
		this.enRenta = enRenta;
	}
	public Float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	@Override
	public String toString() {
		return "Inventario [idInventario=" + idInventario + ", cantidad="
				+ cantidad + ", descripcion=" + descripcion + ", enRenta="
				+ enRenta + ", precioUnitario=" + precioUnitario + ", total="
				+ total + ", fechaAlta=" + fechaAlta + "]";
	}	

}
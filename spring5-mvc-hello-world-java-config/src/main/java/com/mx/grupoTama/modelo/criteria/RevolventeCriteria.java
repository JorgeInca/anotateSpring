package com.mx.grupoTama.modelo.criteria;


public class RevolventeCriteria {

	private String fechaInicio;
	private String fechaFin;
	private Long idObra;
	private Long idVehiculo;
	
	public boolean isEmpty(){
		
		if( fechaInicio.equals("") && fechaFin.equals("") && idObra == 0 && idVehiculo == 0){
			return true;
		}else{
			return false;
		}
		
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Long getIdObra() {
		return idObra;
	}
	public void setIdObra(Long idObra) {
		this.idObra = idObra;
	}
	public Long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	@Override
	public String toString() {
		return "RevolventeCriteria [fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", idObra=" + idObra + ", idVehiculo="
				+ idVehiculo + "]";
	}
			
}
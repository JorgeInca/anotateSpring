package com.mx.grupoTama.modelo.criteria;


public class RevolventeCriteria {

	private String fechaInicio;
	private String fechaFin;
	private Long idObra;
	private Long idVehiculo;
	private boolean hoy;
	private Integer esIngreso; 
	
	public boolean isEmpty(){
		
		if( fechaInicio.equals("") && fechaFin.equals("") && idObra == 0 && idVehiculo == 0 
				&& !hoy && esIngreso == 0){
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
	public boolean isHoy() {
		return hoy;
	}

	public void setHoy(boolean hoy) {
		this.hoy = hoy;
	}

	public Integer getEsIngreso() {
		return esIngreso;
	}

	public void setEsIngreso(Integer esIngreso) {
		this.esIngreso = esIngreso;
	}

	@Override
	public String toString() {
		return "RevolventeCriteria [fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", idObra=" + idObra + ", idVehiculo="
				+ idVehiculo + ", hoy=" + hoy + ", esIngreso=" + esIngreso
				+ "]";
	}
	
				
}
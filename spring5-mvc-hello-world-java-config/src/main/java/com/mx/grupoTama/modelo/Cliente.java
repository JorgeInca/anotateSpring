package com.mx.grupoTama.modelo;

public class Cliente extends Persona{
	
	public String rfc;
	public String nombreEmpresa;

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	@Override
	public String toString() {
		return "Cliente [rfc=" + rfc + ", nombreEmpresa=" + nombreEmpresa + "]";
	}	
	
	
}

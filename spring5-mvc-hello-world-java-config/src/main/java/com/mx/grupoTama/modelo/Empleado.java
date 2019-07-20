package com.mx.grupoTama.modelo;

public class Empleado extends Persona{
	
	public String numeroEmpleado;

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [numeroEmpleado=" + numeroEmpleado + "]";
	}
	
}
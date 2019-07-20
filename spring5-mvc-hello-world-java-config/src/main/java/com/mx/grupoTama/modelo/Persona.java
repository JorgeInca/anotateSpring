package com.mx.grupoTama.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Persona {
	
	private Long idPersona;
	private Integer tipoPersona;
	public String nombre;
	private String apellidos;
	public String direccion;
	private String telefono;
	private String email;
	private Date fechaNacimiento;
	private String fechaString;
	private Integer edad;
	
	
	public String getFechaString() {
		return fechaString;
	}
	public void setFechaString(String fechaString) {
		
		this.fechaString = fechaString;
		if(fechaString != null && !fechaString.equals("") ){
			try {
				Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(fechaString);
				this.fechaNacimiento = date1;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public Integer getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(Integer tipoPersona) {
		this.tipoPersona = tipoPersona;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;

		if(fechaNacimiento!= null){
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy",new Locale("ES"));
			String fecha = formateador.format(fechaNacimiento);
			this.setFechaString(fecha);
		}
		
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", tipoPersona="
				+ tipoPersona + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", direccion=" + direccion + ", telefono="
				+ telefono + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + ", fechaString=" + fechaString + ", edad="
				+ edad + "]";
	}
	
	
	

}
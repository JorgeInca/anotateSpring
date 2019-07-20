package com.mx.grupoTama.controller;

public class ResponseObjectMVC {
	
	private boolean success;
	private Object modelo;
	private String message;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getModelo() {
		return modelo;
	}
	public void setModelo(Object modelo) {
		this.modelo = modelo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseObjectMVC [success=" + success + ", modelo=" + modelo
				+ ", message=" + message + "]";
	}
	
}

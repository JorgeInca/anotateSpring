package com.mx.grupoTama.modelo.enums;

public enum EstatusEnum {
	
	ACTIVO		(1),
	CANCELADO 	(2);
	
	public Integer idEstatus;
	
	private EstatusEnum(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
	
	public static EstatusEnum getById(Integer id) {
	    for(EstatusEnum e : values()) {
	        if(e.idEstatus.equals(id)) return e;
	    }
	    return null;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
	
	
	
	
	
}
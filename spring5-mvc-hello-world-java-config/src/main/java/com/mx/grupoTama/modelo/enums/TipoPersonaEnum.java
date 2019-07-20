package com.mx.grupoTama.modelo.enums;

public enum TipoPersonaEnum {
	
	CLIENTE		(1),
	EMPLEADO 	(2);
	
	public Integer idTipoPersona;
	
	private TipoPersonaEnum(Integer idEstatus) {
		this.idTipoPersona = idEstatus;
	}
	
	public static TipoPersonaEnum getById(Integer id) {
	    for(TipoPersonaEnum e : values()) {
	        if(e.idTipoPersona.equals(id)) return e;
	    }
	    return null;
	}

	public Integer getIdTipoPersona() {
		return idTipoPersona;
	}

	public void setIdTipoPersona(Integer idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}	
	
	
}
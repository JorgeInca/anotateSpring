package com.mx.grupoTama.modelo.enums;

public enum TipoBandejaEnum {
	
	BANDEJA_REVOLVENTE		 	  (1,"Bandeja revolvente" 	  ,"bandejas/revolvente/bandejaRevolvente"   ),
	BANDEJA_VEH_COBUSTIBLE	 	  (2,"Registro combustible"   ,"bandejas/vehiculos/bandejaCombustible"   ),
	BANDEJA_VEH_MANTENIMIENTO	  (3,"Mantenimiento vehículos","bandejas/vehiculos/bandejaMantenimiento" ),
	BANDEJA_VEH_VEHICULOS 	 	  (4,"Vehículos"     		  ,"bandejas/vehiculos/bandejaVehiculos"	 ),
	BANDEJA_OP_OBRAS 		 	  (5,"Obras" 				  ,"bandejas/operaciones/bandejaObras"       ),
	BANDEJA_OP_RENTAS  		 	  (6,"Rentas" 				  ,"bandejas/operaciones/bandejaRentas"	     ),
	BANDEJA_OP_INVENTARIOS	 	  (7,"Inventario" 			  ,"bandejas/operaciones/bandejaInventarios" ),
	BANJDEJA_PERSONAS_CLIENTE	  (8,"Clientes"	 			  ,"bandejas/personas/bandejaClientes"	 ),
	BANJDEJA_PERSONAS_TRABAJADORES(9,"Empleados" 			  ,"bandejas/personas/bandejaEmpleados"	 );
	
	
	private TipoBandejaEnum(Integer idBandeja, String descripcion,
			String vistaBandeja) {
		this.idBandeja = idBandeja;
		this.descripcion = descripcion;
		this.vistaBandeja = vistaBandeja;
	}
	
	public static TipoBandejaEnum getById(Integer id) {
	    for(TipoBandejaEnum e : values()) {
	        if(e.idBandeja.equals(id)) return e;
	    }
	    return null;
	}
	
	private Integer idBandeja;
	private String descripcion;
	private String vistaBandeja;
	
	public Integer getIdBandeja() {
		return idBandeja;
	}
	public void setIdBandeja(Integer idBandeja) {
		this.idBandeja = idBandeja;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getVistaBandeja() {
		return vistaBandeja;
	}

	public void setVistaBandeja(String vistaBandeja) {
		this.vistaBandeja = vistaBandeja;
	}
	
		
}

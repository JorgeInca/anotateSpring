package com.mx.grupoTama.core.dao.querys;

import org.springframework.stereotype.Repository;

@Repository 
public class QuerysRevolvente{

	public static final String GET_REVOLVENTES = "SELECT R.* FROM REVOLVENTE R WHERE 1 = 1 ";
			
	public static final String GET_REVOLVENTES_ESTATUS = " and ESTATUS = :idEstatus ";
	
	public static final String GET_REVOLVENTES_AND_FECHA = " and FECHA_ALTA between :fechaInicio and :fechaFin ";
	
	public static final String GET_REVOLVENTES_AND_ID_OBRA = " and OBRA_ID = :idObra ";
	
	public static final String GET_REVOLVENTES_AND_ID_VEHICULO = "and VEHICULO_ID = :idVehiculo ";
	
	public static final String ID_REVOLVENTE = " and R.REVOLVENTE_ID  = :idRevolvente ";
	
	public static final String INSERT_REVOLVENTES = "INSERT INTO REVOLVENTE (DESCRIPCION,ES_INGRESO,MONTO,OBRA_ID,VEHICULO_ID,CANTIDAD) "
			+ "VALUES(:descripcion,:esIngreso,:monto, :idObra, :idVehiculo, :cantidad)"; 
	
	public static final String ACTUALIZA_REVOLVENTES = "UPDATE REVOLVENTE R SET "
			+ " R.DESCRIPCION = :descripcion, "
			+ " R.ES_INGRESO = :esIngreso, "
			+ " R.CANTIDAD = :cantidad, "
			+ " R.MONTO = :monto, "
			+ " R.OBRA_ID = :idObra, "
			+ " R.VEHICULO_ID = :idVehiculo "
			+ "	WHERE 1=1 "; 
	
	public static final String BAJA_REVOLVENTES = "UPDATE REVOLVENTE R SET "
			+ " R.ESTATUS = :idEstatus "
			+ "	WHERE 1 = 1 "; 

}

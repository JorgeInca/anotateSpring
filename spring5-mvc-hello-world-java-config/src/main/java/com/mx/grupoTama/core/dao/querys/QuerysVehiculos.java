package com.mx.grupoTama.core.dao.querys;

import org.springframework.stereotype.Repository;

@Repository 
public class QuerysVehiculos{

	public static final String GET_VEHICULOS = " SELECT V.* FROM VEHICULO V WHERE 1 = 1 ";
			
	public static final String GET_VEHICULOS_ESTATUS = " and V.ESTATUS = :idEstatus ";
	
	public static final String ID_VEHICULO = " and V.VEHICULO_ID  = :idVehiculo ";
	
	public static final String INSERT_VEHICULOS = "INSERT INTO VEHICULO (DESCRIPCION,MARCA,MODELO,COLOR,MATRICULA,ANIO,SERIE) "
			+ "VALUES(:descripcion,:marca,:modelo,:color,:matricula,:anio,:serie)"; 
	
	public static final String ACTUALIZA_VEHICULOS = "UPDATE VEHICULO V SET "
			+ " V.DESCRIPCION = :descripcion, "
			+ " V.MARCA = :marca, "
			+ " V.MODELO = :modelo, "
			+ " V.COLOR = :color, "
			+ " V.MATRICULA = :matricula, "
			+ " V.ANIO = :anio, "
			+ " V.SERIE = :serie "
			+ "	WHERE  1 = 1 "; 
	
	public static final String BAJA_VEHICULO = "UPDATE VEHICULO V SET "
			+ " V.ESTATUS = :idEstatus "
			+ "	WHERE 1 = 1 "; 

}

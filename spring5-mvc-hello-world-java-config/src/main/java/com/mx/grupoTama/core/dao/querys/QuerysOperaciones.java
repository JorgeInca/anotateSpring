package com.mx.grupoTama.core.dao.querys;

import org.springframework.stereotype.Repository;

@Repository 
public class QuerysOperaciones{

	public static final String GET_OBRAS = "SELECT O.OBRA_ID,O.NOMBRE,O.DIRECCION,CONCAT (P.NOMBRE,' ', P.APELLIDOS) AS NOMBRE_CLIENTE,P.TELEFONO,O.CLIENTE_ID,O.FECHA_INICIO FROM OBRA O INNER JOIN PERSONA P ON P.PERSONA_ID = O.CLIENTE_ID WHERE 1 = 1";
	
	public static final String GET_OBRAS_ESTATUS = " AND O.ESTATUS = :idEstatus ";
	
	public static final String ID_OBRA = " and O.OBRA_ID  = :idObra ";
	
	public static final String INSERT_OBRA = " INSERT INTO OBRA (NOMBRE,DIRECCION,CLIENTE_ID) "
			+ " VALUES (:nombre,:direccion,:idCliente);"; 
	
	public static final String ACTUALIZA_OBRA = " UPDATE OBRA O SET "
			+ " O.NOMBRE = :nombre, "
			+ " O.DIRECCION = :direccion, "
			+ " O.CLIENTE_ID = :idCliente "			
			+ "	WHERE 1 = 1 "; 
	
	public static final String BAJA_OBRA = "UPDATE OBRA O SET "
			+ " O.ESTATUS = :idEstatus "
			+ "	WHERE 1 = 1 "; 
	
	public static final String GET_INVENTARIOS = "SELECT I.* FROM INVENTARIO I WHERE 1 = 1 ";
	
	public static final String GET_INVENTARIOS_ESTATUS = " AND I.ESTATUS = :idEstatus ";
	
	public static final String ID_INVENTARIO = " and I.INVENTARIO_ID  = :idInventario ";
	
	public static final String INSERT_INVENTARIO = " INSERT INTO INVENTARIO (CANTIDAD,DESCRIPCION,PRECIO_UNITARIO,TOTAL) "
			+ " VALUES (:cantidad,:descripcion,:precioUnitario,:total);"; 
	
	public static final String ACTUALIZA_INVENTARIO = " UPDATE INVENTARIO I SET "
			+ " I.CANTIDAD = :cantidad, "
			+ " I.DESCRIPCION = :descripcion, "
			+ " I.PRECIO_UNITARIO = :precioUnitario, "
			+ " I.TOTAL = :total "		
			+ "	WHERE 1 = 1 "; 
	
	public static final String BAJA_INVENTARIO = "UPDATE INVENTARIO I SET "
			+ " I.ESTATUS = :idEstatus "
			+ "	WHERE 1 = 1 "; 
	
	public static final String UPDATE_EN_RENTA_INVENTARIO = "UPDATE INVENTARIO I SET "
			+ " I.EN_RENTA = :enRenta "
			+ "	WHERE 1 = 1 "; 

}

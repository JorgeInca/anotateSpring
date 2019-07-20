package com.mx.grupoTama.core.dao.querys;

import org.springframework.stereotype.Repository;

@Repository 
public class QuerysPersonas{

	public static final String GET_PERSONAS = "SELECT P.* FROM PERSONA P WHERE TIPO_PERSONA = :idTipoPersona "; 
	
	public static final String GET_PERSONAS_ESTATUS = " AND ESTATUS = :idEstatus ";
	
	public static final String INSERT_CLIENTE = " INSERT INTO PERSONA (TIPO_PERSONA,NOMBRE,APELLIDOS,DIRECCION,TELEFONO,FECHA_NACIMIENTO,EDAD,RFC,NOMBRE_EMPRESA,EMAIL) "
			+ " VALUES (:tipoPersona,:nombre,:apellidos,:direccion,:telefono,:fechaNacimiento,:edad,:rfc,:nombreEmpresa,:email);"; 
	
	public static final String INSERT_EMPLEADO = " INSERT INTO PERSONA (TIPO_PERSONA,NOMBRE,APELLIDOS,DIRECCION,TELEFONO,FECHA_NACIMIENTO,EDAD,NUMERO_EMPLEADO,EMAIL) "
			+ " VALUES (:tipoPersona,:nombre,:apellidos,:direccion,:telefono,:fechaNacimiento,:edad,:numeroEmpleado,:email);"; 
	
	public static final String ID_PERSONA = " and PERSONA_ID  = :idPersona ";

	public static final String ACTUALIZA_CLIENTE = "UPDATE PERSONA SET "
			+ " NOMBRE = :nombre, "
			+ " APELLIDOS = :apellidos, "
			+ " DIRECCION = :direccion, "
			+ " TELEFONO = :telefono, "
			+ " EMAIL = :email, "
			+ " FECHA_NACIMIENTO = :fechaNacimiento, "
			+ " EDAD = :edad, "
			+ " RFC = :rfc, "
			+ " NOMBRE_EMPRESA = :nombreEmpresa "
			+ "	WHERE PERSONA_ID = :idPersona "; 
	
	public static final String ACTUALIZA_EMPLEADO = "UPDATE PERSONA SET "
			+ " NOMBRE = :nombre, "
			+ " APELLIDOS = :apellidos, "
			+ " DIRECCION = :direccion, "
			+ " TELEFONO = :telefono, "
			+ " EMAIL = :email, "
			+ " FECHA_NACIMIENTO = :fechaNacimiento, "
			+ " EDAD = :edad, "
			+ " NUMERO_EMPLEADO = :numeroEmpleado "			
			+ "	WHERE PERSONA_ID = :idPersona ";
	
	public static final String BAJA_PERSONA = "UPDATE PERSONA SET "
			+ " ESTATUS = :idEstatus "
			+ "	WHERE PERSONA_ID = :idPersona "; 

}

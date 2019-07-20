package com.mx.grupoTama.modelo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.grupoTama.modelo.Empleado;

public class EmpleadoRowMapper implements RowMapper<Empleado> {
	
	@Override
	public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Empleado cliente = new Empleado();
		cliente.setIdPersona((rs.getLong("PERSONA_ID")));
		cliente.setTipoPersona((rs.getInt("TIPO_PERSONA")));
		cliente.setNombre((rs.getString("NOMBRE")));
		cliente.setApellidos((rs.getString("APELLIDOS")));
		cliente.setDireccion((rs.getString("DIRECCION")));
		cliente.setTelefono((rs.getString("TELEFONO")));
		cliente.setFechaNacimiento((rs.getDate("FECHA_NACIMIENTO")));
		cliente.setEmail(rs.getString("EMAIL"));
		cliente.setEdad((rs.getInt("EDAD")));
		cliente.setNumeroEmpleado(rs.getString("NUMERO_EMPLEADO"));
		
	    return cliente;
	}	

}
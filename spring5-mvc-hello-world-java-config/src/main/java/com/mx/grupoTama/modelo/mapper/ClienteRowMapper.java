package com.mx.grupoTama.modelo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.grupoTama.modelo.Cliente;

public class ClienteRowMapper implements RowMapper<Cliente> {
	
	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cliente cliente = new Cliente();
		cliente.setIdPersona((rs.getLong("PERSONA_ID")));
		cliente.setTipoPersona((rs.getInt("TIPO_PERSONA")));
		cliente.setNombre((rs.getString("NOMBRE")));
		cliente.setApellidos((rs.getString("APELLIDOS")));
		cliente.setDireccion((rs.getString("DIRECCION")));
		cliente.setTelefono((rs.getString("TELEFONO")));
		cliente.setFechaNacimiento((rs.getDate("FECHA_NACIMIENTO")));
		cliente.setEmail(rs.getString("EMAIL"));
		cliente.setEdad((rs.getInt("EDAD")));
		cliente.setRfc((rs.getString("RFC")));
		cliente.setNombreEmpresa((rs.getString("NOMBRE_EMPRESA")));
		
	    return cliente;
	}	

}
package com.mx.grupoTama.modelo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.grupoTama.modelo.Obra;

public class ObraRowMapper implements RowMapper<Obra> {
	
	@Override
	public Obra mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Obra obra = new Obra();
		obra.setIdObra(rs.getLong("OBRA_ID"));
		obra.setNombre(rs.getString("NOMBRE"));
		obra.setDireccion(rs.getString("DIRECCION"));
		obra.setIdCliente(rs.getLong("CLIENTE_ID"));
		obra.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
		obra.setTelefonoCliente(rs.getString("TELEFONO"));
		obra.setFechaInicio( rs.getDate("FECHA_INICIO"));
	    return obra;
	}	
	
}

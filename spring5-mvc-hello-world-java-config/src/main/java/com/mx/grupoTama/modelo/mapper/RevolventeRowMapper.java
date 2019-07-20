package com.mx.grupoTama.modelo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.grupoTama.modelo.Revolvente;

public class RevolventeRowMapper implements RowMapper<Revolvente> {
	
	@Override
	public Revolvente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Revolvente revolvente = new Revolvente();
		revolvente.setIdRevolvente(rs.getLong("REVOLVENTE_ID"));
		revolvente.setCantidad(rs.getInt("CANTIDAD"));
		revolvente.setDescripcion(rs.getString("DESCRIPCION"));
		revolvente.setEsIngreso(rs.getBoolean("ES_INGRESO"));
		revolvente.setMonto(rs.getFloat("MONTO"));
		revolvente.setFecha(rs.getTimestamp("FECHA_ALTA"));
		revolvente.setIdObra(rs.getLong("OBRA_ID"));
		revolvente.setIdVehiculo(rs.getLong("VEHICULO_ID"));
		
	    return revolvente;
	}	

}
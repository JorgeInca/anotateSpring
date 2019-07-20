package com.mx.grupoTama.modelo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.grupoTama.modelo.Vehiculo;

public class VehiculoRowMapper implements RowMapper<Vehiculo> {
	
	@Override
	public Vehiculo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setIdVehiculo(rs.getLong("VEHICULO_ID"));
		vehiculo.setDescripcion(rs.getString("DESCRIPCION"));
		vehiculo.setMarca(rs.getString("MARCA"));
		vehiculo.setModelo(rs.getString("MODELO"));
		vehiculo.setColor(rs.getString("MODELO"));
		vehiculo.setMatricula(rs.getString("MATRICULA"));
		vehiculo.setAnio(rs.getInt("ANIO"));
		
	    return vehiculo;
	}	

}
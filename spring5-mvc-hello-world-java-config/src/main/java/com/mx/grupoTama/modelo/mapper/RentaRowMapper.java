package com.mx.grupoTama.modelo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.grupoTama.modelo.Renta;

public class RentaRowMapper implements RowMapper<Renta> {
	
	@Override
	public Renta mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Renta renta = new Renta();
		renta.setIdRenta(rs.getLong("RENTA_ID"));
		renta.setIdEmpleado(rs.getLong("EMPLEADO_ID"));
		renta.setDescripcion(rs.getString("DESCRIPCION"));
		renta.setFechaAlta(rs.getDate("FECHA_ALTA"));
		renta.setFechaInicio(rs.getDate("FECHA_INICIO"));
		renta.setFechaFin(rs.getDate("FECHA_FINAL"));
		renta.setEstatus(rs.getInt("ESTATUS"));

		
	    return renta;
	}	

}
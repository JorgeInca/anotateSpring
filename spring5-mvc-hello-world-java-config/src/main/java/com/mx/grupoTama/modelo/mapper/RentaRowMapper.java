package com.mx.grupoTama.modelo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.grupoTama.modelo.Renta;

public class RentaRowMapper implements RowMapper<Renta> {
	
	@Override
	public Renta mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Renta renta = new Renta();
//		renta.setIdRenta(rs.getLong("INVENTARIO_ID"));
//		renta.setCantidad(rs.getInt("CANTIDAD"));
//		renta.setDescripcion(rs.getString("DESCRIPCION"));
//		renta.setEnRenta(rs.getLong("EN_RENTA"));
//		renta.setPrecioUnitario(rs.getFloat("PRECIO_UNITARIO"));
//		renta.setTotal(rs.getFloat("TOTAL"));
//		renta.setFechaAlta(rs.getDate("FECHA_ALTA"));
		
	    return renta;
	}	

}
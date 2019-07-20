package com.mx.grupoTama.modelo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.grupoTama.modelo.Inventario;

public class InventarioRowMapper implements RowMapper<Inventario> {
	
	@Override
	public Inventario mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Inventario inventario = new Inventario();
		inventario.setIdInventario(rs.getLong("INVENTARIO_ID"));
		inventario.setCantidad(rs.getInt("CANTIDAD"));
		inventario.setDescripcion(rs.getString("DESCRIPCION"));
		inventario.setEnRenta(rs.getLong("EN_RENTA"));
		inventario.setPrecioUnitario(rs.getFloat("PRECIO_UNITARIO"));
		inventario.setTotal(rs.getFloat("TOTAL"));
		inventario.setFechaAlta(rs.getDate("FECHA_ALTA"));
		
	    return inventario;
	}	

}
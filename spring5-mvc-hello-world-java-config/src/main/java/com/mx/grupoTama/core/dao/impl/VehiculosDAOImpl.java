package com.mx.grupoTama.core.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mx.grupoTama.config.BasicDAO;
import com.mx.grupoTama.core.dao.VehiculosDAO;
import com.mx.grupoTama.core.dao.querys.QuerysVehiculos;
import com.mx.grupoTama.modelo.Vehiculo;
import com.mx.grupoTama.modelo.enums.EstatusEnum;
import com.mx.grupoTama.modelo.mapper.VehiculoRowMapper;

@Repository 
public class VehiculosDAOImpl extends BasicDAO implements VehiculosDAO{

	@Autowired
	DataSource datasource;
	
	@Override
	public List<Vehiculo> getVehiculos() throws Exception{
		System.out.println("DAO - getVehiculos");
		
		String sql = QuerysVehiculos.GET_VEHICULOS;
		sql = sql + QuerysVehiculos.GET_VEHICULOS_ESTATUS;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idEstatus", EstatusEnum.ACTIVO.getIdEstatus());
			
		return getNamedJdbcTemplate().query(sql,parameters,new VehiculoRowMapper());
	}
	
	@Override
	public void insertaVehiculo(Vehiculo vehiculo) throws Exception{
		System.out.println("DAO - insertaVehiculo");
		
		String sql = QuerysVehiculos.INSERT_VEHICULOS;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("descripcion", vehiculo.getDescripcion());
		parameters.put("marca", vehiculo.getMarca());
		parameters.put("modelo", vehiculo.getModelo());
		parameters.put("color", vehiculo.getColor());
		parameters.put("matricula", vehiculo.getMatricula());
		parameters.put("anio", vehiculo.getAnio());
		
		getNamedJdbcTemplate().update(sql,parameters);

	}

	@Override
	public void actualizaVehiculo(Vehiculo vehiculo) throws Exception{
		System.out.println("DAO - actualizaVehiculo");
		
		String sql = QuerysVehiculos.ACTUALIZA_VEHICULOS;
		sql = sql + QuerysVehiculos.ID_VEHICULO;

		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("descripcion", vehiculo.getDescripcion());
		parameters.put("marca", vehiculo.getMarca());
		parameters.put("modelo", vehiculo.getModelo());
		parameters.put("color", vehiculo.getColor());
		parameters.put("matricula", vehiculo.getMatricula());
		parameters.put("anio", vehiculo.getAnio());
		parameters.put("idVehiculo", vehiculo.getIdVehiculo());
		
		getNamedJdbcTemplate().update(sql,parameters);
		
	}
	
	@Override
	public void eliminaVehiculo(Integer idVehiculo) throws Exception{
		System.out.println("DAO - bajaVehiculo");
		
		String sql = QuerysVehiculos.BAJA_VEHICULO;
		sql = sql + QuerysVehiculos.ID_VEHICULO;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idVehiculo", idVehiculo);
		parameters.put("idEstatus", EstatusEnum.CANCELADO.getIdEstatus());

		getNamedJdbcTemplate().update(sql,parameters);
		
	}

	@Override
	public Vehiculo getVehiculoById(Integer idVehiculo) throws Exception {
		System.out.println("DAO - getVehiculoById");
		
		String sql = QuerysVehiculos.GET_VEHICULOS;
		sql = sql + QuerysVehiculos.ID_VEHICULO;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idVehiculo", idVehiculo);
			
		List<Vehiculo> listaVehiculos = new ArrayList<>();
				
		listaVehiculos = getNamedJdbcTemplate().query(sql,parameters,new VehiculoRowMapper());
		
		if(listaVehiculos.size()>0){
			return listaVehiculos.get(0);
		}
		return new Vehiculo();
	}

}

package com.mx.grupoTama.core.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mx.grupoTama.config.BasicDAO;
import com.mx.grupoTama.core.dao.RevolventesDAO;
import com.mx.grupoTama.core.dao.querys.QuerysRevolvente;
import com.mx.grupoTama.modelo.Revolvente;
import com.mx.grupoTama.modelo.criteria.RevolventeCriteria;
import com.mx.grupoTama.modelo.enums.EstatusEnum;
import com.mx.grupoTama.modelo.mapper.RevolventeRowMapper;

@Repository 
public class RevolventesDAOImpl extends BasicDAO implements RevolventesDAO{

	@Autowired
	DataSource datasource;
	
	@Override
	public List<Revolvente> getRevolventes(RevolventeCriteria criteria) throws Exception{
		System.out.println("DAO - getRevolventes");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		String sql = "";
		
		parameters.put("idEstatus", EstatusEnum.ACTIVO.getIdEstatus());
		
		if(criteria != null && !criteria.isEmpty() ){ //Criteria
			sql = QuerysRevolvente.GET_REVOLVENTES;
			sql = sql + QuerysRevolvente.GET_REVOLVENTES_ESTATUS;
			
			if( !criteria.getFechaInicio().equals("") && !criteria.getFechaFin().equals("")){
				
				sql = sql + QuerysRevolvente.GET_REVOLVENTES_AND_FECHA;
				
				parameters.put("fechaInicio", criteria.getFechaInicio());
				parameters.put("fechaFin", criteria.getFechaFin());
			}
			
			if(criteria.getIdObra()>0){
				sql = sql + QuerysRevolvente.GET_REVOLVENTES_AND_ID_OBRA;
				parameters.put("idObra", criteria.getIdObra());
			}
			if(criteria.getIdVehiculo()>0){
				sql = sql + QuerysRevolvente.GET_REVOLVENTES_AND_ID_VEHICULO;
				parameters.put("idVehiculo", criteria.getIdVehiculo());
			}
		}else{ //All
			sql = QuerysRevolvente.GET_REVOLVENTES;
			sql = sql + QuerysRevolvente.GET_REVOLVENTES_ESTATUS;
		}
		
			
		return getNamedJdbcTemplate().query(sql,parameters,new RevolventeRowMapper());
	}
	
	@Override
	public Revolvente getRevolventeById(Integer idRevolvente) throws Exception{
		System.out.println("DAO - getRevolventeById");
		
		String sql = QuerysRevolvente.GET_REVOLVENTES;
		sql = sql + QuerysRevolvente.ID_REVOLVENTE;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idRevolvente", idRevolvente);
			
		List<Revolvente> listaRevolventes = new ArrayList<>();
				
		listaRevolventes = getNamedJdbcTemplate().query(sql,parameters,new RevolventeRowMapper());
		
		if(listaRevolventes.size()>0){
			return listaRevolventes.get(0);
		}
		return new Revolvente();
	}
	
	@Override
	public void insertaRevolvente(Revolvente revolvente) throws Exception{
		System.out.println("DAO - insertaRevolvente");
		
		String sql = QuerysRevolvente.INSERT_REVOLVENTES;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("descripcion", revolvente.getDescripcion());
		parameters.put("cantidad", revolvente.getCantidad());
		parameters.put("esIngreso", revolvente.isEsIngreso());
		parameters.put("monto", revolvente.getMonto());
		parameters.put("idObra", revolvente.getIdObra());
		parameters.put("idVehiculo", revolvente.getIdVehiculo());
		
		getNamedJdbcTemplate().update(sql,parameters);

	}

	@Override
	public void actualizaRevolvente(Revolvente revolvente) throws Exception{
		System.out.println("DAO - actualizaRevolvente");
		
		String sql = QuerysRevolvente.ACTUALIZA_REVOLVENTES;
		sql = sql + QuerysRevolvente.ID_REVOLVENTE;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idRevolvente", revolvente.getIdRevolvente());
		parameters.put("descripcion", revolvente.getDescripcion());
		parameters.put("cantidad", revolvente.getCantidad());
		parameters.put("esIngreso", revolvente.isEsIngreso());
		parameters.put("monto", revolvente.getMonto());
		parameters.put("idObra", revolvente.getIdObra());
		parameters.put("idVehiculo", revolvente.getIdVehiculo());
		
		getNamedJdbcTemplate().update(sql,parameters);
		
	}
	
	@Override
	public void eliminaRevolvente(Integer idRevolvente) throws Exception{
		System.out.println("DAO - bajaRevolvente");
		
		String sql = QuerysRevolvente.BAJA_REVOLVENTES;
		sql = sql + QuerysRevolvente.ID_REVOLVENTE;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idRevolvente", idRevolvente);
		parameters.put("idEstatus", EstatusEnum.CANCELADO.getIdEstatus());

		getNamedJdbcTemplate().update(sql,parameters);
		
	}


}

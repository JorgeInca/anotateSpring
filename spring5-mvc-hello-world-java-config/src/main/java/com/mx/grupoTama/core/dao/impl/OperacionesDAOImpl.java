package com.mx.grupoTama.core.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mx.grupoTama.config.BasicDAO;
import com.mx.grupoTama.core.dao.OperacionesDAO;
import com.mx.grupoTama.core.dao.querys.QuerysOperaciones;
import com.mx.grupoTama.modelo.Inventario;
import com.mx.grupoTama.modelo.Obra;
import com.mx.grupoTama.modelo.Renta;
import com.mx.grupoTama.modelo.enums.EstatusEnum;
import com.mx.grupoTama.modelo.mapper.InventarioRowMapper;
import com.mx.grupoTama.modelo.mapper.ObraRowMapper;
import com.mx.grupoTama.modelo.mapper.RentaRowMapper;

@Repository 
public class OperacionesDAOImpl extends BasicDAO implements OperacionesDAO{

	@Autowired
	DataSource datasource;
	
	@Override
	public List<Obra> getObras() throws Exception{
		System.out.println("DAO - getObras");
		
		String sql = QuerysOperaciones.GET_OBRAS;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idEstatus", EstatusEnum.ACTIVO.getIdEstatus());
			
		return getNamedJdbcTemplate().query(sql,parameters,new ObraRowMapper());
	}
	
	@Override
	public Obra getObraById(Integer idObra) {
		
		System.out.println("DAO - getObraById");
		
		String sql = QuerysOperaciones.GET_OBRAS;
		sql = sql + QuerysOperaciones.ID_OBRA;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idObra", idObra);
					
		List<Obra> listaObras = new ArrayList<>();
				
		listaObras = getNamedJdbcTemplate().query(sql,parameters,new ObraRowMapper());
		
		if(listaObras.size()>0){
			return listaObras.get(0);
		}
		return new Obra();
	}
	
	@Override
	public void insertaObra(Obra obra) throws Exception{
		System.out.println("DAO - insertaObra");
		
		String sql = QuerysOperaciones.INSERT_OBRA;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("nombre", obra.getNombre());
		parameters.put("direccion", obra.getDireccion());
		parameters.put("idCliente", obra.getIdCliente());
		
		getNamedJdbcTemplate().update(sql,parameters);

	}

	@Override
	public void actualizaObra(Obra obra) throws Exception{
		System.out.println("DAO - actualizaObra");
		
		String sql = QuerysOperaciones.ACTUALIZA_OBRA;
		sql = sql + QuerysOperaciones.ID_OBRA;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		
		parameters.put("idObra", obra.getIdObra());
		
		parameters.put("nombre", obra.getNombre());
		parameters.put("direccion", obra.getDireccion());
		parameters.put("idCliente", obra.getIdCliente());

		getNamedJdbcTemplate().update(sql,parameters);
		
	}
	
	@Override
	public void eliminaObra(Integer idObra) throws Exception{
		System.out.println("DAO - bajaObra");
		
		String sql = QuerysOperaciones.BAJA_OBRA;
		sql = sql + QuerysOperaciones.ID_OBRA;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idObra", idObra);
		parameters.put("idEstatus", EstatusEnum.CANCELADO.getIdEstatus());

		getNamedJdbcTemplate().update(sql,parameters);
		
	}
	
	@Override
	public List<Inventario> getInventarios() throws Exception{
		
		System.out.println("DAO - getInventarios");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idEstatus", EstatusEnum.ACTIVO.getIdEstatus());
		
		String sql = "";
		
		if(false){
			
		}else{ //All
			sql = QuerysOperaciones.GET_INVENTARIOS;
			sql = sql + QuerysOperaciones.GET_INVENTARIOS_ESTATUS;
		}
		
					
		return getNamedJdbcTemplate().query(sql,parameters,new InventarioRowMapper());
	}
	
	@Override
	public void insertaInventario(Inventario inventario) throws Exception{
		System.out.println("DAO - insertaInventario");
		
		String sql = QuerysOperaciones.INSERT_INVENTARIO;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		
		parameters.put("cantidad", inventario.getCantidad());
		parameters.put("descripcion", inventario.getDescripcion());
		parameters.put("precioUnitario", inventario.getPrecioUnitario());
		parameters.put("total", inventario.getTotal());
		
		getNamedJdbcTemplate().update(sql,parameters);

	}

	@Override
	public void actualizaInventario(Inventario inventario) throws Exception{
		System.out.println("DAO - actualizaInventario");
		
		String sql = QuerysOperaciones.ACTUALIZA_INVENTARIO;
		sql = sql + QuerysOperaciones.ID_INVENTARIO;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idInventario", inventario.getIdInventario());
		
		parameters.put("cantidad", inventario.getCantidad());
		parameters.put("descripcion", inventario.getDescripcion());
		parameters.put("precioUnitario", inventario.getPrecioUnitario());
		parameters.put("total", inventario.getTotal());
		
		getNamedJdbcTemplate().update(sql,parameters);
		
	}

	@Override
	public Inventario getInventarioById(Long idInventario) {
		
		System.out.println("DAO - getInventarioById");
		
		String sql = QuerysOperaciones.GET_INVENTARIOS;
		sql = sql + QuerysOperaciones.ID_INVENTARIO;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idInventario", idInventario);
			
		List<Inventario> listaInventarios = new ArrayList<>();
				
		listaInventarios = getNamedJdbcTemplate().query(sql,parameters,new InventarioRowMapper());
		
		if(listaInventarios.size()>0){
			return listaInventarios.get(0);
		}
		return new Inventario();
	}
	
	@Override
	public void eliminaInventario(Integer idInventario) throws Exception{
		System.out.println("DAO - eliminaInventario");
		
		String sql = QuerysOperaciones.BAJA_INVENTARIO;
		sql = sql + QuerysOperaciones.ID_INVENTARIO;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idInventario", idInventario);
		parameters.put("idEstatus", EstatusEnum.CANCELADO.getIdEstatus());

		getNamedJdbcTemplate().update(sql,parameters);
		
	}
	
	@Override
	public List<Renta> getRentas() throws Exception{
		
		System.out.println("DAO - getRentas");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idEstatus", EstatusEnum.ACTIVO.getIdEstatus());
		
		String sql = "";
		
		if(false){
			
		}else{ //All
			sql = QuerysOperaciones.GET_RENTAS;
			sql = sql + QuerysOperaciones.GET_RENTAS_ESTATUS;
		}
		
					
		return getNamedJdbcTemplate().query(sql,parameters,new RentaRowMapper());
	}
	
	@Override
	public void insertaRenta(Renta renta) throws Exception{
		System.out.println("DAO - insertaRenta");
		
		String sql = QuerysOperaciones.INSERT_RENTA;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		
//		parameters.put("cantidad", renta.getCantidad());
//		parameters.put("descripcion", renta.getDescripcion());
//		parameters.put("precioUnitario", renta.getPrecioUnitario());
//		parameters.put("total", renta.getTotal());
		
		getNamedJdbcTemplate().update(sql,parameters);

	}

	@Override
	public void actualizaRenta(Renta renta) throws Exception{
		System.out.println("DAO - actualizaRenta");
		
		String sql = QuerysOperaciones.ACTUALIZA_RENTA;
		sql = sql + QuerysOperaciones.ID_RENTA;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idRenta", renta.getIdRenta());
		
//		parameters.put("cantidad", renta.getCantidad());
//		parameters.put("descripcion", renta.getDescripcion());
//		parameters.put("precioUnitario", renta.getPrecioUnitario());
//		parameters.put("total", renta.getTotal());
		
		getNamedJdbcTemplate().update(sql,parameters);
		
	}

	@Override
	public Renta getRentaById(Long idRenta) {
		
		System.out.println("DAO - getRentaById");
		
		String sql = QuerysOperaciones.GET_RENTAS;
		sql = sql + QuerysOperaciones.ID_RENTA;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idRenta", idRenta);
			
		List<Renta> listaRentas = new ArrayList<>();
				
		listaRentas = getNamedJdbcTemplate().query(sql,parameters,new RentaRowMapper());
		
		if(listaRentas.size()>0){
			return listaRentas.get(0);
		}
		return new Renta();
	}
	
	@Override
	public void eliminaRenta(Integer idRenta) throws Exception{
		System.out.println("DAO - eliminaRenta");
		
		String sql = QuerysOperaciones.BAJA_RENTA;
		sql = sql + QuerysOperaciones.ID_RENTA;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idRenta", idRenta);
		parameters.put("idEstatus", EstatusEnum.CANCELADO.getIdEstatus());

		getNamedJdbcTemplate().update(sql,parameters);
		
	}

}

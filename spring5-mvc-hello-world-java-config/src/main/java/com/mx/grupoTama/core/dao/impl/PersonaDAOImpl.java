package com.mx.grupoTama.core.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mx.grupoTama.config.BasicDAO;
import com.mx.grupoTama.core.dao.PersonaDAO;
import com.mx.grupoTama.core.dao.querys.QuerysPersonas;
import com.mx.grupoTama.modelo.Cliente;
import com.mx.grupoTama.modelo.Empleado;
import com.mx.grupoTama.modelo.enums.EstatusEnum;
import com.mx.grupoTama.modelo.enums.TipoPersonaEnum;
import com.mx.grupoTama.modelo.mapper.ClienteRowMapper;
import com.mx.grupoTama.modelo.mapper.EmpleadoRowMapper;

@Repository 
public class PersonaDAOImpl extends BasicDAO implements PersonaDAO{

	@Autowired
	DataSource datasource;
	
	@Override
	public List<Cliente> getClientes() throws Exception{
		
		System.out.println("DAO - getClientes");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idEstatus", EstatusEnum.ACTIVO.getIdEstatus());
		parameters.put("idTipoPersona", TipoPersonaEnum.CLIENTE.getIdTipoPersona());
		
		String sql = "";
		
		if(false){
			
		}else{ //All
			sql = QuerysPersonas.GET_PERSONAS;
			sql = sql + QuerysPersonas.GET_PERSONAS_ESTATUS;
		}
		
					
		return getNamedJdbcTemplate().query(sql,parameters,new ClienteRowMapper());
	}
	
	@Override
	public void insertaCliente(Cliente cliente) throws Exception{
		System.out.println("DAO - insertaCliente");
		
		String sql = QuerysPersonas.INSERT_CLIENTE;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		cliente.setFechaString(cliente.getFechaString());
		
		parameters.put("tipoPersona", TipoPersonaEnum.CLIENTE.getIdTipoPersona());
		parameters.put("nombre", cliente.getNombre());
		parameters.put("apellidos", cliente.getApellidos());
		parameters.put("direccion", cliente.getDireccion());
		parameters.put("telefono", cliente.getTelefono());
		parameters.put("email", cliente.getEmail());
		parameters.put("fechaNacimiento", cliente.getFechaNacimiento());
		parameters.put("edad", cliente.getEdad());
		parameters.put("rfc", cliente.getRfc());
		parameters.put("nombreEmpresa", cliente.getNombreEmpresa());
		
		getNamedJdbcTemplate().update(sql,parameters);

	}

	@Override
	public void actualizaCliente(Cliente cliente) throws Exception{
		System.out.println("DAO - actualizaCliente");
		
		String sql = QuerysPersonas.ACTUALIZA_CLIENTE;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		cliente.setFechaString(cliente.getFechaString());
		
		parameters.put("nombre", cliente.getNombre());
		parameters.put("apellidos", cliente.getApellidos());
		parameters.put("direccion", cliente.getDireccion());
		parameters.put("telefono", cliente.getTelefono());
		parameters.put("email", cliente.getEmail());
		parameters.put("fechaNacimiento", cliente.getFechaNacimiento());
		parameters.put("edad", cliente.getEdad());
		parameters.put("rfc", cliente.getRfc());
		parameters.put("nombreEmpresa", cliente.getNombreEmpresa());
		parameters.put("idPersona", cliente.getIdPersona());
		getNamedJdbcTemplate().update(sql,parameters);
		
	}

	@Override
	public Cliente getClienteById(Integer idCliente) {
		
		System.out.println("DAO - getClienteById");
		
		String sql = QuerysPersonas.GET_PERSONAS;
		sql = sql + QuerysPersonas.ID_PERSONA;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idPersona", idCliente);
		parameters.put("idTipoPersona", TipoPersonaEnum.CLIENTE.getIdTipoPersona());
			
		List<Cliente> listaClientes = new ArrayList<>();
				
		listaClientes = getNamedJdbcTemplate().query(sql,parameters,new ClienteRowMapper());
		
		if(listaClientes.size()>0){
			return listaClientes.get(0);
		}
		return new Cliente();
	}
	
	@Override
	public List<Empleado> getEmpleados() throws Exception{
		
		System.out.println("DAO - getEmpleados");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idEstatus", EstatusEnum.ACTIVO.getIdEstatus());
		parameters.put("idTipoPersona", TipoPersonaEnum.EMPLEADO.getIdTipoPersona());
		
		String sql = "";
		
		if(false){
			
		}else{ //All
			sql = QuerysPersonas.GET_PERSONAS;
			sql = sql + QuerysPersonas.GET_PERSONAS_ESTATUS;
		}
		
					
		return getNamedJdbcTemplate().query(sql,parameters,new EmpleadoRowMapper());
	}
	
	@Override
	public void insertaEmpleado(Empleado cliente) throws Exception{
		System.out.println("DAO - insertaEmpleado");
		
		String sql = QuerysPersonas.INSERT_EMPLEADO;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		cliente.setFechaString(cliente.getFechaString());
		
		parameters.put("tipoPersona", TipoPersonaEnum.EMPLEADO.getIdTipoPersona());
		parameters.put("nombre", cliente.getNombre());
		parameters.put("apellidos", cliente.getApellidos());
		parameters.put("direccion", cliente.getDireccion());
		parameters.put("telefono", cliente.getTelefono());
		parameters.put("email", cliente.getEmail());
		parameters.put("fechaNacimiento", cliente.getFechaNacimiento());
		parameters.put("edad", cliente.getEdad());
		parameters.put("numeroEmpleado", cliente.getNumeroEmpleado());
		
		getNamedJdbcTemplate().update(sql,parameters);

	}

	@Override
	public void actualizaEmpleado(Empleado cliente) throws Exception{
		System.out.println("DAO - actualizaEmpleado");
		
		String sql = QuerysPersonas.ACTUALIZA_EMPLEADO;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		cliente.setFechaString(cliente.getFechaString());
		
		parameters.put("nombre", cliente.getNombre());
		parameters.put("apellidos", cliente.getApellidos());
		parameters.put("direccion", cliente.getDireccion());
		parameters.put("telefono", cliente.getTelefono());
		parameters.put("email", cliente.getEmail());
		parameters.put("fechaNacimiento", cliente.getFechaNacimiento());
		parameters.put("edad", cliente.getEdad());
		parameters.put("numeroEmpleado", cliente.getNumeroEmpleado());
		parameters.put("idPersona", cliente.getIdPersona());
		getNamedJdbcTemplate().update(sql,parameters);
		
	}

	@Override
	public Empleado getEmpleadoById(Integer idEmpleado) {
		
		System.out.println("DAO - getEmpleadoById");
		
		String sql = QuerysPersonas.GET_PERSONAS;
		sql = sql + QuerysPersonas.ID_PERSONA;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idPersona", idEmpleado);
		parameters.put("idTipoPersona", TipoPersonaEnum.EMPLEADO.getIdTipoPersona());
			
		List<Empleado> listaEmpleados = new ArrayList<>();
				
		listaEmpleados = getNamedJdbcTemplate().query(sql,parameters,new EmpleadoRowMapper());
		
		if(listaEmpleados.size()>0){
			return listaEmpleados.get(0);
		}
		return new Empleado();
	}

	
	@Override
	public void eliminaPersona(Integer idPersona) throws Exception{
		System.out.println("DAO - bajaPersona");
		
		String sql = QuerysPersonas.BAJA_PERSONA;
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("idPersona", idPersona);
		parameters.put("idEstatus", EstatusEnum.CANCELADO.getIdEstatus());

		getNamedJdbcTemplate().update(sql,parameters);
		
	}
	
	

}

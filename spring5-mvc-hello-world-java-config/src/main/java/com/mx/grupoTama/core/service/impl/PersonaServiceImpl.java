package com.mx.grupoTama.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.grupoTama.core.dao.PersonaDAO;
import com.mx.grupoTama.core.service.PersonaService;
import com.mx.grupoTama.modelo.Cliente;
import com.mx.grupoTama.modelo.Empleado;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaDAO dao;

	@Override
	public List<Cliente> getClientes() throws Exception{
		System.out.println("Service - getClientes");
		return dao.getClientes();
	}

	@Override
	public void insertaCliente(Cliente Cliente) throws Exception{
		System.out.println("Service - insertaCliente");
		dao.insertaCliente(Cliente);
	}

	@Override
	public void actualizaCliente(Cliente Cliente) throws Exception{
		System.out.println("Service - actualizaCliente");
		dao.actualizaCliente(Cliente);
	}

	@Override
	public Cliente getClienteById(Integer idCliente) {
		System.out.println("Service - getClienteById");
		return dao.getClienteById(idCliente);
	}

	@Override
	public List<Empleado> getEmpleados() throws Exception{
		System.out.println("Service - getEmpleados");
		return dao.getEmpleados();
	}

	@Override
	public void insertaEmpleado(Empleado Empleado) throws Exception{
		System.out.println("Service - insertaEmpleado");
		dao.insertaEmpleado(Empleado);
	}

	@Override
	public void actualizaEmpleado(Empleado Empleado) throws Exception{
		System.out.println("Service - actualizaEmpleado");
		dao.actualizaEmpleado(Empleado);
	}

	@Override
	public Empleado getEmpleadoById(Integer idEmpleado) throws Exception{
		System.out.println("Service - getEmpleadoById");
		return dao.getEmpleadoById(idEmpleado);
	}
	
	@Override
	public void eliminaPersona(Integer idCliente) throws Exception {
		dao.eliminaPersona(idCliente);		
	}

}

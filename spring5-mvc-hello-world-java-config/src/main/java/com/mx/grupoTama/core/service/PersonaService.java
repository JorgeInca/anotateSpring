package com.mx.grupoTama.core.service;

import java.util.List;

import com.mx.grupoTama.modelo.Cliente;
import com.mx.grupoTama.modelo.Empleado;

public interface PersonaService {
	//Clientes
	public List<Cliente> getClientes() throws Exception;	
	public Cliente getClienteById(Integer idCliente);	
	public void insertaCliente(Cliente Cliente) throws Exception;
	public void actualizaCliente(Cliente Cliente) throws Exception;
	
	//Empleados
	public List<Empleado> getEmpleados() throws Exception;
	public Empleado getEmpleadoById(Integer idEmpleado) throws Exception;
	public void insertaEmpleado(Empleado Empleado) throws Exception;
	public void actualizaEmpleado(Empleado Empleado) throws Exception;
	
	//Personas
	public void eliminaPersona(Integer Empleado) throws Exception;
	
}

package com.mx.grupoTama.core.dao;

import java.util.List;

import com.mx.grupoTama.modelo.Cliente;
import com.mx.grupoTama.modelo.Empleado;

public interface PersonaDAO {
	//Clientes
	public List<Cliente> getClientes() throws Exception;
	public void insertaCliente(Cliente cliente) throws Exception;
	public Cliente getClienteById(Integer idCliente);
	public void actualizaCliente(Cliente cliente) throws Exception;
	
	//Empleados
	public List<Empleado> getEmpleados() throws Exception;
	public void insertaEmpleado(Empleado cliente) throws Exception;
	public Empleado getEmpleadoById(Integer idEmpleado) throws Exception;
	public void actualizaEmpleado(Empleado cliente) throws Exception;
	
	//Personas
	public void eliminaPersona(Integer idPersona) throws Exception;
	
}

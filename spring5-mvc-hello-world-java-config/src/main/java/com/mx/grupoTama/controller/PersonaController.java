
package com.mx.grupoTama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mx.grupoTama.core.service.PersonaService;
import com.mx.grupoTama.modelo.Cliente;
import com.mx.grupoTama.modelo.Empleado;

@Controller
public class PersonaController {
	
	@Autowired
	PersonaService personaService;

	@RequestMapping("/doGuardaCliente")
	public @ResponseBody String doGuardaCliente(@RequestParam("cliente") String clienteJson,@RequestParam("esNuevo") String esNuevo) throws Exception{

		System.out.println("MVC - doGuardaCliente =" + clienteJson);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		Cliente cliente = gson.fromJson(clienteJson, Cliente.class);
		
		if( Integer.parseInt(esNuevo) == 1){
			personaService.insertaCliente(cliente);			
		}else{
			personaService.actualizaCliente(cliente);			
		}
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/doEliminaCliente")
	public @ResponseBody String doEliminaCliente(@RequestParam("idCliente") Integer idCliente) throws Exception{

		System.out.println("MVC - doEliminaCliente =" + idCliente);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		personaService.eliminaPersona(idCliente);			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getClientes")
	public @ResponseBody String getClientes(@RequestParam("idCliente") Integer idCliente) throws Exception{

		System.out.println("MVC - getClientes =" + idCliente);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(personaService.getClientes());			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getClienteById")
	public @ResponseBody String getClienteById(@RequestParam("idCliente") Integer idCliente) throws Exception{

		System.out.println("MVC - getClienteById =" + idCliente);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(personaService.getClienteById(idCliente));
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getEmpleados")
	public @ResponseBody String getEmpleados(@RequestParam("idCliente") Integer idCliente) throws Exception{

		System.out.println("MVC - getEmpleados =" + idCliente);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(personaService.getEmpleados());			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/doGuardaEmpleado")
	public @ResponseBody String doGuardaEmpleado(@RequestParam("empleado") String empleadoJson,@RequestParam("esNuevo") String esNuevo) throws Exception{

		System.out.println("MVC - doGuardaEmpleado =" + empleadoJson);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		Empleado empleado = gson.fromJson(empleadoJson, Empleado.class);
		
		if( Integer.parseInt(esNuevo) == 1){
			personaService.insertaEmpleado(empleado);			
		}else{
			personaService.actualizaEmpleado(empleado);			
		}
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/doEliminaEmpleado")
	public @ResponseBody String doEliminaEmpleado(@RequestParam("idEmpleado") Integer idEmpleado) throws Exception{

		System.out.println("MVC - doEliminaEmpleado =" + idEmpleado);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		personaService.eliminaPersona(idEmpleado);			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getEmpleadoById")
	public @ResponseBody String getEmpleadoById(@RequestParam("idEmpleado") Integer idEmpleado) throws Exception{

		System.out.println("MVC - getEmpleadoById =" + idEmpleado);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(personaService.getEmpleadoById(idEmpleado));
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	
}

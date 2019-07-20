
package com.mx.grupoTama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mx.grupoTama.core.service.VehiculosService;
import com.mx.grupoTama.modelo.Vehiculo;

@Controller
public class VehiculosController {
	
	@Autowired
	VehiculosService vehiculoService;

	@RequestMapping("/doGuardaVehiculo")
	public @ResponseBody String doGuardaVehiculo(@RequestParam("vehiculo") String vehiculoJSON,@RequestParam("esNuevo") String esNuevo) throws Exception{

		System.out.println("MVC - doGuardaVehiculo =" + vehiculoJSON);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		Vehiculo vehiculo = gson.fromJson(vehiculoJSON, Vehiculo.class);
		
		if( Integer.parseInt(esNuevo) == 1){
			vehiculoService.insertaVehiculo(vehiculo);			
		}else{
			vehiculoService.actualizaVehiculo(vehiculo);			
		}
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getVehiculoById")
	public @ResponseBody String getVehiculoById(@RequestParam("idVehiculo") Integer idVehiculo) throws Exception{

		System.out.println("MVC - getVehiculoById =" + idVehiculo);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(vehiculoService.getVehiculoById(idVehiculo));
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/doEliminaVehiculo")
	public @ResponseBody String doEliminaVehiculo(@RequestParam("idVehiculo") Integer idVehiculo) throws Exception{

		System.out.println("MVC - doEliminaVehiculo =" + idVehiculo);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		vehiculoService.eliminaVehiculo(idVehiculo);			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getVehiculos")
	public @ResponseBody String getVehiculos(@RequestParam("idRevolvente") Integer idRevolvente) throws Exception{

		System.out.println("MVC - getVehiculos =" + idRevolvente);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(vehiculoService.getVehiculos());			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	
}


package com.mx.grupoTama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mx.grupoTama.core.service.OperacionesService;
import com.mx.grupoTama.modelo.Inventario;
import com.mx.grupoTama.modelo.Obra;

@Controller
public class OperacionesController {
	
	@Autowired
	OperacionesService operacionesService;

	@RequestMapping("/doGuardaObra")
	public @ResponseBody String doGuardaObra(@RequestParam("obra") String obraJSON,@RequestParam("esNuevo") String esNuevo) throws Exception{

		System.out.println("MVC - doGuardaObra =" + obraJSON);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		Obra obra = gson.fromJson(obraJSON, Obra.class);
		
		if( Integer.parseInt(esNuevo) == 1){
			operacionesService.insertaObra(obra);			
		}else{
			operacionesService.actualizaObra(obra);			
		}
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/doEliminaObra")
	public @ResponseBody String doEliminaObra(@RequestParam("idRevolvente") Integer idObra) throws Exception{

		System.out.println("MVC - doEliminaRevolvente =" + idObra);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		operacionesService.eliminaObra(idObra);			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getObras")
	public @ResponseBody String getObras(@RequestParam("idRevolvente") Integer idRevolvente) throws Exception{

		System.out.println("MVC - getObras =" + idRevolvente);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(operacionesService.getObras());			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getObraById")
	public @ResponseBody String getObraById(@RequestParam("idObra") Integer idObra) throws Exception{

		System.out.println("MVC - getObraById =" + idObra);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(operacionesService.getObraById(idObra));
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/doGuardaInventario")
	public @ResponseBody String doGuardaInventario(@RequestParam("inventario") String inventarioJson,@RequestParam("esNuevo") String esNuevo) throws Exception{

		System.out.println("MVC - doGuardaInventario =" + inventarioJson);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		Inventario inventario = gson.fromJson(inventarioJson, Inventario.class);
		
		if( Integer.parseInt(esNuevo) == 1){
			operacionesService.insertaInventario(inventario);			
		}else{
			operacionesService.actualizaInventario(inventario);			
		}
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/doEliminaInventario")
	public @ResponseBody String doEliminaInventario(@RequestParam("idInventario") Integer idInventario) throws Exception{

		System.out.println("MVC - doEliminaInventario =" + idInventario);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		operacionesService.eliminaInventario(idInventario);			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getInventarios")
	public @ResponseBody String getInventarios(@RequestParam("idInventario") Integer idInventario) throws Exception{

		System.out.println("MVC - getInventarios =" + idInventario);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(operacionesService.getInventarios());			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getInventarioById")
	public @ResponseBody String getInventarioById(@RequestParam("idInventario") Integer idInventario) throws Exception{

		System.out.println("MVC - getInventarioById =" + idInventario);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(operacionesService.getInventarioById(idInventario));
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	
}

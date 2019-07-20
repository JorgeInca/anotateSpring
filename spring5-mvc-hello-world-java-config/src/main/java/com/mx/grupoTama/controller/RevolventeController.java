
package com.mx.grupoTama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mx.grupoTama.core.service.RevolventesService;
import com.mx.grupoTama.modelo.Revolvente;

@Controller
public class RevolventeController {
	
	@Autowired
	RevolventesService revolventesService;

	@RequestMapping("/doGuardaRevolvente")
	public @ResponseBody String doGuardaRevolvente(@RequestParam("revolvente") String revolventeJSON,@RequestParam("esNuevo") String esNuevo) throws Exception{

		System.out.println("MVC - doGuardaRevolvente =" + revolventeJSON);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		Revolvente revolvente = gson.fromJson(revolventeJSON, Revolvente.class);
		
		if( Integer.parseInt(esNuevo) == 1){
			revolventesService.insertaRevolvente(revolvente);			
		}else{
			revolventesService.actualizaRevolvente(revolvente);			
		}
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/getRevolventeById")
	public @ResponseBody String getRevolventeById(@RequestParam("idRevolvente") Integer idRevolvente) throws Exception{

		System.out.println("MVC - getRevolventeById =" + idRevolvente);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		respuesta.setModelo(revolventesService.getRevolventeById(idRevolvente));
				
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	@RequestMapping("/doEliminaRevolvente")
	public @ResponseBody String doEliminaRevolvente(@RequestParam("idRevolvente") Integer idRevolvente) throws Exception{

		System.out.println("MVC - doEliminaRevolvente =" + idRevolvente);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		revolventesService.eliminaRevolvente(idRevolvente);			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	
}

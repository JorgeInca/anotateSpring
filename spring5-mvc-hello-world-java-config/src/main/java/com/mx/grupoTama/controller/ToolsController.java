
package com.mx.grupoTama.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class ToolsController {

	@RequestMapping("/getFechaFormato")
	public @ResponseBody String getFechaFormato() throws Exception{

		System.out.println("MVC - getFechaFormato ");
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		Gson gson = new Gson();
		
		DateFormat dateFormat = new SimpleDateFormat("MMMM dd,yyyy"); 
		
		respuesta.setModelo( dateFormat.format(new Date()));			
						
		respuesta.setSuccess(true);
		
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
	}
	
	
}

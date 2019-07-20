
package com.mx.grupoTama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mx.grupoTama.core.service.OperacionesService;
import com.mx.grupoTama.core.service.PersonaService;
import com.mx.grupoTama.core.service.RevolventesService;
import com.mx.grupoTama.core.service.VehiculosService;
import com.mx.grupoTama.modelo.criteria.RevolventeCriteria;
import com.mx.grupoTama.modelo.enums.TipoBandejaEnum;

@Controller
public class BandejaController {
	
	@Autowired
	RevolventesService revolventesService;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	OperacionesService operacionesService;
	
	@Autowired
	VehiculosService vehiculosService;

	@RequestMapping("/getBandejaInicial")
	public ModelAndView getBandejaInicial(@RequestParam("user") String usuario,@RequestParam("password") String password) throws Exception{

		System.out.println("MVC - obtieneBandeja");
		ModelAndView mv = getMVCBandeja( TipoBandejaEnum.BANDEJA_REVOLVENTE.getIdBandeja());
	
		mv.addObject("user", usuario);
		mv.addObject("password", usuario);

		return mv;
	}
	
	@RequestMapping(value = "/getDatosBandeja")
	public @ResponseBody String obtenerDatosBandeja(@RequestParam(value = "user" ,required = false) String usuario,@RequestParam(value = "tipoBandeja",required = false) Integer tipoBandeja) throws Exception{

		System.out.println("MVC - obtenerDatosBandeja =" + tipoBandeja);
		
		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		respuesta.setSuccess(true);
		
		if( tipoBandeja == TipoBandejaEnum.BANDEJA_REVOLVENTE.getIdBandeja() ){
			respuesta.setModelo( revolventesService.getRevolventes(null) );
		}else{
			if( tipoBandeja == TipoBandejaEnum.BANDEJA_VEH_COBUSTIBLE.getIdBandeja() ){
				//respuesta.setModelo( revolventesService.getRevolventes(null) );
			}else{
				if( tipoBandeja == TipoBandejaEnum.BANDEJA_VEH_MANTENIMIENTO.getIdBandeja() ){
					//respuesta.setModelo( revolventesService.getRevolventes(null) );
				}else{
					if( tipoBandeja == TipoBandejaEnum.BANDEJA_VEH_VEHICULOS.getIdBandeja() ){
						respuesta.setModelo( vehiculosService.getVehiculos() );
					}else{
						if( tipoBandeja == TipoBandejaEnum.BANDEJA_OP_OBRAS.getIdBandeja() ){
							respuesta.setModelo( operacionesService.getObras() );
						}else{
							if( tipoBandeja == TipoBandejaEnum.BANDEJA_OP_RENTAS.getIdBandeja() ){
								//respuesta.setModelo( revolventesService.getRevolventes(null) );
							}
							else{
								if( tipoBandeja == TipoBandejaEnum.BANDEJA_OP_INVENTARIOS.getIdBandeja() ){
									respuesta.setModelo( operacionesService.getInventarios() );
								}else{
									if( tipoBandeja == TipoBandejaEnum.BANJDEJA_PERSONAS_CLIENTE.getIdBandeja() ){
										respuesta.setModelo( personaService.getClientes() );
									}
									else{
										if( tipoBandeja == TipoBandejaEnum.BANJDEJA_PERSONAS_TRABAJADORES.getIdBandeja() ){
											respuesta.setModelo( personaService.getEmpleados() );
										}
									}
								}
							}
						}
					}
				}
			}
		}
				
		Gson gson = new Gson();
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
        
	}
	
	@RequestMapping(value = "/getDatosBandejaCriteria")
	public @ResponseBody String getDatosBandejaCriteria(@RequestParam(value = "user" ,required = false) String usuario,@RequestParam(value = "tipoBandeja",required = false) Integer tipoBandeja,@RequestParam(value = "criteria" ,required = false) String criteria) throws Exception{

		ResponseObjectMVC respuesta = new ResponseObjectMVC();
		respuesta.setSuccess(true);
		Gson gson = new Gson();
		
		
		System.out.println("MVC - getDatosBandejaCriteria =" + tipoBandeja);
		
		if( tipoBandeja == TipoBandejaEnum.BANDEJA_REVOLVENTE.getIdBandeja() ){
			RevolventeCriteria revolvente = gson.fromJson(criteria, RevolventeCriteria.class);
			respuesta.setModelo( revolventesService.getRevolventes(revolvente) );
		}else{
			if( tipoBandeja == TipoBandejaEnum.BANDEJA_VEH_COBUSTIBLE.getIdBandeja() ){
				//respuesta.setModelo( revolventesService.getRevolventesCriteria() );
			}else{
				if( tipoBandeja == TipoBandejaEnum.BANDEJA_VEH_MANTENIMIENTO.getIdBandeja() ){
					//respuesta.setModelo( revolventesService.getRevolventesCriteria() );
				}else{
					if( tipoBandeja == TipoBandejaEnum.BANDEJA_VEH_VEHICULOS.getIdBandeja() ){
						//respuesta.setModelo( vehiculosService.getVehiculosCriteria() );
					}else{
						if( tipoBandeja == TipoBandejaEnum.BANDEJA_OP_OBRAS.getIdBandeja() ){
							//respuesta.setModelo( operacionesService.getObrasCriteria() );
						}else{
							if( tipoBandeja == TipoBandejaEnum.BANDEJA_OP_RENTAS.getIdBandeja() ){
								//respuesta.setModelo( revolventesService.getRevolventesCriteria() );
							}
							else{
								if( tipoBandeja == TipoBandejaEnum.BANDEJA_OP_INVENTARIOS.getIdBandeja() ){
									//respuesta.setModelo( revolventesService.getRevolventesCriteria() );
								}else{
									if( tipoBandeja == TipoBandejaEnum.BANJDEJA_PERSONAS_CLIENTE.getIdBandeja() ){
										//respuesta.setModelo( personaService.getClientesCriteria() );
									}
									else{
										if( tipoBandeja == TipoBandejaEnum.BANJDEJA_PERSONAS_TRABAJADORES.getIdBandeja() ){
											//respuesta.setModelo( personaService.getEmpleadosCriteria() );
										}
									}
								}
							}
						}
					}
				}
			}
		}
				
		//Gson gson = new Gson();
        String mensajeJson = gson.toJson(respuesta);
        return mensajeJson;
        
	}

	@RequestMapping("/getBandejaGeneral")
	public ModelAndView obtieneBandeja(@RequestParam(value = "idBandejaConsultar",required = false) Integer tipoBandeja) throws Exception{

		System.out.println("MVC - obtieneBandeja: " + tipoBandeja);
		
		ModelAndView mv;		
		mv = getMVCBandeja(tipoBandeja);

		return mv;
	}
	
	public ModelAndView getMVCBandeja(Integer idTipoBandejaVar) throws Exception{
	
		ModelAndView mv = new ModelAndView();

		TipoBandejaEnum bandeja = null;
		
		bandeja = bandeja.getById(idTipoBandejaVar);
		
		mv.addObject("descripcionBandeja", bandeja.getDescripcion());
		mv.addObject("tipoBandeja", bandeja.getIdBandeja());
		mv.addObject("nombreBandeja", bandeja.getDescripcion());
		
		mv.setViewName(bandeja.getVistaBandeja());
		
		return mv; 
	}	

}

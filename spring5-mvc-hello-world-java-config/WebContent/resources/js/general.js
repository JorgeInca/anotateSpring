/**
 * 
 */
var GeneralJS = {
	    linkBandeja : function(tipoBandejaVar) {
	    	console.log(tipoBandejaVar);
	    	$( "#idBandejaConsultar" ).val(tipoBandejaVar);
	    	$( "#formGetBandeja" ).submit();
	    }		
};


const TipoBandejaEnum = {
		
		BANDEJA_REVOLVENTE		 		 : { idTipoBandeja : 1, descripcion : "Bandeja revolvente" 	 	, vistaBandeja : "bandejas/revolventes/bandejaRevolvente/"	},
		BANDEJA_VEH_COBUSTIBLE	   		 : { idTipoBandeja : 2, descripcion : "Registro combustible" 	, vistaBandeja : "bandejas/operaciones/"					},
		BANDEJA_VEH_MANTENIMIENTO		 : { idTipoBandeja : 3, descripcion : "Mantenimiento vehículos" , vistaBandeja : "bandejas/operaciones/"					},
		BANDEJA_VEH_VEHICULOS 	 		 : { idTipoBandeja : 4, descripcion : "Vehículos" 			    , vistaBandeja : "bandejas/operaciones/"					},
		BANDEJA_OP_OBRAS 		  		 : { idTipoBandeja : 5, descripcion : "Obras" 				    , vistaBandeja : "bandejas/vehiculos/"						},
		BANDEJA_OP_RENTAS  		 		 : { idTipoBandeja : 6, descripcion : "Rentas" 				    , vistaBandeja : "bandejas/vehiculos/"						},
		BANDEJA_OP_INVENTARIOS	 		 : { idTipoBandeja : 7, descripcion : "Inventario" 			    , vistaBandeja : "bandejas/vehiculos/"						},
		BANJDEJA_PERSONAS_CLIENTE	 	 : { idTipoBandeja : 8, descripcion : "Clientes" 			    , vistaBandeja : "bandejas/personas/"						},
		BANJDEJA_PERSONAS_TRABAJADORES	 : { idTipoBandeja : 9, descripcion : "Trabajadores" 			, vistaBandeja : "bandejas/personas/"						}
		
};


$('.number').keypress(function(event) {
	  if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
	    event.preventDefault();
	  }
	});

$(".money").on({
    "focus": function (event) {
        $(event.target).select();
    },
    "keyup": function (event) {
        $(event.target).val(function (index, value ) {
        	
            return value.toString().replace(/\D/g, "")
							  	   .replace(/([0-9])([0-9]{2})$/, '$1.$2')
							       .replace(/\B(?=(\d{3})+(?!\d)\.?)/g, ",");
        });
    }
});

function formateaComasNumero(value){
	
	var valorString = value.toString();
	
	if( valorString.includes(".") ){
		return valorString.replace(/\D/g, "")
				    .replace(/([0-9])([0-9]{2})$/, '$1.$2')
				    .replace(/\B(?=(\d{3})+(?!\d)\.?)/g, ",");
	}else{
		valorString = valorString + ".00";
		
		return valorString.replace(/\D/g, "")
	    .replace(/([0-9])([0-9]{2})$/, '$1.$2')
	    .replace(/\B(?=(\d{3})+(?!\d)\.?)/g, ",");
	}
};

function quitaComas(value){
	return value.toString().replace(/,/g, "");
};

function setFechaFormato(inputName){
	
    	$.ajax({
    		method : "POST",
    		url : "getFechaFormato",
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success )	
    	        	$('#'+inputName+'').val(obj.modelo);   
    	        	
    	          else
    	        	  alert("Fallo al consultar");
      		 },
      		 error : function(e) {
      		  console.log("ERROR: ", e);
      		},
      	});

};
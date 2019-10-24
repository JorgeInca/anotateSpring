var PersonasJS = {
	nuevoCliente : function() {

		$("#btnModalCliente").empty().append("Guardar");
		$("#titleModalCliente").empty().append("Nuevo Cliente");
		$("#tipoOperacion").val("guardar");
		$("#idCliente").val("0");	
		
		PersonasJS.limpiaModalCliente();
		
		$('#modalCliente').modal('show');

	},
	editaCliente : function(idCliente) {

		$("#divError").hide(); 
		
		$("#btnModalCliente").empty().append("Actualizar");
		$("#titleModalCliente").empty().append("Actualizar Cliente");
		$("#tipoOperacion").val("actualizar");
		$("#idCliente").val(idCliente);
		
		PersonasJS.llenaCliente(idCliente);
		
		$('#modalCliente').modal('show');

	},
	validaEliminarCliente : function(idCliente, descripcion) {

		$("#descripcionEliminarCliente").empty();
		$("#descripcionEliminarCliente").append(descripcion);
		$("#idCliente").val(idCliente);

		$('#modalEliminaCliente').modal('show');

	},
	validaGuardaCliente : function() {    
		
    	$("#divError").empty();
    	$("#divError").hide();  
    	
    	var mensaje = "Está seguro que desea " + $("#tipoOperacion").val() + " este registro?";
    	if( confirm(mensaje) ){
    		
    		if (PersonasJS.camposVaciosFaltantesCliente()){
    			PersonasJS.doNuevoCliente( $("#tipoOperacion").val() );
    		}
    		
    	}else{
    		
    	}	
    },
    doNuevoCliente : function(tipoOperacion) {
    	
		var objCliente = {
				idPersona : $("#idCliente").val(),
				nombre: $("#nombre").val(),
				apellidos: $("#apellidos").val(),
				direccion: $("#direccion").val(),
				telefono: $("#telefono").val(),
				email: $("#email").val(),
				fechaString: $("#fechaNac").val(),				
				rfc: $("#rfc").val(),
				nombreEmpresa: $("#nombreEmpresa").val()
		};
		
    	$.ajax({
    		method : "POST",
    		url : "doGuardaCliente",
    		data : {
    			esNuevo : $("#tipoOperacion").val() == "guardar" ? "1" : "0",
    			cliente : JSON.stringify(objCliente)
    		},
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success ){
    	        	  alert("Guardado con éxito");
    	        	  BandejaGeneralJS.cargaBandejaGeneral($('#tipoBandeja').val()); 
    	          }
    	          else{
    	        	  alert("Fallo al guardar");
    	          }
      		  },
      		  error : function(e) {
      			  console.log("ERROR: ", e);
      		  }
      		});
    	
		$('#modalCliente').modal('hide');
		
    },
    doEliminaCliente : function() {
    	
    	$.ajax({
    		method : "POST",
    		url : "doEliminaCliente",
    		data : {
    			idCliente : $("#idCliente").val()
    		},
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success ){
    	        	  alert("El registro fue dado de baja");
    	        	  BandejaGeneralJS.cargaBandejaGeneral($('#tipoBandeja').val()); 
    	          }
    	          else{
    	        	  alert("Fallo al eliminar");
    	          }
      		  },
      		  error : function(e) {
      			  console.log("ERROR: ", e);
      		  }
      		});
    	
    },
    llenaCliente: function(idCliente){
    	
  	  $.ajax({
  		method : "POST",
  		url : "getClienteById",
  		data : {
  			idCliente : idCliente
  		},
  		success : function(data) {  			 
  	          var obj=JSON.parse(data);	   
  	          if( obj.success ){	    	        	
  	        	  
  	        	  $("#idCliente").val(obj.modelo.idPersona);
	  	  		  $("#nombre").val(obj.modelo.nombre);
	  			  $("#apellidos").val(obj.modelo.apellidos);
	  			  $("#direccion").val(obj.modelo.direccion);
	  			  $("#telefono").val(obj.modelo.telefono);
	  			  $("#email").val(obj.modelo.email);
	  			  $("#fechaNac").val(obj.modelo.fechaString);	
	  			  $("#fechaNac").change();	  			
	  			  $("#rfc").val(obj.modelo.rfc);
	  			  $("#nombreEmpresa").val(obj.modelo.nombreEmpresa);
  	        
  	          }
  	          else{
  	        	$("#divError").html("Fallo al recuperar");
	  			$("#divError").show();  
  	          }
    		  },
    		  error : function(e) {
        			$("#divError").html("Error: " + e);
    	  			$("#divError").show();     
    		  }
    		});
	
				
  },
  camposVaciosFaltantesCliente: function() {
  	
  	var mensaje = 'Favor de completar los campos: <b>';
  	var empty = true;
  	var coma = "";
  	
		var objValidacion = {
				idPersona : $("#idCliente").val(),
				nombre: $("#nombre").val(),
				apellidos: $("#apellidos").val(),
				direccion: $("#direccion").val(),
				telefono: $("#telefono").val(),
				email: $("#email").val(),
				fechaString: $("#fechaNac").val(),				
				rfc: $("#rfc").val(),
				nombreEmpresa: $("#nombreEmpresa").val()
		};
		
		if( objValidacion.nombre == '' ){
			mensaje = mensaje + "Nombre";		
			empty = false;
		}		
		if( objValidacion.apellidos == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Apellidos";
			empty = false;
		}
		if( objValidacion.direccion == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Dirección";	
			empty = false;
		}
		if( objValidacion.telefono == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Telefono";	
			empty = false;
		}
		if( objValidacion.email == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Email";	
			empty = false;
		}
		if( objValidacion.fechaString == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Fecha de Nacimiento";	
			empty = false;
		}
		if( objValidacion.rfc == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "RFC";	
			empty = false;
		}
		if( objValidacion.nombreEmpresa == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Nombre de Empresa";	
			empty = false;
		}
		
		if( empty==false ){
			mensaje = mensaje + '</b>';
			$("#divError").html(mensaje);
			$("#divError").show();
		}
		
		return empty;
		
  },limpiaModalCliente: function(obra){
    	  $("#divError").hide(); 
    	
		  $("#nombre").val("");
		  $("#apellidos").val("");
		  $("#direccion").val("");
		  $("#telefono").val("");
		  $("#email").val("");
		  $("#fechaNac").val("");
		  $("#edad").val("");
		  $("#rfc").val("");
		  $("#nombreEmpresa").val("");
		  
  },
  /** Inicia Empleados**/
  nuevoEmpleado : function() {

		$("#btnModalEmpleado").empty().append("Guardar");
		$("#titleModalEmpleado").empty().append("Nuevo Empleado");
		$("#tipoOperacion").val("guardar");
		$("#idEmpleado").val("0");	
		
		PersonasJS.limpiaModalEmpleado();
		
		$('#modalEmpleado').modal('show');

	},
	editaEmpleado : function(idEmpleado) {

		$("#divError").hide(); 
		
		$("#btnModalEmpleado").empty().append("Actualizar");
		$("#titleModalEmpleado").empty().append("Actualizar Empleado");
		$("#tipoOperacion").val("actualizar");
		$("#idEmpleado").val(idEmpleado);
		
		PersonasJS.llenaEmpleado(idEmpleado);
		
		$('#modalEmpleado').modal('show');

	},
	validaEliminarEmpleado : function(idEmpleado, descripcion) {

		$("#descripcionEliminarEmpleado").empty();
		$("#descripcionEliminarEmpleado").append(descripcion);
		$("#idEmpleado").val(idEmpleado);

		$('#modalEliminaEmpleado').modal('show');

	},
	validaGuardaEmpleado : function() {    
		
  	$("#divError").empty();
  	$("#divError").hide();  
  	
  	var mensaje = "Está seguro que desea " + $("#tipoOperacion").val() + " este registro?";
  	if( confirm(mensaje) ){
  		
  		if (PersonasJS.camposVaciosFaltantesEmpleado()){
  			PersonasJS.doNuevoEmpleado( $("#tipoOperacion").val() );
  		}
  		
  	}else{
  		
  	}	
  },
  doNuevoEmpleado : function(tipoOperacion) {
  	
		var objEmpleado = {
				idPersona : $("#idEmpleado").val(),
				nombre: $("#nombre").val(),
				apellidos: $("#apellidos").val(),
				direccion: $("#direccion").val(),
				telefono: $("#telefono").val(),
				email: $("#email").val(),
				fechaString: $("#fechaNac").val(),				
				numeroEmpleado: $("#numeroEmpleado").val()
		};
		
  	$.ajax({
  		method : "POST",
  		url : "doGuardaEmpleado",
  		data : {
  			esNuevo : $("#tipoOperacion").val() == "guardar" ? "1" : "0",
  			empleado : JSON.stringify(objEmpleado)
  		},
  		success : function(data) {  			 
  	          var obj=JSON.parse(data);	   
  	          if( obj.success ){
  	        	  alert("Guardado con éxito");
  	        	  BandejaGeneralJS.cargaBandejaGeneral($('#tipoBandeja').val()); 
  	          }
  	          else{
  	        	  alert("Fallo al guardar");
  	          }
    		  },
    		  error : function(e) {
    			  console.log("ERROR: ", e);
    		  }
    		});
  	
		$('#modalEmpleado').modal('hide');
		
  },
  doEliminaEmpleado : function() {
  	
  	$.ajax({
  		method : "POST",
  		url : "doEliminaEmpleado",
  		data : {
  			idEmpleado : $("#idEmpleado").val()
  		},
  		success : function(data) {  			 
  	          var obj=JSON.parse(data);	   
  	          if( obj.success ){
  	        	  alert("El registro fue dado de baja");
  	        	  BandejaGeneralJS.cargaBandejaGeneral($('#tipoBandeja').val()); 
  	          }
  	          else{
  	        	  alert("Fallo al eliminar");
  	          }
    		  },
    		  error : function(e) {
    			  console.log("ERROR: ", e);
    		  }
    		});
  	
  },
  llenaEmpleado: function(idEmpleado){
  	
	  $.ajax({
		method : "POST",
		url : "getEmpleadoById",
		data : {
			idEmpleado : idEmpleado
		},
		success : function(data) {  			 
	          var obj=JSON.parse(data);	   
	          if( obj.success ){	    	        	
	        	  
	        	  $("#idEmpleado").val(obj.modelo.idPersona);
	  	  		  $("#nombre").val(obj.modelo.nombre);
	  			  $("#apellidos").val(obj.modelo.apellidos);
	  			  $("#direccion").val(obj.modelo.direccion);
	  			  $("#telefono").val(obj.modelo.telefono);
	  			  $("#email").val(obj.modelo.email);
	  			  $("#fechaNac").val(obj.modelo.fechaString);	
	  			  $("#fechaNac").change();	  				  			
	  			  $("#numeroEmpleado").val(obj.modelo.numeroEmpleado);
	        
	          }
	          else{
	        	$("#divError").html("Fallo al recuperar");
	  			$("#divError").show();  
	          }
  		  },
  		  error : function(e) {
      			$("#divError").html("Error: " + e);
  	  			$("#divError").show();     
  		  }
  		});
	
				
},
camposVaciosFaltantesEmpleado: function() {
	
	var mensaje = 'Favor de completar los campos: <b>';
	var empty = true;
	var coma = "";
	
		var objValidacion = {
				idPersona : $("#idEmpleado").val(),
				nombre: $("#nombre").val(),
				apellidos: $("#apellidos").val(),
				direccion: $("#direccion").val(),
				telefono: $("#telefono").val(),
				email: $("#email").val(),
				fechaString: $("#fechaNac").val(),
				numeroEmpleado: $("#numeroEmpleado").val()				
		};
		
		if( objValidacion.nombre == '' ){
			mensaje = mensaje + "Nombre";		
			empty = false;
		}		
		if( objValidacion.apellidos == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Apellidos";
			empty = false;
		}
		if( objValidacion.direccion == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Dirección";	
			empty = false;
		}
		if( objValidacion.telefono == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Telefono";	
			empty = false;
		}
		if( objValidacion.email == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Email";	
			empty = false;
		}
		if( objValidacion.fechaString == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Fecha de Nacimiento";	
			empty = false;
		}
		if( objValidacion.numeroEmpleado == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Numero Empleado";	
			empty = false;
		}
		
		if( empty==false ){
			mensaje = mensaje + '</b>';
			$("#divError").html(mensaje);
			$("#divError").show();
		}
		
		return empty;
		
},
limpiaModalEmpleado: function(obra){
  	  $("#divError").hide(); 
  	
		  $("#nombre").val("");
		  $("#apellidos").val("");
		  $("#direccion").val("");
		  $("#telefono").val("");
		  $("#email").val("");
		  $("#fechaNac").val("");
		  $("#edad").val("");
		  $("#numeroEmpleado").val("");
		  
		  
},
obtieneEmpleadosSelect: function() {    	
	$.ajax({
		method : "POST",
		url : "getEmpleados",
		data : {
			idEmpleado : '0'
		},
		success : function(data) {  			 
	          var obj=JSON.parse(data);	   
	          if( obj.success ){	
	        	  obj.modelo.forEach(function(empleado) {
	        		  $('#idEmpleado').append($('<option>', {value:empleado.idPersona, text:empleado.nombre + ' ' + empleado.apellidos}));
	        		  //inventariosMap.set(inventario.idInventario, inventario.precioUnitario );
	        	  });    	          	        	  
	        
	          }
	          else{
	        	  alert("Fallo al consultar");
	          }
  		  },
  		  error : function(e) {
  			  console.log("ERROR: ", e);
  		  }
  		});
},
};

$(function() {
	  $('input[name="fechaNac"]').daterangepicker({
	    singleDatePicker: true,
	    showDropdowns: true,
	    minYear: 1901,
	    maxYear: parseInt(moment().format('YYYY'),10)
	  }, function(start, end, label) {
//	    var years = moment().diff(start, 'years');
//	    alert("You are " + years + " years old!");
	  });
	  

	  $('input[name="fechaNac"]').on('apply.daterangepicker', function(ev, picker) {
	      $(this).val(picker.startDate.format('DD/MM/YYYY'));
	  });
});



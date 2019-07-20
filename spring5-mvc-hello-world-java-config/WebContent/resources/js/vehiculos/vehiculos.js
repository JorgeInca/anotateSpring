var VehiculosJS = {
	nuevoCombustible : function(idCombustible) {
		
		$("#btnModalCombustible").empty().append("Guardar");
		$("#titleModalCombustible").empty().append("Nuevo Combustible");	
				
		$('#modalCombustible').modal('show');
		
	},
	editaCombustible : function(idCombustible) { 
		
		$("#btnModalCombustible").empty().append("Actualizar");
		$("#titleModalCombustible").empty().append("Actualizar Combustible");
		
		$('#modalCombustible').modal('show');
		
    },
    validaEliminarCombustible : function(idCombustible,descripcion) {

		$("#descripcionEliminarCombustible").empty();
		$("#descripcionEliminarCombustible").append(descripcion);
    	
    	$('#modalEliminaCombustible').modal('show');
		
    },
	nuevoMantenimiento : function(idMantenimiento) {
		
		$("#btnModalMantenimiento").empty().append("Guardar");
		$("#titleModalMantenimiento").empty().append("Nuevo Mantenimiento");	
				
		$('#modalMantenimiento').modal('show');
		
	},
	editaMantenimiento : function(idMantenimiento) { 
		
		$("#btnModalMantenimiento").empty().append("Actualizar");
		$("#titleModalMantenimiento").empty().append("Actualizar Mantenimiento");
		
		$('#modalMantenimiento').modal('show');
		
    },
    validaEliminarMantenimiento : function(idMantenimiento,descripcion) {

		$("#descripcionEliminarMantenimiento").empty();
		$("#descripcionEliminarMantenimiento").append(descripcion);
    	
    	$('#modalEliminaMantenimiento').modal('show');
		
    },
    /** Vehiculos JS */
    nuevoVehiculo : function() {

		$("#btnModalVehiculo").empty().append("Guardar");
		$("#titleModalVehiculo").empty().append("Nuevo Vehiculo");
		$("#tipoOperacion").val("guardar");
		$("#idVehiculo").val("0");	
		
		VehiculosJS.limpiaModalVehiculo();
		
		$('#modalVehiculo').modal('show');

	},
	editaVehiculo : function(idVehiculo) {

		$("#divError").hide(); 
		
		$("#btnModalVehiculo").empty().append("Actualizar");
		$("#titleModalVehiculo").empty().append("Actualizar Vehiculo");
		$("#tipoOperacion").val("actualizar");
		$("#idVehiculo").val(idVehiculo);
		
		VehiculosJS.llenaVehiculo(idVehiculo);
		
		$('#modalVehiculo').modal('show');

	},
	validaEliminarVehiculo : function(idVehiculo, descripcion) {

		$("#descripcionEliminarVehiculo").empty();
		$("#descripcionEliminarVehiculo").append(descripcion);
		$("#idVehiculo").val(idVehiculo);

		$('#modalEliminaVehiculo').modal('show');

	},
	validaGuardaVehiculo : function() {    
		
    	$("#divError").empty();
    	$("#divError").hide();  
    	
    	var mensaje = "Está seguro que desea " + $("#tipoOperacion").val() + " este registro?";
    	if( confirm(mensaje) ){
    		
    		if (VehiculosJS.camposVaciosFaltantesVehiculo()){
    			VehiculosJS.doNuevoVehiculo( $("#tipoOperacion").val() );
    		}
    		
    	}else{
    		
    	}	
    },
    doNuevoVehiculo : function(tipoOperacion) {
    	
		var objVehiculo = {				
			idVehiculo : $("#idVehiculo").val(),
			descripcion: $("#descripcion").val(),
			marca: $("#marca").val(),
			modelo: $("#modelo").val(),
			matricula: $("#matricula").val(),
			anio: $("#anio").val()	
		};
		
    	$.ajax({
    		method : "POST",
    		url : "doGuardaVehiculo",
    		data : {
    			esNuevo : $("#tipoOperacion").val() == "guardar" ? "1" : "0",
    			vehiculo : JSON.stringify(objVehiculo)
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
    	
		$('#modalVehiculo').modal('hide');
		
    },
    doEliminaVehiculo : function() {
    	
    	$.ajax({
    		method : "POST",
    		url : "doEliminaVehiculo",
    		data : {
    			idVehiculo : $("#idVehiculo").val()
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
    llenaVehiculo: function(idVehiculo){
    	
  	  $.ajax({
  		method : "POST",
  		url : "getVehiculoById",
  		data : {
  			idVehiculo : idVehiculo
  		},
  		success : function(data) {  			 
  	          var obj=JSON.parse(data);	   
  	          if( obj.success ){	    	        	
  	        	  
  	        	  $("#idVehiculo").val(obj.modelo.idVehiculo);
  	        	  $("#descripcion").val(obj.modelo.descripcion);
	  	  		  $("#marca").val(obj.modelo.marca);
	  			  $("#modelo").val(obj.modelo.modelo);
	  			  $("#matricula").val(obj.modelo.matricula);
	  			  $("#anio").val(obj.modelo.anio);	  			  
  	        
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
  camposVaciosFaltantesVehiculo: function() {
  	
  	var mensaje = 'Favor de completar los campos: <b>';
  	var empty = true;
  	var coma = "";
  	
  		var objValidacion = {				
			idVehiculo : $("#idVehiculo").val(),
			descripcion: $("#descripcion").val(),
			marca: $("#marca").val(),
			modelo: $("#modelo").val(),
			matricula: $("#matricula").val(),
			anio: $("#anio").val()	
		};
		
		if( objValidacion.descripcion == '' ){
			mensaje = mensaje + "Descripción";		
			empty = false;
		}		
		if( objValidacion.marca == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Marca";
			empty = false;
		}
		if( objValidacion.modelo == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Modelo";	
			empty = false;
		}
		if( objValidacion.matricula == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Matricula";	
			empty = false;
		}
		if( objValidacion.anio == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Año";	
			empty = false;
		}		
		
		if( empty==false ){
			mensaje = mensaje + '</b>';
			$("#divError").html(mensaje);
			$("#divError").show();
		}
		
		return empty;
		
  },limpiaModalVehiculo: function(obra){
    	  $("#divError").hide(); 
    	
      	  $("#descripcion").val("");
  		  $("#marca").val("");
		  $("#modelo").val("");
		  $("#matricula").val("");
		  $("#anio").val("");
		  
		  
  },
    obtieneVehiculosSelect: function() {    	
    	$.ajax({
    		method : "POST",
    		url : "getVehiculos",
    		data : {
    			idRevolvente : '0'
    		},
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success ){	
    	        	  obj.modelo.forEach(function(vehiculo) {    	        		 
    	        		  $('#idVehiculo').append($('<option>', {value:vehiculo.idVehiculo, text:vehiculo.descripcion})); 
    	        		  $('#idVehiculoFiltro').append($('<option>', {value:vehiculo.idVehiculo, text:vehiculo.descripcion})); 
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



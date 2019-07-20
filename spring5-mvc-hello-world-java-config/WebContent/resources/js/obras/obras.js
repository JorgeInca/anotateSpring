var clientesMap = new Map();

var ObrasJS = {
	nuevoObra : function() {

		$("#btnModalObra").empty().append("Guardar");
		$("#titleModalObra").empty().append("Nuevo Obra");
		$("#tipoOperacion").val("guardar");
		$("#idObra").val("0");	
		
		ObrasJS.limpiaModalObra();
		
		$('#modalObra').modal('show');

	},
	editaObra : function(idObra) {

		$("#divError").hide(); 
		
		$("#btnModalObra").empty().append("Actualizar");
		$("#titleModalObra").empty().append("Actualizar Obra");
		$("#tipoOperacion").val("actualizar");
		$("#idObra").val(idObra);
		
		ObrasJS.llenaObra(idObra);
		
		$('#modalObra').modal('show');

	},
	validaEliminarObra : function(idObra, descripcion) {

		$("#descripcionEliminarObra").empty();
		$("#descripcionEliminarObra").append(descripcion);
		$("#idObra").val(idObra);

		$('#modalEliminaObra').modal('show');

	},
	validaGuardaObra : function() {    
		
    	$("#divError").empty();
    	$("#divError").hide();  
    	
    	var mensaje = "Est� seguro que desea " + $("#tipoOperacion").val() + " este registro?";
    	if( confirm(mensaje) ){
    		
    		if (ObrasJS.camposVaciosFaltantesObra()){
    			ObrasJS.doNuevoObra( $("#tipoOperacion").val() );
    		}
    		
    	}else{
    		
    	}	
    },
    doNuevoObra : function(tipoOperacion) {
    	
		var objObra = {			  
				idObra : $("#idObra").val(),
				nombre: $("#nombre").val(),
				direccion: $("#direccion").val(),
				idCliente: $("#idCliente").val()				
		};
		
    	$.ajax({
    		method : "POST",
    		url : "doGuardaObra",
    		data : {
    			esNuevo : $("#tipoOperacion").val() == "guardar" ? "1" : "0",
    			obra : JSON.stringify(objObra)
    		},
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success ){
    	        	  alert("Guardado con �xito");
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
    	
		$('#modalObra').modal('hide');
		
    },
    doEliminaObra : function() {
    	
    	$.ajax({
    		method : "POST",
    		url : "doEliminaObra",
    		data : {
    			idObra : $("#idObra").val()
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
    llenaObra: function(idObra){
    	
  	  $.ajax({
  		method : "POST",
  		url : "getObraById",
  		data : {
  			idObra : idObra
  		},
  		success : function(data) {  			 
  	          var obj=JSON.parse(data);	   
  	          if( obj.success ){	    	        	
  	        	  
  	        	  $("#idObra").val(obj.modelo.idObra);
	  	  		  $("#nombre").val(obj.modelo.nombre);
	  			  $("#direccion").val(obj.modelo.direccion);
	  			 
	  			  $("#idCliente").val(obj.modelo.idCliente);
        		  $("#idCliente").change();
        		  
	  			  $("#fechaInicio").val(obj.modelo.fechaInicio);	
  	        
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
  camposVaciosFaltantesObra: function() {
  	
  	var mensaje = 'Favor de completar los campos: <b>';
  	var empty = true;
  	var coma = "";
  	
		var objValidacion = {				
				nombre: $("#nombre").val(),
				direccion: $("#direccion").val(),
				idCliente: $("#idCliente").val()				
		};
		
		if( objValidacion.nombre == '' ){
			mensaje = mensaje + "Nombre";		
			empty = false;
		}		
		if( objValidacion.direccion == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Direcci�n";
			empty = false;
		}
		if( objValidacion.idCliente == '0' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Cliente";	
			empty = false;
		}
		
		
		if( empty==false ){
			mensaje = mensaje + '</b>';
			$("#divError").html(mensaje);
			$("#divError").show();
		}
		
		return empty;
		
  },limpiaModalObra: function(obra){
    	  $("#divError").hide(); 
    	
		  $("#nombre").val("");
		  $("#direccion").val("");
		  $("#idCliente").val("0");			  
		  $("#telefono").val("");
		  $("#fechaInicio").val("");
		  
  },
  obtieneClientesSelect: function() {    	
    	$.ajax({
    		method : "POST",
    		url : "getClientes",
    		data : {
    			idCliente : '0'
    		},
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success ){	
    	        	  obj.modelo.forEach(function(cliente) {
    	        		  clientesMap.set(cliente.idPersona, cliente.telefono );
    	        		  $('#idCliente').append($('<option>', {value:cliente.idPersona, text:cliente.nombre + ' ' + cliente.apellidos + ' - ' + cliente.nombreEmpresa}));
    	        		  //$('#idObraFiltro').append($('<option>', {value:obra.idObra, text:obra.nombre}));  
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
    seleccionaTelefonoPorCliente: function(cliente){
    	$('#telefono').val( clientesMap.get( parseInt(cliente.value) ));
    }
};



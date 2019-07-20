var obrasMap = new Map();

var OperacionesJS = {
	nuevoRevolvente : function() {
		
		$("#btnModalRevolvente").empty().append("Guardar");
		$("#titleModalRevolvente").empty().append("Nuevo Revolvente");
		$("#tipoOperacion").val("guardar");
		$("#idRevolvente").val("0");		
		
		OperacionesJS.limpiaModalRevolvente();
		
		$('#modalRevolvente').modal('show');
		
	},
	editaRevolvente : function(idRevolvente) { 
		
		$("#divError").hide(); 
		
		$("#btnModalRevolvente").empty().append("Actualizar");
		$("#titleModalRevolvente").empty().append("Actualizar Revolvente");
		$("#tipoOperacion").val("actualizar");
		$("#idRevolvente").val(idRevolvente);
		
		OperacionesJS.llenaRevolvente(idRevolvente);
		
		$('#modalRevolvente').modal('show');
		
    },
    validaEliminarRevolvente : function(idRevolvente,descripcion) {

		$("#descripcionEliminarRevolvente").empty();
		$("#descripcionEliminarRevolvente").append(descripcion);
		$("#idRevolvente").val(idRevolvente);
		
    	$('#modalEliminaRevolvente').modal('show');
		
    },
    validaGuardaRevolvente : function() {
    	
    	$("#divError").empty();
    	$("#divError").hide();    	
   	
    	var mensaje = "Está seguro que desea " + $("#tipoOperacion").val() + " este registro?";
    	if( confirm(mensaje) ){  		
  
    		if (OperacionesJS.camposVaciosFaltantesRevolvente()){
    			OperacionesJS.doNuevoRevolvente( $("#tipoOperacion").val() );
    		}
    		
    	}else{
    		  
    	}
    	
    },
    doNuevoRevolvente : function(tipoOperacion) {
    	
		var objRevolvente = {
				idRevolvente : $("#idRevolvente").val(),
				cantidad : $("#cantidad").val(),
				esIngreso: $("input[name=gastoRadio]").filter(":checked").val()=="1" ? true :false,
				descripcion: $("#descripcion").val(),
				monto: quitaComas($("#monto").val()),
				idObra: $("#idObra").val() == "0" ? null : $("#idObra").val(),
				idVehiculo: $("#idVehiculo").val() == "0" ? null : $("#idVehiculo").val(),
		};
		
    	$.ajax({
    		method : "POST",
    		url : "doGuardaRevolvente",
    		data : {
    			esNuevo : $("#tipoOperacion").val() == "guardar" ? "1" : "0",
    			revolvente : JSON.stringify(objRevolvente)
    		},
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success ){
    	        	  alert("Guardado con éxito");
    	        	  BandejaGeneralJS.cargaBandejaGeneral($('#tipoBandeja').val()); 
    	        	  $('#modalRevolvente').modal('hide');
    	          }
    	          else{
    	        	$("#divError").html("Fallo al guardar");
    	  			$("#divError").show();    	  			
    	          }
      		  },
      		  error : function(e) {
      			$("#divError").html("Error: " + e);
	  			$("#divError").show();       			  
      		  }
      		});
    	
				
    },
    doEliminaRevolvente : function() {
    	
    	$.ajax({
    		method : "POST",
    		url : "doEliminaRevolvente",
    		data : {
    			idRevolvente : $("#idRevolvente").val()
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
    llenaRevolvente: function(idRevolvente){
    	
    	  $.ajax({
    		method : "POST",
    		url : "getRevolventeById",
    		data : {
    			idRevolvente : idRevolvente
    		},
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success ){	    	        	  
    	        		  
    	    		  $("#cantidad").val(obj.modelo.cantidad);
    	    		  $("#enRenta").val(obj.modelo.enRenta);
    	    		  $("#descripcion").val(obj.modelo.descripcion);
    	    		  $("#precioUnitario").val(obj.modelo.precioUnitario);
    	    		  $("#monto").val(formateaComasNumero(obj.modelo.monto));
    	    		  $("#total").val(obj.modelo.total);
    	    		  $("#fechaCreacion").val(obj.modelo.fechaCreacion);
    	    		  
    	    		  if(obj.modelo.esIngreso){
    	    			  document.getElementById("radioIngreso").checked = true;
    	    			  document.getElementById("radioGasto").checked = false;    	    			
    	    		  }else{
    	    			  document.getElementById("radioIngreso").checked = false;
    	    			  document.getElementById("radioGasto").checked = true;  
    	    		  }
    	    		  
    	    		  $("input[name=gastoRadio]").change();
    	    		  
    	    		  $("#idObra").val(obj.modelo.idObra);
    	    		  $("#idVehiculo").val(obj.modelo.idVehiculo);
    	    		  
	        		  $("#cantidad").change();      //¿para que?   		  
    	        
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
  	
				
    },camposVaciosFaltantesRevolvente: function() {
    	
    	var mensaje = 'Favor de completar los campos: <b>';
    	var empty = true;
    	var coma = "";
    	
		var objRevolvente = {
				idRevolvente : $("#idRevolvente").val(),
				cantidad : $("#cantidad").val(),
				esIngreso: $("input[name=gastoRadio]").filter(":checked").val()=="1" ? true :false,
				descripcion: $("#descripcion").val(),
				monto: quitaComas($("#monto").val()),
				idObra: $("#idObra").val() == "0" ? null : $("#idObra").val(),
				idVehiculo: $("#idVehiculo").val() == "0" ? null : $("#idVehiculo").val(),
		};
		
		if( objRevolvente.cantidad == '' ){
			mensaje = mensaje + "Cantidad";		
			empty = false;
		}		
		if( objRevolvente.descripcion == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Descripción";
			empty = false;
		}
		if( objRevolvente.monto == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Monto";	
			empty = false;
		}
		if($("input[name=gastoRadio]").filter(":checked").val()==undefined){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Gasto/Ingreso";	
			empty = false;
		}else{
			if(objRevolvente.esIngreso){
				if( objRevolvente.idObra == '' ){
					coma = empty ? "" : ",";
					mensaje = mensaje + coma + "Obra";	
					empty = false;
				}
			}
		}
		
		if( empty==false ){
			mensaje = mensaje + '</b>';
			$("#divError").html(mensaje);
			$("#divError").show();
		}
		
		return empty;
		
    },
    obtieneObrasSelect: function() {    	
    	$.ajax({
    		method : "POST",
    		url : "getObras",
    		data : {
    			idRevolvente : '0'
    		},
    		success : function(data) {  			 
    	          var obj=JSON.parse(data);	   
    	          if( obj.success ){	
    	        	  obj.modelo.forEach(function(obra) {
    	        		  obrasMap.set(obra.idObra, obra.nombreCliente );
    	        		  $('#idObra').append($('<option>', {value:obra.idObra, text:obra.nombre}));
    	        		  $('#idObraFiltro').append($('<option>', {value:obra.idObra, text:obra.nombre}));  
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
    seleccionaClientePorObra: function(obra){
    	$('#cliente').val( obrasMap.get( parseInt(obra.value) ));
    },
    seleccionaClientePorObraFiltro: function(obra){
    	$('#clienteFiltro').val( obrasMap.get( parseInt(obra.value) ));
    },
    limpiaModalRevolvente: function(obra){
    	  $("#divError").hide(); 
    	
		  $("#descripcion").val("");
		  $("#monto").val("");
		  $("#cliente").val("");
		  $("#cantidad").val("1");
		  
		  
		  document.getElementById("radioIngreso").checked = false;
		  document.getElementById("radioGasto").checked = false;
		  
		  $("#idObra").val(0);
		  $("#idVehiculo").val(0);
		  
		  $("#gastosEnVehiculosDiv").attr("hidden",true);
  	      $("#gastosEnObrasDiv").attr("hidden",true);
    }, /**INVENTARIOO **/
    nuevoInventarios : function() {

		$("#btnModalInventario").empty().append("Guardar");
		$("#titleModalInventario").empty().append("Nuevo Inventario");
		$("#tipoOperacion").val("guardar");
		$("#idInventario").val("0");
		$("#total").val("0");
		
		OperacionesJS.limpiaModalInventario();
		
		$('#modalInventarios').modal('show');

	},
	editaInventario : function(idInventario) {

		$("#divError").hide(); 
		
		$("#btnModalInventario").empty().append("Actualizar");
		$("#titleModalInventario").empty().append("Actualizar Inventario");
		$("#tipoOperacion").val("actualizar");
		$("#idInventario").val(idInventario);
		
		OperacionesJS.llenaInventario(idInventario);
		
		$('#modalInventarios').modal('show');

	},
	validaEliminarInventario : function(idInventario, descripcion) {

		$("#descripcionEliminarInventario").empty();
		$("#descripcionEliminarInventario").append(descripcion);
		$("#idInventario").val(idInventario);

		$('#modalEliminaInventario').modal('show');

	},
	validaGuardaInventario : function() {    
		
    	$("#divError").empty();
    	$("#divError").hide();  
    	
    	var mensaje = "Está seguro que desea " + $("#tipoOperacion").val() + " este registro?";
    	if( confirm(mensaje) ){
    		
    		if (OperacionesJS.camposVaciosFaltantesInventario()){
    			OperacionesJS.doNuevoInventario( $("#tipoOperacion").val() );
    		}
    		
    	}else{
    		
    	}	
    },
    doNuevoInventario : function(tipoOperacion) {
    	
		var objInventario = {
				idInventario : $("#idInventario").val(),				
				cantidad : $("#cantidad").val(),
				enRenta : $("#enRenta").val(),
				descripcion : $("#descripcion").val(),
				precioUnitario : $("#precioUnitario").val(),
				total :  $("#total").val()				  
		};
		
		
    	$.ajax({
    		method : "POST",
    		url : "doGuardaInventario",
    		data : {
    			esNuevo : $("#tipoOperacion").val() == "guardar" ? "1" : "0",
    			inventario : JSON.stringify(objInventario)
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
    	
		$('#modalInventarios').modal('hide');
		
    },
    doEliminaInventario : function() {
    	
    	$.ajax({
    		method : "POST",
    		url : "doEliminaInventario",
    		data : {
    			idInventario : $("#idInventario").val()
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
    llenaInventario: function(idInventario){
    	
  	  $.ajax({
  		method : "POST",
  		url : "getInventarioById",
  		data : {
  			idInventario : idInventario
  		},
  		success : function(data) {  			 
  	          var obj=JSON.parse(data);	   
  	          if( obj.success ){	    	        	
  	        	  
  	        	  $("#idInventario").val(obj.modelo.idInventario);
	  	  		  $("#cantidad").val(obj.modelo.cantidad);
	  			  $("#enRenta").val(obj.modelo.enRenta);
	  			  $("#descripcion").val(obj.modelo.descripcion);
	  			  $("#precioUnitario").val(obj.modelo.precioUnitario);
	  			  $("#total").val(obj.modelo.total);
	  			  $("#fechaCreacion").val(obj.modelo.fechaCreacion);
	  			  $("#fechaCreacion").val(obj.modelo.fechaAlta);
	  			  
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
  camposVaciosFaltantesInventario: function() {
  	
  	var mensaje = 'Favor de completar los campos: <b>';
  	var empty = true;
  	var coma = "";
  	
		var objValidacion = {
				idInventario : $("#idInventario").val(),				
				cantidad : $("#cantidad").val(),
				enRenta : $("#enRenta").val(),
				descripcion : $("#descripcion").val(),
				precioUnitario : $("#precioUnitario").val(),
				total :  $("#total").val()				  
		};
		
		if( objValidacion.cantidad == '' ){
			mensaje = mensaje + "Cantidad";		
			empty = false;
		}		
		if( objValidacion.descripcion == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Descripción";	
			empty = false;
		}
		if( objValidacion.precioUnitario == '' ){
			coma = empty ? "" : ",";
			mensaje = mensaje + coma + "Precio unitario";
			empty = false;
		}
		
		if( empty==false ){
			mensaje = mensaje + '</b>';
			$("#divError").html(mensaje);
			$("#divError").show();
		}
		
		return empty;
		
  },limpiaModalInventario: function(obra){
    	  $("#divError").hide(); 
    	
		  $("#cantidad").val("");
		  $("#enRenta").val("0");
		  $("#descripcion").val("");
		  $("#precioUnitario").val("");
		  $("#total").val("");
		  $("#fechaCreacion").val("");
		  
  },
    
    
};

//$(function() {
//	  $('input[name="daterange"]').daterangepicker({
//	    opens: 'left'
//	  }, function(start, end, label) {
//	    console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
//	  });
//	});

$(function() {
	  $('input[name="daterange"]').daterangepicker({
	      autoUpdateInput: false,
	      locale: {
	          cancelLabel: 'Limpiar',
	          applyLabel: 'Aplicar'
	          //format: 'DD/MM/YYYY'
	      }
	  });

	  $('input[name="daterange"]').on('apply.daterangepicker', function(ev, picker) {
	      $(this).val(picker.startDate.format('YYYY/MM/DD') + ' - ' + picker.endDate.format('YYYY/MM/DD'));
	  });

	  $('input[name="daterange"]').on('cancel.daterangepicker', function(ev, picker) {
	      $(this).val('');
	  });
});




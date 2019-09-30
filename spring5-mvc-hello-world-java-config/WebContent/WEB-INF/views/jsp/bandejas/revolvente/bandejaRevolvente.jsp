<html>
<head>
  <title>${nombreBandeja}</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
	<link
	href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet" type="text/css" media="screen">
	
	<link
	href="${pageContext.request.contextPath}/resources/css/datatable/dataTables.bootstrap.min.css"
	rel="stylesheet" type="text/css" media="screen">
</head>

<style>
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: black;
   color: white;
   text-align: center;
}
.div{
    margin-right: 0px;
    margin-left: 0px;
}

</style>

<body>
	<jsp:include page="/WEB-INF/views/jsp/header.jsp" />
	<input id="tipoBandeja" type="text"  value="${tipoBandeja}" hidden>	
	<br>
	 
	<div class="container">
	  
	</div>
	<div class="row">
		<div class="col col-md-4 offset-md-2" >
			<h4> ${nombreBandeja} : </h4>
		</div>
		<div class="col col-md-2 offset-md-3" >
			<button type="button" class="btn btn-warning" onclick="OperacionesJS.nuevoRevolvente()">
				<span style="color: white;">
					<i class="fas fa-plus"></i>Nuevo revolvente
				</span>
			</button>
		</div>
		<p>
	</div>
	<div class="row">
	&nbsp;
	</div>
	<hr />
	<div class="row" >
		<div class="control-label col-md-1 offset-md-1 form-group" >
	      <label>¿Hoy?:</label>
	    </div>
	    <div class="col-md-2">          
			<input type="checkbox" id="hoyCheckCriteria" name="hoyCheckCriteria" class="form-control" value="0">
		</div>    
	    <div class="control-label col-md-1 form-group" >
	      <label>Tipo operación:</label>
	    </div>
	    <div class="col-md-2">          
			<select name="idGastoCriteria" id="idGastoCriteria" class="form-control">
			  <option value="0">Seleccione</option> 
			  <option value="2">INGRESO</option> 
			  <option value="1">GASTO</option> 
			</select>
	    </div>
	</div>
	<div class="row" >
    	<div class="control-label col-md-1 offset-md-1 form-group" >
	      <label>Rango de fecha:</label>
	    </div>
	    <div class="col-md-2">          
			<input type="text" name="daterange" id="daterange" class="form-control"/>
	    </div>	    
	    <div class="control-label col-md-1 form-group" >
	      <label>Vehículo:</label>
	    </div>
	    <div class="col-md-2">          
			<select name="idVehiculoFiltro" id="idVehiculoFiltro" class="form-control">
			  <option value="0">Seleccione</option> 
			</select>
	    </div>
	</div>	
	<div class="row" >
		 <div class="control-label col-md-1 offset-md-1 form-group" >
	      <label>Obra:</label>
	    </div>
	    <div class="col-md-2">          
			<select name="idObraFiltro" id="idObraFiltro" class="form-control" onchange="OperacionesJS.seleccionaClientePorObraFiltro(this);">
			  <option value="0">Seleccione</option> 
			</select>
	    </div>
	  	<div class="control-label col-md-1 form-group" >
	      <label>Cliente:</label>
	    </div>
	    <div class="col-md-2">         
	    	<input type="text" class="form-control" id="clienteFiltro" name="cliente" maxlength="140" disabled>
	    </div>
	    <div class="control-label col-md-1 offset-md-1 form-group" >
	      	<button type="button" class="btn btn-info" onclick="BandejaGeneralJS.busquedBandejaRevolvente()">
				<span style="color: white;">
					<i class="fas fa-search"></i>Buscar
				</span>
			</button>
	    </div>
	</div>
	<hr />
	<div class="row">
	&nbsp;
	</div>
	<div class="row" id="tableBandejaGeneral">
		<div class="col col-md-10 offset-md-1" id="tableBandejaGeneral">
			<div class="table-responsive">
				<table id="tableRevolvente"
					class="table table-striped table-bordered dt-responsive nowrap table-hover table-condensed">
					<thead>
						<tr>
							<th width="15%">FECHA</th>
							<th width="5%"> # </th>
							<th width="45%">DESCRIPCION</th>
							<th width="10%">MONTO:</th>	
							<th width="15%">TIPO</th>													
							<!-- <th>OBRA</th>
							<th>CLIENTE</th>-->
							<th width="5%">Editar:</th>
							<th width="5%">Borrar:</th> 
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				</div>
		</div>
	</div>
	<p>
	<div class="row">
		<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	</div>
	<p>
    <div class="row">
	&nbsp;
	</div>
	<%@ include file="modal/modalRevolvente.jsp"%>
	<%@ include file="modal/modalEliminaRevolvente.jsp"%>
	<jsp:include page="/WEB-INF/views/jsp/footer.jsp" />
</body>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/datatable/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
  <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/general.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/js/bandejas/bandejaGeneral.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/operaciones/operaciones.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/vehiculos/vehiculos.js"></script>
  <script src="https://coreui.io/docs/assets/js/jquery.maskedinput.min.js"></script>
  <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
  
  <script type="text/javascript">
  tablaGlobal = $('#tableRevolvente').DataTable({
		columns : [
		// { mData: "id" },
		{
			mData : "fecha"
		}, {
			mData : "cantidad"
		}, {
			mData : "descripcion"
		}, {
			mData : "monto",
			className: "text-right"
		}, {
			mData : "tipo"
		}, { 
			mData: "editar" 
		}, { 
			mData: "borrar" } ]
	});
  

  </script>
  
  <script>
  	BandejaGeneralJS.cargaBandejaGeneral($('#tipoBandeja').val());
  	OperacionesJS.obtieneInventariosSelect();
  	OperacionesJS.obtieneObrasSelect();
  	VehiculosJS.obtieneVehiculosSelect();
  	
  //Calculating chart
  	
  	
  	$("#divError").hide(); 
  	
  	$("input[name=gastoRadio]").change(function(){
  	    var  esIngreso = $("input[name=gastoRadio]").filter(":checked").val();
  	    
  	    if(esIngreso == "1"){  	    	
  	    	$("#idVehiculo").val(0);
  	    	$("#idVehiculo").change();
  	    	$("#gastosEnVehiculosDiv").attr("hidden",true);
  	    	$("#gastosEnObrasDiv").attr("hidden",false);
  	    	
  	    }else{
  	    	$("#idObra").val(0);
  	    	$("#idObra").change();
  	    	$("#gastosEnObrasDiv").attr("hidden",true);
  	    	$("#gastosEnVehiculosDiv").attr("hidden",false);
  	    }
  	});
  	
  	$("input[name=checkInventario]").change(function(){
  		
  	    var  esInventario = $("#checkInventario").is(":checked");
  	
  	    if(esInventario){  	    	
  	    	
  	    	$("#muestraInventarioDiv").attr("hidden",false);
  	    	$('#inputId').prop('readonly', true);
  	    }else{  	    	
  	    	$("#muestraInventarioDiv").attr("hidden",true);
  	    }
  	    
  	    
  	});
  	
  	$("#idInventario").change(function(){
  		
  	    var valorInventario = $("#idInventario").val();
  	    var cantidad = $("#cantidad").val();
  	    var precioInventario = inventariosMap.get( parseInt(valorInventario) );
  	    
  	    alert(precioInventario);
  	    
  	    if(valorInventario == 0){  	    	
  	    	alert("Es nuevo" + precioInventario);
  	    	$('#precioUnitario').prop('readonly', false);
  	    	$('#monto').prop('readonly', false);
  	    	
  	    	$('#monto').val('');
  	    	$('#precioUnitario').val('');
  	    	
  	    }else{  	    	
  	    	alert("Cualquier otrao");
  	    	$('#precioUnitario').val( precioInventario );
  	    	
  	    	$('#precioUnitario').prop('readonly', true);
  	    	$('#monto').val( precioInventario * cantidad );
  	    	$('#monto').prop('readonly', true);
  	    	
  	    	
  	    }
  	});
  	
  	$("#cantidad").change(function(){
  		
  		var esNuevo = $("#tipoOperacion").val() == "guardar";
  		
  		if(esNuevo){
  			var esInventario = $("#checkInventario").is(":checked");
  			
  			if(esInventario){
  				
  				var cantidad = $("#cantidad").val();
  				var precioInventario = $('#precioUnitario').val();
  				$('#monto').val( precioInventario * cantidad );
  				
  			}  				
  		}	 		
  	    
  	});
  	
	$("#precioUnitario").change(function(){
  		
  		var esNuevo = $("#tipoOperacion").val() == "guardar";
  		
  		if(esNuevo){
  			var esInventario = $("#checkInventario").is(":checked");
  			
  			if(esInventario){
  				
  				var cantidad = $("#cantidad").val();
  				var precioInventario = $('#precioUnitario').val();
  				$('#monto').val( precioInventario * cantidad );
  				
  			}  				
  		}	 		
  	    
  	});
	
	$("#hoyCheckCriteria").change(function(){
		
		var esHoyCriteria = $("#hoyCheckCriteria").is(":checked");
			
			if(esHoyCriteria){
				$("#daterange").val('');
				$('#daterange').prop('disabled', true);			
			}else{
				$("#daterange").val('');
				$('#daterange').prop('disabled', false);
			}
			
		
	});
  </script>


</html>
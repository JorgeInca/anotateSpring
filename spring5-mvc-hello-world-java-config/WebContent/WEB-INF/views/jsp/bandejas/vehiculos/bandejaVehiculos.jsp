<html>
<head>
  <title>${nombreBandeja}</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
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
			<button type="button" class="btn btn-warning" onclick="VehiculosJS.nuevoVehiculo()">
				<span style="color: white;">
					<i class="fas fa-plus"></i>Nuevo
				</span>
			</button>
		</div>
		<p>
	</div>
	<div class="row">
	&nbsp;
	</div>
	<div class="row" id="tableBandejaGeneral">
		<div class="col col-md-8 offset-md-2" id="tableBandejaGeneral">
			<div class="table-responsive">
				<table id="tableVehiculos"
					class="table table-striped table-bordered dt-responsive nowrap table-hover table-condensed"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>DESCRIPCION</th>
							<th>MARCA</th>
							<th>MODELO</th>
							<th>MATRICULA</th>
							<th>COLOR</th>							
							<th>AÑO</th>
							<th>DETALLE</th>
							<th>EDITAR</th>
							<th>BORRAR</th> 
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				</div>
		</div>
	</div>
	<%@ include file="modal/modalVehiculos.jsp"%>
	<%@ include file="modal/modalEliminaVehiculos.jsp"%>
	<jsp:include page="/WEB-INF/views/jsp/footer.jsp" />
</body>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/datatable/jquery.dataTables.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/general.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/js/bandejas/bandejaGeneral.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/vehiculos/vehiculos.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.13.4/jquery.mask.min.js"></script>
  
  
  <script type="text/javascript">
  tablaGlobal = $('#tableVehiculos').DataTable({
		columns : [
		// { mData: "id" },
		{
			mData : "descripcion"
		}, {
			mData : "marca"
		}, {
			mData : "modelo"
		}, { 
			mData: "matricula" 
		}, { 
			mData: "color" 
		},{ 
			mData: "anio" 
		}, {
			mData : "detalle"
		},{
			mData : "editar"
		},{
			mData : "borrar"
		}, ]
	});
  
  </script>
  
  <script>
  	BandejaGeneralJS.cargaBandejaGeneral($('#tipoBandeja').val()); 
  	
  	$("#divError").hide(); 
  </script>

</html>
<html>
<head>
  <title>${nombreBandeja}</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/all.css">
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
			<button type="button" class="btn btn-warning" onclick="OperacionesJS.nuevoInventarios()">
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
		<div class="col col-md-10 offset-md-1" id="tableBandejaGeneral">
			<div class="table-responsive">
				<table id="tableInventarios"
					class="table table-striped table-bordered dt-responsive nowrap table-hover table-condensed"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>CANTIDAD</th>
							<th>DESCRIPCION</th>
							<th>EN RENTA</th>
							<th>PRECIO</th>
							<th>TOTAL</th>							
							<th>Editar:</th>
							<th>Borrar:</th> 
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				</div>
		</div>
	</div>
	<%@ include file="modal/modalInventarios.jsp"%>
	<%@ include file="modal/modalEliminaInventarios.jsp"%>
	<jsp:include page="/WEB-INF/views/jsp/footer.jsp" />
</body>

  <script src="${pageContext.request.contextPath}/resources/js/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/tools/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/datatable/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tools/moment.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/daterangepicker/daterangepicker.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/general.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/js/bandejas/bandejaGeneral.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/operaciones/operaciones.js"></script>
  
  <script type="text/javascript">
  tablaGlobal = $('#tableInventarios').DataTable({
		columns : [
		// { mData: "id" },
		{
			mData : "cantidad"
		}, {
			mData : "descripcion"
		}, {
			mData : "enRenta"
		}, { 
			mData: "precioUnitario" 
		}, { 
			mData: "total" 
		}, { 
			mData: "editar" 
		}, { 
			mData: "borrar" } ]
	});
  
  </script>
  
  <script>
  	BandejaGeneralJS.cargaBandejaGeneral($('#tipoBandeja').val()); 
  	$("#divError").hide(); 
  	
  	$(".precioTotal").change(function(){
  		var cantidad = $("#cantidad").val();
  		var precioUnitario = $("#precioUnitario").val(); 
  		
  		if( cantidad == '' || precioUnitario == '' ){
  			$("#total").val("0");
  		}else{
  			$("#total").val( cantidad * precioUnitario);
  		}
	});
  </script>

</html>
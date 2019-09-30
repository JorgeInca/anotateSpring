
<!-- The Modal -->
<div class="modal" id="modalRevolvente">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><div id="titleModalRevolvente"></div></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      	<div class="modal-body">
      	<div id="agregarInventarioDiv">	
	      	<div class="row" >
		    	<div class="col-md-4 form-group" >
			      <label class="control-label col-sm-2" for="checkInventario">¿Agregar a Inventario?</label>
			    </div>
			    <div class="col-md-6 col-md-offset-2 form-group">          
				   <input type="checkbox" id="checkInventario" name=checkInventario class="form-control" value="0">
			    </div>
			</div>
		</div>
		<div id="muestraInventarioDiv">	
	       <div class="row" >
		    	<div class="col-md-4 form-group" >
			      <label class="control-label col-sm-2" for="idInventario">Inventario:</label>
			    </div>
			    <div class="col-md-6 col-md-offset-2 form-group">          
					<select name="idInventario" id="idInventario" class="form-control" onchange="">
					  <option value="0">** [NUEVO] **</option> 
					</select>
			    </div>
			</div>
		    <div class="row" >
		    	<div class="col-md-4 form-group" >
		     		<label class="control-label col-sm-2" for="pwd">Precio Unitario:</label>
		    	</div>
		    	<div class="col-md-6 col-md-offset-2 form-group">          
		       		<input type="text" class="form-control money" id="precioUnitario" name="precioUnitario" maxlength="140">
		    	</div>
			</div>
		</div>
      	 <div class="row" >
		    	<div class="col-md-4 form-group" >
			      <label class="control-label col-sm-2" for="pwd">Cantidad:</label>
			    </div>
			    <div class="col-md-6 col-md-offset-2 form-group">          
			       <input type="text" class="form-control number" id="cantidad" name="cantidad" maxlength="140">
			    </div>
		</div>
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Descripción:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="descripcion" name="descripcion" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Monto:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control money" id="monto" name="monto" maxlength="140">
		    </div>
		</div>
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="esIngreso">Ingreso:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
			    <input type="radio" id="radioIngreso" name="gastoRadio" class="form-control" value="1">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="esIngreso">Egreso:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
			   <input type="radio" id="radioGasto" name="gastoRadio" class="form-control" value="0">
		    </div>
		</div>
		
		<hr />	
		<div id="gastosEnObrasDiv">	
			<div class="row" >
		    	<div class="col-md-4 form-group" >
			      <label class="control-label col-sm-2" for="idObra">Obra:</label>
			    </div>
			    <div class="col-md-6 col-md-offset-2 form-group">          
					<select name="idObra" id="idObra" class="form-control" onchange="OperacionesJS.seleccionaClientePorObra(this);">
					  <option value="0">Seleccione</option> 
					</select>
			    </div>
			</div>
			<div class="row" >
		    	<div class="col-md-4 form-group" >
			      <label class="control-label col-sm-2" for="pwd">Cliente:</label>
			    </div>
			    <div class="col-md-6 col-md-offset-2 form-group">          
			       <input type="text" class="form-control" id="cliente" name="cliente" maxlength="140" readonly="readonly">
			    </div>
			</div>
		</div>
		<div id="gastosEnVehiculosDiv">	
			<div class="row" >
		    	<div class="col-md-4 form-group" >
			      <label class="control-label col-sm-2" for="idObra">Vehículo:</label>
			    </div>
			    <div class="col-md-6 col-md-offset-2 form-group">          
					<select name="idVehiculo" id="idVehiculo" class="form-control">
					  <option value="0">Seleccione</option> 
					</select>
			    </div>
			</div>
			<input id="tipoOperacion" type="text"  hidden>
			<input id="idRevolvente" type="text"  hidden>	
	   </div>
	   <div id="divError" class="alert alert-danger" role="alert" ></div>
	  </div>
      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="button" class="btn btn-warning" onClick="OperacionesJS.limpiaModalRevolvente();">
      			<span style="color: white;">Limpiar</span>
		</button>
      	<button type="button" class="btn btn-success" onClick="OperacionesJS.validaGuardaRevolvente();"><div id="btnModalRevolvente"></div></button>
        <button type="button" class="btn btn-danger" data-dismiss="modal" >Cancelar</button>
      </div>

    </div>
  </div>
</div>

<!-- The Modal -->
<div class="modal" id="modalInventarios">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><div id="titleModalInventario"></div></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
            <!-- Modal body -->
      <div class="modal-body">
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Cantidad:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control number precioTotal" id="cantidad" name="cantidad" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">En renta:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control number" id="enRenta" name="enRenta" maxlength="140" readonly>
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
		      <label class="control-label col-sm-2" for="pwd">PrecioUnitario:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control number precioTotal" id="precioUnitario" name="precioUnitario" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Total:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control number" id="total" name="total" maxlength="140" readonly>
		    </div>
		</div>
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Fecha Creación:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="fechaCreacion" name="fechaCreacion" maxlength="140" readonly>
		    </div>
		</div>
		<input id="tipoOperacion" type="text"  hidden>
		<input id="idInventario" type="text"  hidden>
		<div id="divError" class="alert alert-danger" role="alert" ></div>	
	  </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" onClick="OperacionesJS.limpiaModalInventario();">
      			<span style="color: white;">Limpiar</span>
		</button>
      	<button type="button" class="btn btn-success"  onClick="OperacionesJS.validaGuardaInventario();"><div id="btnModalInventario"></div></button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
      </div>

    </div>
  </div>
</div>
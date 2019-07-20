
<!-- The Modal -->
<div class="modal" id="modalObra">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><div id="titleModalObra"></div></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
            <!-- Modal body -->
      <div class="modal-body">
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Nombre:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="nombre" name="nombre" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Dirección:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="direccion" name="direccion" maxlength="140">
		    </div>
		</div>
		<div class="row" >
		    	<div class="col-md-4 form-group" >
			      <label class="control-label col-sm-2" for="idCliente">Cliente:</label>
			    </div>
			    <div class="col-md-6 col-md-offset-2 form-group">          
					<select name="idCliente" id="idCliente" class="form-control" onchange="ObrasJS.seleccionaTelefonoPorCliente(this);">
					  <option value="0">Seleccione</option> 
					</select>
			    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Teléfono:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control number" id="telefono" name="telefono" maxlength="140" readonly>
		    </div>
		</div>
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Fecha Inicio:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="fechaInicio" name="fechaInicio" maxlength="140" readOnly>
		    </div>
		</div>
		<input id="tipoOperacion" type="text"  hidden>
		<input id="idObra" type="text"  hidden>
		<div id="divError" class="alert alert-danger" role="alert" ></div>	
	  </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" onClick="ObrasJS.limpiaModalObra();">
      			<span style="color: white;">Limpiar</span>
		</button>
      	<button type="button" class="btn btn-success"  onClick="ObrasJS.validaGuardaObra();"><div id="btnModalObra"></div></button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
      </div>

    </div>
  </div>
</div>
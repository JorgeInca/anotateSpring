
<!-- The Modal -->
<div class="modal" id="modalVehiculo">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><div id="titleModalVehiculo"></div></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      	<div class="modal-body">
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
			      <label class="control-label col-sm-2" for="pwd">Marca:</label>
			    </div>
			    <div class="col-md-6 col-md-offset-2 form-group">          
			       <input type="text" class="form-control" id="marca" name="marca" maxlength="140">
			    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Modelo:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="modelo" name="modelo" maxlength="140">
		    </div>
		</div>
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Matrícula:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="matricula" name="matricula" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Color:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="color" name="color" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Año:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control number" id="anio" name="anio" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Serie:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control number" id="serie" name="serie" maxlength="140">
		    </div>
		</div>
		<input id="tipoOperacion" type="text"  hidden>
		<input id="idVehiculo" type="text"  hidden>
	   <div id="divError" class="alert alert-danger" role="alert" ></div>
	  </div>
      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="button" class="btn btn-warning" onClick="VehiculosJS.limpiaModalVehiculo();">
      			<span style="color: white;">Limpiar</span>
		</button>
      	<button type="button" class="btn btn-success" onClick="VehiculosJS.validaGuardaVehiculo();"><div id="btnModalVehiculo"></div></button>
        <button type="button" class="btn btn-danger" data-dismiss="modal" >Cancelar</button>
      </div>

    </div>
  </div>
</div>
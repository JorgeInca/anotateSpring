
<!-- The Modal -->
<div class="modal" id="modalRenta">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><div id="titleModalRenta"></div></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
            <!-- Modal body -->
      <div class="modal-body">
		<div class="row" >
		    	<div class="col-md-4 form-group" >
			      <label class="control-label col-sm-2" for="idCliente">Empleado:</label>
			    </div>
			    <div class="col-md-6 col-md-offset-2 form-group">          
					<select name="idEmpleado" id="idEmpleado" class="form-control">
					  <option value="0">Seleccione</option> 
					</select>
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
		      <label class="control-label col-sm-2" for="pwd">Fecha Inicio:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="fechaInicio" name="fechaInicio" maxlength="140" readonly>
		    </div>
		</div>
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Fecha entrega:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="fechaEntrega" name="fechaEntrega" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Valor Final:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control number" id="telefono" name="telefono" maxlength="140" readonly>
		    </div>
		</div>
		
		<hr />	
		
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Inventario:</label>
		    </div>
		</div>
		<div class="row" >
		     <table class="table table-bordered" id="item_table">
		      <tr>
		       <th width="16%">#</th>
		       <th width="64%">Elemento</th>
		       <th width="20%">Total</th>
		       <th><button type="button" name="add" class="btn btn-success btn-sm add"><i class="fas fa-plus"></i></button></th>
		      </tr>
		     </table>
		</div>
		
		<input id="tipoOperacion" type="text"  hidden>
		<input id="idRenta" type="text"  hidden>
		<div id="divError" class="alert alert-danger" role="alert" ></div>	
	  </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" onClick="RentasJS.limpiaModalRenta();">
      			<span style="color: white;">Limpiar</span>
		</button>
      	<button type="button" class="btn btn-success"  onClick="RentasJS.validaGuardaRenta();"><div id="btnModalRenta"></div></button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
      </div>

    </div>
  </div>
</div>
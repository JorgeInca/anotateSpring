
<!-- The Modal -->
<div class="modal" id="modalCliente">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><div id="titleModalCliente"></div></h4>
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
		      <label class="control-label col-sm-2" for="pwd">Apellidos:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="apellidos" name="apellidos" maxlength="140">
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
		      <label class="control-label col-sm-2" for="pwd">Teléfono:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control number" id="telefono" name="telefono" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Correo:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="email" name="email" maxlength="140">
		    </div>
		</div>
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Fecha Nacimiento:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="fechaNac" name="fechaNac" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Edad:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="edad" name="edad" maxlength="140" readonly>
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">RFC:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="rfc" name="rfc" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Nombre Empresa:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="nombreEmpresa" name="nombreEmpresa" maxlength="140">
		    </div>
		</div>
		<input id="tipoOperacion" type="text"  hidden>
		<input id="idCliente" type="text"  hidden>
		<div id="divError" class="alert alert-danger" role="alert" ></div>	
	  </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" onClick="PersonasJS.limpiaModalCliente();">
      			<span style="color: white;">Limpiar</span>
		</button>
      	<button type="button" class="btn btn-success"  onClick="PersonasJS.validaGuardaCliente();"><div id="btnModalCliente"></div></button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
      </div>

    </div>
  </div>
</div>
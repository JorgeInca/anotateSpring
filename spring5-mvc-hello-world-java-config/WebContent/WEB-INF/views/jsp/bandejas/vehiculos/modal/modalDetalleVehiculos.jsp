<!-- The Modal -->
<div class="modal" id="modalDetalleVehiculos">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><div id="titleModalDetalleVehiculo"></div></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      	<div class="modal-body">

		<input id="tipoOperacion" type="text"  hidden>
		<input id="idDetalleVehiculo" type="text"  hidden>
	   <div id="divErrorDetalle" class="alert alert-danger" role="alert" ></div>
	  </div>
      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="button" class="btn btn-warning" onClick="VehiculosJS.limpiaModalDetalleVehiculo();">
      			<span style="color: white;">Limpiar</span>
		</button>
      	<button type="button" class="btn btn-success" onClick="VehiculosJS.validaGuardaDetalleVehiculo();"><div id="btnModalDetalleVehiculo"></div>Guardar</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal" >Cancelar</button>
      </div>

    </div>
  </div>
</div>

<!-- The Modal -->
<div class="modal" id="modalEliminaInventario">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Elimina Inventario</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body alert alert-danger">
        ¿Deseas eliminar siguiente registro? 
        <p></p> <div id="descripcionEliminarInventario"></div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      <button type="button" class="btn btn-success" data-dismiss="modal" onClick="OperacionesJS.doEliminaInventario();">Eliminar</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
      </div>

    </div>
  </div>
</div>
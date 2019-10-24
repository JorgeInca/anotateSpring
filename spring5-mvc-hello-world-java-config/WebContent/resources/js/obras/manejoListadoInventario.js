
var ManejoInventario = {
	nuevoObra : function() {

	},
};


$(document).on('click', '.add', function(){
	  var html = '';
	  html += '<tr>';
	  html += '<td><input type="text" name="item_name[]" class="form-control item_name" /></td>';
	  html += '<td><select name="item_unit[]" class="form-control item_unit"><option value="">Select Unit</option><?php echo fill_unit_select_box($connect); ?></select></td>';
	  html += '<td><input type="text" name="item_quantity[]" class="form-control item_quantity" /></td>';
	  html += '<td><button type="button" name="remove" class="btn btn-danger btn-sm remove"><i class="fas fa-minus"></i></button></td></tr>';
	  $('#item_table').append(html);
});

$(document).on('click', '.remove', function(){
	  $(this).closest('tr').remove();
});
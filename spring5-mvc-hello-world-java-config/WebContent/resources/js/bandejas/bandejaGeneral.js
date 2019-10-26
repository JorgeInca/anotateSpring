var tablaGlobal;

var BandejaGeneralJS = {
	radius : 10,
	cargaBandejaGeneral : function(tipoBandejaVar) {

		tablaGlobal.clear().draw();

		var obj = {};
		obj['user'] = 'jorge';
		obj['tipoBandeja'] = 'loco';

		$.ajax({
			method : "POST",
			url : "getDatosBandeja",
			data : {
				user : '2',
				tipoBandeja : tipoBandejaVar
			},
			success : function(data) {
				var obj = JSON.parse(data);
				if (obj.success) {
					BandejaGeneralJS.llenaDatosBandejaRevolvente(
							tipoBandejaVar, obj.modelo);
				} else {

				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});

	},
	buscaBandejaGeneral : function(tipoBandejaVar, criteriaVar) {

		tablaGlobal.clear().draw();

		var obj = {};
		obj['user'] = 'jorge';
		obj['tipoBandeja'] = 'loco';

		$.ajax({
			method : "POST",
			url : "getDatosBandejaCriteria",
			data : {
				user : '2',
				tipoBandeja : tipoBandejaVar,
				criteria : JSON.stringify(criteriaVar)
			},
			success : function(data) {
				var obj = JSON.parse(data);
				if (obj.success) {
					BandejaGeneralJS.llenaDatosBandejaRevolvente(
							tipoBandejaVar, obj.modelo);
				} else {

				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});

	},
	llenaDatosBandejaRevolvente : function(tipoBandejaVar, modelo) {
		
		chartRevolventeGastos = []; 
		chartRevolventeIngresos = []; 
		
		if (modelo.length > 0) {
			modelo.forEach(function(revolvente) {

				var obj = BandejaGeneralJS.llenaObjetoPorTipoBandeja(
						tipoBandejaVar, revolvente);
				console.log(obj);

				tablaGlobal.row.add(obj).draw();
			});
		}
	},
	llenaObjetoPorTipoBandeja : function(tipoBandejaVar, modelo) {
		console.log('tipoBandeja: ' + tipoBandejaVar);
		var obj;

		if (tipoBandejaVar == TipoBandejaEnum.BANDEJA_REVOLVENTE.idTipoBandeja) {
			obj = {
				fecha : modelo.fecha,
				descripcion : modelo.descripcion,
				cantidad : modelo.cantidad,
				monto : formateaComasNumero(modelo.monto) + " MXN",
				tipo : (modelo.esIngreso ? 'INGRESO' : 'GASTO'),
				editar : '<button  id="btnActualizar" class="btn btn-primary btn-sm" onClick="javascript: OperacionesJS.editaRevolvente('
						+ modelo.idRevolvente
						+ ');"><span style="color: white;"><i class="fas fa-edit"></i></span></button>',
				borrar : '<button  class="btn btn-danger btn-sm" onClick="javascript: OperacionesJS.validaEliminarRevolvente('
						+ modelo.idRevolvente
						+ ',\''
						+ modelo.descripcion
						+ '\');"><span style="color: white;"><i class="fas fa-trash"></i></span></button>'
			};
			
			if(modelo.esIngreso){
				chartRevolventeIngresos.push(modelo);
			}else{
				chartRevolventeGastos.push(modelo);
			}
			
			OperacionesJS.calculaChartRevolvente();
			
		}
		if (tipoBandejaVar == TipoBandejaEnum.BANJDEJA_PERSONAS_CLIENTE.idTipoBandeja) {

			var dateParts = modelo.fechaString.split("/");

			obj = {
				nombre : modelo.nombre,
				apellidos : modelo.apellidos,
				empresa : modelo.nombreEmpresa,
				telefono : modelo.telefono,
				email : modelo.email,
				edad : moment()
						.diff(
								new Date(+dateParts[2], dateParts[1] - 1,
										+dateParts[0]), 'years'),
				rfc : modelo.rfc,
				editar : '<button  id="btnActualizar" class="btn btn-primary btn-sm" onClick="javascript: PersonasJS.editaCliente('
						+ modelo.idPersona
						+ ');"><span style="color: white;"><i class="fas fa-edit"></i></span></button>',
				borrar : '<button  class="btn btn-danger btn-sm" onClick="javascript: PersonasJS.validaEliminarCliente('
						+ modelo.idPersona
						+ ',\''
						+ modelo.nombre
						+ ' '
						+ modelo.apellidos
						+ '\');"><span style="color: white;"><i class="fas fa-trash"></i></span></button>'
			};

		}
		if (tipoBandejaVar == TipoBandejaEnum.BANJDEJA_PERSONAS_TRABAJADORES.idTipoBandeja) {
			var dateParts = modelo.fechaString.split("/");

			obj = {
				nombre : modelo.nombre,
				apellidos : modelo.apellidos,
				telefono : modelo.telefono,
				email : modelo.email,
				edad : moment()
						.diff(
								new Date(+dateParts[2], dateParts[1] - 1,
										+dateParts[0]), 'years'),
				numeroEmpleado : modelo.numeroEmpleado,
				editar : '<button  id="btnActualizar" class="btn btn-primary btn-sm" onClick="javascript: PersonasJS.editaEmpleado('
						+ modelo.idPersona
						+ ');"><span style="color: white;"><i class="fas fa-edit"></i></span></button>',
				borrar : '<button  class="btn btn-danger btn-sm" onClick="javascript: PersonasJS.validaEliminarEmpleado('
						+ modelo.idPersona
						+ ',\''
						+ modelo.nombre
						+ ' '
						+ modelo.apellidos
						+ '\');"><span style="color: white;"><i class="fas fa-trash"></i></span></button>'
			};
		}
		if (tipoBandejaVar == TipoBandejaEnum.BANDEJA_VEH_COBUSTIBLE.idTipoBandeja) {

		}
		if (tipoBandejaVar == TipoBandejaEnum.BANDEJA_VEH_MANTENIMIENTO.idTipoBandeja) {

		}
		if (tipoBandejaVar == TipoBandejaEnum.BANDEJA_VEH_VEHICULOS.idTipoBandeja) {
			obj = {
				descripcion : modelo.descripcion,
				marca : modelo.marca,
				modelo : modelo.modelo,
				color : modelo.color,
				matricula : modelo.matricula,
				anio : modelo.anio,
				serie : modelo.serie,
				detalle:  '<button  id="btnGuardar" class="btn btn-success btn-sm" onClick="javascript: VehiculosJS.editaDetalleVehiculo('
					+ modelo.idVehiculo
					+ ');"><span style="color: white;"><i class="fas fa-edit"></i></span></button>',
				editar : '<button  id="btnActualizar" class="btn btn-primary btn-sm" onClick="javascript: VehiculosJS.editaVehiculo('
						+ modelo.idVehiculo
						+ ');"><span style="color: white;"><i class="fas fa-edit"></i></span></button>',
				borrar : '<button  class="btn btn-danger btn-sm" onClick="javascript: VehiculosJS.validaEliminarVehiculo('
						+ modelo.idVehiculo
						+ ',\''
						+ modelo.descripcion
						+ '\');"><span style="color: white;"><i class="fas fa-trash"></i></span></button>'
			};
		}
		if (tipoBandejaVar == TipoBandejaEnum.BANDEJA_OP_OBRAS.idTipoBandeja) {
			obj = {
				nombre : modelo.nombre,
				direccion : modelo.direccion,
				cliente : modelo.nombreCliente,
				telefono : modelo.telefonoCliente,
				editar : '<button  id="btnActualizar" class="btn btn-primary btn-sm" onClick="javascript: ObrasJS.editaObra('
						+ modelo.idObra
						+ ');"><span style="color: white;"><i class="fas fa-edit"></i></span></button>',
				borrar : '<button  class="btn btn-danger btn-sm" onClick="javascript: ObrasJS.validaEliminarObra('
						+ modelo.idObra
						+ ',\''
						+ modelo.descripcion
						+ '\');"><span style="color: white;"><i class="fas fa-trash"></i></span></button>'
			};
		}
		if (tipoBandejaVar == TipoBandejaEnum.BANDEJA_OP_RENTAS.idTipoBandeja) {
			obj = {
					idRenta : modelo.idRenta,
					idEmpleado : modelo.idEmpleado,
					descripcion : modelo.descripcion,					
					fechaAlta : modelo.fechaAlta,
					fechaInicio : modelo.fechaInicio,
					fechaFin : modelo.fechaFin != null ? modelo.fechaFin : 'x',
					valor : modelo.valor,
					estatus : modelo.estatus,
					editar : '<button  id="btnActualizar" class="btn btn-primary btn-sm" onClick="javascript: ObrasJS.editaRenta('
							+ modelo.idRenta
							+ ');"><span style="color: white;"><i class="fas fa-edit"></i></span></button>',
					borrar : '<button  class="btn btn-danger btn-sm" onClick="javascript: ObrasJS.validaEliminarRenta('
							+ modelo.idRenta
							+ ',\''
							+ modelo.descripcion
							+ '\');"><span style="color: white;"><i class="fas fa-trash"></i></span></button>'
				};
		}
		if (tipoBandejaVar == TipoBandejaEnum.BANDEJA_OP_INVENTARIOS.idTipoBandeja) {
			obj = {
					cantidad : modelo.cantidad,
					descripcion : modelo.descripcion,
					enRenta : modelo.enRenta,					
					precioUnitario : modelo.precioUnitario,
					total : modelo.total,
					editar : '<button  id="btnActualizar" class="btn btn-primary btn-sm" onClick="javascript: OperacionesJS.editaInventario('
							+ modelo.idInventario
							+ ');"><span style="color: white;"><i class="fas fa-edit"></i></span></button>',
					borrar : '<button  class="btn btn-danger btn-sm" onClick="javascript: OperacionesJS.validaEliminarInventario('
							+ modelo.idInventario
							+ ',\''
							+ modelo.descripcion
							+ '\');"><span style="color: white;"><i class="fas fa-trash"></i></span></button>'
				};
		}
		return obj;
	},
	busquedBandejaRevolvente : function(obra) {

		var fechaInicioFiltro = "";
		var fechaFinFiltro = "";

		if ($("#daterange").val() != "") {
			fechaInicioFiltro = $("#daterange").val().split(' - ')[0];
			fechaFinFiltro = $("#daterange").val().split(' - ')[1];
		}

		var idObraFiltro = $("#idObraFiltro").val();
		var idVehiculoFiltro = $("#idVehiculoFiltro").val();
		var hoy = $("#hoyCheckCriteria").is(":checked");
		var esIngreso = $("#idGastoCriteria").val();

		$("#daterange").val();

		var criteria = {
			fechaInicio : fechaInicioFiltro,
			fechaFin : fechaFinFiltro,
			idObra : idObraFiltro,
			idVehiculo : idVehiculoFiltro,
			hoy : hoy,
			esIngreso : esIngreso
		};

		BandejaGeneralJS.buscaBandejaGeneral(
				TipoBandejaEnum.BANDEJA_REVOLVENTE.idTipoBandeja, criteria);
	}
};

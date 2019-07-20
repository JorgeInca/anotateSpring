package com.mx.grupoTama.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.grupoTama.core.dao.VehiculosDAO;
import com.mx.grupoTama.core.service.VehiculosService;
import com.mx.grupoTama.modelo.Vehiculo;

@Service
public class VehiculosServiceImpl implements VehiculosService {

	@Autowired
	VehiculosDAO dao;

	@Override
	public List<Vehiculo> getVehiculos() throws Exception{
		System.out.println("Service - getVehiculos");
		return dao.getVehiculos();
	}

	@Override
	public void insertaVehiculo(Vehiculo Vehiculo) throws Exception{
		System.out.println("Service - insertaVehiculo");
		dao.insertaVehiculo(Vehiculo);
	}

	@Override
	public void actualizaVehiculo(Vehiculo Vehiculo) throws Exception{
		System.out.println("Service - actualizaVehiculo");
		dao.actualizaVehiculo(Vehiculo);
	}

	@Override
	public void eliminaVehiculo(Integer idVehiculo) throws Exception {
		System.out.println("Service - eliminaVehiculo");
		dao.eliminaVehiculo(idVehiculo);		
	}

	@Override
	public Vehiculo getVehiculoById(Integer idVehiculo) throws Exception {
		System.out.println("Service - getVehiculoById");
		return dao.getVehiculoById(idVehiculo);		
	}

}

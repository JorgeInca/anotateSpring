package com.mx.grupoTama.core.service;

import java.util.List;

import com.mx.grupoTama.modelo.Vehiculo;

public interface VehiculosService {
	public List<Vehiculo> getVehiculos() throws Exception;
	public Vehiculo getVehiculoById(Integer idVehiculo) throws Exception;
	public void insertaVehiculo(Vehiculo vehiculo) throws Exception;
	public void actualizaVehiculo(Vehiculo vehiculo) throws Exception;
	public void eliminaVehiculo(Integer vehiculo) throws Exception;
}

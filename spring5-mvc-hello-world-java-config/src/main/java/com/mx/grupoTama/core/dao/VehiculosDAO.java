package com.mx.grupoTama.core.dao;

import java.util.List;

import com.mx.grupoTama.modelo.Vehiculo;

public interface VehiculosDAO {

	public List<Vehiculo> getVehiculos() throws Exception;
	public Vehiculo getVehiculoById(Integer idVehiculo) throws Exception;
	public void insertaVehiculo(Vehiculo vehiculo) throws Exception;
	public void actualizaVehiculo(Vehiculo vehiculo) throws Exception;
	public void eliminaVehiculo(Integer idVehiculo) throws Exception;
}

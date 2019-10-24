package com.mx.grupoTama.core.service;

import java.util.List;

import com.mx.grupoTama.modelo.Inventario;
import com.mx.grupoTama.modelo.Obra;
import com.mx.grupoTama.modelo.Renta;

public interface OperacionesService {
	//Obras
	public List<Obra> getObras() throws Exception;
	public Obra getObraById(Integer idObra) throws Exception;
	public void insertaObra(Obra Obra) throws Exception;
	public void actualizaObra(Obra Obra) throws Exception;
	public void eliminaObra(Integer idObra) throws Exception;
	
	//Inventario
	public List<Inventario> getInventarios() throws Exception;
	public void insertaInventario(Inventario inventario) throws Exception;
	public void actualizaInventario(Inventario inventario) throws Exception;
	public void actualizaInventarioPorRevolvente(Inventario inventario) throws Exception;
	public Inventario getInventarioById(Long idInventario) throws Exception;
	void eliminaInventario(Integer idInventario) throws Exception;
	
	//Renta
	public List<Renta> getRentas() throws Exception;
	public void insertaRenta(Renta renta) throws Exception;
	public void actualizaRenta(Renta renta) throws Exception;
	public Renta getRentaById(Long idRenta) throws Exception;
	void eliminaRenta(Integer idRenta) throws Exception;
}

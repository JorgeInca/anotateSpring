package com.mx.grupoTama.core.dao;

import java.util.List;

import com.mx.grupoTama.modelo.Inventario;
import com.mx.grupoTama.modelo.Obra;

public interface OperacionesDAO {
	//Obras
	public List<Obra> getObras() throws Exception;
	public Obra getObraById(Integer idObra) throws Exception;
	public void insertaObra(Obra cliente) throws Exception;
	public void actualizaObra(Obra obra) throws Exception;
	public void eliminaObra(Integer idObra) throws Exception;
	
	//Inventario
	public List<Inventario> getInventarios() throws Exception;
	public void insertaInventario(Inventario inventario) throws Exception;
	public void actualizaInventario(Inventario inventario) throws Exception;
	public Inventario getInventarioById(Integer idInventario) throws Exception;
	void eliminaInventario(Integer idInventario) throws Exception;
}

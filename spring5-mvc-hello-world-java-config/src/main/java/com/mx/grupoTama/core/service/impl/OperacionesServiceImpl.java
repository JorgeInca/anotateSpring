package com.mx.grupoTama.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.grupoTama.core.dao.OperacionesDAO;
import com.mx.grupoTama.core.service.OperacionesService;
import com.mx.grupoTama.modelo.Inventario;
import com.mx.grupoTama.modelo.Obra;

@Service
public class OperacionesServiceImpl implements OperacionesService {

	@Autowired
	OperacionesDAO dao;

	@Override
	public List<Obra> getObras() throws Exception{
		System.out.println("Service - getObras");
		return dao.getObras();
	}
	
	@Override
	public Obra getObraById(Integer idObra) throws Exception{
		System.out.println("Service - getObraById");
		return dao.getObraById(idObra);
	}


	@Override
	public void insertaObra(Obra Obra) throws Exception{
		System.out.println("Service - insertaObra");
		dao.insertaObra(Obra);
	}

	@Override
	public void actualizaObra(Obra Obra) throws Exception{
		System.out.println("Service - actualizaObra");
		dao.actualizaObra(Obra);
	}

	@Override
	public void eliminaObra(Integer idObra) throws Exception {
		System.out.println("Service - eliminaObra");
		dao.eliminaObra(idObra);		
	}
	
	/** Inventarios*/
	
	@Override
	public List<Inventario> getInventarios() throws Exception{
		System.out.println("Service - getInventarios");
		return dao.getInventarios();
	}

	@Override
	public void insertaInventario(Inventario Inventario) throws Exception{
		System.out.println("Service - insertaInventario");
		dao.insertaInventario(Inventario);
	}

	@Override
	public void actualizaInventario(Inventario Inventario) throws Exception{
		System.out.println("Service - actualizaInventario");
		dao.actualizaInventario(Inventario);
	}

	@Override
	public Inventario getInventarioById(Integer idInventario) throws Exception{
		System.out.println("Service - getInventarioById");
		return dao.getInventarioById(idInventario);
	}

	@Override
	public void eliminaInventario(Integer idInventario) throws Exception {
		dao.eliminaInventario(idInventario);
		
	}

}

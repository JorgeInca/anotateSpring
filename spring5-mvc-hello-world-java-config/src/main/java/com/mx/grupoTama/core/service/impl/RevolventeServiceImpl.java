package com.mx.grupoTama.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.grupoTama.core.dao.RevolventesDAO;
import com.mx.grupoTama.core.service.RevolventesService;
import com.mx.grupoTama.modelo.Revolvente;
import com.mx.grupoTama.modelo.criteria.RevolventeCriteria;

@Service
public class RevolventeServiceImpl implements RevolventesService {

	@Autowired
	RevolventesDAO dao;

	@Override
	public List<Revolvente> getRevolventes(RevolventeCriteria criteria) throws Exception{
		System.out.println("Service - getRevolventes");
		return dao.getRevolventes(criteria);
	}
	
	@Override
	public Revolvente getRevolventeById(Integer idRevolvente)
			throws Exception {
		System.out.println("Service - getRevolventeById");
		return dao.getRevolventeById(idRevolvente);
	}

	@Override
	public void insertaRevolvente(Revolvente revolvente) throws Exception{
		System.out.println("Service - insertaRevolvente");
		dao.insertaRevolvente(revolvente);
	}

	@Override
	public void actualizaRevolvente(Revolvente revolvente) throws Exception{
		System.out.println("Service - actualizaRevolvente");
		dao.actualizaRevolvente(revolvente);
	}

	@Override
	public void eliminaRevolvente(Integer idRevolvente) throws Exception {
		System.out.println("Service - eliminaRevolvente");
		dao.eliminaRevolvente(idRevolvente);
		
	}

}

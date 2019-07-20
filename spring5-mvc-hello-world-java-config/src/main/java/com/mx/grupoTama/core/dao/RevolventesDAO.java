package com.mx.grupoTama.core.dao;

import java.util.List;

import com.mx.grupoTama.modelo.Revolvente;
import com.mx.grupoTama.modelo.criteria.RevolventeCriteria;

public interface RevolventesDAO {
	public List<Revolvente> getRevolventes(RevolventeCriteria criteria) throws Exception;
	public Revolvente getRevolventeById(Integer idRevolvente) throws Exception;
	public void insertaRevolvente(Revolvente revolvente) throws Exception;
	public void actualizaRevolvente(Revolvente revolvente) throws Exception;
	public void eliminaRevolvente(Integer idRevolvente) throws Exception;
}

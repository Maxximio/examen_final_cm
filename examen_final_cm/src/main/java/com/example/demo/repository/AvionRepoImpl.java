package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Avion;

@Transactional
@Repository
public class AvionRepoImpl implements IAvionRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Avion avion) {
		this.entityManager.persist(avion);
	}

	@Override
	public Avion buscar(Integer id) {
		return this.entityManager.find(Avion.class, id);
	}

	@Override
	public Avion buscarNombre(String nombre) {
		TypedQuery<Avion> myQuery = this.entityManager
				.createQuery("select v from Avion v where v.nombre =: datoNombre", Avion.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Avion avion) {
		this.entityManager.merge(avion);
	}

	@Override
	public void borrar(Integer id) {
		Avion a=this.buscar(id);
		this.entityManager.remove(a);
	}

}

package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.CompraPasaje;
import com.example.demo.repository.model.Vuelo;

@Transactional
@Repository
public class ComprarPasajeRepoImpl implements ICompraPasajeRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CompraPasaje pasaje) {
		this.entityManager.persist(pasaje);
		
	}

	@Override
	public CompraPasaje buscar(Integer id) {
		return this.entityManager.find(CompraPasaje.class, id);
	}

	@Override
	public CompraPasaje buscarPasaje(String numero) {
		TypedQuery<CompraPasaje> myQuery = this.entityManager
				.createQuery("select v from CompraPasaje v where v.numero =: datoNumero", CompraPasaje.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(CompraPasaje pasaje) {
		this.entityManager.merge(pasaje);
	}

	@Override
	public void borrar(Integer id) {
		CompraPasaje c=this.buscar(id);
		this.entityManager.remove(c);
	}

}

package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Cliente;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}

	@Override
	public Cliente buscar(Integer id) {
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public Cliente buscarNombre(String nombre) {
		TypedQuery<Cliente> myQuery = this.entityManager
				.createQuery("select v from Cliente v where v.nombre =: datoNombre", Cliente.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Cliente buscarCedula(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager
				.createQuery("select v from Cliente v where v.cedula =: datoNombre", Cliente.class);
		myQuery.setParameter("datoNombre", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
	}

	@Override
	public void borrar(Integer id) {
		Cliente c=this.buscar(id);
		this.entityManager.remove(c);
	}
	
	
	
}

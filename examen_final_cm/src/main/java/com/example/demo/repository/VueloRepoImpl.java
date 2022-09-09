package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Vuelo;
import com.example.demo.repository.model.VueloDisponible;

@Transactional
@Repository
public class VueloRepoImpl implements IVueloRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vuelo vuelo) {
		this.entityManager.persist(vuelo);
	}

	@Override
	public Vuelo buscar(Integer id) {
		return this.entityManager.find(Vuelo.class, id);
	}

	@Override
	public Vuelo buscarNumero(String numero) {
		TypedQuery<Vuelo> myQuery = this.entityManager
				.createQuery("select v from Vuelo v where v.numero =: datoNumero", Vuelo.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Vuelo vuelo) {
		this.entityManager.merge(vuelo);
	}

	@Override
	public void borrar(Integer id) {
		Vuelo v=this.buscar(id);
		this.entityManager.remove(v);
	}

	@Override
	public List<VueloDisponible> buscarOriDesFech(String origen, String destino, LocalDateTime fecha, String estado) {
		
		estado="DIS";
		
		TypedQuery< VueloDisponible> myQuery =this.entityManager.createQuery(
				"select new com.example.demo.repository.model.VueloDisponible"
				+ "(v.numero,v.fecha,v.valor,v.origen,v.destino,a.nombre) "
				+ "from Vuelo v join v.avion a where v.origen =: datoOrigen "
				+ "and v.destino =: datoDestino and v.fecha >=: datoFecha and v.estado =: datoEstado"
				, VueloDisponible.class);
		myQuery.setParameter("datoOrigen", origen);
		myQuery.setParameter("datoDestino", destino);
		myQuery.setParameter("datoFecha", fecha);
		myQuery.setParameter("datoEstado", estado);
		
		return myQuery.getResultList();
	}

}

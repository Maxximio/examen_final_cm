package com.example.demo.repository.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "avion")
public class Avion {

	@Id
	@Column(name = "avio_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avio")
	@SequenceGenerator(name = "seq_avio", sequenceName = "seq_avio", allocationSize = 1)
	private Integer id;

	@Column(name = "avio_nombre")
	private String nombre;

	@Column(name = "avio_capacidad")
	private Integer capacidad;

	@OneToMany(mappedBy = "avion", cascade = CascadeType.ALL)
	private List<Vuelo> vuelo;

	public Avion(Integer id, String nombre, Integer capacidad, List<Vuelo> vuelo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.vuelo = vuelo;
	}

	public Avion() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public List<Vuelo> getVuelo() {
		return vuelo;
	}

	public void setVuelo(List<Vuelo> vuelo) {
		this.vuelo = vuelo;
	}
}

package com.example.demo.repository;

import com.example.demo.repository.model.Avion;

public interface IAvionRepo {

	public void insertar(Avion avion);
	
	public Avion buscar(Integer id);
	
	public Avion buscarNombre(String nombre);
	
	public void actualizar(Avion avion);
	
	public void borrar(Integer id);
	
}

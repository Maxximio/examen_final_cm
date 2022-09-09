package com.example.demo.repository;

import com.example.demo.repository.model.CompraPasaje;

public interface ICompraPasajeRepo {

	public void insertar(CompraPasaje pasaje);
	
	public CompraPasaje buscar(Integer id);
	
	public CompraPasaje buscarPasaje(String numero);
	
	public void actualizar(CompraPasaje pasaje);
	
	public void borrar(Integer id);
	
}

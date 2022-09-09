package com.example.demo.repository;

import com.example.demo.repository.model.Cliente;

public interface IClienteRepo {

	public void insertar(Cliente cliente);
	
	public Cliente buscar(Integer id);
	
	public Cliente buscarNombre(String nombre);
	
	public Cliente buscarCedula(String cedula);
	
	public void actualizar(Cliente cliente);
	
	public void borrar(Integer id);
	
}

package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.model.Vuelo;
import com.example.demo.repository.model.VueloDisponible;

public interface IVueloRepo {

	public void insertar(Vuelo vuelo);
	
	public Vuelo buscar(Integer id);
	
	public Vuelo buscarNumero(String numero);
	
	public List<VueloDisponible> buscarOriDesFech(String origen,String destino,LocalDateTime fecha
			,String estado); 
	
	public void actualizar(Vuelo vuelo);
	
	public void borrar(Integer id);
	
}

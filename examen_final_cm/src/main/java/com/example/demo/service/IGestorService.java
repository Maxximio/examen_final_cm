package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.model.CompraPasaje;
import com.example.demo.repository.model.Vuelo;
import com.example.demo.repository.model.VueloDisponible;

public interface IGestorService {

	public List<VueloDisponible> buscarVuelosDisponibles(String origen
			,String destino, LocalDateTime fecha); 
	
	public CompraPasaje reservarPasaje(String numeroVuelo,Integer cantidad,String cedula);
	
	public Vuelo verificarDIS(String numeroVuelo);
	
}

package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepo;
import com.example.demo.repository.ICompraPasajeRepo;
import com.example.demo.repository.IVueloRepo;
import com.example.demo.repository.model.Cliente;
import com.example.demo.repository.model.CompraPasaje;
import com.example.demo.repository.model.Vuelo;
import com.example.demo.repository.model.VueloDisponible;

@Service
public class GestorServiceImpl implements IGestorService{

	@Autowired 
	private IVueloRepo vueloRepo;
	
	@Autowired 
	private IClienteRepo clienteRepo;
	
	@Autowired
	private ICompraPasajeRepo compraPasajeRepo;
	
	@Override
	public List<VueloDisponible> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fecha) {
		
		List<VueloDisponible>lista= this.vueloRepo.buscarOriDesFech(origen, destino, fecha, destino);
		
		return lista;
	}

	@Override
	public CompraPasaje reservarPasaje(String numeroVuelo, Integer cantidad, String cedula) {
		Vuelo v=this.vueloRepo.buscarNumero(numeroVuelo);
		
		if(v.getDisponibles()>=cantidad) {
			v.setDisponibles(v.getDisponibles()-cantidad);
			v.setOcupados(v.getOcupados()+cantidad);
			this.vueloRepo.actualizar(v);
	
			CompraPasaje compa=new CompraPasaje();
			compa.setNumero(numeroVuelo+cantidad+cedula);
			compa.setCantidadAsienteosComprados(cantidad);
			compa.setFechaCompra(LocalDateTime.now());
			compa.setEstado("RES");
			
			Cliente c=this.clienteRepo.buscarCedula(cedula);
			compa.setCliente(c);
			
			compa.setVuelo(v);
			
			this.compraPasajeRepo.insertar(compa);
			
			return compa;
		}
		
		return null;
	}

	@Override
	public Vuelo verificarDIS(String numeroVuelo) {

		Vuelo v=this.vueloRepo.buscarNumero(numeroVuelo);
		
		if(v.getEstado().equals("DIS")) {
			return v;
		}
		
		return null;
	}

	
	
}

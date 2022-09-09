package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.model.CompraPasaje;
import com.example.demo.repository.model.Vuelo;
import com.example.demo.repository.model.VueloDisponible;
import com.example.demo.service.IGestorService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private IGestorService gestorService;
	
	//1
	@GetMapping("/buscarDisponibles")
	public String paginaBuscarVuelos(VueloDisponible vuelo,Model modelo) {
		
		modelo.addAttribute("vuelo",vuelo);
		return "buscarVuelo";
	}

	@GetMapping("/insertarDatos")
	public String insertarDatos(VueloDisponible vuelo,Model modelo) {
		
		List<VueloDisponible> vueloLista=this.gestorService.buscarVuelosDisponibles
				(vuelo.getOrigen(), vuelo.getDestino(), vuelo.getFecha());
		
		modelo.addAttribute("lista",vueloLista);
		return "ListaVuelos";
	}
	
	//2
	@GetMapping("/buscarDisponiblesNumero")
	public String verificar(Vuelo vuelo,Model modelo) {
		modelo.addAttribute("vuelo",vuelo);
		return "verificarDisponibilidad";
	}
	
	@GetMapping("/verificar")
	public String listarDisponibles(Vuelo vuelo,Model modelo) {
		
		Vuelo v=this.gestorService.verificarDIS(vuelo.getNumero());
		
		modelo.addAttribute("vuelo",v);
		return "asientos";
	}
	//insertarDatosCompra
	
	@GetMapping("/ingresaCompra")
	public String ingresoCompra(CompraPasaje compa,Model modelo) {
		
		modelo.addAttribute("compa",compa);
		return "ingresaDatosCompra";
	}
	
	@PostMapping("/comprando")
	public String comprado(Model modelo, CompraPasaje compa) {
		
		CompraPasaje compra=this.gestorService.reservarPasaje(compa.getNumero()
				, compa.getCantidadAsienteosComprados(), compa.getCedula());
		
		modelo.addAttribute("compa",compra);
		return "mostrarCompra";
	}
}

package com.example.demo.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class VueloDisponible {

	private String numero;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fecha;
	
	private BigDecimal valor;
	
	private String origen;
	
	private String destino;
	
	private String nombre;

	public VueloDisponible(String numero, LocalDateTime fecha, BigDecimal valor, String origen,
			String destino, String nombre) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.valor = valor;
		this.origen = origen;
		this.destino = destino;
		this.nombre = nombre;
	}
	
	public VueloDisponible() {
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

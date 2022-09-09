package com.example.demo.repository.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "compra_pasaje")
public class CompraPasaje {

	@Id
	@Column(name="copa_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_copa")
	@SequenceGenerator(name="seq_copa",sequenceName = "seq_copa",allocationSize = 1)
	private Integer id;
	
	@Column(name="copa_numero")
	private String numero;
	
	@Column(name="copa_cedula")
	private String cedula;
	
	@Column(name="copa_fecha_compra")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaCompra;
	
	@Column(name="copa_cantidad_asientos_comprados")
	private Integer cantidadAsienteosComprados;
	
	@Column(name="copa_estado")//res
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="copa_clie_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="copa_vuel_id")
	private Vuelo vuelo;

	//constructores
	public CompraPasaje() {
	}

	public CompraPasaje(Integer id, String numero, String cedula, LocalDateTime fechaCompra,
			Integer cantidadAsienteosComprados, String estado, Cliente cliente, Vuelo vuelo) {
		super();
		this.id = id;
		this.numero = numero;
		this.cedula = cedula;
		this.fechaCompra = fechaCompra;
		this.cantidadAsienteosComprados = cantidadAsienteosComprados;
		this.estado = estado;
		this.cliente = cliente;
		this.vuelo = vuelo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Integer getCantidadAsienteosComprados() {
		return cantidadAsienteosComprados;
	}

	public void setCantidadAsienteosComprados(Integer cantidadAsienteosComprados) {
		this.cantidadAsienteosComprados = cantidadAsienteosComprados;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}

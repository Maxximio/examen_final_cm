package com.example.demo.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vuelo")
public class Vuelo {

	@Id
	@Column(name="vuel_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vuel")
	@SequenceGenerator(name="seq_vuel",sequenceName = "seq_vuel",allocationSize = 1)
	private Integer id;

	@Column(name="vuel_numero")
	private String numero;
	
	@Column(name="vuel_fecha")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fecha;
	
	@Column(name="vuel_valor")
	private BigDecimal valor;
	
	@Column(name="vuel_estado")
	private String estado;
	
	@Column(name="vuel_origen")
	private String origen;
	
	@Column(name="vuel_destino")
	private String destino;
	
	@Column(name="vuel_disponibles")
	private Integer disponibles;
	
	@Column(name="vuel_ocupados")
	private Integer ocupados;
	
	@ManyToOne
	@JoinColumn(name="vuel_avion_id")
	private Avion avion;
	
	@OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
	private List<CompraPasaje> compra_pasaje;

	public Vuelo(Integer id, String numero, LocalDateTime fecha, BigDecimal valor, String estado, String origen,
			String destino, Integer disponibles, Integer ocupados, Avion avion,
			List<CompraPasaje> compra_pasaje) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha = fecha;
		this.valor = valor;
		this.estado = estado;
		this.origen = origen;
		this.destino = destino;
		this.disponibles = disponibles;
		this.ocupados = ocupados;
		this.avion = avion;
		this.compra_pasaje = compra_pasaje;
	}

	public Vuelo() {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public List<CompraPasaje> getCompra_pasaje() {
		return compra_pasaje;
	}

	public void setCompra_pasaje(List<CompraPasaje> compra_pasaje) {
		this.compra_pasaje = compra_pasaje;
	}

	public Integer getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(Integer disponibles) {
		this.disponibles = disponibles;
	}

	public Integer getOcupados() {
		return ocupados;
	}

	public void setOcupados(Integer ocupados) {
		this.ocupados = ocupados;
	}
	
}

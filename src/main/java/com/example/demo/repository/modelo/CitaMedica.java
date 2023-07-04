package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cita_medica")
@NamedQuery(name = "CitaMedica.buscaPorNumCita" , query = "SELECT cm FROM CitaMedica cm WHERE cm.numCita = :datoNumCita")

public class CitaMedica {

	@GeneratedValue(generator = "seq_cita_medica", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_cita_medica", sequenceName = "seq_cita_medica", allocationSize = 1)
	@Id
	@Column(name = "cime_id")
	private Integer id;

	@Column(name = "cime_num_cita")
	private String numCita;

	@Column(name = "cime_fecha_cita")
	private LocalDateTime fechaCita;

	@Column(name = "cime_valor")
	private BigDecimal valor;

	@Column(name = "cime_lugar_cita")
	private String lugarCita;

	@Column(name = "cime_diagnostico")
	private String diagnostico;

	@Column(name = "cime_receta")
	private String receta;

	@Column(name = "cime_prox_cita")
	private LocalDateTime proxCita;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cime_cita_paciente")
	Paciente paciente;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cime_cita_doctor")
	Doctor doctor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumCita() {
		return numCita;
	}

	public void setNumCita(String numCita) {
		this.numCita = numCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getLugarCita() {
		return lugarCita;
	}

	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public LocalDateTime getProxCita() {
		return proxCita;
	}

	public void setProxCita(LocalDateTime proxCita) {
		this.proxCita = proxCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numCita=" + numCita + ", fechaCita=" + fechaCita + ", valor=" + valor
				+ ", lugarCita=" + lugarCita + ", diagnostico=" + diagnostico + ", receta=" + receta + ", proxCita="
				+ proxCita + ", paciente=" + paciente + ", doctor=" + doctor + "]";
	}
	
	
	

}

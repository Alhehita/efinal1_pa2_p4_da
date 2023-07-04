package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@GeneratedValue(generator = "seq_doctor", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_doctor", sequenceName = "seq_doctor", allocationSize = 1)
	@Id
	@Column(name = "doct_id")
	private Integer id;

	@Column(name = "doct_cedula")
	private String cedula;

	@Column(name = "doct_nombre")
	private String nombre;

	@Column(name = "doct_apellido")
	private String apellido;

	@Column(name = "doct_fecha_nacimiento")
	private LocalDate fechaNacimiento;

	@Column(name = "doct_num_consultorio")
	private String numConsultorio;

	@Column(name = "doct_cod_senecyt")
	private String codSenecyt;

	@Column(name = "doct_genero")
	private String genero;

	@OneToMany(mappedBy = "doctor")
	List<CitaMedica> citaMedicas;

	// Get y Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNumConsultorio() {
		return numConsultorio;
	}

	public void setNumConsultorio(String numConsultorio) {
		this.numConsultorio = numConsultorio;
	}

	public String getCodSenecyt() {
		return codSenecyt;
	}

	public void setCodSenecyt(String codSenecyt) {
		this.codSenecyt = codSenecyt;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<CitaMedica> getCitaMedicas() {
		return citaMedicas;
	}

	public void setCitaMedicas(List<CitaMedica> citaMedicas) {
		this.citaMedicas = citaMedicas;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", numConsultorio=" + numConsultorio + ", codSenecyt="
				+ codSenecyt + ", genero=" + genero + ", citaMedica=" + citaMedicas + "]";
	}

}

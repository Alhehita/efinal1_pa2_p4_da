package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
@NamedQuery(name = "Paciente.buscaPorCedula" , query = "SELECT p FROM Paciente p WHERE p.cedula = :datoCedula")

public class Paciente {

	@GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", allocationSize = 1)
	@Id
	@Column(name = "paci_id")
	private Integer id;

	@Column(name = "paci_cedula")
	private String cedula;

	@Column(name = "paci_nombre")
	private String nombre;

	@Column(name = "paci_apellido")
	private String apellido;

	@Column(name = "paci_fecha_nacimiento")
	private LocalDate fechaNacimiento;

	@Column(name = "paci_cod_seguro")
	private String codSeguro;

	@Column(name = "paci_estatura")
	private String estatura;

	@Column(name = "paci_peso")
	private Double peso;

	@Column(name = "paci_genero")
	private String genero;

	@OneToMany(mappedBy = "paciente")
	List<CitaMedica> citaMedicas;

	//Get y Set
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

	public String getCodSeguro() {
		return codSeguro;
	}

	public void setCodSeguro(String codSeguro) {
		this.codSeguro = codSeguro;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
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
		return "Paciente [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", codSeguro=" + codSeguro + ", estatura=" + estatura
				+ ", peso=" + peso + ", genero=" + genero + ", citaMedicas=" + citaMedicas + "]";
	}

	

}

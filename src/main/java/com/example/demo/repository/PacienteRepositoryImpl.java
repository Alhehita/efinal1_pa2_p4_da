package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PacienteRepositoryImpl implements PacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void ingresar(Paciente paciente) {
		this.entityManager.persist(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);
	}

	@Override
	public Paciente seleccionarPorCedula(String cedula) {

		Query query = this.entityManager.createNamedQuery("Paciente.buscaPorCedula");
		query.setParameter("datoCedula", cedula);

		return (Paciente) query.getSingleResult();
	}

}

package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements CitaMedicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica citaMedica) {
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica seleccionarPorNumCita(String numCita) {
		Query query = this.entityManager.createNamedQuery("CitaMedica.buscaPorNumCita");
		query.setParameter("datoNumCita", numCita);

		return (CitaMedica) query.getSingleResult();
	}

}

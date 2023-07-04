package com.example.demo.repository;

import java.time.LocalDateTime;

import com.example.demo.repository.modelo.CitaMedica;

public interface CitaMedicaRepository {

	public void insertar(CitaMedica citaMedica);

	public void actualizar(CitaMedica citaMedica);
	
	public CitaMedica seleccionarPorNumCita(String numCita);

}

package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.repository.modelo.CitaMedica;

public interface CitaMedicaService {

	public void agendar(String numCita, LocalDateTime fechaCita, String lugarCita, String cedulaDoc, String cedulaPaci,
			BigDecimal valor);

	public void actualizar(String numCita,String diagnostico, String receta, LocalDateTime proxCita);
}

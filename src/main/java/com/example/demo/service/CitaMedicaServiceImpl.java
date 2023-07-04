package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CitaMedicaRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService {

	@Autowired
	CitaMedicaRepository citaMedicaRepository;

	@Autowired
	PacienteRepository pacienteRepository;
	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public void agendar(String numCita, LocalDateTime fechaCita, String lugarCita, String cedulaDoc, String cedulaPaci,
			BigDecimal valor) {

		Doctor doctor = this.doctorRepository.seleccionar(cedulaDoc);

		Paciente paciente = this.pacienteRepository.seleccionarPorCedula(cedulaPaci);

		CitaMedica citaMedica = new CitaMedica();

		citaMedica.setNumCita(numCita);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setValor(valor);
		citaMedica.setLugarCita(lugarCita);

		citaMedica.setDoctor(doctor);
		citaMedica.setPaciente(paciente);

		this.citaMedicaRepository.insertar(citaMedica);

	}

	@Override
	public void actualizar(String numCita, String diagnostico, String receta, LocalDateTime proxCita) {

		// CitaMedica citaMedica = new CitaMedica();

		CitaMedica citaMedica = this.citaMedicaRepository.seleccionarPorNumCita(numCita);

		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setProxCita(proxCita);
		citaMedica.setReceta(receta);

		this.citaMedicaRepository.actualizar(citaMedica);
	}

}

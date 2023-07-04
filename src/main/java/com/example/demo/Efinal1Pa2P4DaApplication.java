package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.CitaMedicaService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PacienteService;

@SpringBootApplication
public class Efinal1Pa2P4DaApplication implements CommandLineRunner {

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private CitaMedicaService citaMedicaService;

	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P4DaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Doctor doctor = new Doctor();
		Paciente paciente = new Paciente();
		CitaMedica citaMedica = new CitaMedica();

		doctor.setApellido("Andrade");
		doctor.setCedula("1751556653");
		doctor.setNombre("Dennisse");
		doctor.setFechaNacimiento(LocalDate.of(1997, 03, 17));
		doctor.setCodSenecyt("1733H");
		doctor.setGenero("F");
		doctor.setNumConsultorio("56");

		paciente.setApellido("Marin");
		paciente.setCedula("1234567890");
		paciente.setCodSeguro("12546");
		paciente.setEstatura("1.67");
		paciente.setGenero("F");
		paciente.setFechaNacimiento(LocalDate.of(1999, 5, 27));
		paciente.setNombre("Alexandra");
		paciente.setPeso(56.9);

		citaMedica.setDoctor(doctor);
		citaMedica.setFechaCita(LocalDateTime.of(2023, 7, 10, 10, 10));
		citaMedica.setNumCita("124");
		citaMedica.setValor(new BigDecimal(25));
		citaMedica.setLugarCita("Hospital Pablo Arturo");

		citaMedica.setDiagnostico("Gripe");
		citaMedica.setReceta("Paracetamol");
		citaMedica.setProxCita(LocalDateTime.of(2023, 8, 10, 11, 10));

		List<CitaMedica> citaMedicas = new ArrayList<>();
		citaMedicas.add(citaMedica);

		paciente.setCitaMedicas(citaMedicas);
		doctor.setCitaMedicas(citaMedicas);

		pacienteService.guardar(paciente);

		doctorService.guardar(doctor);

		citaMedicaService.agendar(citaMedica.getNumCita(), citaMedica.getFechaCita(), citaMedica.getLugarCita(),
				doctor.getCedula(), paciente.getCedula(), citaMedica.getValor());

		// citaMedicaService.actualizar(citaMedica.getNumCita(),
		// citaMedica.getDiagnostico(), citaMedica.getReceta(),
		// citaMedica.getProxCita());
	}

}

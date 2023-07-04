package com.example.demo.service;

import com.example.demo.repository.modelo.Doctor;

public interface DoctorService {

	public void guardar(Doctor doctor);
	
	public void borrar(String apellido);
	
	public void actualizar(Doctor doctor);
	
	public Doctor buscar(String apellido);
}

package com.example.demo.repository;

import com.example.demo.repository.modelo.Doctor;

public interface DoctorRepository {
	
	public void insertar(Doctor doctor);
	
	public void eliminar(String apellido);
	
	public void actualizar(Doctor doctor);
	
	public Doctor seleccionar(String apellido);
	
	

}

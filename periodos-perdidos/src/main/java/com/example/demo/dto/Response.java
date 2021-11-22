package com.example.demo.dto;

import java.util.List;


/**
 * Clase de respuesta de Api Actual.
 * 
 * @author Blas Munoz
 *
 */
public class Response {
	private int id;
	private String fechaCreacion;
	private String fechaFin;
	private List<String> fechas;
	private List<String> fechasFaltantes;
	
	public Response(int id, String fechaCreacion, String fechaFin, List<String> fechas, List<String> fechasFaltantes) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechaFin = fechaFin;
		this.fechas = fechas;
		this.fechasFaltantes = fechasFaltantes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public List<String> getFechas() {
		return fechas;
	}

	public void setFechas(List<String> fechas) {
		this.fechas = fechas;
	}

	public List<String> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<String> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}		
	
}

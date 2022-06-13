package com.reubica.interfaceService;

import java.util.List;

import com.reubica.entidad.Perro;


public interface IperroService {

	
	public List<Perro>listAll();

	public List<Perro>listAllS(String filtro_sexo);
	
	public List<Perro>listAllT(String filtro_tamano);
	
	public List<Perro>listAllF(String filtro_tamano, String filtro_sexo);
		
	public Perro guardarPerro(Perro perro);
	
	public Perro obtenerPerroId(Integer id);
	
	public Perro actualizarPerro(Perro perro);
	
	public void eliminarPerro(Integer id);
	
}

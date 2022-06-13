package com.reubica.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reubica.entidad.Perro;
import com.reubica.interfaceService.IperroService;
import com.reubica.interfaces.IPerro;


@Service
public class PerroService implements IperroService{
	
	@Autowired
	private IPerro repositorio;

	@Override
	public List<Perro> listAll() {
		return repositorio.findAll();
	}
	
	@Override
	public List<Perro> listAllS(String filtro_sexo) {
		return repositorio.findAllS(filtro_sexo);
	}
	
	@Override
	public List<Perro> listAllT(String filtro_tamano) {
		return repositorio.findAllT(filtro_tamano);
	}
	
	@Override
	public List<Perro> listAllF(String filtro_tamano, String filtro_sexo) {
		return repositorio.findAllF(filtro_tamano, filtro_sexo);
	}
	
	@Override
	public Perro guardarPerro(Perro perro) {
		return repositorio.save(perro);
	}

	@Override
	public Perro obtenerPerroId(Integer id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Perro actualizarPerro(Perro perro) {
		return repositorio.save(perro);
	}

	@Override
	public void eliminarPerro(Integer id) {
		repositorio.deleteById(id);
	}


}



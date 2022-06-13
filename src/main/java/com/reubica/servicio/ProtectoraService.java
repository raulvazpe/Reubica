package com.reubica.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reubica.entidad.Protectora;
import com.reubica.interfaceService.IProtectoraService;
import com.reubica.interfaces.IProtectora;

@Service
public class ProtectoraService implements IProtectoraService {

	@Autowired
	private IProtectora repositorio;

	@Override
	public List<Protectora> listarTodasLasProtectoras() {
		return repositorio.findAll();
	}

	@Override
	public Protectora guardarProtectora(Protectora protectora) {
		return repositorio.save(protectora);
	}

	@Override
	public Protectora obtenerProtectoraId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Protectora actualizarProtectora(Protectora protectora) {
		return repositorio.save(protectora);
	}

	@Override
	public void eliminarProtectora(Long id) {
		repositorio.deleteById(id);
	}

}

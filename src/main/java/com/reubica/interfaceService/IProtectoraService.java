package com.reubica.interfaceService;

import java.util.List;

import com.reubica.entidad.Protectora;

public interface IProtectoraService {

	public List<Protectora>listarTodasLasProtectoras();

	public Protectora guardarProtectora(Protectora protectora);
	
	public Protectora obtenerProtectoraId(Long id);
	
	public Protectora actualizarProtectora(Protectora protectora);
	
	public void eliminarProtectora(Long id) ;
	
}




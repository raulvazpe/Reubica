package com.reubica.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reubica.entidad.Perro;

@Repository
public interface IPerro extends JpaRepository<Perro, Integer>{

	public List<Perro> findAll();
	
	@Query("SELECT p FROM Perro p WHERE p.sexo LIKE %?1%")
	public List<Perro> findAllS(String filtro_sexo);

	@Query("SELECT p FROM Perro p WHERE p.tamano LIKE %?1%")
	public List<Perro> findAllT(String filtro_tamano);
	
	@Query("SELECT p FROM Perro p WHERE p.tamano LIKE %?1% AND p.sexo LIKE %?2%")
	public List<Perro> findAllF(String filtro_tamano, String filtro_sexo);
	
}

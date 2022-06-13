package com.reubica.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reubica.entidad.Protectora;

@Repository
public interface IProtectora extends JpaRepository<Protectora, Long>{
	
}

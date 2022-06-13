package com.reubica.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reubica.entidad.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
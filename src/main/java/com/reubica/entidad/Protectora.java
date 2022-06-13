package com.reubica.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "protectora")
public class Protectora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprotectora;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "ciudad", nullable = false, length = 80)
	private String ciudad;

	@Column(name = "descripcion", nullable = false, length = 500)
	private String descripcion;

	@Column(name = "img", nullable = true, length = 500)
	private String img;

	@Column(name = "mail", nullable = false, length = 80)
	private String mail;

	@Column(name = "maps", nullable = true, length = 100)
	private String maps;

	
	
	
	
	public Protectora() {

	}

	public Protectora(Long idprotectora, String nombre, String ciudad, String descripcion, String img, String mail,
			String maps) {
	
		this.idprotectora = idprotectora;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.img = img;
		this.mail = mail;
		this.maps = maps;
	}

	//GETTERS Y SETTERS
	public Long getIdprotectora() {
		return idprotectora;
	}

	public void setIdprotectora(Long id) {
		this.idprotectora = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMaps() {
		return maps;
	}

	public void setMaps(String maps) {
		this.maps = maps;
	}

	@Override
	public String toString() {
		return "Protectora [id=" + idprotectora + ", nombre=" + nombre + ", ciudad=" + ciudad + ", img=" + img +",descripcion= "+descripcion+"]";
	}

}
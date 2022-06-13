package com.reubica.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perro")

public class Perro {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idperro;
	
	@Column(name = "nombre", nullable = false,length = 50)
	private String nombre;
	
	@Column(name = "edad", nullable = false)
	private Integer edad;
	
	@Column(name = "caracter", nullable = true,length = 999)
	private String caracter;
	
	@Column(name = "descripcion", nullable = false,length = 500)
	private String descripcion;
	
	@Column(name = "sexo", nullable = false,length = 45)
	private String sexo;
	
	@Column(name = "tamano", nullable = false,length = 45)
	private String tamano;
	
	@Column(name = "img", nullable = true,length = 45)
	private String img;
	
	@Column(name = "protectora_idprotectora", nullable = false,length = 10)
	private Integer protectora_idprotectora;
	
	public Perro() {

	}
	
	public Perro(Integer idperro, String nombre, Integer edad, String caracter, String descripcion, String sexo,
			String tamano, String img, Integer protectora_idprotectora) {
		super();
		this.idperro = idperro;
		this.nombre = nombre;
		this.edad = edad;
		this.caracter = caracter;
		this.descripcion = descripcion;
		this.sexo = sexo;
		this.tamano = tamano;
		this.img = img;
		this.protectora_idprotectora = protectora_idprotectora;
	}
	
	public Perro(String nombre, Integer edad, String caracter, String descripcion, String sexo,
			String tamano, String img, Integer protectora_idprotectora) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.caracter = caracter;
		this.descripcion = descripcion;
		this.sexo = sexo;
		this.tamano = tamano;
		this.img = img;
		this.protectora_idprotectora = protectora_idprotectora;
	}
	

	public Integer getIdPerro() {
		return idperro;
	}

	public void setIdPerro(Integer idPerro) {
		this.idperro = idPerro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getProtectora_idprotectora() {
		return protectora_idprotectora;
	}

	public void setProtectora_idprotectora(Integer protectora_idprotectora) {
		this.protectora_idprotectora = protectora_idprotectora;
	}

	@Override
	public String toString() {
		return "Perro [idPerro=" + idperro + ", nombre=" + nombre + ", edad=" + edad + ", caracter=" + caracter
				+ ", descripcion=" + descripcion + ", sexo=" + sexo + ", tamano=" + tamano + ", img=" + img
				+ ", protectora_idprotectora=" + protectora_idprotectora + "]";
	}
	
}


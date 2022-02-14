package com.example.demo.negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/* para crear la entidad , table , query*/
@Entity
@Table(name = "Clientes1")
@NamedQuery(query = "select u from Clientes1 u", name = "query_find_all_clientes")

public class Clientes1 {
	/* Indicamos cua les el id de la tabla y para generar la bbdd automaticamnete*/
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long id;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String dni;
	@Column
	private long telefono;
	@Column
	private String direccion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientes")
	private List<Ventas1> ventas1;
	public Clientes1() {
		super();
	}

	public Clientes1(long id, String nombre, String apellidos, String dni, long telefono, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.direccion = direccion;

	}

	public Clientes1(String nombre, String apellidos, String dni, long telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public long getCod_cliente() {
		return id;
	}

	public void setCod_cliente(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long l) {
		this.telefono = l;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String CString() {
		return String.format("Clientes [id=%s, nombre=%s, apellidos=%s, dni=%s, telefono=%s, direccion=%s]",
				id, nombre, apellidos, dni, telefono, direccion);

	}

}

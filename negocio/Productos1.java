package com.example.demo.negocio;

public class Productos1 {
	private long cod_producto;
	private String nombre;
	private long precio_compra;
	private long unidades;

	public Productos1() {
		super();

	}

	public Productos1(long cod_producto, String nombre, long precio_compra, long unidades) {
		super();
		this.cod_producto = cod_producto;
		this.nombre = nombre;
		this.precio_compra = precio_compra;
		this.unidades = unidades;
	}

	public Productos1(String nombre, long precio_compra, long unidades) {
		super();
		this.nombre = nombre;
		this.precio_compra = precio_compra;
		this.unidades = unidades;
	}

	public long getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(long cod_producto) {
		this.cod_producto = cod_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(long precio_compra) {
		this.precio_compra = precio_compra;
	}

	public long getUnidades() {
		return unidades;
	}

	public void setUnidades(long unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return String.format("productos1 [cod_producto=%s, nombre=%s, precio_compra=%s, unidades=%s]", cod_producto,
				nombre, precio_compra, unidades);
	}

}

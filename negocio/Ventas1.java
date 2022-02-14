package com.example.demo.negocio;

import java.time.LocalDate;
import java.util.Date;

import javax.xml.crypto.Data;

public class Ventas1 {
	private long cod_venta;
	private Date fecha;
	private long precio_subasta;

	public Ventas1() {
		super();

	}

	public Ventas1(long cod_venta, Date fecha, long precio_subasta) {
		super();
		this.cod_venta = cod_venta;
		this.fecha = fecha;
		this.precio_subasta = precio_subasta;

	}

	public Ventas1(Date fecha, long precio_subasta) {
		super();

		this.fecha = fecha;
		this.precio_subasta = precio_subasta;

	}

	public long getCod_venta() {
		return cod_venta;
	}

	public void setCod_venta(long cod_venta) {
		this.cod_venta = cod_venta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getPrecio_subasta() {
		return precio_subasta;
	}

	public void setPrecio_subasta(long precio_subasta) {
		this.precio_subasta = precio_subasta;
	}

	@Override
	public String toString() {
		return String.format("Ventas1 [cod_venta=%s, fecha=%s, precio_subasta=%s]", cod_venta, fecha, precio_subasta);
	}

}

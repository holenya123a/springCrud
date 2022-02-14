package com.example.demo.controlador;

import java.util.List;

import java.util.ResourceBundle.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.example.demo.negocio.Clientes1;
import com.example.demo.negocio.ClientesJPA;
import com.example.demo.negocio.ClientesPersistance;
import com.example.demo.negocio.Eventos;
import com.example.demo.negocio.Productos1;
import com.example.demo.negocio.RepositoryClientes;
import com.example.demo.negocio.RepositoryProductos;
import com.example.demo.negocio.RepositoryVentas;
import com.example.demo.negocio.Ventas1;
import com.example.demo.presentacion.Clientes;
import com.example.demo.presentacion.Principal;
import com.example.demo.presentacion.Productos;
import com.example.demo.presentacion.Ventas;

@Controller
public class controlador1 extends Control {

	@Autowired
	RepositoryVentas v;

	@Autowired
	ClientesJPA jpaC;

	@Autowired
	ClientesPersistance cp;

	@Autowired
	@Lazy
	Ventas vf;

	@Autowired
	RepositoryClientes c;

	@Autowired
	@Lazy
	Clientes cf;

	@Autowired
	RepositoryProductos p;

	@Autowired
	@Lazy
	Productos pf;

	@Autowired
	@Lazy
	Principal p1;

	public void accion(int evento, Object datos) {
		/*
		 * Productos p = new Productos(); Ventas v = new Ventas (); Clientes c= new
		 * Clientes(); Principal p1 = new Principal();
		 */

		long resultado;

		switch (evento) {
		case Eventos.ABRIR_VENTANA_CLIENTE:

			cf.open();

			break;

		case Eventos.ADD_CLIENTE:
			/* Con hibernate sintaxis */
			// resultado = cp.insert((Clientes1)datos);
			/* System.out.println(resultado); */
			jpaC.save((Clientes1) datos);
			break;

		case Eventos.UPDATE_CLIENTE:
			resultado = c.UPDATE_CLIENTE((Clientes1) datos);
			System.out.println(resultado);
			break;

		case Eventos.DELETE_CLIENTE:
			resultado = c.DELETE_CLIENTE((long) datos);
			System.out.println(resultado);
			break;

		case Eventos.VER_VENTANA_CLIENTE:
			cf.update(c.VER_CLIENTE());

			break;

		case Eventos.ABRIR_VENTANA_PRODUCTO:

			pf.open();

			break;

		case Eventos.ADD_PRODUCTO:
			resultado = p.INSERT_PRODUCTO((Productos1) datos);
			System.out.println(resultado);
			break;

		case Eventos.UPDATE_PRODUCTO:
			resultado = p.UPDATE_PRODUCTO((Productos1) datos);
			System.out.println(resultado);
			break;

		case Eventos.DELETE_PRODUCTO:
			resultado = p.DELETEid_producto((long) datos);
			System.out.println(resultado);
			break;

		case Eventos.VER_VENTANA_PRODUCTO:
			pf.update(p.VER_PRODUCTO());

			break;

		case Eventos.ABRIR_VENTANA_VENTA:

			vf.open();

			break;

		case Eventos.ADD_VENTA:
			resultado = v.INSERT_VENTAS((Ventas1) datos);
			System.out.println(resultado);
			break;

		case Eventos.UPDATE_VENTA:
			resultado = v.UPDATE_VENTAS((Ventas1) datos);
			System.out.println(resultado);
			break;

		case Eventos.DELETE_VENTA:
			resultado = v.DELETEId_VENTAS((long) datos);
			System.out.println(resultado);
			break;

		case Eventos.VER_VENTANA_VENTA:
			vf.update(v.VER_VENTAS());

			break;

		default:
			break;
		}

	}

}

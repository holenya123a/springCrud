package com.example.demo.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controlador.controlador1;
import com.example.demo.negocio.Eventos;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import botone.botonicon;
import java.applet.Applet;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class Principal {

	@Autowired
	controlador1 controlador;

	public JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public Principal() {
		super();
		init();
	}

	private void init() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setBounds(200, 200, 500, 400);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		botonicon botonicon__1 = new botonicon("Clientes", "ver.png");
		botonicon__1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.accion(Eventos.ABRIR_VENTANA_CLIENTE, null);
			}
		});
		frame.getContentPane().add(botonicon__1);

		botonicon botonicon__2 = new botonicon("Productos", "ver.png");
		botonicon__2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.accion(Eventos.ABRIR_VENTANA_PRODUCTO, null);
			}
		});
		frame.getContentPane().add(botonicon__2);

		botonicon botonicon_ = new botonicon("Ventas", "ver.png");
		botonicon_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.accion(Eventos.ABRIR_VENTANA_VENTA, null);
			}
		});
		frame.getContentPane().add(botonicon_);

	}

}

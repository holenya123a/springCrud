package com.example.demo.presentacion;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controlador.controlador1;
import com.example.demo.negocio.Clientes1;
import com.example.demo.negocio.Eventos;
import com.example.demo.negocio.Productos1;

import botone.botonicon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class Productos {

	@Autowired
	controlador1 controlador;

	private JFrame frame;
	private JTable table;
	private DefaultTableModel modelo;
	private JPanel panel;
	private botonicon botonicon;
	private botonicon botonicon_1;
	private botonicon botonicon_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Productos() {
		initialize();

	}

	/**
	 * 
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Productos");
		frame.setBounds(100, 100, 559, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		modelo = new DefaultTableModel() {
			String[] header = { "cod_producto", "Nombre", "Precio_compra", "Unidades" };

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public int getColumnCount() {
				return header.length;
			}

			@Override
			public String getColumnName(int index) {
				return header[index];
			}
		};

		table = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(44, 47, 436, 253);
		frame.getContentPane().add(scrollPane);

		botonicon botonicon_ = new botonicon("Añadir", "anadir.png");
		botonicon_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField nombrel = new JTextField(5);
				JTextField precio = new JTextField(5);
				JTextField unidades = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("Nombre:"));
				myPanel.add(nombrel);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Precio_compra:"));
				myPanel.add(precio);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Unidades:"));
				myPanel.add(unidades);

				int rs = JOptionPane.showConfirmDialog(null, myPanel, "Añadir producto", JOptionPane.OK_CANCEL_OPTION);
				if (rs == JOptionPane.OK_OPTION) {
					String nombre = nombrel.getText();
					Long precio1 = (long) 0;
					Long unidades1 = (long) 0;

					try {
						precio1 = Long.parseLong(precio.getText());
						unidades1 = Long.parseLong(unidades.getText());
						if (nombre.equals("")) {
							JOptionPane.showMessageDialog(null, "porfavor rellene todos los campos");
						} else {
							Productos1 productos = new Productos1(nombre, precio1, unidades1);
							controlador.accion(Eventos.ADD_PRODUCTO, productos);
							controlador.accion(Eventos.VER_VENTANA_PRODUCTO, null);
						}
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "porfavor introduzca un elemento válido");
					}

				}
			}
		});
		botonicon_.setBounds(44, 310, 107, 30);
		frame.getContentPane().add(botonicon_);

		botonicon botonicon__1 = new botonicon("Eliminar", "eliminar.png");
		botonicon__1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField cod_producto1 = new JTextField(5);

				JPanel myPanel2 = new JPanel();
				myPanel2.add(new JLabel("cod_cliente:"));
				myPanel2.add(cod_producto1);
				myPanel2.add(Box.createHorizontalStrut(15));

				int rs1 = JOptionPane.showConfirmDialog(null, myPanel2, "¿Qué cliente quiere eliminar?",
						JOptionPane.OK_CANCEL_OPTION);
				long cod_producto = 0;

				try {
					cod_producto = Long.parseLong(cod_producto1.getText());
					if (cod_producto1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "porfavor introduzca un cod_producto");
					} else {
						controlador.accion(Eventos.DELETE_PRODUCTO, cod_producto);
						controlador.accion(Eventos.VER_VENTANA_PRODUCTO, null);
					}

				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "porfavor introduzca un cod_producto");
				}

			}
		});
		botonicon__1.setBounds(210, 310, 107, 30);
		frame.getContentPane().add(botonicon__1);

		botonicon botonicon__2 = new botonicon("Modificar", "editar.png");
		botonicon__2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField cod_producto2 = new JTextField(5);
				JTextField nombre1 = new JTextField(5);
				JTextField precio1 = new JTextField(5);
				JTextField unidades1 = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("cod_producto:"));
				myPanel.add(cod_producto2);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Nombre:"));
				myPanel.add(nombre1);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Precio:"));
				myPanel.add(precio1);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Unidades:"));
				myPanel.add(unidades1);

				int rs = JOptionPane.showConfirmDialog(null, myPanel, "Modificar producto",
						JOptionPane.OK_CANCEL_OPTION);

				if (rs == JOptionPane.OK_OPTION) {

					long cod_producto = 0;

					String nombre = nombre1.getText();
					Long precio = (long) 0;
					Long unidades = (long) 0;

					try {
						precio = Long.parseLong(precio1.getText());
						unidades = Long.parseLong(unidades1.getText());
						cod_producto = Long.parseLong(cod_producto2.getText());
						if (nombre.equals("")) {
							JOptionPane.showMessageDialog(null, "porfavor rellene todos los campos");
						} else {

							Productos1 productos = new Productos1(cod_producto, nombre, precio, unidades);
							controlador.accion(Eventos.UPDATE_PRODUCTO, productos);
							controlador.accion(Eventos.VER_VENTANA_PRODUCTO, null);
						}

					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "porfavor introduzca elementos  válidos");
					}

				}

			}
		});
		botonicon__2.setBounds(373, 310, 107, 30);
		frame.getContentPane().add(botonicon__2);

	}

	public void open() {
		controlador.accion(Eventos.VER_VENTANA_PRODUCTO, null);
		frame.setVisible(true);
	}

	public void update(List<Productos1> l) {
		modelo.setRowCount(0);
		for (Productos1 p1 : l) {
			modelo.addRow(
					new Object[] { p1.getCod_producto(), p1.getNombre(), p1.getPrecio_compra(), p1.getUnidades() });
		}
		modelo.fireTableDataChanged();

	}
}

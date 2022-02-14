package com.example.demo.presentacion;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controlador.controlador1;
import com.example.demo.negocio.Clientes1;
import com.example.demo.negocio.Eventos;
import com.example.demo.negocio.Productos1;

import botone.botonicon;

@Component
public class Clientes extends JFrame {

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
	public Clientes() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Clientes");
		frame.setBounds(100, 100, 605, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();

		modelo = new DefaultTableModel() {
			String[] header = { "cod_cliente", "Nombre", "Apellidos", "Direccion", "Telefono", "Dni" };

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
		scrollPane.setBounds(65, 48, 436, 253);
		frame.getContentPane().add(scrollPane);

		botonicon botonicon_ = new botonicon("Añadir", "anadir.png");
		botonicon_.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField nombrel = new JTextField(5);
				JTextField apellidol = new JTextField(5);
				JTextField telefonol = new JTextField(5);
				JTextField direccionl = new JTextField(5);
				JTextField dnil = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("Nombre:"));
				myPanel.add(nombrel);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Apellidos:"));
				myPanel.add(apellidol);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Telefono:"));
				myPanel.add(telefonol);
				myPanel.add(new JLabel("Direccion:"));
				myPanel.add(direccionl);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("DNI:"));
				myPanel.add(dnil);
				myPanel.add(Box.createHorizontalStrut(15));

				int rs = JOptionPane.showConfirmDialog(null, myPanel, "Añadir cliente", JOptionPane.OK_CANCEL_OPTION);
				if (rs == JOptionPane.OK_OPTION) {
					String nombre = nombrel.getText();
					String apellidos = apellidol.getText();
					Long telefono = (long) 0;
					String dni = dnil.getText();
					String direccion = direccionl.getText();

					try {
						telefono = Long.parseLong(telefonol.getText());
						if (nombre.equals("") || apellidos.equals("") || dni.equals("") || direccion.equals("")) {
							JOptionPane.showMessageDialog(null, "porfavor rellene todos los campos");
						} else {
							Clientes1 clientes = new Clientes1(nombre, apellidos, dni, telefono, direccion);
							controlador.accion(Eventos.ADD_CLIENTE, clientes);
							controlador.accion(Eventos.VER_VENTANA_CLIENTE, null);
						}
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "porfavor introduzca un número válido");
					}

				}

			}

		});
		botonicon_.setBounds(65, 327, 115, 26);
		frame.getContentPane().add(botonicon_);

		botonicon botonicon__1 = new botonicon("Eliminar", "eliminar.png");
		botonicon__1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JTextField cod_cliente1 = new JTextField(5);

				JPanel myPanel2 = new JPanel();
				myPanel2.add(new JLabel("cod_cliente:"));
				myPanel2.add(cod_cliente1);
				myPanel2.add(Box.createHorizontalStrut(15));

				int rs1 = JOptionPane.showConfirmDialog(null, myPanel2, "¿Qué cliente quiere eliminar?",
						JOptionPane.OK_CANCEL_OPTION);
				long cod_cliente = 0;
				try {
					cod_cliente = Long.parseLong(cod_cliente1.getText());
					if (cod_cliente1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "porfavor introduzca un cod_producto");
					} else {
						controlador.accion(Eventos.DELETE_CLIENTE, cod_cliente);
						controlador.accion(Eventos.VER_VENTANA_CLIENTE, null);
					}

				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "porfavor introduzca un cod_producto");
				}

			}
		});
		botonicon__1.setBounds(230, 327, 115, 26);
		frame.getContentPane().add(botonicon__1);

		botonicon botonicon__2 = new botonicon("Modificar", "editar.png");
		botonicon__2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField cod_cliente2 = new JTextField(5);
				JTextField nombrel = new JTextField(5);
				JTextField apellidol = new JTextField(5);
				JTextField telefonol = new JTextField(5);
				JTextField direccionl = new JTextField(5);
				JTextField dnil = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("cod_cliente:"));
				myPanel.add(cod_cliente2);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Nombre:"));
				myPanel.add(nombrel);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Apellidos:"));
				myPanel.add(apellidol);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Telefono:"));
				myPanel.add(telefonol);
				myPanel.add(new JLabel("Direccion:"));
				myPanel.add(direccionl);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("DNI:"));
				myPanel.add(dnil);
				myPanel.add(Box.createHorizontalStrut(15));

				int rs = JOptionPane.showConfirmDialog(null, myPanel, "Modificar cliente",
						JOptionPane.OK_CANCEL_OPTION);

				if (rs == JOptionPane.OK_OPTION) {

					long cod_cliente = 0;

					String nombre = nombrel.getText();
					String apellidos = apellidol.getText();
					Long telefono = (long) 0;
					String dni = dnil.getText();
					String direccion = direccionl.getText();

					if (nombre.equals("") || apellidos.equals("") || dni.equals("") || direccion.equals("")) {
						JOptionPane.showMessageDialog(null, "porfavor rellene todos los campos");
					}

					try {
						telefono = Long.parseLong(telefonol.getText());
						cod_cliente = Long.parseLong(cod_cliente2.getText());
						if (nombre.equals("")) {
							JOptionPane.showMessageDialog(null, "porfavor rellene todos los campos");
						} else {
							Clientes1 clientes = new Clientes1(cod_cliente, nombre, apellidos, dni, telefono,
									direccion);
							controlador.accion(Eventos.UPDATE_CLIENTE, clientes);
							controlador.accion(Eventos.VER_VENTANA_CLIENTE, null);

						}

					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "porfavor introduzca elementos válidos");
					}

				}

			}
		});
		botonicon__2.setBounds(386, 327, 115, 26);
		frame.getContentPane().add(botonicon__2);
		frame.setVisible(false);

	}

	public void open() {
		controlador.accion(Eventos.VER_VENTANA_CLIENTE, null);
		frame.setVisible(true);
	}

	public void update(List<Clientes1> l) {
		modelo.setRowCount(0);

		for (Clientes1 p1 : l) {
			modelo.addRow(new Object[] { p1.getCod_cliente(), p1.getNombre(), p1.getApellidos(), p1.getDireccion(),
					p1.getTelefono(), p1.getDni() });

		}
		modelo.fireTableDataChanged();

	}
}

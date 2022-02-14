package com.example.demo.presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
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
import com.example.demo.negocio.Ventas1;

import botone.botonicon;

@Component
public class Ventas extends JFrame {

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
	 * 
	 * /** Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Ventas() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ventas");
		frame.setBounds(100, 100, 559, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();

		modelo = new DefaultTableModel() {
			String[] header = { "cod_venta", "Fecha", "Precio_subasta" };

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
		scrollPane.setBounds(43, 28, 436, 253);
		frame.getContentPane().add(scrollPane);

		botonicon botonicon_ = new botonicon("Añadir", "anadir.png");
		botonicon_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField fecha1 = new JTextField(5);
				JTextField precio1 = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("Fecha:"));
				myPanel.add(fecha1);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Precio_subasta:"));
				myPanel.add(precio1);
				myPanel.add(Box.createHorizontalStrut(15));

				int rs = JOptionPane.showConfirmDialog(null, myPanel, "Añadir venta", JOptionPane.OK_CANCEL_OPTION);
				if (rs == JOptionPane.OK_OPTION) {

					SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
					Date fecha = null;

					Long precio = (long) 0;

					try {
						fecha = f.parse(fecha1.getText());
					} catch (ParseException e1) {

					}

					try {
						precio = Long.parseLong(precio1.getText());

						if (fecha1.getText().isEmpty() || precio1.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "porfavor rellene todos los campos");
						} else {
							Ventas1 ventas = new Ventas1(fecha, precio);
							controlador.accion(Eventos.ADD_VENTA, ventas);
							controlador.accion(Eventos.VER_VENTANA_VENTA, null);
						}
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "porfavor introduzca  elementos válido");

					}

				}

			}
		});
		botonicon_.setBounds(45, 301, 107, 30);
		frame.getContentPane().add(botonicon_);

		botonicon botonicon__1 = new botonicon("Eliminar", "eliminar.png");
		botonicon__1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField cod_venta1 = new JTextField(5);

				JPanel myPanel2 = new JPanel();
				myPanel2.add(new JLabel("cod_venta:"));
				myPanel2.add(cod_venta1);
				myPanel2.add(Box.createHorizontalStrut(15));

				int rs1 = JOptionPane.showConfirmDialog(null, myPanel2, "¿Qué venta quiere eliminar?",
						JOptionPane.OK_CANCEL_OPTION);
				long cod_venta = 0;

				try {
					cod_venta = Long.parseLong(cod_venta1.getText());
					if (cod_venta1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "porfavor introduzca un cod_producto");
					} else {
						controlador.accion(Eventos.DELETE_VENTA, cod_venta);
						controlador.accion(Eventos.VER_VENTANA_VENTA, null);

					}

				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "porfavor introduzca un cod_producto");
				}

			}
		});
		botonicon__1.setBounds(206, 301, 107, 30);
		frame.getContentPane().add(botonicon__1);

		botonicon botonicon__2 = new botonicon("Modificar", "editar.png");
		botonicon__2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField cod_venta2 = new JTextField(5);
				JTextField fecha1 = new JTextField(5);
				JTextField precio1 = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("cod_venta:"));
				myPanel.add(cod_venta2);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Fecha:"));
				myPanel.add(fecha1);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Precio_subasta:"));
				myPanel.add(precio1);
				myPanel.add(Box.createHorizontalStrut(15));

				int rs = JOptionPane.showConfirmDialog(null, myPanel, "Modificar producto",
						JOptionPane.OK_CANCEL_OPTION);

				if (rs == JOptionPane.OK_OPTION) {

					long cod_venta = 0;

					SimpleDateFormat f = new SimpleDateFormat("dd-mm-yyyy");
					Date fecha = null;

					try {
						fecha = f.parse(fecha1.getText());
					} catch (ParseException e1) {

						JOptionPane.showMessageDialog(null, "porfavor introduzca una fecha válida dd-mm-yyyy");
					}

					Long precio = (long) 0;

					try {
						fecha = f.parse(fecha1.getText());
					} catch (ParseException e2) {

					}
					try {
						precio = Long.parseLong(precio1.getText());
						cod_venta = Long.parseLong(cod_venta2.getText());

						if (fecha1.getText().isEmpty() || precio1.getText().isEmpty()
								|| cod_venta2.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "porfavor rellene todos los campos");
						} else {
							Ventas1 ventas = new Ventas1(cod_venta, fecha, precio);
							controlador.accion(Eventos.UPDATE_VENTA, ventas);
							controlador.accion(Eventos.VER_VENTANA_VENTA, null);
						}

					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "porfavor introduzca elementos válidos");
					}

				}
			}
		});
		botonicon__2.setBounds(374, 301, 107, 30);
		frame.getContentPane().add(botonicon__2);

	}

	public void open() {
		controlador.accion(Eventos.VER_VENTANA_VENTA, null);
		frame.setVisible(true);
	}

	public void update(List<Ventas1> l) {
		modelo.setRowCount(0);
		for (Ventas1 p1 : l) {
			modelo.addRow(new Object[] { p1.getCod_venta(), p1.getFecha(), p1.getPrecio_subasta() });
		}
		modelo.fireTableDataChanged();

	}
}

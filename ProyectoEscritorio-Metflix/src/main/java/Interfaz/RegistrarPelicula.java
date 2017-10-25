package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Principal;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class RegistrarPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtLanzamiento;
	private JTextField txtPrecio;
	private JTextField txtDescripcion;

	/**
	 * Create the frame.
	 */
	public RegistrarPelicula(Administrador admin) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 567, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 549, 305);
		contentPane.add(panel);

		JLabel lblRegistroPelicula = new JLabel("Registro Pelicula");
		lblRegistroPelicula.setForeground(Color.RED);
		lblRegistroPelicula.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblRegistroPelicula.setBounds(12, 13, 190, 16);
		panel.add(lblRegistroPelicula);

		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblId.setBounds(12, 55, 88, 16);
		panel.add(lblId);

		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(112, 55, 177, 22);
		panel.add(txtId);

		JLabel label_2 = new JLabel("Nombre");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label_2.setBounds(12, 100, 88, 16);
		panel.add(label_2);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(112, 100, 177, 22);
		panel.add(txtNombre);

		JLabel lblLanzamieto = new JLabel("A\u00F1o de lanzamieto");
		lblLanzamieto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblLanzamieto.setBounds(331, 100, 190, 16);
		panel.add(lblLanzamieto);

		txtLanzamiento = new JTextField();
		txtLanzamiento.setText("YYYY-MM-DD");
		txtLanzamiento.setColumns(10);
		txtLanzamiento.setBounds(331, 141, 190, 22);
		panel.add(txtLanzamiento);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPrecio.setBounds(12, 144, 39, 16);
		panel.add(lblPrecio);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblDescripcion.setBounds(12, 183, 132, 16);
		panel.add(lblDescripcion);

		JLabel lblConfirmacion = new JLabel("Confirmacion");
		lblConfirmacion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblConfirmacion.setBounds(12, 275, 354, 16);
		panel.add(lblConfirmacion);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(112, 144, 177, 22);
		panel.add(txtPrecio);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(112, 183, 177, 55);
		panel.add(txtDescripcion);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				String fecha = txtLanzamiento.getText();
				String desc = txtDescripcion.getText();
				int estado = 1;
				String nombre = txtNombre.getText();
				double precio = Double.parseDouble(txtPrecio.getText());

				try {
					Principal.getInstancia().registroPelicula(id, fecha, desc, estado, nombre, precio);
					lblConfirmacion.setText("Proceso completado.");
				} catch (ElementoRegistradorException | InformacionRepetidaException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblConfirmacion.setText("Proceso no completado.");
				}

			}
		});
		btnGuardar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnGuardar.setBounds(410, 179, 112, 25);
		panel.add(btnGuardar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin.setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.setBounds(410, 217, 112, 25);
		panel.add(btnSalir);
	}
}

package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Principal;
import co.edu.uniquindio.com.Empleado;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class BuscarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JLabel lblNombre;
	private JLabel lblPuesto;
	private JLabel lblSalario;
	private JLabel lblSueldo;

	/**
	 * Create the frame.
	 */
	public BuscarEmpleado(Administrador admin) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 401, 356);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin.setVisible(true);
			}
		});
		btnSalir.setBounds(257, 271, 97, 25);
		contentPane.add(btnSalir);

		JLabel lblBuscarEmpleado = new JLabel("Buscar Empleado");
		lblBuscarEmpleado.setForeground(Color.RED);
		lblBuscarEmpleado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblBuscarEmpleado.setBounds(12, 13, 170, 16);
		contentPane.add(lblBuscarEmpleado);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCedula.setBounds(12, 58, 56, 16);
		contentPane.add(lblCedula);
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNombre.setBounds(12, 149, 56, 16);
		contentPane.add(lblNombre);

		lblPuesto = new JLabel("Puesto:");
		lblPuesto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPuesto.setBounds(12, 178, 56, 16);
		contentPane.add(lblPuesto);

		lblNombre = new JLabel("informacion");
		lblNombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNombre.setBounds(97, 149, 257, 16);
		contentPane.add(lblNombre);

		lblSueldo = new JLabel("informacion");
		lblSueldo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblSueldo.setBounds(97, 201, 116, 16);
		contentPane.add(lblSueldo);

		lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblSalario.setBounds(12, 201, 56, 16);
		contentPane.add(lblSalario);

		lblPuesto = new JLabel("informacion");
		lblPuesto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPuesto.setBounds(97, 178, 116, 16);
		contentPane.add(lblPuesto);

		txtCedula = new JTextField();
		txtCedula.setBounds(97, 55, 257, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				if (cedula != "") {
					try {
						Empleado empleado = Principal.getInstancia().buscarEmpleadoPorNombreUsuario(cedula);
						lblNombre.setText(empleado.getNombre());
						lblPuesto.setText(empleado.getPuesto());
						lblSueldo.setText(String.valueOf(empleado.getSueldo()));

					} catch (Exception e1) {
						lblNombre.setText("No se ha encontrado ningun empleado");
						lblPuesto.setText("");
						lblSalario.setText("");
						e1.printStackTrace();
					}
				}
			}
		});
		btnBuscar.setBounds(257, 96, 97, 25);
		contentPane.add(btnBuscar);
	}

	public void resetear() {
		txtCedula.setText("");
		lblNombre.setText("informacion");
		lblPuesto.setText("informacion");
		lblSueldo.setText("informacion");
	}
}

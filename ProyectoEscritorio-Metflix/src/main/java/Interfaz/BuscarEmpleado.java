package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Principal;
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

	/**
	 * Create the frame.
	 */
	public BuscarEmpleado(Administrador admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				setVisible(false);
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
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNombre.setBounds(12, 149, 56, 16);
		contentPane.add(lblNombre);

		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPuesto.setBounds(12, 178, 56, 16);
		contentPane.add(lblPuesto);

		JLabel lblnombre = new JLabel("informacion");
		lblnombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblnombre.setBounds(97, 149, 116, 16);
		contentPane.add(lblnombre);

		JLabel lblsalario = new JLabel("informacion");
		lblsalario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblsalario.setBounds(97, 201, 116, 16);
		contentPane.add(lblsalario);

		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblSalario.setBounds(12, 201, 56, 16);
		contentPane.add(lblSalario);

		JLabel lblpuesto = new JLabel("informacion");
		lblpuesto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblpuesto.setBounds(97, 178, 116, 16);
		contentPane.add(lblpuesto);

		txtCedula = new JTextField();
		txtCedula.setBounds(97, 55, 257, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				try {
					// Cargar los datos del empleado, cuando se haga una busqueda, traer la el nombre del empleado, el puesto y el salario desde la BD.
					Principal.getInstancia().buscarEmpleadoPorNombreUsuario(cedula);
				} catch (ElementoRegistradorException | InformacionRepetidaException e1) {
					lblnombre.setText("No se ha encontrado ningun empleado");
					e1.printStackTrace();
				}				
			}
		});
		btnBuscar.setBounds(257, 96, 97, 25);
		contentPane.add(btnBuscar);		
	}
}

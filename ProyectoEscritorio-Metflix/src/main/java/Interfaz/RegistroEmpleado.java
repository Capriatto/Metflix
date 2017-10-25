package Interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Principal.Principal;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;
import java.awt.Font;
import java.awt.Color;

public class RegistroEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtContraseña;
	private JTextField txtCorreo;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 *//*
		 * public static void main(String[] args) { EventQueue.invokeLater(new
		 * Runnable() { public void run() { try { RegistroEmpleado frame = new
		 * RegistroEmpleado(); frame.setVisible(true); } catch (Exception e) {
		 * e.printStackTrace(); } } }); }
		 */

	/**
	 * Create the frame.
	 */
	public RegistroEmpleado(Administrador admin) {
		admin.setVisible(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 615, 368);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegistroEmpleado = new JLabel("Registro Empleado");
		lblRegistroEmpleado.setForeground(Color.RED);
		lblRegistroEmpleado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblRegistroEmpleado.setBounds(12, 13, 190, 16);
		contentPane.add(lblRegistroEmpleado);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCedula.setBounds(12, 55, 88, 16);
		contentPane.add(lblCedula);

		txtCedula = new JTextField();
		txtCedula.setBounds(142, 52, 177, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNombre.setBounds(12, 100, 88, 16);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(142, 97, 177, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblApellido.setBounds(331, 100, 45, 16);
		contentPane.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(388, 97, 190, 22);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblContrasea.setBounds(331, 183, 85, 16);
		contentPane.add(lblContrasea);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCorreo.setBounds(12, 144, 39, 16);
		contentPane.add(lblCorreo);

		JLabel lblUsuario = new JLabel("Nombre de usuario");
		lblUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblUsuario.setBounds(12, 183, 132, 16);
		contentPane.add(lblUsuario);

		JLabel lblConfirmacion = new JLabel("Confirmacion");
		lblConfirmacion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblConfirmacion.setBounds(12, 219, 354, 16);
		contentPane.add(lblConfirmacion);

		txtContraseña = new JTextField();
		txtContraseña.setBounds(428, 180, 150, 22);
		contentPane.add(txtContraseña);
		txtContraseña.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(142, 141, 177, 22);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(142, 180, 177, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String contrasena = txtContraseña.getText();
				String correo = txtCorreo.getText();
				String usuario = txtUsuario.getText();
				int estado = 1;

				try {
					Principal.getInstancia().registroEmpleado(cedula, apellido, contrasena, correo, estado, nombre,
							usuario);
					lblConfirmacion.setText("Proceso completado.");
				} catch (ElementoRegistradorException | InformacionRepetidaException e1) {
					lblConfirmacion.setText("Proceso no completado.");
					e1.printStackTrace();
				}
				System.out.println(cedula);
			}
		});
		btnGuardar.setBounds(466, 215, 112, 25);
		contentPane.add(btnGuardar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin.setVisible(true);
			}
		});
		btnSalir.setBounds(466, 253, 112, 25);
		contentPane.add(btnSalir);

	}
}

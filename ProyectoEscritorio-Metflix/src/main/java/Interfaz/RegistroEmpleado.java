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
		setBounds(100, 100, 424, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegistroEmpleado = new JLabel("Registro Empleado");
		lblRegistroEmpleado.setBounds(40, 13, 107, 16);
		contentPane.add(lblRegistroEmpleado);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(40, 47, 39, 16);
		contentPane.add(lblCedula);

		txtCedula = new JTextField();
		txtCedula.setBounds(142, 44, 252, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 76, 45, 16);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(142, 73, 252, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(40, 108, 45, 16);
		contentPane.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(142, 108, 252, 22);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(40, 146, 65, 16);
		contentPane.add(lblContrasea);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(40, 177, 39, 16);
		contentPane.add(lblCorreo);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(40, 212, 43, 16);
		contentPane.add(lblUsuario);

		JLabel lblConfirmacion = new JLabel("Confirmacion");
		lblConfirmacion.setBounds(40, 281, 354, 16);
		contentPane.add(lblConfirmacion);

		txtContraseña = new JTextField();
		txtContraseña.setBounds(142, 143, 252, 22);
		contentPane.add(txtContraseña);
		txtContraseña.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(142, 174, 252, 22);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(142, 209, 252, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
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
		btnGuardar.setBounds(282, 244, 112, 25);
		contentPane.add(btnGuardar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				admin.setVisible(true);
			}
		});
		btnSalir.setBounds(173, 244, 97, 25);
		contentPane.add(btnSalir);

	}
}

package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Principal;
import co.edu.uniquindio.com.Administrador;
import co.edu.uniquindio.com.Empleado;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPws;
	String tipo;
	Interfaz.Administrador administrador = new Interfaz.Administrador();
	Interfaz.Empleado empleadoI = new Interfaz.Empleado();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panelLog = new JPanel();
		panelLog.setBounds(12, 128, 337, 114);
		contentPane.add(panelLog);
		panelLog.setLayout(null);
		panelLog.setVisible(false);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblTipo.setBounds(12, 13, 105, 16);
		panelLog.add(lblTipo);

		JLabel lblBienvenidoMetflix = new JLabel("Bienvenido MetFlix");
		lblBienvenidoMetflix.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblBienvenidoMetflix.setBounds(12, 13, 117, 16);
		contentPane.add(lblBienvenidoMetflix);

		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLog.setVisible(true);
				tipo = "Administrador";
				lblTipo.setText(tipo);
			}
		});
		btnAdministrador.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnAdministrador.setBounds(12, 75, 117, 25);
		contentPane.add(btnAdministrador);

		JButton btnEmpleado = new JButton("Empleado");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLog.setVisible(true);
				tipo = "Empleado";
				lblTipo.setText(tipo);
			}
		});
		btnEmpleado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnEmpleado.setBounds(141, 75, 97, 25);
		contentPane.add(btnEmpleado);

		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnCliente.setBounds(252, 75, 97, 25);
		contentPane.add(btnCliente);

		JLabel lblSeleccioneSuRol = new JLabel("Seleccione su rol");
		lblSeleccioneSuRol.setForeground(Color.RED);
		lblSeleccioneSuRol.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblSeleccioneSuRol.setBounds(12, 42, 226, 16);
		contentPane.add(lblSeleccioneSuRol);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblUsuario.setBounds(12, 42, 56, 16);
		panelLog.add(lblUsuario);

		txtUser = new JTextField();
		txtUser.setBounds(115, 39, 116, 22);
		panelLog.add(txtUser);
		txtUser.setColumns(10);

		JLabel lblContrasea = new JLabel("contrase\u00F1a");
		lblContrasea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblContrasea.setBounds(12, 71, 105, 16);
		panelLog.add(lblContrasea);

		txtPws = new JPasswordField();
		txtPws.setBounds(115, 68, 116, 22);
		panelLog.add(txtPws);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText();
				if (tipo == "Administrador") {
					lblTipo.setText(tipo);
					try {
						Administrador admin = Principal.getInstancia().buscarAdministrador(user);
						if (admin != null) {
							String pass = admin.getContrasena();
							if (pass.equals(txtPws.getText())) {
								administrador.setVisible(true);
								dispose();

							} else {
								System.out.println("no entra");
							}
						}
					} catch (ElementoRegistradorException | InformacionRepetidaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (tipo == "Empleado") {
					lblTipo.setText(tipo);
					try {
						Empleado empleado = Principal.getInstancia().buscarEmpleadoPorNombreUsuario(user);
						if (empleado != null) {
							String pass = empleado.getContrasena();
							if (pass.equals(txtPws.getText())) {
								empleadoI.setVisible(true);
								dispose();

							} else {
								System.out.println("no entra");
							}
						}
					} catch (ElementoRegistradorException | InformacionRepetidaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (tipo == "Cliente") {
					lblTipo.setText(tipo);
					try {
						Empleado empleado = Principal.getInstancia().buscarEmpleadoPorNombreUsuario(user);
						if (empleado != null) {
							String pass = empleado.getContrasena();
							if (pass.equals(txtPws.getText())) {
								empleadoI.setVisible(true);
								dispose();

							} else {
								System.out.println("no entra");
							}
						}
					} catch (ElementoRegistradorException | InformacionRepetidaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnIngresar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnIngresar.setBounds(243, 67, 82, 25);
		panelLog.add(btnIngresar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.setBounds(252, 248, 97, 25);
		contentPane.add(btnSalir);
	}
}

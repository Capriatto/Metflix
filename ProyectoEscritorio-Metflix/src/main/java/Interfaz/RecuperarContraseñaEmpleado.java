package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Principal.EmailSenderService;
import Principal.Principal;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;
import excepciones.PersonaNoEncontradaException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class RecuperarContraseñaEmpleado extends JFrame {
	private JTextField txtCedula;

	/**
	 * Create the frame.
	 */
	public RecuperarContraseñaEmpleado(Administrador admin) {
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 367, 220);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("RECUPERAR CONTRASEÑA");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 21, 296, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblCdulaEmpleado = new JLabel("C\u00E9dula");
		lblCdulaEmpleado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCdulaEmpleado.setBounds(28, 64, 114, 14);
		getContentPane().add(lblCdulaEmpleado);

		txtCedula = new JTextField();
		txtCedula.setBounds(79, 62, 245, 20);
		getContentPane().add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnNewButton = new JButton("Recuperar");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				try {
					if(!cedula.equals("")) {
					if (Principal.getInstancia().buscarAdministrador(cedula) != null) {
						try {
							String de = "admonmetflix1@gmail.com";
							String clave = "administrador1";
							String para = Principal.getInstancia().buscarAdministrador(cedula).getCorreo();
							String mensaje = "Saludos\nSegun solicitud realizada, "
									+ "te recordamos tu clave de acceso a la plataforma METFLIX.\n\nClave:"
									+ Principal.getInstancia().recuperarContraseniaAdmin(cedula);
							String asunto = "Contraseña Plataforma METFLIX";
							EmailSenderService.getInstancia().enviarcorreo(de, clave, para, mensaje, asunto);
							JOptionPane.showMessageDialog(null,"Un correo electrónico le ha sido enviado con su contraseña.","Contraseña enviada!", JOptionPane.INFORMATION_MESSAGE);
						} catch (ElementoRegistradorException | InformacionRepetidaException e1) {
							JOptionPane.showMessageDialog(null,"No hemos podido recuperar su contraseña.\nPor favor registre una cuenta nueva o comuníquese con soporte","Error!", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null,"No hemos podido recuperar su contraseña.\nNo se encontró el usuario con cédula: "+cedula,"Error!", JOptionPane.ERROR_MESSAGE);
					}
					}else {JOptionPane.showMessageDialog(null,
							"Todos los campos son obligatorios.\nPor favor rellene los campos faltantes para recuperar su contraseña.",
							"Error al recuperar contraseña!", JOptionPane.ERROR_MESSAGE);}
				} catch (ElementoRegistradorException | InformacionRepetidaException e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(227, 94, 97, 23);
		getContentPane().add(btnNewButton);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin.setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.setBounds(227, 128, 97, 25);
		getContentPane().add(btnSalir);

	}
}

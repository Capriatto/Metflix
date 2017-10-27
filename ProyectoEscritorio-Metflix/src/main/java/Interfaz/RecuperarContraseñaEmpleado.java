package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
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
		setBounds(100, 100, 371, 241);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("RECUPERAR CONTRASEÑA DE EMPLEADO");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 21, 296, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblCdulaEmpleado = new JLabel("C\u00E9dula");
		lblCdulaEmpleado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCdulaEmpleado.setBounds(28, 64, 114, 14);
		getContentPane().add(lblCdulaEmpleado);

		JLabel lblInformacion = new JLabel("Informacion");
		lblInformacion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblInformacion.setBounds(132, 126, 192, 16);
		getContentPane().add(lblInformacion);

		txtCedula = new JTextField();
		txtCedula.setBounds(132, 61, 192, 20);
		getContentPane().add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnNewButton = new JButton("Recuperar");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				try {
					lblInformacion.setText(Principal.getInstancia().recuperarContrasenia(cedula));
					String de = "admonmetflix1@gmail.com";
					String clave = "administrador1";
					String para = Principal.getInstancia().buscarEmpleadoPorNombreUsuario(cedula).getCorreo();
					String mensaje = "Saludos\nSegun solicitud realizada, "
							+ "te recordamos tu clave de acceso a la plataforma METFLIX.\n\nClave:"
							+ Principal.getInstancia().recuperarContrasenia(cedula);
					String asunto = "Constraseña Plataforma METFLIX";
					EmailSenderService.getInstancia().enviarcorreo(de, clave, para, mensaje, asunto);
				} catch (ElementoRegistradorException | InformacionRepetidaException e1) {
					lblInformacion.setText("Proceso no completado");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(227, 94, 97, 23);
		getContentPane().add(btnNewButton);

		JLabel lblConstrasea = new JLabel("Constrase\u00F1a");
		lblConstrasea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblConstrasea.setBounds(28, 126, 114, 16);
		getContentPane().add(lblConstrasea);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin.setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.setBounds(227, 156, 97, 25);
		getContentPane().add(btnSalir);

	}
}

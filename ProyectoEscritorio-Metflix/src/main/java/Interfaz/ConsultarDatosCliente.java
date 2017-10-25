package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ConsultarDatosCliente extends JFrame {
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ConsultarDatosCliente(Administrador admin) {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		getContentPane().setForeground(Color.RED);
		getContentPane().setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		setBounds(100, 100, 351, 339);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblConsultarDatosCliente = new JLabel("CONSULTAR DATOS CLIENTE");
		lblConsultarDatosCliente.setForeground(Color.RED);
		lblConsultarDatosCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblConsultarDatosCliente.setBounds(10, 12, 296, 14);
		getContentPane().add(lblConsultarDatosCliente);
		
		JLabel lblCdulaCliente = new JLabel("C\u00E9dula cliente");
		lblCdulaCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCdulaCliente.setBounds(10, 39, 97, 14);
		getContentPane().add(lblCdulaCliente);
		
		textField = new JTextField();
		textField.setBounds(104, 36, 189, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Consultar Datos");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(162, 71, 131, 23);
		getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label.setBounds(10, 129, 97, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("informacion");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label_1.setBounds(149, 129, 144, 16);
		getContentPane().add(label_1);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblApellido.setBounds(10, 158, 97, 16);
		getContentPane().add(lblApellido);
		
		JLabel label_3 = new JLabel("informacion");
		label_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label_3.setBounds(149, 158, 144, 16);
		getContentPane().add(label_3);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCorreo.setBounds(10, 187, 97, 16);
		getContentPane().add(lblCorreo);
		
		JLabel label_5 = new JLabel("informacion");
		label_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label_5.setBounds(149, 187, 144, 16);
		getContentPane().add(label_5);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblContrasea.setBounds(10, 216, 97, 16);
		getContentPane().add(lblContrasea);
		
		JLabel lblNewLabel = new JLabel("Informacion");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel.setBounds(149, 216, 144, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin.setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.setBounds(224, 254, 97, 25);
		getContentPane().add(btnSalir);
		
		JButton btnRecuperarPass = new JButton("Recuperar pass");
		btnRecuperarPass.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnRecuperarPass.setBounds(81, 254, 131, 25);
		getContentPane().add(btnRecuperarPass);

	}
}

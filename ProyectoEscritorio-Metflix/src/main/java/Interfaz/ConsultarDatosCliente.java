package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Principal.Principal;
import co.edu.uniquindio.com.Empleado;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ConsultarDatosCliente extends JFrame {
	private JTextField txtCedula;

	/**
	 * Create the frame.
	 */
	public ConsultarDatosCliente(String tipo) {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		getContentPane().setForeground(Color.RED);
		getContentPane().setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		setBounds(100, 100, 327, 337);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
						
								JLabel lblcorreo = new JLabel("informacion");
								lblcorreo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
								lblcorreo.setBounds(149, 187, 144, 16);
								getContentPane().add(lblcorreo);
				
						JLabel lblapellido = new JLabel("informacion");
						lblapellido.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
						lblapellido.setBounds(149, 158, 144, 16);
						getContentPane().add(lblapellido);
		
				JLabel lblnombre = new JLabel("informacion");
				lblnombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
				lblnombre.setBounds(149, 129, 144, 16);
				getContentPane().add(lblnombre);

		JLabel lblpass = new JLabel("Informacion");
		lblpass.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblpass.setBounds(149, 216, 144, 16);
		getContentPane().add(lblpass);
		lblpass.setVisible(false);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblContrasea.setBounds(10, 216, 97, 16);
		getContentPane().add(lblContrasea);
		lblContrasea.setVisible(false);

		JLabel lblConsultarDatosCliente = new JLabel("CONSULTAR DATOS CLIENTE");
		lblConsultarDatosCliente.setForeground(Color.RED);
		lblConsultarDatosCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblConsultarDatosCliente.setBounds(10, 12, 296, 14);
		getContentPane().add(lblConsultarDatosCliente);

		JLabel lblCdulaCliente = new JLabel("C\u00E9dula cliente");
		lblCdulaCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCdulaCliente.setBounds(10, 39, 97, 14);
		getContentPane().add(lblCdulaCliente);

		txtCedula = new JTextField();
		txtCedula.setBounds(104, 36, 189, 20);
		getContentPane().add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnNewButton = new JButton("Consultar Datos");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				if (cedula != "") {
					if (tipo.equals("Cliente")) {
						lblContrasea.setVisible(true);
						lblpass.setVisible(true);
						try {
							co.edu.uniquindio.com.Cliente cliente = Principal.getInstancia().buscarClienteId(cedula);
							lblnombre.setText(cliente.getNombre());
							lblapellido.setText(cliente.getApellido());
							lblcorreo.setText(cliente.getCorreo());
							lblpass.setText(cliente.getContrasena());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "No se encontró el cliente que busca.");
							lblnombre.setText("");
							lblapellido.setText("");
							lblcorreo.setText("");
							lblpass.setText("");
						}
					}else if(tipo.equals("Empleado")) {
						try {
							co.edu.uniquindio.com.Cliente cliente = Principal.getInstancia().buscarClienteId(cedula);
							lblnombre.setText(cliente.getNombre());
							lblapellido.setText(cliente.getApellido());
							lblcorreo.setText(cliente.getCorreo());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "No se encontró el cliente que busca.");
							lblnombre.setText("");
							lblapellido.setText("");
							lblcorreo.setText("");
						}
					}
					
				}
			}
		});
		btnNewButton.setBounds(162, 71, 131, 23);
		getContentPane().add(btnNewButton);

		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label.setBounds(10, 129, 97, 16);
		getContentPane().add(label);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblApellido.setBounds(10, 158, 97, 16);
		getContentPane().add(lblApellido);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCorreo.setBounds(10, 187, 97, 16);
		getContentPane().add(lblCorreo);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.setBounds(196, 254, 97, 25);
		getContentPane().add(btnSalir);

	}
}

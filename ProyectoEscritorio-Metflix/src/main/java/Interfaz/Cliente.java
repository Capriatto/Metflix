package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Cliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Cliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenuAdministrador = new JLabel("Metflix");
		lblMenuAdministrador.setForeground(Color.RED);
		lblMenuAdministrador.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblMenuAdministrador.setBounds(12, 13, 182, 34);
		contentPane.add(lblMenuAdministrador);

		JPanel panelEmpleado = new JPanel();
		panelEmpleado.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panelEmpleado.setBounds(12, 60, 391, 132);
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(null);

		JLabel lblAdministrarEmpleados = new JLabel("Peliculas");
		lblAdministrarEmpleados.setForeground(Color.RED);
		lblAdministrarEmpleados.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblAdministrarEmpleados.setBounds(12, 13, 170, 16);
		panelEmpleado.add(lblAdministrarEmpleados);

		JButton btnRegistrar = new JButton("Buscar Películas");
		btnRegistrar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnRegistrar.setBounds(12, 42, 195, 25);
		panelEmpleado.add(btnRegistrar);

		JButton btnEliminar = new JButton("Calificar Películas");
		btnEliminar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnEliminar.setBounds(223, 80, 158, 25);
		panelEmpleado.add(btnEliminar);

		JButton btnModificar = new JButton("Películas Recomendadas");
		btnModificar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnModificar.setBounds(12, 80, 195, 25);
		panelEmpleado.add(btnModificar);

		JButton btnBuscar = new JButton("Comprar Peliculas");
		btnBuscar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBuscar.setBounds(223, 42, 158, 25);
		panelEmpleado.add(btnBuscar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(306, 291, 97, 25);
		contentPane.add(btnSalir);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel.setBounds(12, 203, 391, 75);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblOtrasOpciones = new JLabel("Otras Opciones");
		lblOtrasOpciones.setForeground(Color.RED);
		lblOtrasOpciones.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblOtrasOpciones.setBounds(12, 13, 130, 16);
		panel.add(lblOtrasOpciones);

		JButton btnCambiarContrasea = new JButton("Recuperar Contrase\u00F1a");
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCambiarContrasea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnCambiarContrasea.setBounds(12, 37, 175, 25);
		panel.add(btnCambiarContrasea);
	}
}

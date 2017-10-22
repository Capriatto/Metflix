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

public class EliminarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;

	/**
	 * Create the frame.
	 */
	public EliminarEmpleado(Administrador admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 243, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				admin.setVisible(true);
			}
		});
		btnSalir.setBounds(113, 146, 97, 25);
		contentPane.add(btnSalir);

		JLabel lblEliminarEmpleado = new JLabel("Eliminar Empleado");
		lblEliminarEmpleado.setBounds(12, 13, 147, 16);
		contentPane.add(lblEliminarEmpleado);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(12, 42, 56, 16);
		contentPane.add(lblCedula);

		JLabel lblConfirmacion = new JLabel("Confirmacion");
		lblConfirmacion.setBounds(12, 117, 198, 16);
		contentPane.add(lblConfirmacion);

		txtCedula = new JTextField();
		txtCedula.setBounds(94, 39, 116, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				try {
					Principal.getInstancia().elimiarEmpleado(cedula);
					lblConfirmacion.setText("Empleado Eliminado");					
				} catch (ElementoRegistradorException | InformacionRepetidaException e1) {
					lblConfirmacion.setText("Proceso no completado.");
					e1.printStackTrace();
				}
				System.out.println(cedula);
			}
		});
		btnEliminar.setBounds(113, 74, 97, 25);
		contentPane.add(btnEliminar);

	}

}

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

public class EliminarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JLabel lblConfirmacion;
	
	/**
	 * Create the frame.
	 */
	public EliminarEmpleado(Administrador admin) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 262, 241);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin.setVisible(true);
			}
		});
		btnSalir.setBounds(135, 144, 97, 25);
		contentPane.add(btnSalir);

		JLabel lblEliminarEmpleado = new JLabel("Eliminar Empleado");
		lblEliminarEmpleado.setForeground(Color.RED);
		lblEliminarEmpleado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblEliminarEmpleado.setBounds(12, 13, 147, 16);
		contentPane.add(lblEliminarEmpleado);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCedula.setBounds(12, 42, 56, 16);
		contentPane.add(lblCedula);

		lblConfirmacion = new JLabel("Confirmacion");
		lblConfirmacion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblConfirmacion.setBounds(12, 117, 198, 16);
		contentPane.add(lblConfirmacion);

		txtCedula = new JTextField();
		txtCedula.setBounds(80, 37, 152, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				try {
					int estado = 0;
					boolean confirmacion = Principal.getInstancia().eliminarEmpleado(cedula, estado);
					if (confirmacion) {
						lblConfirmacion.setText("Empleado eliminado");
					} else {
						lblConfirmacion.setText("Proceso no completado.");
					}
				} catch (ElementoRegistradorException | InformacionRepetidaException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setBounds(135, 72, 97, 25);
		contentPane.add(btnEliminar);

	}
	

	public void resetear() {
		txtCedula.setText("");
		lblConfirmacion.setText("");
	}

}

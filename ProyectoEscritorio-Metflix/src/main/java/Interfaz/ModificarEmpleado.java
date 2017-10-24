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

public class ModificarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtPuesto;
	private JTextField txtSalario;

	/**
	 * Create the frame.
	 */
	public ModificarEmpleado(Administrador admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 246, 282);
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
		btnSalir.setBounds(95, 176, 97, 25);
		contentPane.add(btnSalir);

		JLabel lblModificarEmpleado = new JLabel("Modificar Empleado");
		lblModificarEmpleado.setBounds(12, 13, 143, 16);
		contentPane.add(lblModificarEmpleado);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(12, 42, 56, 16);
		contentPane.add(lblCedula);

		txtCedula = new JTextField();
		txtCedula.setBounds(76, 39, 116, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setBounds(12, 77, 56, 16);
		contentPane.add(lblPuesto);

		txtPuesto = new JTextField();
		txtPuesto.setBounds(76, 74, 116, 22);
		contentPane.add(txtPuesto);
		txtPuesto.setColumns(10);

		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setBounds(12, 106, 56, 16);
		contentPane.add(lblSalario);

		JLabel lblConfirmacion = new JLabel("Confirmacion");
		lblConfirmacion.setBounds(12, 206, 180, 16);
		contentPane.add(lblConfirmacion);

		txtSalario = new JTextField();
		txtSalario.setBounds(76, 103, 116, 22);
		contentPane.add(txtSalario);
		txtSalario.setColumns(10);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				String puesto = txtPuesto.getText();
				double salario = Double.parseDouble(txtSalario.getText());
				try {
					boolean confirmacion=Principal.getInstancia().modificarEmpleado(cedula, puesto, salario);
					if(confirmacion) {
						lblConfirmacion.setText("Empleado modificado");
					}else {
						lblConfirmacion.setText("Proceso no completado.");
					}
				} catch (ElementoRegistradorException | InformacionRepetidaException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnModificar.setBounds(95, 138, 97, 25);
		contentPane.add(btnModificar);

	}

}

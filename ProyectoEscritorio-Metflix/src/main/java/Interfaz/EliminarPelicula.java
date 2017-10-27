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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class EliminarPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;

	/**
	 * Create the frame.
	 */
	public EliminarPelicula(Administrador admin) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 291, 172);
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
		btnSalir.setBounds(174, 109, 97, 25);
		contentPane.add(btnSalir);

		JLabel lblEliminarPelicula = new JLabel("Eliminar Pelicula");
		lblEliminarPelicula.setForeground(Color.RED);
		lblEliminarPelicula.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblEliminarPelicula.setBounds(12, 13, 147, 16);
		contentPane.add(lblEliminarPelicula);

		JLabel lblCedula = new JLabel("Nombre Pelicula");
		lblCedula.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCedula.setBounds(12, 42, 109, 16);
		contentPane.add(lblCedula);

		txtNombre = new JTextField();
		txtNombre.setBounds(119, 40, 152, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				int estado = 0;
				boolean confirmacion = Principal.getInstancia().eliminarPelicula(nombre, estado);
				if (confirmacion) {
					JOptionPane.showMessageDialog(null, "La pel�cula ha sido eliminada.", "Aviso Importante!", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "la pel�cula no se ha podido eliminar.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminar.setBounds(174, 73, 97, 25);
		contentPane.add(btnEliminar);

	}

	public void resetear() {
		txtNombre.setText("");
	}

}

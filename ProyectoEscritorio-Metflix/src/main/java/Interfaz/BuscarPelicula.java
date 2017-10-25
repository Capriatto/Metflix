package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Principal;
import co.edu.uniquindio.com.Empleado;
import co.edu.uniquindio.com.Pelicula;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class BuscarPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;

	/**
	 * Create the frame.
	 */
	public BuscarPelicula(Administrador admin) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 401, 356);
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
		btnSalir.setBounds(257, 271, 97, 25);
		contentPane.add(btnSalir);

		JLabel lblBuscarEmpleado = new JLabel("Buscar Pelicula");
		lblBuscarEmpleado.setForeground(Color.RED);
		lblBuscarEmpleado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblBuscarEmpleado.setBounds(12, 13, 170, 16);
		contentPane.add(lblBuscarEmpleado);

		JLabel lblCedula = new JLabel("Id Pelicula");
		lblCedula.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCedula.setBounds(12, 58, 97, 16);
		contentPane.add(lblCedula);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNombre.setBounds(12, 149, 85, 16);
		contentPane.add(lblNombre);

		JLabel lblPuesto = new JLabel("Descripcion");
		lblPuesto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPuesto.setBounds(12, 178, 97, 16);
		contentPane.add(lblPuesto);

		JLabel lblnombre = new JLabel("informacion");
		lblnombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblnombre.setBounds(144, 149, 210, 16);
		contentPane.add(lblnombre);

		JLabel lblfecha = new JLabel("informacion");
		lblfecha.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblfecha.setBounds(144, 201, 210, 16);
		contentPane.add(lblfecha);

		JLabel lblSalario = new JLabel("Fecha lanzamiento");
		lblSalario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblSalario.setBounds(12, 201, 120, 16);
		contentPane.add(lblSalario);

		JLabel lbldesc = new JLabel("informacion");
		lbldesc.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lbldesc.setBounds(144, 178, 210, 16);
		contentPane.add(lbldesc);

		txtCedula = new JTextField();
		txtCedula.setBounds(144, 55, 210, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtCedula.getText());
				try {
					// Cargar los datos del empleado, cuando se haga una busqueda, traer la el
					// nombre del empleado, el puesto y el salario desde la BD.
					Pelicula pelicula = Principal.getInstancia().buscarPeliculaPorId(id);
					lblnombre.setText(pelicula.getNombre());
					lbldesc.setText(pelicula.getDescripcion());
					lblfecha.setText(String.valueOf(pelicula.getAnio_lanzamiento()));

				} catch (Exception e1) {
					lblnombre.setText("No se ha encontrado ninguna Pelicula");
					lbldesc.setText("");
					lblfecha.setText("");
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(257, 96, 97, 25);
		contentPane.add(btnBuscar);
	}
}

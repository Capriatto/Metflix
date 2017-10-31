package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Principal.Principal;
import co.edu.uniquindio.com.Pelicula;

public class BuscarPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombrePelicula;
	private JLabel lblnombre;
	private JLabel lbldesc;
	private JLabel lblfecha;

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

		JLabel lblCedula = new JLabel("Nombre Pelicula");
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

	    lblnombre = new JLabel("informacion");
		lblnombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblnombre.setBounds(144, 149, 249, 16);
		contentPane.add(lblnombre);

		lblfecha = new JLabel("informacion");
		lblfecha.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblfecha.setBounds(144, 201, 210, 16);
		contentPane.add(lblfecha);

		JLabel lblSalario = new JLabel("Fecha lanzamiento");
		lblSalario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblSalario.setBounds(12, 201, 120, 16);
		contentPane.add(lblSalario);

	    lbldesc = new JLabel("informacion");
		lbldesc.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lbldesc.setBounds(144, 178, 210, 16);
		contentPane.add(lbldesc);

		txtNombrePelicula = new JTextField();
		txtNombrePelicula.setBounds(144, 55, 210, 22);
		contentPane.add(txtNombrePelicula);
		txtNombrePelicula.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String nombre= txtNombrePelicula.getText();
				try {
					Pelicula pelicula = Principal.getInstancia().buscarPeliculaPorNombre(nombre);
					if(pelicula != null) {
						lblnombre.setText(pelicula.getNombre());
						lbldesc.setText(pelicula.getDescripcion());
						SimpleDateFormat df = new SimpleDateFormat("yyyy");
						lblfecha.setText(String.valueOf(df.format(pelicula.getAnio_lanzamiento())));
					}else {
						lbldesc.setText("");
						lblfecha.setText("");
						lblnombre.setText("");
						JOptionPane.showMessageDialog(null, "No se ha encontrado la película");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado la película");
					lbldesc.setText("");
					lblfecha.setText("");
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(257, 96, 97, 25);
		contentPane.add(btnBuscar);
	}
	
	public void resetear() {
		lblnombre.setText("");
		lbldesc.setText("");
		lblfecha.setText("");
		txtNombrePelicula.setText("");
	}

}

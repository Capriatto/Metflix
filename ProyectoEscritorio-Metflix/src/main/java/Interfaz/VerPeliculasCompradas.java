package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Principal.Principal;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;

public class VerPeliculasCompradas extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesde;
	private JTextField txtHasta;
	private JTextField txtResultado;

	/**
	 * Create the frame.
	 */
	public VerPeliculasCompradas(Administrador admin) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 386, 348);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenuAdministrador = new JLabel("Cantidad de Películas Compradas");
		lblMenuAdministrador.setForeground(Color.RED);
		lblMenuAdministrador.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblMenuAdministrador.setBounds(12, 13, 352, 34);
		contentPane.add(lblMenuAdministrador);

		JPanel panelEmpleado = new JPanel();
		panelEmpleado.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panelEmpleado.setBounds(12, 60, 352, 97);
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(null);

		JLabel lblAdministrarEmpleados = new JLabel("Escriba el rango de fechas a consultar");
		lblAdministrarEmpleados.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblAdministrarEmpleados.setBounds(12, 13, 249, 16);
		panelEmpleado.add(lblAdministrarEmpleados);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDesde.getText().trim().equals("YYYY-MM-DD") || txtHasta.getText().trim().equals("YYYY-MM-DD")) {
					JOptionPane.showMessageDialog(null,
							"Todos los campos son obligatorios.\nPor favor rellene los campos faltantes para realizar la consulta.",
							"Error consultando!", JOptionPane.ERROR_MESSAGE);
				} else {
					Date desde = Date.valueOf(txtDesde.getText().trim());
					Date hasta = Date.valueOf(txtHasta.getText().trim());
					long compras = Principal.getInstancia().peliculasCompradasEntreFechas(desde, hasta);
					txtResultado.setText("" +compras);
				}
			}
		});
		btnConsultar.setBounds(240, 60, 102, 25);
		panelEmpleado.add(btnConsultar);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblDesde.setBounds(12, 40, 46, 14);
		panelEmpleado.add(lblDesde);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblHasta.setBounds(12, 65, 46, 14);
		panelEmpleado.add(lblHasta);

		txtDesde = new JTextField("YYYY-MM-DD");
		txtDesde.setBounds(65, 38, 135, 20);
		panelEmpleado.add(txtDesde);
		txtDesde.setColumns(10);

		txtHasta = new JTextField("YYYY-MM-DD");
		txtHasta.setBounds(65, 63, 135, 20);
		panelEmpleado.add(txtHasta);
		txtHasta.setColumns(10);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(267, 288, 97, 25);
		contentPane.add(btnSalir);

		JPanel panelPelicula = new JPanel();
		panelPelicula.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelPelicula.setBounds(12, 168, 352, 109);
		contentPane.add(panelPelicula);
		panelPelicula.setLayout(null);

		JLabel lblAdministrarPelicula = new JLabel("Cantidad de películas compradas en este periodo:");
		lblAdministrarPelicula.setBounds(12, 13, 328, 16);
		lblAdministrarPelicula.setForeground(Color.RED);
		lblAdministrarPelicula.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		panelPelicula.add(lblAdministrarPelicula);

		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setBounds(12, 38, 101, 41);
		panelPelicula.add(txtResultado);
		txtResultado.setColumns(10);
	}

	public void resetear() {
		txtDesde.setText("YYYY-MM-DD");
		txtHasta.setText("YYYY-MM-DD");
		txtResultado.setText("");
	}
}

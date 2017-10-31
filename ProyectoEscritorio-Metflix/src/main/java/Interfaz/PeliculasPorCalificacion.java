package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Principal.Principal;
import co.edu.uniquindio.com.Pelicula;

public class PeliculasPorCalificacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup grupoRadios = new ButtonGroup();
	JTextArea txtArea;
	JRadioButton uno;
	JRadioButton dos;
	JRadioButton tres;
	JRadioButton cuatro;
	JRadioButton quinto;
	

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public PeliculasPorCalificacion(Administrador admin) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 480, 348);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenuAdministrador = new JLabel("Consultar Películas Por Calificación");
		lblMenuAdministrador.setForeground(Color.RED);
		lblMenuAdministrador.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblMenuAdministrador.setBounds(12, 13, 352, 34);
		contentPane.add(lblMenuAdministrador);

		JPanel panelEmpleado = new JPanel();
		panelEmpleado.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panelEmpleado.setBounds(12, 60, 452, 65);
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(null);

		JLabel lblAdministrarEmpleados = new JLabel("Seleccione una calificación");
		lblAdministrarEmpleados.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblAdministrarEmpleados.setBounds(12, 13, 249, 16);
		panelEmpleado.add(lblAdministrarEmpleados);
		
	    uno = new JRadioButton("Muy Mala");
	    uno.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		peliculasCalificadas(1);
	    	}
	    });
		grupoRadios.add(uno);
		uno.setBounds(12, 36, 90, 23);
		panelEmpleado.add(uno);
		
		dos = new JRadioButton("Mala");
		dos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliculasCalificadas(2);
			}
		});
		grupoRadios.add(dos);
		dos.setBounds(104, 36, 64, 23);
		panelEmpleado.add(dos);
		
		tres = new JRadioButton("Aceptable");
		tres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliculasCalificadas(3);
			}
		});
		grupoRadios.add(tres);
		tres.setBounds(170, 36, 84, 23);
		panelEmpleado.add(tres);
		
		cuatro = new JRadioButton("Buena");
		cuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliculasCalificadas(4);
			}
		});
		grupoRadios.add(cuatro);
		cuatro.setBounds(256, 36, 79, 23);
		panelEmpleado.add(cuatro);
		
		quinto = new JRadioButton("Muy Buena");
		quinto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliculasCalificadas(5);
			}
		});
		grupoRadios.add(quinto);
		quinto.setBounds(337, 36, 96, 23);
		panelEmpleado.add(quinto);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin.setVisible(true);
			}
		});
		btnSalir.setBounds(267, 288, 97, 25);
		contentPane.add(btnSalir);

		JPanel panelPelicula = new JPanel();
		panelPelicula.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelPelicula.setBounds(12, 136, 452, 141);
		contentPane.add(panelPelicula);
		panelPelicula.setLayout(null);
		
		txtArea = new JTextArea();
		txtArea.setBounds(10, 11, 432, 119);
		panelPelicula.add(txtArea);
		
		
	}
	
	public void peliculasCalificadas(int calificacion) {
		txtArea.setText("");
		List<Pelicula> peliculas = Principal.getInstancia().peliculasPorCalificacion(calificacion);
		peliculas.forEach((temp) -> {
			txtArea.setText(temp.getNombre()+" - "+temp.getAnio_lanzamiento()+"\n"); 
		});
	}
	
	/**
	 * método para inicializar la interfaz sin datos.
	 */
	public void resetear() {
		grupoRadios.clearSelection();
		uno.setSelected(false);
		dos.setSelected(false);
		tres.setSelected(false);
		cuatro.setSelected(false);
		quinto.setSelected(false);
		txtArea.setText("");
	}
}

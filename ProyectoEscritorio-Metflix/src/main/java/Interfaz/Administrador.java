package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Administrador extends JFrame {
	RegistroEmpleado regEmpleado = new RegistroEmpleado(this);
	EliminarEmpleado eliminarEmpleado = new EliminarEmpleado(this);
	BuscarEmpleado buscarEmpleado = new BuscarEmpleado(this);
	ModificarEmpleado modificarEmpleado = new ModificarEmpleado(this);
	RecuperarContraseñaEmpleado recuperarConstraseña = new RecuperarContraseñaEmpleado(this);
	RegistrarPelicula registrarPelicula= new RegistrarPelicula(this);
	EliminarPelicula eliminarPelicula= new EliminarPelicula(this);
	BuscarPelicula buscarPelicula = new BuscarPelicula(this);
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Administrador() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 440, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenuAdministrador = new JLabel("Menu administrador");
		lblMenuAdministrador.setForeground(Color.RED);
		lblMenuAdministrador.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblMenuAdministrador.setBounds(12, 13, 182, 34);
		contentPane.add(lblMenuAdministrador);

		JPanel panelEmpleado = new JPanel();
		panelEmpleado.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panelEmpleado.setBounds(12, 60, 352, 132);
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(null);

		JLabel lblAdministrarEmpleados = new JLabel("Administrar empleados");
		lblAdministrarEmpleados.setForeground(Color.RED);
		lblAdministrarEmpleados.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblAdministrarEmpleados.setBounds(12, 13, 170, 16);
		panelEmpleado.add(lblAdministrarEmpleados);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				regEmpleado.resetear();
				regEmpleado.setVisible(true);
				
			}
		});
		btnRegistrar.setBounds(12, 42, 158, 25);
		panelEmpleado.add(btnRegistrar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				eliminarEmpleado.resetear();
				eliminarEmpleado.setVisible(true);
			}
		});
		btnEliminar.setBounds(182, 80, 158, 25);
		panelEmpleado.add(btnEliminar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				modificarEmpleado.setVisible(true);
			}
		});
		btnModificar.setBounds(12, 80, 158, 25);
		panelEmpleado.add(btnModificar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				buscarEmpleado.resetear();
				buscarEmpleado.setVisible(true);
			}
		});
		btnBuscar.setBounds(182, 42, 158, 25);
		panelEmpleado.add(btnBuscar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(325, 430, 97, 25);
		contentPane.add(btnSalir);
		
		JPanel panelPelicula = new JPanel();
		panelPelicula.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelPelicula.setBounds(12, 205, 352, 109);
		contentPane.add(panelPelicula);
		panelPelicula.setLayout(null);
		
		JLabel lblAdministrarPelicula = new JLabel("Administrar Pelicula");
		lblAdministrarPelicula.setBounds(12, 13, 130, 16);
		lblAdministrarPelicula.setForeground(Color.RED);
		lblAdministrarPelicula.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		panelPelicula.add(lblAdministrarPelicula);
		
		JButton btnRegP = new JButton("Registrar");
		btnRegP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			    registrarPelicula.resetear();
				registrarPelicula.setVisible(true);
				setVisible(false);
			}
		});
		btnRegP.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnRegP.setBounds(12, 33, 158, 25);
		panelPelicula.add(btnRegP);
		
		JButton btnBuscarP = new JButton("Buscar");
		btnBuscarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				buscarPelicula.resetear();
				buscarPelicula.setVisible(true);
			}
		});
		btnBuscarP.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBuscarP.setBounds(182, 33, 158, 25);
		panelPelicula.add(btnBuscarP);
		
		JButton btnModP = new JButton("Modificar");
		btnModP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModP.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnModP.setBounds(12, 71, 158, 25);
		panelPelicula.add(btnModP);
		
		JButton btnEliminarP = new JButton("Eliminar");
		btnEliminarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				eliminarPelicula.resetear();
				eliminarPelicula.setVisible(true);
			}
		});
		btnEliminarP.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnEliminarP.setBounds(182, 71, 158, 25);
		panelPelicula.add(btnEliminarP);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel.setBounds(12, 324, 352, 75);
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
				setVisible(false);
				recuperarConstraseña.setVisible(true);
			}
		});
		btnCambiarContrasea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnCambiarContrasea.setBounds(12, 37, 175, 25);
		panel.add(btnCambiarContrasea);
	}

}

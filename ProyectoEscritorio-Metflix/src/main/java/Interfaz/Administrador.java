package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Administrador extends JFrame {
	RegistroEmpleado regEmpleado = new RegistroEmpleado(this);
	EliminarEmpleado eliminarEmpleado= new EliminarEmpleado(this);
	BuscarEmpleado buscarEmpleado = new BuscarEmpleado(this);
	ModificarEmpleado modificarEmpleado= new ModificarEmpleado(this);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuAdministrador = new JLabel("Menu administrador");
		lblMenuAdministrador.setForeground(Color.RED);
		lblMenuAdministrador.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblMenuAdministrador.setBounds(12, 13, 182, 34);
		contentPane.add(lblMenuAdministrador);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 60, 182, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdministrarEmpleados = new JLabel("Administrar empleados");
		lblAdministrarEmpleados.setBounds(12, 13, 170, 16);
		panel.add(lblAdministrarEmpleados);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				regEmpleado.setVisible(true);
					
			}
		});
		btnRegistrar.setBounds(12, 42, 97, 25);
		panel.add(btnRegistrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				eliminarEmpleado.setVisible(true);
			}
		});
		btnEliminar.setBounds(12, 80, 97, 25);
		panel.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				modificarEmpleado.setVisible(true);
			}
		});
		btnModificar.setBounds(12, 118, 97, 25);
		panel.add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				buscarEmpleado.setVisible(true);
			}
		});
		btnBuscar.setBounds(12, 156, 97, 25);
		panel.add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(218, 60, 97, 25);
		contentPane.add(btnSalir);
	}
}

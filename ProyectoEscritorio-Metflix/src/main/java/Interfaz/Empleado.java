package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Empleado extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Empleado() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 439, 286);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpleadoMetflix = new JLabel("Empleado Metflix");
		lblEmpleadoMetflix.setForeground(Color.RED);
		lblEmpleadoMetflix.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblEmpleadoMetflix.setBounds(12, 13, 190, 16);
		contentPane.add(lblEmpleadoMetflix);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 42, 190, 143);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblOpciones.setBounds(12, 13, 56, 16);
		panel.add(lblOpciones);
		
		JButton btnConsultarCliente = new JButton("Consultar Cliente");
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String empleado="Empleado";
				ConsultarDatosCliente consulta = new ConsultarDatosCliente(empleado);
				consulta.setVisible(true);
			}
		});
		btnConsultarCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnConsultarCliente.setBounds(12, 42, 166, 25);
		panel.add(btnConsultarCliente);
		
		JButton btnResolverConsultas = new JButton("Resolver Consultas");
		btnResolverConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnResolverConsultas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnResolverConsultas.setBounds(12, 80, 166, 25);
		panel.add(btnResolverConsultas);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblConsultas.setBounds(214, 42, 56, 16);
		contentPane.add(lblConsultas);
		
		JList list = new JList();
		list.setBounds(214, 71, 190, 114);
		contentPane.add(list);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSalir.setBounds(307, 201, 97, 25);
		contentPane.add(btnSalir);
	}
}

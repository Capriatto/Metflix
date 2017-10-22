package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarDatosCliente extends JFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarDatosCliente frame = new ConsultarDatosCliente();
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
	public ConsultarDatosCliente() {
		setBounds(100, 100, 448, 256);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblConsultarDatosCliente = new JLabel("CONSULTAR DATOS CLIENTE");
		lblConsultarDatosCliente.setBounds(146, 11, 296, 14);
		getContentPane().add(lblConsultarDatosCliente);
		
		JLabel lblCdulaCliente = new JLabel("C\u00E9dula cliente");
		lblCdulaCliente.setBounds(10, 39, 97, 14);
		getContentPane().add(lblCdulaCliente);
		
		textField = new JTextField();
		textField.setBounds(104, 36, 186, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Consultar Datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(299, 36, 131, 23);
		getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(10, 67, 420, 139);
		getContentPane().add(table);

	}
}

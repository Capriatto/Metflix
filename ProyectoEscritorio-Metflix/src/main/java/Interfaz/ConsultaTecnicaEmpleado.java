package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ConsultaTecnicaEmpleado extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaTecnicaEmpleado frame = new ConsultaTecnicaEmpleado();
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
	public ConsultaTecnicaEmpleado() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cédula");
		lblNewLabel.setBounds(20, 53, 46, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(78, 50, 206, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CONSULTA TÉCNICA");
		lblNewLabel_1.setBounds(163, 11, 279, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setBounds(20, 90, 56, 14);
		getContentPane().add(lblConsulta);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(78, 81, 206, 81);
		getContentPane().add(textArea);
		
		JButton btnEnviar = new JButton("Enviar ");
		btnEnviar.setBounds(73, 183, 91, 23);
		getContentPane().add(btnEnviar);

	}

}

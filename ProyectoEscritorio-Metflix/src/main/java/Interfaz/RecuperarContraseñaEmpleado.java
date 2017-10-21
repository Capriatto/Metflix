package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecuperarContraseñaEmpleado extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperarContraseñaEmpleado frame = new RecuperarContraseñaEmpleado();
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
	public RecuperarContraseñaEmpleado() {
		setBounds(100, 100, 450, 233);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RECUPERAR CONTRASEÑA DE EMPLEADO");
		lblNewLabel.setBounds(28, 21, 414, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCdulaEmpleado = new JLabel("C\u00E9dula empleado");
		lblCdulaEmpleado.setBounds(28, 64, 114, 14);
		getContentPane().add(lblCdulaEmpleado);
		
		textField = new JTextField();
		textField.setBounds(132, 61, 192, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(132, 94, 192, 68);
		getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(341, 60, 91, 23);
		getContentPane().add(btnNewButton);

	}
}

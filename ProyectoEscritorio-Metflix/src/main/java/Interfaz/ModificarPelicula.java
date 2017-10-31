package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Principal;
import co.edu.uniquindio.com.Pelicula;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;

public class ModificarPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtDescripcion;
	private JTextField txtFecha;

	/**
	 * Create the frame.
	 */
	public ModificarPelicula(Administrador admin) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 587, 291);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblModificarEmpleado = new JLabel("Modificar Pelicula");
		lblModificarEmpleado.setForeground(Color.RED);
		lblModificarEmpleado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblModificarEmpleado.setBounds(12, 13, 143, 16);
		contentPane.add(lblModificarEmpleado);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date fecha = Date.valueOf(txtFecha.getText());
					int estado=1;
					System.out.println(fecha + "fecha");
					boolean confirmacion = Principal.getInstancia().modificarPelicula(fecha, txtDescripcion.getText(),
							estado, txtNombre.getText(), Double.parseDouble(txtPrecio.getText()));
					if (confirmacion) {
						JOptionPane.showMessageDialog(null, "Pelicula modificada.", "Excelente!",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No se ha podido modificar la pelicula.", "Error!",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "No se ha podido modificar la pelicula.", "Error!",
							JOptionPane.ERROR_MESSAGE);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "No se ha podido modificar la pelicula.", "Error!",
							JOptionPane.ERROR_MESSAGE);
				} catch (ElementoRegistradorException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InformacionRepetidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModificar.setBounds(410, 151, 111, 25);
		contentPane.add(btnModificar);

		JLabel label = new JLabel("Nombre");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label.setBounds(12, 72, 88, 16);
		contentPane.add(label);

		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				Pelicula pelicula = Principal.getInstancia().buscarPeliculaPorNombre(txtNombre.getText());
				System.out.println(pelicula);
				if (pelicula != null) {
					txtPrecio.setText(String.valueOf(pelicula.getPrecio()));
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					txtFecha.setText(String.valueOf(df.format(pelicula.getAnio_lanzamiento())));
					txtDescripcion.setText(pelicula.getDescripcion());
				} else {
					JOptionPane.showMessageDialog(null,
							"No hemos encontrado ninguna coincidencia.\nPor favor verifique nuevamente el nombre de la pelicula a modificar",
							"Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(112, 72, 177, 22);
		contentPane.add(txtNombre);

		JLabel label_1 = new JLabel("Precio");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label_1.setBounds(12, 116, 39, 16);
		contentPane.add(label_1);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(112, 116, 177, 22);
		contentPane.add(txtPrecio);

		JLabel label_2 = new JLabel("Descripcion");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label_2.setBounds(12, 155, 132, 16);
		contentPane.add(label_2);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(112, 155, 177, 55);
		contentPane.add(txtDescripcion);

		JLabel label_3 = new JLabel("A\u00F1o de lanzamieto");
		label_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label_3.setBounds(331, 72, 190, 16);
		contentPane.add(label_3);

		txtFecha = new JTextField();
		txtFecha.setText("YYYY-MM-DD");
		txtFecha.setColumns(10);
		txtFecha.setBounds(331, 113, 190, 22);
		contentPane.add(txtFecha);

		JButton button_1 = new JButton("Salir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		button_1.setBounds(410, 189, 112, 25);
		contentPane.add(button_1);

	}

	public void resetear() {
		txtDescripcion.setText("");
		txtFecha.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
	}
}

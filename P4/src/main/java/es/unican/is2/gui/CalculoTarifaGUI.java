package es.unican.is2.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.unican.is2.practica4.Tarifas_18;
import es.unican.is2.practica4.Tarifas_18.ConsumoErroneo;
import es.unican.is2.practica4.Tarifas_18.FechaErronea;
import es.unican.is2.practica4.TipoTarifa;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

/**
 * Clase que muestra una interfaz para elegir
 * diferentes opciones para calcular
 * el precio de la tarifa.
 * 
 * @author Pablo Martinez Arana
 */
@SuppressWarnings("serial")
public class CalculoTarifaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFechaNacimiento;
	private JTextField txtFechaAlta;
	private JTextField txtPrecio;
	private JComboBox comboTarifa;
	private final JLabel lblConsumo = new JLabel("Consumo");
	private JTextField txtConsumo;
	private Tarifas_18 tarifas18 = new Tarifas_18();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoTarifaGUI frame = new CalculoTarifaGUI();
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
	public CalculoTarifaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setName("txtFechaNacimiento");
		txtFechaNacimiento.setBounds(124, 8, 86, 20);
		contentPane.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);

		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(10, 11, 114, 14);
		contentPane.add(lblFechaNacimiento);

		JLabel lblFechaAltaAbonado = new JLabel("Fecha Alta Abonado");
		lblFechaAltaAbonado.setBounds(10, 42, 114, 14);
		contentPane.add(lblFechaAltaAbonado);

		txtFechaAlta = new JTextField();
		txtFechaAlta.setName("txtFechaAlta");
		txtFechaAlta.setBounds(124, 39, 86, 20);
		contentPane.add(txtFechaAlta);
		txtFechaAlta.setColumns(10);

		comboTarifa = new JComboBox();
		comboTarifa.setName("comboZona");
		comboTarifa.setModel(new DefaultComboBoxModel(new String[] {"TARIFA_A", "TARIFA_B", "TARIFA_C"}));
		comboTarifa.setBounds(243, 39, 210, 20);
		contentPane.add(comboTarifa);

		JLabel lblPrecioAbono = new JLabel("PRECIO");
		lblPrecioAbono.setBounds(151, 140, 126, 17);
		contentPane.add(lblPrecioAbono);

		txtPrecio = new JTextField();
		txtPrecio.setName("txtPrecio");
		txtPrecio.setBounds(217, 138, 166, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setName("btnCalcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
				Date fechaAlta = null;
				Date fechaNacimiento = null;
				int consumo = 0;
				try {
					fechaAlta = formatter.parse(txtFechaAlta.getText());
					fechaNacimiento =  formatter.parse(txtFechaNacimiento.getText());				
					TipoTarifa tarifa = TipoTarifa.valueOf(comboTarifa.getSelectedItem().toString());
					consumo = Integer.parseInt(txtConsumo.getText());
					double precio=tarifas18.precio(tarifa, fechaAlta,fechaNacimiento,consumo);
					txtPrecio.setText(Double.toString(precio));
				} catch (ParseException e) {
					txtPrecio.setText("Fecha incorrecta");
				} catch (NumberFormatException e) {
					txtPrecio.setText("Consumo no valido");
				} catch (FechaErronea e) {
					txtPrecio.setText("Fecha erronea");
				} catch (ConsumoErroneo e) {
					txtPrecio.setText("Consumo no valido");
				}
			}
		});
		btnCalcular.setBounds(170, 83, 126, 29);
		contentPane.add(btnCalcular);

		lblConsumo.setBounds(241, 3, 98, 31);
		contentPane.add(lblConsumo);

		txtConsumo = new JTextField();
		txtConsumo.setBounds(301, 8, 86, 20);
		contentPane.add(txtConsumo);
		txtConsumo.setColumns(10);
		txtConsumo.setName("txtConsumo");

	}

}

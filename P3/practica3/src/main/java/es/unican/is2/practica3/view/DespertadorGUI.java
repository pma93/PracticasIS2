package es.unican.is2.practica3.view;

import es.unican.is2.practica3.model.Despertador;
import es.unican.is2.practica3.model.Piloto.COLOR;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**	
 * 	DespertadorGUI.java
 *	Vista para la interaccion con el despertador
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class DespertadorGUI extends JFrame implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private JFrame frmDespertador;
	//Botones del despertador
	private JButton btnAlarmaOn;
	private JButton btnAlarmaOff;
	private JButton btnSnooze;
	private JButton btnStop;
	private JButton btnBuzz;
	//Etiquetas de los campos para introducir valores
	private JLabel h;
	private JLabel m;
	private JLabel ponerAlarmaLabel;
	private JLabel intervaloLabel;
	private JLabel lblLED = new JLabel("");
	//Campos para introducir valores
	public JComboBox<Integer> horaAlarma;
	public JComboBox<Integer> minAlarma;
	public JComboBox<Integer> intervaloS;
	//Imagen de los leds
	private ImageIcon imgIcon;
	//Obejeto de la clase Despertador
	private Despertador despertador;
	
	/**
	 * Metodo que hace visible la interfaz
	 */
	public void setVisible() 
	{
		frmDespertador.setVisible(true);
	}
	

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public DespertadorGUI(Despertador c) throws IOException 
	{
		try {
			despertador = c;
			despertador.getPiloto().addPropertyChangeListener(this);
			initialize();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException 
	{
		try {
			frmDespertador = new JFrame();
			frmDespertador.setTitle("Despertador");
			frmDespertador.setBounds(100, 100, 750, 300);
			frmDespertador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmDespertador.getContentPane().setLayout(null);

			btnAlarmaOn = new JButton("Alarma On");
			btnAlarmaOn.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAlarmaOn.setBackground(Color.LIGHT_GRAY);
			btnAlarmaOn.setBounds(31, 41, 141, 54);
			frmDespertador.getContentPane().add(btnAlarmaOn);

			ponerAlarmaLabel = new JLabel("Hora alarma: ");
			ponerAlarmaLabel.setBounds(40,55,100,100);
			frmDespertador.getContentPane().add(ponerAlarmaLabel);

			horaAlarma = new JComboBox<Integer>();
			//Introducimos las horas en la lista 
			for(int i=0;i<24;i++) {
				horaAlarma.addItem(i);
			}
			horaAlarma.setBounds(40, 120, 50, 40);
			frmDespertador.getContentPane().add(horaAlarma);

			h = new JLabel("Hora");
			h.setBounds(40, 160, 35, 10);
			frmDespertador.getContentPane().add(h);

			minAlarma = new JComboBox<Integer>();
			//Introducimos los minutos en la lista
			for(int i=0;i<60;i++) {
				minAlarma.addItem(i);
			}
			minAlarma.setBounds(100, 120, 50, 40);
			frmDespertador.getContentPane().add(minAlarma);

			m = new JLabel("Min");
			m.setBounds(100, 160, 20, 10);
			frmDespertador.getContentPane().add(m);

			btnAlarmaOff = new JButton("Alarma Off");
			btnAlarmaOff.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAlarmaOff.setBackground(Color.LIGHT_GRAY);
			btnAlarmaOff.setBounds(31, 181, 141, 54);
			frmDespertador.getContentPane().add(btnAlarmaOff);

			btnSnooze = new JButton("Snooze");
			btnSnooze.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnSnooze.setBackground(Color.LIGHT_GRAY);
			btnSnooze.setBounds(250, 41, 141, 54);
			frmDespertador.getContentPane().add(btnSnooze);

			btnStop = new JButton("Stop");
			btnStop.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnStop.setBackground(Color.LIGHT_GRAY);
			btnStop.setBounds(250, 111, 141, 54);
			frmDespertador.getContentPane().add(btnStop);

			btnBuzz = new JButton("Buzz");
			btnBuzz.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnBuzz.setBackground(Color.LIGHT_GRAY);
			btnBuzz.setBounds(250, 181, 141, 54);
			frmDespertador.getContentPane().add(btnBuzz);

			intervaloLabel = new JLabel("Tiempo Snooze");
			intervaloLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			intervaloLabel.setBackground(Color.LIGHT_GRAY);
			intervaloLabel.setBounds(450, 1, 200, 54);
			frmDespertador.getContentPane().add(intervaloLabel);

			intervaloS = new JComboBox<Integer>();
			//Introducimos los intervalos en la lista
			intervaloS.addItem(5);
			intervaloS.addItem(10);
			intervaloS.addItem(15);
			intervaloS.setBounds(450, 41, 50, 40);
			frmDespertador.getContentPane().add(intervaloS);

			InputStream stream = this.getClass().getClassLoader().getResourceAsStream("img/ledlightoff.png"); 
			imgIcon = new ImageIcon(ImageIO.read(stream));
			lblLED.setIcon(imgIcon);
			lblLED.setHorizontalAlignment(SwingConstants.CENTER);	
			lblLED.setPreferredSize(new Dimension(48, 48));
			lblLED.setBounds(450, 70, 147, 200);
			frmDespertador.getContentPane().add(lblLED);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Asigna manejador al boton AlarmaOn
	 * @param l Manejador
	 */
	public void setAlarmaOnAction(Action action) 
	{
		btnAlarmaOn.setAction(action);
	}

	/**
	 * Asigna manejador al boton AlarmaOff
	 * @param l Manejador
	 */
	public void setAlarmaOffAction(Action action) 
	{
		btnAlarmaOff.setAction(action);
	}

	/**
	 * Asigna manejador al boton Snooze
	 * @param l Manejador
	 */
	public void setSnoozeAction(Action action) 
	{
		btnSnooze.setAction(action);
	}

	/**
	 * Asigna manejador al boton Stop
	 * @param l Manejador
	 */
	public void setStopAction(Action action) 
	{
		btnStop.setAction(action);
	}

	/**
	 * Asigna manejador al boton Buzz
	 * @param l Manejador
	 */
	public void setBuzzAction(Action action) 
	{
		btnBuzz.setAction(action);
	}
	
	/**
	 * Metodo que se llama cuando se produce un cambio 
	 * en un objeto registrado (cambia el piloto de color)
	 * @param evt indica el origen del evento 
	 */
	public void propertyChange(PropertyChangeEvent evt) 
	{
		if (evt.getPropertyName().equals("ledEstado")) 
		{
			InputStream stream; 
			
			switch((COLOR)evt.getNewValue()) 
			{
				case OFF:
					stream = this.getClass().getClassLoader().getResourceAsStream("img/ledlightoff.png");
					break;
				case ROJO:
					stream = this.getClass().getClassLoader().getResourceAsStream("img/ledlightred.png");
					break;
				default:
					stream = this.getClass().getClassLoader().getResourceAsStream("");
					break;
			}
			
			try {
				imgIcon = new ImageIcon(ImageIO.read(stream));
			} catch (IOException e) {
				e.printStackTrace();
			}
			lblLED.setIcon(imgIcon);			
		}	
	}
	
}

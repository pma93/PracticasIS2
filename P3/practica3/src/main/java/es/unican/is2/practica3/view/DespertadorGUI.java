package es.unican.is2.practica3.view;

import es.unican.is2.practica3.model.Despertador;
import es.unican.is2.practica3.model.Piloto.COLOR;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
	public JTextField horaAlarma;
	public JTextField minAlarma;
	public JTextField intervaloS;
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
	 */
	public DespertadorGUI(Despertador c) 
	{
		despertador = c;
		despertador.getPiloto().addPropertyChangeListener(this);
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() 
	{
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
	 
		horaAlarma = new JTextField();
		horaAlarma.setBounds(40, 120, 50, 40);
		frmDespertador.getContentPane().add(horaAlarma);
	 
		h = new JLabel("Hora");
		h.setBounds(40, 160, 35, 10);
		frmDespertador.getContentPane().add(h);
	 
		minAlarma = new JTextField();
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
	 
		intervaloLabel = new JLabel("Tiempo Snooze(5,10,15 min)");
		intervaloLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		intervaloLabel.setBackground(Color.LIGHT_GRAY);
		intervaloLabel.setBounds(450, 1, 200, 54);
		frmDespertador.getContentPane().add(intervaloLabel);
	 
		intervaloS = new JTextField();
		intervaloS.setBounds(450, 41, 50, 40);
		frmDespertador.getContentPane().add(intervaloS);
	 
		imgIcon = new ImageIcon("src/main/resources/img/ledlightoff.png");
		lblLED.setIcon(imgIcon);
		lblLED.setHorizontalAlignment(SwingConstants.CENTER);	
		lblLED.setPreferredSize(new Dimension(48, 48));
		lblLED.setBounds(450, 70, 147, 200);
		frmDespertador.getContentPane().add(lblLED);
	}

	/**
	 * Borra el contenido que contengan los
	 * JTextField de hora y minutos
	 */
	public void clearAlarma(){
		horaAlarma.setText("");
		minAlarma.setText("");
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
			String imgDir;
		
			switch((COLOR)evt.getNewValue()) 
			{
				case OFF:
					imgDir = "src/main/resources/img/ledlightoff.png";
					break;
				case ROJO:
					imgDir = "src/main/resources/img/ledlightred.png";
					break;
				default:
					imgDir = "";
					break;
			}
			imgIcon = new ImageIcon(imgDir);
			lblLED.setIcon(imgIcon);			
		}	
	}
	
}

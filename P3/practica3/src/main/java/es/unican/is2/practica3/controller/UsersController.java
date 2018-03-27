package es.unican.is2.practica3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import es.unican.is2.practica3.model.Despertador;
import es.unican.is2.practica3.view.DespertadorGUI;

/**
 * Clase que implementa el rol de Controlador en la aplicacion del patron
 * MVC a la aplicacion AlarmaDespertador
 * Implementa la interaccion entre la vista y el modelo a traves de los
 * correspondientes manejadores de eventos.
 * @author: Pablo Martinez Arana
 * @version: 03/2018
 */
public class UsersController {
	Calendar calendar;
	private Despertador modelo;
	private DespertadorGUI vista;
	
	public UsersController(Despertador modelo, DespertadorGUI vista) 
	{
		this.modelo = modelo;
		this.vista = vista;
		
		vista.setAlarmaOnAction(new ActionListener() {
			/**
			 * Metodo que realiza varias tareas cuando se 
			 * pulsa el boton ON del despertador
			 */
			public void actionPerformed(ActionEvent e) 
			{
				calendar = Calendar.getInstance();
				int h = Integer.parseInt(UsersController.this.vista.horaAlarma.getSelectedItem().toString());
				int m = Integer.parseInt(UsersController.this.vista.minAlarma.getSelectedItem().toString());
				Date fecha = new Date();
				calendar.set(Calendar.HOUR_OF_DAY, h);
				calendar.set(Calendar.MINUTE, m);
				calendar.set(Calendar.SECOND, 0);
				fecha = calendar.getTime();
				UsersController.this.modelo.signalAlarmaOn(fecha);
			}
		});
		
		vista.setAlarmaOffAction(new ActionListener() {
			/**
			 * Metodo que realiza varias tareas cuando se 
			 * pulsa el boton OFF del despertador
			 */
			public void actionPerformed(ActionEvent e) 
			{
				UsersController.this.modelo.signalAlarmaOff();
				
			}
		});
		
		vista.setBuzzAction(new ActionListener() {
			/**
			 * Metodo que realiza varias tareas cuando se 
			 * pulsa el boton Buzz del despertador
			 */
			public void actionPerformed(ActionEvent e) 
			{
				UsersController.this.modelo.signalBuzz();
				
			}
		});
		
		vista.setStopAction(new ActionListener() {
			/**
			 * Metodo que realiza varias tareas cuando se 
			 * pulsa el boton Stop del despertador
			 */
			public void actionPerformed(ActionEvent e) 
			{
				calendar = Calendar.getInstance();
				int h = Integer.parseInt(UsersController.this.vista.horaAlarma.getSelectedItem().toString());
				int m = Integer.parseInt(UsersController.this.vista.minAlarma.getSelectedItem().toString());
				Date fecha = new Date();
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.DAY_OF_WEEK+1);
				calendar.set(Calendar.HOUR_OF_DAY, h);
				calendar.set(Calendar.MINUTE, m);
				calendar.set(Calendar.SECOND, 0);
				fecha = calendar.getTime();
				UsersController.this.modelo.horaTemp(fecha);
				UsersController.this.modelo.cambiaHora();
				UsersController.this.modelo.signalStop();
				
			}
		});
		
		vista.setSnoozeAction(new ActionListener() {
			/**
			 * Metodo que realiza varias tareas cuando se 
			 * pulsa el boton Snooze del despertador
			 */
			public void actionPerformed(ActionEvent e) 
			{
				calendar = Calendar.getInstance();
				int intervalo = Integer.parseInt(UsersController.this.vista.intervaloS.getSelectedItem().toString());
				UsersController.this.modelo.cambiaIntervaloSnooze(intervalo);
				if(UsersController.this.modelo.getContadorSnooze() == 3) 
				{
					int h = Integer.parseInt(UsersController.this.vista.horaAlarma.getSelectedItem().toString());
					int m = Integer.parseInt(UsersController.this.vista.minAlarma.getSelectedItem().toString());
					Date fecha = new Date();
					calendar.set(Calendar.DAY_OF_WEEK, Calendar.DAY_OF_WEEK+1);
					calendar.set(Calendar.HOUR_OF_DAY, h);
					calendar.set(Calendar.MINUTE, m);
					calendar.set(Calendar.SECOND, 0);
					fecha = calendar.getTime();
					UsersController.this.modelo.horaTemp(fecha);
					UsersController.this.modelo.cambiaHora();
				}
				UsersController.this.modelo.signalSnooze();
			}
		});
	}
	
}

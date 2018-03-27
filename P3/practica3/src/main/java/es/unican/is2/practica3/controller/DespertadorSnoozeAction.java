package es.unican.is2.practica3.controller;

import es.unican.is2.practica3.model.Despertador;
import es.unican.is2.practica3.view.DespertadorGUI;

import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**	
 * 	DespertadorSnoozeAction.java
 *	Controlador con las acciones para la activacion del snooze
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class DespertadorSnoozeAction extends AbstractAction {
	/**
	 * -----------CONTROLADOR------------------------
	 *
	 * Se crea una clase que extiende a AbstractAction para cada accion 
	 * a realizar en la interfaz
	 * Cada clase Action tiene acceso al modelo y a la vista 
	 * En este ejemplo se le suministran como parametros en el constructor
	 */
	private static final long serialVersionUID = 1L;
	
	Calendar calendar;
	private Despertador model;
	private DespertadorGUI view;
	
	/** 
	 * La clase Action puede definir algunos valores determinados 
	 * como el nombre de la accion, la descripcion, etc. que 
	 * compartiran todos los componentes graficos que utilicen dicha accion
	 */
	public DespertadorSnoozeAction(Despertador model, DespertadorGUI view) 
	{
		this.model = model;
		this.view = view;
		putValue(Action.NAME, "Snooze");
	}
	
	/**
	 * Cada clase Action tendra un metodo actionPerformed que se llamara 
	 * cuando un componente grafico asociado desencadene una accion
	 */
	public void actionPerformed(ActionEvent e) 
	{
		calendar = Calendar.getInstance();
		int intervalo = Integer.parseInt(view.intervaloS.getSelectedItem().toString());
		model.cambiaIntervaloSnooze(intervalo);
		if(model.getContadorSnooze() == 3) {
			int h = Integer.parseInt(view.horaAlarma.getSelectedItem().toString());
			int m = Integer.parseInt(view.minAlarma.getSelectedItem().toString());
			Date fecha = new Date();
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.DAY_OF_WEEK+1);
			calendar.set(Calendar.HOUR_OF_DAY, h);
			calendar.set(Calendar.MINUTE, m);
			calendar.set(Calendar.SECOND, 0);
			fecha = calendar.getTime();
			model.horaTemp(fecha);
			model.cambiaHora();
		}
		model.signalSnooze();
	}
	
}

package es.unican.is2.practica3.controller;

import es.unican.is2.practica3.model.Despertador;
import es.unican.is2.practica3.view.DespertadorGUI;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**	
 * 	DespertadorStopAction.java
 *	Controlador con las acciones para apagar la alarma
 *	hasta el dia siguiente
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class DespertadorStopAction extends AbstractAction {
	/**
	 * -----------CONTROLADOR------------------------
	 *
	 * Se crea una clase que extiende a AbstractAction para cada accion 
	 * a realizar en la interfaz
	 * Cada clase Action tiene acceso al modelo y a la vista 
	 * En este ejemplo se le suministran como parametros en el constructor
	 */
	private static final long serialVersionUID = 1L;
	
	private Despertador model;
	private DespertadorGUI view;
	
	/** 
	 * La clase Action puede definir algunos valores determinados 
	 * como el nombre de la accion, la descripcion, etc. que 
	 * compartiran todos los componentes graficos que utilicen dicha accion
	 */
	public DespertadorStopAction(Despertador model, DespertadorGUI view) 
	{
		this.model = model;
		this.view = view;
		putValue(Action.NAME, "Stop");
	}
	
	/**
	 * Cada clase Action tendra un metodo actionPerformed que se llamara 
	 * cuando un componente grafico asociado desencadene una accion
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) 
	{
		int h = Integer.parseInt(view.horaAlarma.getText());
		int m = Integer.parseInt(view.minAlarma.getText());
		Date fecha = new Date();
		fecha.setDate(fecha.getDate()+1);
		fecha.setHours(h);
		fecha.setMinutes(m);
		fecha.setSeconds(0);
		model.horaTemp(fecha);
		model.cambiaHora();
		model.signalStop();
	}

}

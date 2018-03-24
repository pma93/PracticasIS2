package es.unican.is2.practica3.controller;

import es.unican.is2.practica3.model.Despertador;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**	
 * 	DespertadorBuzzAction.java
 *	Controlador con las acciones para la activacion del buzz
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class DespertadorBuzzAction extends AbstractAction{
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
	
	/** 
	 * La clase Action puede definir algunos valores determinados 
	 * como el nombre de la accion, la descripcion, etc. que 
	 * compartiran todos los componentes graficos que utilicen dicha accion
	 */
	public DespertadorBuzzAction(Despertador model) 
	{
		this.model = model;
		putValue(Action.NAME, "Buzz");
	}
	
	/**
	 * Cada clase Action tendra un metodo actionPerformed que se llamara 
	 * cuando un componente grafico asociado desencadene una accion
	 */
	public void actionPerformed(ActionEvent e) 
	{
		model.signalBuzz();
	}
	
}

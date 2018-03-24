package es.unican.is2.practica3.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 	Piloto.java
 *	Clase que controla los estados y realiza operaciones con
 *	el estado actual del despertador
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class Piloto {
	/**
	 * PropertyChangeSupport es una clase de utilidad utilizada por objetos beans 
	 * con propiedades bound (propiedades que notifican sus cambios)
	 * Creamos un objeto que gestionara la notificacion de cambios pasando 
	 * el propio objeto Piloto como parametro
	 */	
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	
	/**
	 * Enumerado con los colores/estados del piloto
	 */
	public static enum COLOR 
	{
	    OFF, ROJO
	}
	
	private COLOR color;
	
	/**
	 * Metodo observador del color
	 * @return color del piloto
	 */
	public COLOR getColor()
	{
		return color;
	}	
	
	/**
	 * Metodo cambiador del color
	 * @param c nuevo color del piloto
	 */
	public void setColor(COLOR c)
	{
		changeSupport.firePropertyChange("ledEstado", color, c);
		this.color  = c;
	}		
	
	/**
	 * Metodos que cambia el 
	 * color al que indica su nombre
	 */
	public void red()
	{
		setColor(COLOR.ROJO);		
	}
	
	/**
	 * Metodos que cambia el 
	 * color al que indica su nombre
	 */
	public void off()
	{
		setColor(COLOR.OFF);
	}
	
	/**
	 * Funcion que nos permite registrar escuchadores
	 * @param listener con el escuchador
	 */
	public void addPropertyChangeListener (PropertyChangeListener listener)
	{
		// Metodo que permite registrar escuchadores
		changeSupport.addPropertyChangeListener(listener);
	}
	
}

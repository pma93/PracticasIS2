package es.unican.is2.practica3.model;

/**	
 * 	TimedState.java
 *	Clase interfaz de los estados
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public interface TimedState {
	
	public void timeout( Despertador context );
}

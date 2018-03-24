package es.unican.is2.practica3.model;

/**	
 * 	StateSnooze.java
 *	Clase estado de Snooze
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class StateSnooze extends DespertadorState implements TimedState {
	/**
	 * Metodo constructor
	 */
	public StateSnooze() {
		name = "Snooze";
	}
	
	/**
	 * Metodo entry que realiza una serie de acciones en 
	 * el despertador dado al entrar en el estado
	 * @param context despertador
	 */
	public void entryAction( Despertador context )
	{
		timedStateController.startRelative(context, this, context.getIntervaloSnooze()*60*1000);
		
	}

	/**
	 * Metodo que actua cuando se acaba el tiempo de espera y
	 * suena el despertador
	 * @param context despertador
	 */
	public void timeout(Despertador context) 
	{
		this.exitAction(context);
		getEstadoSonando().entryAction(context);
		context.setState(getEstadoSonando());
	}
		
}

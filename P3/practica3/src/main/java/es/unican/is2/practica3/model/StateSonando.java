package es.unican.is2.practica3.model;

import java.awt.Toolkit;

/**	
 * 	StateSonando.java
 *	Clase estado de Sonando
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class StateSonando extends DespertadorState implements TimedState {
	/**
	 * Metodo constructor
	 */
	public StateSonando() 
	{
		name = "Sonando";
	}
	
	/**
	 * Metodo que realiza una serie de acciones en 
	 * el despertador dado al estar en ese estado
	 * @param context despertador
	 */
	public void signalStop( Despertador context )
	{
		timedStateController.cancel();
		this.exitAction(context);
		context.setState(getEstadoProgramado());
		getEstadoProgramado().entryAction(context);
		getEstadoProgramado().doAction(context);
	}
	
	/**
	 * Metodo que realiza una serie de acciones en 
	 * el despertador dado al estar en ese estado
	 * @param context despertador
	 */
	public void signalSnooze( Despertador context )
	{
		if(context.getContadorSnooze() == 3) 
		{
			timedStateController.cancel();
			this.exitAction(context);
			context.setState(getEstadoProgramado());
			getEstadoProgramado().entryAction(context);
			getEstadoProgramado().doAction(context);
		}else {
			timedStateController.cancel();
			this.exitAction(context);
			context.setState(getEstadoSnooze());
			context.sumaContadorSnooze();
			System.out.println("Boton pulsado:"+ context.getContadorSnooze()+" "+"veces");
			getEstadoSnooze().entryAction(context);
			getEstadoSnooze().doAction(context);
		}
	}
	
	/**
	 * Metodo entry que realiza una serie de acciones en 
	 * el despertador dado al entrar en el estado
	 * @param context despertador
	 */
	public void entryAction( Despertador context )
	{
		context.activarAlarma();
		if(context.getBuzz() == false) {
			System.out.println("Sonando Radio");
		}
		if(context.getBuzz() == true) {
			System.out.println("Sonando Pitido");
			Toolkit.getDefaultToolkit().beep();
		}
		timedStateController.startRelative(context, this, context.getIntervaloAlarma()*60*1000);
	}
	
	/**
	 * Metodo exit que realiza una serie de acciones en 
	 * el despertador dado al salir del estado
	 * @param context despertador
	 */
	public void exitAction( Despertador context )
	{
		context.desactivarAlarma();
	}

	/**
	 * Metodo que actua cuando se acaba el tiempo de espera y
	 * se desprograma el despertador
	 * @param context despertador
	 */
	public void timeout(Despertador context) 
	{
		this.exitAction(context);
		context.cambiaHora();
		getEstadoDesprogramado().entryAction(context);
		context.setState(getEstadoDesprogramado());
	}
		
}

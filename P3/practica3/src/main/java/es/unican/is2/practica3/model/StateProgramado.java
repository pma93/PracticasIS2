package es.unican.is2.practica3.model;

/**	
 * 	StateProgramado.java
 *	Clase estado de Programado
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class StateProgramado extends DespertadorState implements TimedState {
	/**
	 * Metodo constructor
	 */
	public StateProgramado() 
	{
		name = "Programado";
	}
	
	/**
	 * Metodo que realiza una serie de acciones en 
	 * el despertador dado al estar en ese estado
	 * @param context despertador
	 */
	public void signalAlarmaOff( Despertador context )
	{
		timedStateController.cancel();
		this.exitAction(context);
		context.setState(getEstadoDesprogramado());
		context.cambiaHora();
		getEstadoDesprogramado().entryAction(context);
		getEstadoDesprogramado().doAction(context);
	}
	
	/**
	 * Metodo que realiza una serie de acciones en 
	 * el despertador dado al estar en ese estado
	 * @param context despertador
	 */
	public void signalAlarmaOn( Despertador context )
	{
		timedStateController.cancel();
		this.exitAction(context);
		context.setState(getEstadoProgramado());
		context.cambiaHora();
		getEstadoProgramado().entryAction(context);
		getEstadoProgramado().doAction(context);
		
	}
	
	/**
	 * Metodo que realiza una serie de acciones en 
	 * el despertador dado al estar en ese estado
	 * @param context despertador
	 */
	public void signalBuzz( Despertador context )
	{
		this.exitAction(context);
		context.setState(getEstadoProgramado());
		context.cambiaBuzz();
		getEstadoProgramado().entryAction(context);
		getEstadoProgramado().doAction(context);
	}
	
	/**
	 * Metodo entry que realiza una serie de acciones en 
	 * el despertador dado al entrar en el estado
	 * @param context despertador
	 */
	public void entryAction( Despertador context )
	{
		context.getPiloto().red();
		context.reiniciaContadorSnooze();
		timedStateController.startAbsolute(context, this, context.getHoraProgramada());
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

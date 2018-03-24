package es.unican.is2.practica3.model;

/**	
 * 	StateDesprogramado.java
 *	Clase estado de desprogramado
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class StateDesprogramado extends DespertadorState {
	/**
	 * Metodo constructor
	 */
	public StateDesprogramado() 
	{
		name = "Desprogramado";
	}
	
	/**
	 * Metodo que realiza una serie de acciones en 
	 * el despertador dado al estar en ese estado
	 * @param context despertador
	 */
	public void signalAlarmaOn( Despertador context )
	{
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
		context.setState(getEstadoDesprogramado());
		context.cambiaBuzz();
		getEstadoDesprogramado().entryAction(context);
		getEstadoDesprogramado().doAction(context);
	}
	
	/**
	 * Metodo entry que realiza una serie de acciones en 
	 * el despertador dado al entrar en el estado
	 * @param context despertador
	 */
	public void entryAction(Despertador context) 
	{
		context.getPiloto().off();
	}
	
}

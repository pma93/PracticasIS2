package es.unican.is2.practica3.model;

/**	
 * 	DespertadorState.java
 *	Clase abstracta que contiene los estados del despertador
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public abstract class DespertadorState {
	/**
	 * Los atributos son contenedores de los diferentes estados que se
	 * inicializan al principio
	 */
	protected static StateDesprogramado estadoDesprogramado = new StateDesprogramado();
	protected static StateProgramado estadoProgramado = new StateProgramado();
	protected static StateSonando estadoSonando = new StateSonando();
	protected static StateSnooze estadoSnooze = new StateSnooze();
	
	public TimedStateController timedStateController = TimedStateController.getInstance();
	//Indica el nombre del estado del despertador
	public String name;
	
	/**
	 * Metodo que inicializa el despertador
	 */
	public static DespertadorState init( Despertador context )
	{
		estadoDesprogramado.entryAction(context);
		return estadoDesprogramado;
	}
	
	/**
	 * Metodos para cambiar de estado al despertador
	 */
	public void signalSnooze( Despertador context ) {};
	public void signalStop( Despertador context ){};
	public void signalBuzz( Despertador context ){};
	public void signalAlarmaOn( Despertador context ){};
	public void signalAlarmaOff( Despertador context ){};
	public void entryAction( Despertador context ){};
	public void exitAction( Despertador context ){};
	public void doAction( Despertador context ){}; 
	
	/*------------METODOS PARA OBTENER EL ESTADO DEL DESPERTADOR-------------*/
	
	public static DespertadorState getEstadoDesprogramado() 
	{
		return estadoDesprogramado;
	}
	
	public static DespertadorState getEstadoProgramado() 
	{
		return estadoProgramado;
	}

	public static DespertadorState getEstadoSonando() 
	{
		return estadoSonando;
	}

	public static DespertadorState getEstadoSnooze() 
	{
		return estadoSnooze;
	}

}

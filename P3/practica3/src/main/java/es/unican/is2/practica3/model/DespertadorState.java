/**
 * Clase que representa el estado en que se puede encontrar la clase
 * principal (contexto) Despertador. 
 * Clase raiz de la implementacion del patron State.
 * 
 * @author Pablo Martinez Arana
 */

package es.unican.is2.practica3.model;

public abstract class DespertadorState
{
	protected static StateDesprogramado estadoDesprogramado = new StateDesprogramado();
	protected static StateProgramado estadoProgramado = new StateProgramado();
	protected static StateSonando estadoSonando = new StateSonando();
	protected static StateSnooze estadoSnooze = new StateSnooze();
	
	public TimedStateController timedStateController = TimedStateController.getInstance();
	public String name;
	
	public static DespertadorState init( Despertador context )
	{
		estadoDesprogramado.entryAction(context);
		return estadoDesprogramado;
	}
	
	/*
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
	
	/*
	 * Metodos para obtener los estados del despertador
	 */
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

/**
 * Clase que define las respuestas a eventos
 * del estado Programado
 * 
 * @author Pablo martinez Arana
 */

package es.unican.is2.practica3.model;

public class StateProgramado extends DespertadorState implements TimedState
{
	public StateProgramado() {
		name = "Programado";
	}
	
	public void signalAlarmaOff( Despertador context )
	{
		timedStateController.cancel();
		this.exitAction(context);
		context.setState(getEstadoDesprogramado());
		context.cambiaHora();
		getEstadoDesprogramado().entryAction(context);
		getEstadoDesprogramado().doAction(context);
	}
	
	public void signalAlarmaOn( Despertador context )
	{
		timedStateController.cancel();
		this.exitAction(context);
		context.setState(getEstadoProgramado());
		context.cambiaHora();
		getEstadoProgramado().entryAction(context);
		getEstadoProgramado().doAction(context);
		
	}
	
	public void entryAction( Despertador context )
	{
		context.getPiloto().red();
		context.reiniciaContadorSnooze();
		timedStateController.startAbsolute(context, this, context.getHoraProgramada());
	}
	
	public void signalBuzz( Despertador context )
	{
		this.exitAction(context);
		context.setState(getEstadoProgramado());
		context.cambiaBuzz();
		getEstadoProgramado().entryAction(context);
		getEstadoProgramado().doAction(context);
	}
	
	/**
	 * Metodo que actua cuando se acaba el tiempo de espera y
	 * suena la alarma
	 * @param context alarma
	 */
	public void timeout(Despertador context) {
		this.exitAction(context);
		getEstadoSonando().entryAction(context);
		context.setState(getEstadoSonando());
	}
	
	
}

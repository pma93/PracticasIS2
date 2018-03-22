/**
 * Clase que define las respuestas a eventos
 * del estado Snooze
 * 
 * @author Pablo martinez Arana
 */

package es.unican.is2.practica3.model;

public class StateSnooze extends DespertadorState implements TimedState
{
	public StateSnooze() {
		name = "Snooze";
	}
	
	public void entryAction( Despertador context )
	{
		timedStateController.startRelative(context, this, context.getIntervaloSnooze()*60*1000);
		
	}

	public void timeout(Despertador context) {
		this.exitAction(context);
		getEstadoSonando().entryAction(context);
		context.setState(getEstadoSonando());
	}
	
	
}

/**
 * Clase que define las respuestas a eventos
 * del estado Sonando
 * 
 * @author Pablo martinez Arana
 */

package es.unican.is2.practica3.model;

public class StateSonando extends DespertadorState implements TimedState
{
	public StateSonando() {
		name = "Sonando";
	}
	
	public void signalStop( Despertador context )
	{
		timedStateController.cancel();
		this.exitAction(context);
		context.setState(getEstadoProgramado());
		getEstadoProgramado().entryAction(context);
		getEstadoProgramado().doAction(context);
	}
	
	public void signalSnooze( Despertador context )
	{
		if(context.getContadorSnooze() == 2) {
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
			System.out.println(""+ context.getContadorSnooze());
			getEstadoSnooze().entryAction(context);
			getEstadoSnooze().doAction(context);
		}
	}
	
	public void entryAction( Despertador context )
	{
		context.activarAlarma();
		if(context.getBuzz() == false) {
			System.out.println("Sonando Radio");
		}
		if(context.getBuzz() == true) {
			System.out.println("Sonando Pitido");
		}
		timedStateController.startRelative(context, this, context.getIntervaloAlarma()*60*1000);
	}
	
	public void exitAction( Despertador context )
	{
		context.desactivarAlarma();
	}

	public void timeout(Despertador context) {
		this.exitAction(context);
		context.cambiaHora();
		getEstadoDesprogramado().entryAction(context);
		context.setState(getEstadoDesprogramado());
	}
		
}

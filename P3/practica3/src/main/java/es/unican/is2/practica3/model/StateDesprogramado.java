package es.unican.is2.practica3.model;

/**
 * Clase que define las respuestas a eventos
 * del estado Desprogramado
 * 
 * @author Pablo Martinez Arana
 */
public class StateDesprogramado extends DespertadorState
{
	public StateDesprogramado() {
		name = "Desprogramado";
	}
	
	public void signalAlarmaOn( Despertador context )
	{
		this.exitAction(context);
		context.setState(getEstadoProgramado());
		context.cambiaHora();
		getEstadoProgramado().entryAction(context);
		getEstadoProgramado().doAction(context);
	}
	
	public void signalBuzz( Despertador context )
	{
		this.exitAction(context);
		context.setState(getEstadoDesprogramado());
		context.cambiaBuzz();
		getEstadoDesprogramado().entryAction(context);
		getEstadoDesprogramado().doAction(context);
	}
	
	public void entryAction(Despertador context) {
		context.getPiloto().off();
	}
	
}

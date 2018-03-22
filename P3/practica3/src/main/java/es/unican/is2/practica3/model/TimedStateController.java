package es.unican.is2.practica3.model;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimedStateController {
	private static TimedStateController myTimedStateController;
	private static Timer timer;
	private ExpiraTimerTask expiraTimerTask;
	private TimedState estado;
	private Despertador context;
	
	/**
	 * Metodo constructor que inicializa el timer
	 */
	private TimedStateController() {
		timer = new Timer();
	}

	// Implementacion del patron Singleton
	public static TimedStateController getInstance() {
		if (myTimedStateController == null) {
			myTimedStateController = new TimedStateController();
		}

		return myTimedStateController;
	}
	
	/*
	 * Clase que llama al timeout del estado actual cuando
	 * expira el timer
	 */
	private class ExpiraTimerTask extends TimerTask {
		public void run() {
			estado.timeout(context);
		}
	}
	
	/**
	 * Metodo que programa el timer para acabar en un tiempo relativo
	 * @param context alarma del despertador
	 * @param estado estado actual
	 * @param milis tiempo a esperar
	 */
	public void startRelative(Despertador context, TimedState estado, int milis) {
		this.context = context;
		this.estado = estado;
		this.expiraTimerTask = new ExpiraTimerTask();
		timer.schedule(expiraTimerTask, milis);
	}

	/**
	 * Metodo que programa el timer para acabar en un tiempo absoluto dado
	 * @param context alarma del despertador
	 * @param estado estado actual
	 * @param instante tiempo en el que acabar 
	 */
	public void startAbsolute(Despertador context, TimedState estado, Date instante) {
		this.context = context;
		this.estado = estado;
		this.expiraTimerTask = new ExpiraTimerTask();
		timer.schedule(expiraTimerTask, instante);
	}

	/**
	 * Metodo que cancela el timer programado
	 */
	public void cancel() {
		if(expiraTimerTask != null){
			expiraTimerTask.cancel();
		}
	}
}

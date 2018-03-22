/**
 * Clase que implementa el rol de Modelo en la aplicacion del patron MVC a la
 * aplicacion Despertador. Recibe los eventos y los gestiona aplicando el
 * patron State.
 * 
 * @author Pablo Martinez Arana
 */

package es.unican.is2.practica3.model;

import java.util.Date;

public class Despertador 
{
	private DespertadorState state;
	private Date horaProgramada;
	private Date horaTemp;
	private boolean buzz = false;
	private int intervaloSnooze;
	private static int INTERVALO_ALARMA = 30 /*1*/;
	private int contadorSnooze;
	private Piloto piloto;
	
	public Despertador()
	{
		this.piloto = new Piloto();
		state = DespertadorState.init(this);
	}
	
	public Piloto getPiloto()
	{
		return piloto;
	}
	/**
	 * Metodo de negocio que activa el sonido
	 * de la alarma
	 */
	public void activarAlarma( )
	{
		System.out.println("Alarma sonando");
	}
	
	/**
	 * Metodo de negocio que para el sonido
	 * de la alarma
	 */
	public void desactivarAlarma( )
	{
		System.out.println("Alarma desactivada");
	}
	
	public void signalSnooze( )
	{
		System.out.println("Despertador: Senyal de snooze");
		state.signalSnooze(this);
	}
	
	public void signalStop( )
	{
		System.out.println("Despertador: Senyal de stop");
		state.signalStop(this);
	}
	
	public void signalBuzz( )
	{
		System.out.println("Despertador: Senyal de buzz");
		state.signalBuzz(this);
	}
	
	public void signalAlarmaOn(Date hora)
	{
		System.out.println("Despertador: Senyal de encendido");
		horaTemp(hora);
		state.signalAlarmaOn(this);
	}
	
	public void signalAlarmaOff( )
	{
		System.out.println("Despertador: Senyal de apagado");
		state.signalAlarmaOff(this);
	}
	
	public void setState( DespertadorState state )
	{
		this.state = state;
		System.out.println("Despertador: Estado " + state.name);
	}
	
	
	 // Metodos auxiliares
	
	public void reiniciaContadorSnooze()
	{
		contadorSnooze = 0;
	}
	
	public void sumaContadorSnooze() 
	{
		contadorSnooze++;
	}
	
	public int getContadorSnooze() 
	{
		return contadorSnooze;
	}
	
	public int getIntervaloAlarma() 
	{
		return INTERVALO_ALARMA;
	}
	
	public void cambiaIntervaloSnooze(int intervalo) 
	{
		intervaloSnooze = intervalo;
	}
	
	public int getIntervaloSnooze() 
	{
		return intervaloSnooze;
	}
	
	public void horaTemp(Date h) {
		horaTemp = h;
	}
	public void cambiaHora() 
	{
		horaProgramada = horaTemp;
		horaTemp = null;
	}
	
	public Date getHoraProgramada() 
	{
		return horaProgramada;
	}
	
	public void cambiaBuzz() 
	{
		if(buzz == true) {
			buzz = false;
		}
		if(buzz == false) {
			buzz = true;
		}
	}
	
	public boolean getBuzz() 
	{
		return buzz;
	}
}
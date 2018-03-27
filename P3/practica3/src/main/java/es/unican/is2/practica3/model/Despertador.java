package es.unican.is2.practica3.model;

import java.util.Date;

/**	
 * 	Despertador.java
 *	Clase que contiene los datos del despertador y su estado
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class Despertador {
	private DespertadorState state;
	private Date horaProgramada;
	private Date horaTemp;
	private boolean buzz = false;
	private int intervaloSnooze;
	private static int INTERVALO_ALARMA = 30;
	private int contadorSnooze;
	private Piloto piloto;
	
	/**
	 * Metodo constructor que inicia el despertador
	 */
	public Despertador()
	{
		this.piloto = new Piloto();
		state = DespertadorState.init(this);
	}
	
	/**
	 * Metodo observador del piloto
	 * @return piloto de la alarma
	 */
	public Piloto getPiloto()
	{
		return piloto;
	}
	
	/**
	 * Metodo de negocio que indica que la
	 * alarma esta sonando
	 */
	public void activarAlarma( )
	{
		System.out.println("Alarma sonando");
		
	}
	
	/**
	 * Metodo de negocio que indica que la
	 * alarma no esta sonando
	 */
	public void desactivarAlarma( )
	{
		System.out.println("Alarma desactivada");
	}
	
	/**
	 * Metodo que pospone la alarma para que suene
	 * transcurridos unos minutos
	 */
	public void signalSnooze( )
	{
		System.out.println("Despertador: Senyal de snooze");
		state.signalSnooze(this);
	}
	
	/**
	 * Metodo que pospone la alarma para
	 * que suene al dia siguiente a la misma hora
	 */
	public void signalStop( )
	{
		System.out.println("Despertador: Senyal de stop");
		state.signalStop(this);
	}
	
	/**
	 * Metodo que cambia el estado del buzz
	 */
	public void signalBuzz( )
	{
		System.out.println("Despertador: Senyal de buzz");
		state.signalBuzz(this);
	}
	
	/**
	 * Metodo que programa la alarma a la hora indicada
	 * @param hora hora a la que sonara la alarma
	 */
	public void signalAlarmaOn(Date hora)
	{
		System.out.println("Despertador: Senyal de encendido");
		horaTemp(hora);
		state.signalAlarmaOn(this);
	}
	
	/**
	 * Metodo que desprograma la alarma
	 */
	public void signalAlarmaOff( )
	{
		System.out.println("Despertador: Senyal de apagado");
		state.signalAlarmaOff(this);
	}
	
	/**
	 * Metodo cambiador del estado
	 * @param value nuevo estado del despertador
	 */
	public void setState( DespertadorState state )
	{
		this.state = state;
		System.out.println("Despertador: Estado " + state.name);
	}
	
	
	/*-------------METODOS AUXILIARES----------------*/
	
	/**
	 * Metodo que pone el contador de snooze a cero
	 */
	public void reiniciaContadorSnooze()
	{
		contadorSnooze = 0;
	}
	
	/**
	 * Metodo que suma uno al contador de snooze
	 * cada vez que se pulsa el boton asociado
	 */
	public void sumaContadorSnooze() 
	{
		contadorSnooze++;
	}
	
	/**
	 * Retorna el numero de veces que se ha pulsado el
	 * boton de snooze
	 * @return contazorSnooze veces que se ha pulsado
	 * el boton de snooze
	 */
	public int getContadorSnooze() 
	{
		return contadorSnooze;
	}
	
	/**
	 * Retorna el intervalo que tiene un usuario para
	 * realizar alguna accion antes de que la alarma
	 * se desprograme
	 * @return INTERVALO_ALARMA tiempo en el que se 
	 * desprogramara la alarma si no se realiza ninguna
	 * accion antes
	 */
	public int getIntervaloAlarma() 
	{
		return INTERVALO_ALARMA;
	}
	
	/**
	 * Metodo que permite al usuario posponer
	 * la alarma
	 * @param intervalo minutos que el usuario
	 * quiere posponer la alarma
	 */
	public void cambiaIntervaloSnooze(int intervalo) 
	{
		intervaloSnooze = intervalo;
	}
	
	/**
	 * Retorna el tiempo que el usuario ha pospuesto
	 * la alarma
	 * @return intervaloSnooze tiempo que se ha pospuesto
	 * la alarma
	 */
	public int getIntervaloSnooze() 
	{
		return intervaloSnooze;
	}
	
	/**
	 * Metodo que permite introducir al usuario
	 * la hora a la que quiere que suene la alarma
	 * @param h hora introducida por el usuario
	 */
	public void horaTemp(Date h) 
	{
		horaTemp = h;
	}
	
	/**
	 * Cambia la hora programada por la nueva hora y
	 * reinicia la hora temporal
	 */
	public void cambiaHora() 
	{
		horaProgramada = horaTemp;
		horaTemp = null;
	}
	
	/**
	 * Retorna la hora a la que el usuario quiere
	 * que suene la alarma
	 * @return horaProgramada hora a la que sonara
	 * la alarma
	 */
	public Date getHoraProgramada() 
	{
		return horaProgramada;
	}
	
	/**
	 * Metodo que cambia el buzz para hacer que
	 * suene la radio o un pitido
	 */
	public void cambiaBuzz() 
	{
		if(buzz == true) 
		{
			buzz = false; //Suena la radio
		}
		if(buzz == false) 
		{
			buzz = true; //Suena el pitido
		}
	}
	
	/**
	 * Retorna el valor del buzz para saber si sonara
	 * la radio o un pitido
	 * @return buzz indica si sonara la radio o un pitido
	 */
	public boolean getBuzz() 
	{
		return buzz;
	}
	
	
}
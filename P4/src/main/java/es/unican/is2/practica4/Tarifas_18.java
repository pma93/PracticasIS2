package es.unican.is2.practica4;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase que calcula el precio que tienen que pagar los clientes de la companya
 * en funcion de varios criterios (tarifa, fechaAlta, fechaNacimiento y consumo).
 * 
 * @author Pablo Martinez Arana
 */
public class Tarifas_18 implements ITarifas_18 {
	
	@SuppressWarnings("serial")
	public static class FechaErronea extends Exception {} //Excepcion que se lanzara cuando fAlta<fNac o fAlta>fActual 
	@SuppressWarnings("serial")
	public static class ConsumoErroneo extends Exception {} //Excepcion que se lanzara cuando el consumo sea negativo
	// Consumo a partir del cual se sumaran 4€ 
	private static final double CONSUMO = 200.0;
	// Extra por pasarse del consumo
	private static final int EUROS_EXTRA = 4;
	// Porcentaje para mayores de 65 anyos o alta a partir del 1/1/2018
	private static final double PORCENTAJE = 0.05;
	
	/**
	 * Metodo que calcula el precio que tendra que pagar cada cliente de la
	 * companyia en base a los parametros introducidos.
	 * 
	 * @param tarifa
	 * @param fechaAlta
	 * @param fechaNacimiento
	 * @param consumo
	 * @return precio que tendra que pagar cada cliente
	 * @throws FechaErronea, se lanzara cuando fAlta<fNac o fAlta>fActual 
	 * @throws ConsumoErroneo, se lanzara cuando el consumo sea negativo
	 */
	public double precio(TipoTarifa tarifa, Date fechaAlta, Date fechaNacimiento, int consumo) throws FechaErronea, ConsumoErroneo 
	{
		int limite;
		double precioBasico = 0.0;
		double precioFinal = 0.0;
		double edad = diferenciaAnhos(System.currentTimeMillis(),fechaNacimiento.getTime());
		double alta = diferenciaAnhos(System.currentTimeMillis(),fechaAlta.getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2018);
		double altaLimiteInf = diferenciaAnhos(calendar.getTime().getTime(), fechaAlta.getTime());
		
		//Si el cliente se da de alta antes de nacer
		if (edad < alta) {
			throw new FechaErronea();
		}
		//Si la fecha de alta es mayor que hoy
		if (alta < 0) {
			throw new FechaErronea();
		}
		//Si el consumo es negativo 
		if (consumo < 0) {
			throw new ConsumoErroneo(); 
		}
		
		//Comprobamos que tarifa tiene el cliente y calculamos lo
		//que va a pagar en funcion de varias opciones
		if (tarifa == TipoTarifa.TARIFA_A) { 
			limite = 2000; //Limite de consumo
			precioBasico = 30; //Precio basico
		}else if (tarifa == TipoTarifa.TARIFA_B) {
			limite = 4000; //Limite de consumo
			precioBasico = 40; //Precio basico
		}else {
			limite = 6000; //Limite de consumo
			precioBasico = 50; //Precio basico 
		}
		
		precioFinal = extraAlta18(altaLimiteInf, precioBasico) + extraPorConsumo(consumo, limite);
		precioFinal = descuentoPorJubilado(edad, precioFinal);

		return precioFinal;  
	}
	
	/**
	 * Metodo que retorna los euros de mas que
	 * tiene que pagar un cliente si se ha pasado
	 * del limite de su tarifa
	 * @param consumo
	 * @param limite
	 * @return euros de mas a pagar
	 */
	private double extraPorConsumo(int consumo, int limite) 
	{
		int desfase = consumo - limite;
		double eurosDeMas = 0.0;
		if (desfase > 0) {
			eurosDeMas = Math.ceil(desfase/CONSUMO) * EUROS_EXTRA;
		}
		return eurosDeMas;
	}
	
	/**
	 * Metodo que retorna el precio que tiene que pagar
	 * un cliente si se da de alta a partir del 1/1/2018.
	 * @param fecha
	 * @param precio
	 * @return precio con el incremento por darse de alta
	 * despues del 1/1/2018
	 */
	private double extraAlta18(double fecha, double precio) 
	{
		if (fecha <= 0) {
			precio = precio + precio*PORCENTAJE;
		}
		return precio;
	}
	
	/**
	 * Metodo que retorna el precio que tiene que pagar
	 * un cliente si es mayor de 65 anyos.
	 * @param edadCliente
	 * @param precio
	 * @return precio con el descuento
	 */
	private double descuentoPorJubilado (double edadCliente, double precio) 
	{
		if (edadCliente > 65) {
			precio = precio - precio*PORCENTAJE;
		}
		return precio; 
	}
	
	/**
	 * Metodo que retorna la diferencia que hay entre dos anyos
	 * @param anyo1
	 * @param anyo2
	 * @return diferencia de anyos
	 */
	private double diferenciaAnhos(long anyo1,long anyo2)
	{
		return (anyo1-anyo2)/(365L*24*60*60*1000);  //Milisegundos del año 
	}

}
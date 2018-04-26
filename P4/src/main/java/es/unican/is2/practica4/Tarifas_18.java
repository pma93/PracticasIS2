package es.unican.is2.practica4;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase que calcula el precio que tienen que pagar los clientes de la companhia
 * en funcion de varios criterios (tarifa, fechaAlta, fechaNacimiento y
 * consumo).
 * 
 * @author Pablo Martinez Arana
 */
public class Tarifas_18 implements ITarifas_18 {
	@SuppressWarnings("serial")
	public static class FechaErronea extends Exception {} //Excepcion que se lanzara cuando fAlta<fNac, fAlta>fActual o
														//fNac>fActual
	@SuppressWarnings("serial")
	public static class ConsumoErroneo extends Exception {} //Excepcion que se lanzara cuando el consumo sea negativo

	// Precios basicos de cada tarifa, es decir,
	// sin descuento, sin incremento y sin pasarse del consumo
	private static int precios[] = { 30, 40, 50 };
	// Limite de consumo para cada tarifa
	private static final int LIMITE_TARIFA_A = 2000;
	private static final int LIMITE_TARIFA_B = 4000;
	private static final int LIMITE_TARIFA_C = 6000;
	// Consumo a partir del cual se sumaran 4€
	private static final double CONSUMO = 200.0;
	// Extra por pasarse del consumo
	private static final int EUROS_EXTRA = 4;
	// Porcentaje para mayores de 65 anhos o alta a partir del 1/1/2018
	private static final double PORCENTAJE = 0.05;
	
	/**
	 * Metodo que calcula el precio que tendra que pagar cada cliente de la
	 * companhia en base a los parametros introducidos.
	 * 
	 * @param tarifa
	 * @param fechaAlta
	 * @param fechaNacimiento
	 * @param consumo
	 * @return precio que tendra que pagar cada cliente
	 * @throws FechaErronea, se lanzara cuando fAlta<fNac, fAlta>fActual o fNac>fActual
	 * @throws TarifaErronea, se lanzara cuando la tarifa sea erronea
	 * @throws ConsumoErroneo, se lanzara cuando el consumo sea negativo
	 */
	@SuppressWarnings("deprecation")
	public double precio(TipoTarifa tarifa, Date fechaAlta, Date fechaNacimiento, int consumo) throws FechaErronea,
		ConsumoErroneo {
		int desfase;
		double precioFinal = 0.0;
		double eurosDeMas = 0.0;
		double eurosDeMasAlta = 0.0;
		Calendar c = Calendar.getInstance();
		//Si la fecha de alta es menor que la de nacimiento
		if (fechaAlta.compareTo(fechaNacimiento) < 0) {
			throw new FechaErronea(); 
		}
		//Si la fecha es mayor que hoy
		if (fechaAlta.compareTo(new Date(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))) > 0) {
			throw new FechaErronea();
		}
		//Si el consumo es negativo 
		if (consumo < 0) {
			throw new ConsumoErroneo();
		}

		if (tarifa == TipoTarifa.TARIFA_A) { 
			desfase = consumo - LIMITE_TARIFA_A;
			// Si la fecha de alta esta entre 1/1/2018 y la fecha actual
			if (fechaAlta.compareTo(new Date(2018,0,1)) >= 0) {  
				eurosDeMasAlta = precios[0] * PORCENTAJE;
			}
			// Si el consumo es superior al de la tarifa contratada
			if (desfase > 0) {
				eurosDeMas = Math.ceil(desfase/CONSUMO) * EUROS_EXTRA;
			}
			precioFinal = precios[0] + eurosDeMas + eurosDeMasAlta;
			// Si el cliente es mayor de 65 anhos 
			if (fechaNacimiento.getYear() < 1953) {
				precioFinal = precioFinal - precioFinal * PORCENTAJE;
			}
		} else if (tarifa == TipoTarifa.TARIFA_B) {
			desfase = consumo - LIMITE_TARIFA_B;
			// Si la fecha de alta esta entre 1/1/2018 y la fecha actual
			if (fechaAlta.compareTo(new Date(2018,0,1)) >= 0) {
				eurosDeMasAlta = precios[1] * PORCENTAJE;
			}
			// Si el consumo es superior al de la tarifa contratada
			if (desfase > 0) {
				eurosDeMas = Math.ceil(desfase/CONSUMO) * EUROS_EXTRA;
			}
			precioFinal = precios[1] + eurosDeMas + eurosDeMasAlta;
			// Si el cliente es mayor de 65 anhos 
			if (fechaNacimiento.getYear() < 1953) {
				precioFinal = precioFinal - precioFinal * PORCENTAJE;
			}
		} else {
			desfase = consumo - LIMITE_TARIFA_C;
			// Si la fecha de alta esta entre 1/1/2018 y la fecha actual
			if (fechaAlta.compareTo(new Date(2018,0,1)) >= 0) {
				eurosDeMasAlta = precios[2] * PORCENTAJE;
			}
			// Si el consumo es superior al de la tarifa contratada
			if (desfase > 0) {
				eurosDeMas = Math.ceil(desfase/CONSUMO) * EUROS_EXTRA;
			}
			precioFinal = precios[2] + eurosDeMas + eurosDeMasAlta;
			// Si el cliente es mayor de 65 anhos 
			if (fechaNacimiento.getYear() < 1953) {
				precioFinal = precioFinal - precioFinal * PORCENTAJE;
			}
		}

		return precioFinal; 
	}

}
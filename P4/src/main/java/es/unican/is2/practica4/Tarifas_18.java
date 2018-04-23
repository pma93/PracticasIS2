package es.unican.is2.practica4;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase que calcula el precio que tienen que pagar
 * los clientes de la companhia en funcion de varios
 * criterios (tarifa, fechaAlta, fechaNacimiento y consumo).
 * 
 * @author Pablo Martinez Arana
 */
public class Tarifas_18 {  
	@SuppressWarnings("serial")
	public static class TarifaErronea extends Exception{} //Excepcion que se lanza si la tarifa no es A,B o C
	@SuppressWarnings("serial")
	public static class FechaErronea extends Exception{} //Excepcion que se lanzara cuando fAlta<fNac, fAlta>fActual o
														//fNac>fActual
	@SuppressWarnings("serial")
	public static class ConsumoErroneo extends Exception{} //Excepcion que se lanzara cuando el consumo sea negativo
	
	//Precios basicos de cada tarifa, es decir, 
	//sin descuento, sin incremento y sin pasarse del consumo 
	private static int precios []={30, 40, 50};
	
	/**
	 * Metodo que calcula el precio que tendra que pagar cada cliente
	 * de la companhia en base a los parametros introducidos.
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
	public static double precio(TipoTarifa tarifa, Date fechaAlta, Date fechaNacimiento,  int consumo) throws FechaErronea, 
		TarifaErronea, ConsumoErroneo {
		int i = 0;
		double precioNormal=0.0;
		double edad = diferenciaAnhos(System.currentTimeMillis(),fechaNacimiento.getTime());
		double alta = diferenciaAnhos(System.currentTimeMillis(),fechaAlta.getTime());
		
		if (edad < alta || System.currentTimeMillis() < fechaAlta.getTime()) {
			throw new FechaErronea();
		}
		
		if (consumo < 0) {
			throw new ConsumoErroneo();
		}
		
		switch (tarifa) {
		case TARIFA_A:
			i = 0;
			break;
		case TARIFA_B:
			i = 1;
			break;
		case TARIFA_C:
			i = 2;
			break;
		default:
			throw new TarifaErronea();
		}
		
		precioNormal = precios[i]; 
		
		//Si la fecha de alta esta entre 1/1/2018 y la fecha actual
		Calendar limiteInferiorFechaAlta = Calendar.getInstance();
		limiteInferiorFechaAlta.set(2018, 1, 1);
		long limiteInf = limiteInferiorFechaAlta.getTimeInMillis();
		if (fechaAlta.getTime()>=limiteInf && fechaAlta.getTime()<=System.currentTimeMillis()) {
			precioNormal = precioNormal + precioNormal*0.05;
		}
		
		//Si el consumo es superior al de la tarifa contratda
		int megasDeMas;
		int resto = consumo%200;
		if (tarifa == TipoTarifa.TARIFA_A && consumo > 2000  && resto > 0) {
			megasDeMas = (consumo - 2000)/200;
			precioNormal = precioNormal + (megasDeMas*4 + 4);
		} else if (tarifa == TipoTarifa.TARIFA_A && consumo > 2000 && resto == 0) {
			megasDeMas = (consumo - 2000)/200;
			precioNormal = precioNormal + (megasDeMas*4);
		}
		
		if (tarifa == TipoTarifa.TARIFA_B && consumo > 4000 && resto > 0) {
			megasDeMas = (consumo - 4000)/200;
			precioNormal = precioNormal + (megasDeMas*4 + 4);
		} else if (tarifa == TipoTarifa.TARIFA_B && consumo > 4000 && resto == 0) {
			megasDeMas = (consumo - 4000)/200;
			precioNormal = precioNormal + (megasDeMas*4);
		}
		
		if (tarifa == TipoTarifa.TARIFA_C && consumo > 6000 && resto > 0) {
			megasDeMas = (consumo - 6000)/200;
			precioNormal = precioNormal + (megasDeMas*4 + 4);
		} else if (tarifa == TipoTarifa.TARIFA_C && consumo > 6000 && resto == 0) {
			megasDeMas = (consumo - 6000)/200;
			precioNormal = precioNormal + (megasDeMas*4);
		}
		
		//Si el cliente es mayor de 65 anhos
		if (edad > 65) {
			precioNormal = precioNormal - precioNormal*0.05;
		}
		
		return precioNormal;
	}
	
	/**
	 * Metodo que calcula la diferencia de milisegundos entre
	 * dos anhos.
	 * 
	 * @param anho1
	 * @param anho2
	 * @return diferencia de milisegundos entre los dos anhos
	 */
	private static double diferenciaAnhos(long anho1,long anho2) {
		return (anho1-anho2)/(365L*24*60*60*1000);  //Son los milisegundos del año 31556952
	}
	
}

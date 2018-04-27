package es.unican.is2.practica4;

import java.util.Date;

import es.unican.is2.practica4.Tarifas_18.ConsumoErroneo;
import es.unican.is2.practica4.Tarifas_18.FechaErronea;

/**
 * Interfaz que contiene el metodo a probar mediante
 * diferentes test.
 * 
 * @author Pablo Martinez Arana
 */
public interface ITarifas_18 {
	
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
	public double precio(TipoTarifa tarifa, Date fechaAlta, Date fechaNacimiento, int consumo) throws FechaErronea, ConsumoErroneo;
	
}

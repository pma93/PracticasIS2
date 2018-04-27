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
	public double precio(TipoTarifa tarifa, Date fechaAlta, Date fechaNacimiento, int consumo) throws FechaErronea, ConsumoErroneo;
	
}

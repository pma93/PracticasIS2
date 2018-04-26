package es.unican.is2.practica4;

import es.unican.is2.practica4.Tarifas_18.FechaErronea;
import es.unican.is2.practica4.Tarifas_18.ConsumoErroneo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase que contiene varios test para probar el metodo precio
 * de la clase Tarifas_18 con diferentes opciones.
 * 
 * @author Pablo Martinez Arana
 */
public class Tarifas_18Test { 
	private Tarifas_18 tarifas18;
	
	@Before
    public void setUp()  
	{
		tarifas18 = new Tarifas_18();
	} 
	
	/**
	 * CASOS DE PRUEBA VALIDOS
	 * NUMTEST: 11
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testPrecioValidos() 
	{
		//Test 1: (tarifaA, 19/06/2017, 6/06/1954, 1000)
		//Resultado: 30€
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_A, new Date(2017,5,19), new Date(1954,5,6), 1000)==30.0);
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 2: (tarifaB, 31/12/2017, 31/12/1953, 0)
		//Resultado: 40€
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_B, new Date(2017,11,31), new Date(1953,11,31), 0)==40.0);
		}catch (FechaErronea e) { 
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 3: (tarifaC, 16/02/2018, 10/6/1950, 2000)
		//Resultado: 49.875€
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_C, new Date(2018,1,16), new Date(1950,5,10), 2000)==49.875);
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 4: (tarifaA, 1/01/2018, 1/01/1952, 3000)
		//Resultado: 48.925€
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_A, new Date(2018,0,1), new Date(1952,0,1), 3000)==48.925);
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 5: (tarifaB, fechaActual, 6/06/1954, 2001)
		//Resultado: 42€
		
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_B, new Date(2018,Calendar.MONTH,Calendar.DATE), 
					new Date(1954,5,6), 2001)==42.0);
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 6: (tarifaC, 19/06/2017, 31/12/1953, 4000)
		//Resultado: 50€
		
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_C, new Date(2017,5,19), new Date(1953,11,31), 4000)==50.0);
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 7: (tarifaA, 31/12/2017, 10/6/1950, 5000)
		//Resultado: 85.5€
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_A, new Date(2017,11,31), new Date(1950,5,10), 5000)==85.5);
		}catch (FechaErronea e) { 
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 8: (tarifaB, 16/02/2018, 1/01/1952, 4001)
		//Resultado: 43.7€
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_B, new Date(2018,1,16), new Date(1952,0,1), 4001)==43.7);
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 9: (tarifaC, 1/01/2018, 6/06/1954, 6000)
		//Resultado: 52.5€
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_C, new Date(2018,0,1), new Date(1954,5,6), 6000)==52.5);
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 10: (tarifaA, fechaActual, 31/12/1953, 8000)
		//Resultado: 151.5€
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_A, new Date(2018,Calendar.MONTH,Calendar.DATE), 
					new Date(1953,11,31), 8000)==151.5);
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 11: (tarifaB, 19/06/2017, 10/6/1950, 6001)
		//Resultado: 79.8€	
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_B, new Date(2017,5,19), new Date(1950,11,31), 6001)==79.8);
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
	}
	
	/**
	 * Casos de prueba adicionales para intentar alcanzar 
	 * la cobertura pedidda
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testPrecioValidosAdicionales() 
	{	
		//Test adicional 1: (tarifaC, 19/5/2017, 19/5/1954)
		//Resultado: 54.0€ 
		try {
			assertTrue(tarifas18.precio(TipoTarifa.TARIFA_C, new Date(2017,5,19), new Date(1954,5,19), 6001)==54.0);
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
	}
	
	/**
	 * CASOS DE PRUEBA NO VALIDOS
	 * NUMTEST: 3
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testPrecioNoValidos() 
	{
		//Test 13: (tarifaA, 1954, 2018, 0)
		//Resultado: Error, fAlta<fNac
		try {
			tarifas18.precio(TipoTarifa.TARIFA_A, new Date(1954), new Date(2018), 0);
			fail("Deberia lanzar la excepcion de fecha incorrecta");
		}catch (FechaErronea e) {
			//Debe lanzar esta excepcion
		}catch (ConsumoErroneo e) {
			//
		}
		//Test 13: (tarifaA, 1954, 2018, 0)
		//Resultado: Error, fAlta<fNac
		try {
			tarifas18.precio(TipoTarifa.TARIFA_A, new Date(2018,9,31), new Date(1954,6,3), 0);
			fail("Deberia lanzar la excepcion de fecha incorrecta");
		}catch (FechaErronea e) {
			//Debe lanzar esta excepcion
		}catch (ConsumoErroneo e) {
			//
		}
		
		//Test 19: (tarifaA, 2018, 1952, -20)
		//Resultado: Error, consumo<0
		try {
			tarifas18.precio(TipoTarifa.TARIFA_A, new Date(2018), new Date(1952), -20);
			fail("Deberia lanzar la excepcion de consumo incorrecto");
		}catch (FechaErronea e) {
			//
		}catch (ConsumoErroneo e) {
			//Debe lanzar esta excepcion
		}
	}
	
}


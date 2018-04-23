package es.unican.is2.practica4;

import es.unican.is2.practica4.Tarifas_18;
import es.unican.is2.practica4.Tarifas_18.FechaErronea;
import es.unican.is2.practica4.Tarifas_18.TarifaErronea;
import es.unican.is2.practica4.Tarifas_18.ConsumoErroneo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * Clase que contiene varios test para probar el metodo precio
 * de la clase Tarifas_18 con diferentes opciones.
 * 
 * @author Pablo Martinez Arana
 */
public class Tarifas_18Test { 
	Calendar fechaAlta;
	Calendar fechaNacimiento;
	
	@Before
    public void setUp() throws Exception {
		fechaAlta = Calendar.getInstance();
		fechaNacimiento = Calendar.getInstance();
	} 
	
	/**
	 * CASOS DE PRUEBA VALIDOS
	 * NUMTEST: 11
	 */
	@Test
	public void testPrecioValidos() {
		//Test 1: (tarifaA, 19/06/2017, 6/06/1954, 1000)
		//Resultado: 30€
		fechaAlta.set(Calendar.YEAR,2017);
		fechaNacimiento.set(Calendar.YEAR,1954);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_A, fechaAlta.getTime(), fechaNacimiento.getTime(), 1000)==30.0);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 2: (tarifaB, 31/12/2017, 31/12/1953, 0)
		//Resultado: 40€
		fechaAlta.set(Calendar.YEAR,2017);
		fechaNacimiento.set(Calendar.YEAR,1953);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_B, fechaAlta.getTime(), fechaNacimiento.getTime(), 0)==40.0);
		}catch (TarifaErronea e) {
				fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 3: (tarifaC, 16/02/2018, 10/6/1950, 2000)
		//Resultado: 49.875€
		fechaAlta.set(Calendar.YEAR,2018); 
		fechaNacimiento.set(Calendar.YEAR,1950);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_C, fechaAlta.getTime(), fechaNacimiento.getTime(), 2000)==49.875);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 4: (tarifaA, 1/01/2018, 1/01/1952, 3000)
		//Resultado: 48.925€
		fechaAlta.set(Calendar.YEAR,2018);
		fechaNacimiento.set(Calendar.YEAR,1952);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_A, fechaAlta.getTime(), fechaNacimiento.getTime(), 3000)==48.925);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 5: (tarifaB, fechaActual, 6/06/1954, 2001)
		//Resultado: 42€
		fechaAlta.set(Calendar.YEAR,2018);
		fechaNacimiento.set(Calendar.YEAR,1954);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_B, fechaAlta.getTime(), fechaNacimiento.getTime(), 2001)==42.0);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 6: (tarifaC, 19/06/2017, 31/12/1953, 4000)
		//Resultado: 50€
		fechaAlta.set(Calendar.YEAR,2017);
		fechaNacimiento.set(Calendar.YEAR,1953);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_C, fechaAlta.getTime(), fechaNacimiento.getTime(), 4000)==50.0);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 7: (tarifaA, 31/12/2017, 10/6/1950, 5000)
		//Resultado: 85.5€
		fechaAlta.set(Calendar.YEAR,2017);
		fechaNacimiento.set(Calendar.YEAR,1950);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_A, fechaAlta.getTime(), fechaNacimiento.getTime(), 5000)==85.5);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 8: (tarifaB, 16/02/2018, 1/01/1952, 4001)
		//Resultado: 43.7€
		fechaAlta.set(Calendar.YEAR,2018);
		fechaAlta.set(Calendar.MONTH,2);
		fechaNacimiento.set(Calendar.YEAR,1952);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_B, fechaAlta.getTime(), fechaNacimiento.getTime(), 4001)==43.7);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 9: (tarifaC, 1/01/2018, 6/06/1954, 6000)
		//Resultado: 52.5€
		fechaAlta.set(Calendar.YEAR,2018);
		fechaNacimiento.set(Calendar.YEAR,1954);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_C, fechaAlta.getTime(), fechaNacimiento.getTime(), 6000)==52.5);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 10: (tarifaA, fechaActual, 31/12/1953, 8000)
		//Resultado: 151.5€
		fechaAlta.set(Calendar.YEAR,2018);
		fechaNacimiento.set(Calendar.YEAR,1953);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_A, fechaAlta.getTime(), fechaNacimiento.getTime(), 8000)==151.5);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test 11: (tarifaB, 19/06/2017, 10/6/1950, 6001)
		//Resultado: 79.8€	
		fechaAlta.set(Calendar.YEAR,2017);
		fechaNacimiento.set(Calendar.YEAR,1950);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_B, fechaAlta.getTime(), fechaNacimiento.getTime(), 6001)==79.8);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
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
	@Test
	public void testPrecioValidosAdicionales() {
		//Test adicional 1
		//Resultado: 34€
		fechaAlta.set(Calendar.YEAR,2017);
		fechaNacimiento.set(Calendar.YEAR,1954);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_A, fechaAlta.getTime(), fechaNacimiento.getTime(), 2001)==34.0);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}	
		
		//Test adicional 2
		//Resultado: 44€
		fechaAlta.set(Calendar.YEAR,2017);
		fechaNacimiento.set(Calendar.YEAR,1954);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_B, fechaAlta.getTime(), fechaNacimiento.getTime(), 4200)==44.0);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test adicional 3
		//Resultado: 56.5€
		fechaAlta.set(Calendar.YEAR,2018);
		fechaNacimiento.set(Calendar.YEAR,1954);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_C, fechaAlta.getTime(), fechaNacimiento.getTime(), 6001)==56.5);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
		//Test adicional 4
		//Resultado: 54€
		fechaAlta.set(Calendar.YEAR,2017);
		fechaNacimiento.set(Calendar.YEAR,1954);
		try {
			assertTrue(Tarifas_18.precio(TipoTarifa.TARIFA_C, fechaAlta.getTime(), fechaNacimiento.getTime(), 6200)==54.0);
		}catch (TarifaErronea e) {
			fail("No deberia lanzar la excepcion tarifa erronea");
		}catch (FechaErronea e) {
			fail("No deberia lanzar la excepcion fecha erronea");
		}catch (ConsumoErroneo e) {
			fail("No deberia lanzar la excepcion consumo erroneo");
		}
		
	}
	
	/**
	 * CASOS DE PRUEBA NO VALIDOS
	 * NUMTEST: 4
	 */
	@Test
	public void testPrecioNoValidos() {
		//Test 12: (tarifaD, 19/06/2017, 6/06/1954, 1000)
		//Resultado: Error, tarifa incorrecta
		fechaAlta.set(Calendar.YEAR,2017);
		fechaAlta.set(Calendar.MONTH,6);
		fechaAlta.set(Calendar.DAY_OF_MONTH,19);
		fechaNacimiento.set(Calendar.YEAR,1954);
		fechaNacimiento.set(Calendar.MONTH,6);
		fechaNacimiento.set(Calendar.DAY_OF_MONTH,6);
		try {
			Tarifas_18.precio(TipoTarifa.TARIFA_D, fechaAlta.getTime(), fechaNacimiento.getTime(), 1000);
			fail("Deberia lanzar la excepcion de tarifa incorrecta");
		}catch (TarifaErronea e) {
			//Debe lanzar esta excepcion
		}catch (FechaErronea e) {
			//
		}catch (ConsumoErroneo e) {
			//
		}
		
		//Test 13: (tarifaA, 6/06/1954, 16/02/2018, 0)
		//Resultado: Error, fAlta<fNac
		fechaAlta.set(Calendar.YEAR,1954);
		fechaAlta.set(Calendar.MONTH,6);
		fechaAlta.set(Calendar.DAY_OF_MONTH,6);
		fechaNacimiento.set(Calendar.YEAR,2018);
		fechaNacimiento.set(Calendar.MONTH,2);
		fechaNacimiento.set(Calendar.DAY_OF_MONTH,16);
		try {
			Tarifas_18.precio(TipoTarifa.TARIFA_A, fechaAlta.getTime(), fechaNacimiento.getTime(), 0);
			fail("Deberia lanzar la excepcion de fecha incorrecta");
		}catch (TarifaErronea e) {
			//
		}catch (FechaErronea e) {
			//Debe lanzar esta excepcion
		}catch (ConsumoErroneo e) {
			//
		}
		
		//Test 14: (tarifaB, fAct+1día, 31/12/1953, 2000)
		//Resultado: Error, fAlta>fActual
		fechaAlta.set(Calendar.YEAR,2018);
		fechaAlta.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH+1);
		fechaNacimiento.set(Calendar.YEAR,1953);
		fechaNacimiento.set(Calendar.MONTH,12);
		fechaNacimiento.set(Calendar.DAY_OF_MONTH,31);
		try {
			Tarifas_18.precio(TipoTarifa.TARIFA_A, fechaAlta.getTime(), fechaNacimiento.getTime(), 2000);
			fail("Deberia lanzar la excepcion de fecha incorrecta");
		}catch (TarifaErronea e) {
			//
		}catch (FechaErronea e) {
			//Debe lanzar esta excepcion
		}catch (ConsumoErroneo e) {
			//
		}
		
		//Test 19: (tarifaA, 1/01/2018, 1/01/1952, -20)
		//Resultado: Error, consumo<0
		fechaAlta.set(Calendar.YEAR,2018);
		fechaAlta.set(Calendar.MONTH,1);
		fechaAlta.set(Calendar.DAY_OF_MONTH,1);
		fechaNacimiento.set(Calendar.YEAR,1952);
		fechaNacimiento.set(Calendar.MONTH,1);
		fechaNacimiento.set(Calendar.DAY_OF_MONTH,1);
		try {
			Tarifas_18.precio(TipoTarifa.TARIFA_A, fechaAlta.getTime(), fechaNacimiento.getTime(), -20);
			fail("Deberia lanzar la excepcion de consumo incorrecto");
		}catch (TarifaErronea e) {
			//
		}catch (FechaErronea e) {
			//
		}catch (ConsumoErroneo e) {
			//Debe lanzar esta excepcion
		}
	}
	
}

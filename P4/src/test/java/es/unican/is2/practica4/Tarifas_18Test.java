package es.unican.is2.practica4;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Clase que contiene varios test para probar el metodo precio
 * de la clase Tarifas_18 con diferentes opciones.
 * 
 * @author Pablo Martinez Arana
 */
public class Tarifas_18Test {
	
	/**
	 * CASOS DE PRUEBA VALIDOS
	 * NUMTEST: 11
	 */
	@Test
	public void testPrecioValidos() {
		//Test 1: (tarifaA, 19/06/2017, 6/06/1954, 1000)
		//Resultado: 30€
		//Test 2: (tarifaB, 31/12/2017, 31/12/1953, 0)
		//Resultado: 40€
		//Test 3: (tarifaC, 16/02/2018, 10/6/1950, 2000)
		//Resultado: 49.875€
		//Test 4: (tarifaA, 1/01/2018, 1/01/1952, 3000)
		//Resultado: 48.925€
		//Test 5: (tarifaB, fechaActual, 6/06/1954, 2100)
		//Resultado: 42€
		//Test 6: (tarifaC, 19/06/2017, 31/12/1953, 4000)
		//Resultado: 50€
		//Test 7: (tarifaA, 31/12/2017, 10/6/1950, 5000)
		//Resultado: 85.5€
		//Test 8: (tarifaB, 16/02/2018, 1/01/1952, 4100)
		//Resultado: 39.9€
		//Test 9: (tarifaC, 1/01/2018, 6/06/1954, 6000)
		//Resultado: 52.5€
		//Test 10: (tarifaA, fechaActual, 31/12/1953, 8000)
		//Resultado: 151.5€
		//Test 11: (tarifaB, 19/06/2017, 10/6/1950, 6100)
		//Resultado: 76€	
	}

	/**
	 * CASOS DE PRUEBA NO VALIDOS
	 * NUMTEST: 7
	 */
	@Test
	public void testPrecioNoValidos() {
		//Test 12: (NULL, 19/06/2017, 6/06/1954, 1000)
		//Resultado: Error, tarifa incorrecta
		//Test 13: (tarifaA, 6/06/1954, 16/02/2018, 0)
		//Resultado: Error, fAlta<fNac
		//Test 14: (tarifaB, fAct+7días, 31/12/1953, 2000)
		//Resultado: Error, fAlta>fActual
		//Test 15: (tarifaC, NULL, 6/06/1954, 2100)
		//Resultado: Error, formato incorrecto
		//Test 16: (tarifaC, 31/12/2017, fAct+1día, 3000)
		//Resultado: Error, fNac>fActual
		//Test 17: (tarifaA, 6/06/1954, NULL, 4000)
		//Resultado: formato incorrecto
		//Test 19: (tarifaA, 1/01/2018, 1/01/1952, -20)
		//Resultado: Error, consumo<0	
	}
	
}

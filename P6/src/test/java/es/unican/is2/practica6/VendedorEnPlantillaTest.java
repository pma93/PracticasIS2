package es.unican.is2.practica6;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unican.is2.practica6.VendedorEnPracticas;


public class VendedorEnPlantillaTest {
	
	private static VendedorEnPracticas v;
	

	
	@Before
	public void setUp(){
		v = new VendedorEnPracticas("Ana", "12345678A");
	}
	
	@Test
	public void testConstructor() {
		assertEquals("12345678A", v.getDni());
		assertEquals("Ana", v.getNombre());
	}

	@Test
	public void testAnhadeVenta() {
		
		v.anhadeVenta(200);
		assertEquals(200, v.getTotalVentas(), 0);
		assertEquals(0, v.getComisionAcumulada(), 0.1);
		
		v.anhadeVenta(300);
		assertEquals(500, v.getTotalVentas(), 0);
		assertEquals(0, v.getComisionAcumulada(), 0.1);
		
	
	}
	
	@Test
	public void testSetTotalVentas() {
		
		v.setTotalVentas(2000);
		assertEquals(2000, v.getTotalVentas(), 0);
		assertEquals(0, v.getComisionAcumulada(), 0.1);
		
	}

}

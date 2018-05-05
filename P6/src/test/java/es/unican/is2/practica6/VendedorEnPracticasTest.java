package es.unican.is2.practica6;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unican.is2.practica6.TipoVendedor;
import es.unican.is2.practica6.VendedorEnPlantilla;


public class VendedorEnPracticasTest {
	
	private static VendedorEnPlantilla junior;
	private static VendedorEnPlantilla senior;

	
	@Before
	public void setUp(){
		junior = new VendedorEnPlantilla("Ana", "12345678A", TipoVendedor.JUNIOR);
		senior = new VendedorEnPlantilla("Pepe", "87654321A", TipoVendedor.SENIOR);
	}
	
	@Test
	public void testConstructor() {
		assertEquals("12345678A", junior.getDni());
		assertEquals("Ana", junior.getNombre());
	}

	@Test
	public void testAnhadeVenta() {
		
		junior.anhadeVenta(200);
		assertEquals(200, junior.getTotalVentas(), 0);
		assertEquals(1, junior.getComisionAcumulada(), 0.1);
		
		junior.anhadeVenta(300);
		assertEquals(500, junior.getTotalVentas(), 0);
		assertEquals(2.5, junior.getComisionAcumulada(), 0.1);
		
		senior.anhadeVenta(200);
		assertEquals(200, senior.getTotalVentas(), 0);
		assertEquals(2, senior.getComisionAcumulada(), 0.1);
		
	}
	
	@Test
	public void testSetTotalVentas() {
		
		junior.setTotalVentas(2000);
		assertEquals(2000, junior.getTotalVentas(), 0);
		assertEquals(10, junior.getComisionAcumulada(), 0.1);
		
		senior.setTotalVentas(4500);
		assertEquals(4500, senior.getTotalVentas(), 0);
		assertEquals(45, senior.getComisionAcumulada(), 0.1);
		
	}

}

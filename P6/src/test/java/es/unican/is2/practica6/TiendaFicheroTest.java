package es.unican.is2.practica6;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unican.is2.practica6.Tienda;
import es.unican.is2.practica6.Vendedor;


public class TiendaFicheroTest {
	
	private static Tienda t;

	@Before
	public void setUp(){
		t = new Tienda();
		t.vendedores();
	}
	
	@Test
	public void testAnhadeVenta() {
		t.anhadeVenta("22222222C", 200.0);		
		Vendedor v = t.buscaVendedor("22222222C");
		assertEquals(700.0, v.getTotalVentas(), 0);

	}

	@Test
	public void testBuscaVendedor() {
		// Buscamos un vendedor que no exista
		assertEquals(null, t.buscaVendedor("11111111A"));
		
		// Buscamos un vendedor que exista
		Vendedor v = t.buscaVendedor("22222222C");
		assertEquals(("22222222C"), v.getDni());
		assertEquals("Marta", v.getNombre());
		assertEquals(500.0, v.getTotalVentas(), 0);
		
	}
	
}

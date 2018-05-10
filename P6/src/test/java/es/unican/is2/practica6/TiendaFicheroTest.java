package es.unican.is2.practica6;
import static org.junit.Assert.*;

import org.junit.Test;

import es.unican.is2.practica6.Tienda;
import es.unican.is2.practica6.Vendedor;


public class TiendaFicheroTest {

	@Test
	public void testAnhadeVenta() {
		Tienda t = new Tienda();
		t.anhadeVenta("22222222C", 200.0);		
		Vendedor v = t.buscaVendedor("22222222C");
		assertEquals("",700.0,v.getTotalVentas(),0);
	}

	@Test
	public void testBuscaVendedor() {
		Tienda t = new Tienda();
		// Buscamos un vendedor que no exista
		assertEquals(null, t.buscaVendedor("11111111A"));
		
		// Buscamos un vendedor que exista
		Vendedor v = t.buscaVendedor("22222222C");
		assertEquals(("22222222C"), v.getDni());
		assertEquals("Marta", v.getNombre());
		assertEquals("",500.0,v.getTotalVentas(),0);
		
	}
	
}

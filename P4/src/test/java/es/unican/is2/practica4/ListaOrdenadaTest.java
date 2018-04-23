package es.unican.is2.practica4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unican.is2.practica4.ListaOrdenada;

/**
 * Clase que contiene varios test para probar los metodos
 * de la clase ListaOrdenada con diferentes opciones.
 * 
 * @author Pablo Martinez Arana
 */
public class ListaOrdenadaTest {
	private ListaOrdenada<Integer> lista;
	int tamanho;
	int tamanho1;
	Integer elem;

	@Before
    public void setUp() throws Exception {
		lista= new ListaOrdenada<Integer>();
	} 
	
	@Test
	public void testGet(){
		//Test get 1
		//lista.size=0
		try{
			elem=lista.get(0); 
			fail("No se ha lanzado la excepcion");
		}catch(IndexOutOfBoundsException e) {
			//Debe lanzar la excepcion
		}
		
		//Test get 2
		//lista.size=1
		lista.add(3);
		try {
			elem=lista.get(0);
			assertTrue(elem==3);
		}catch (IndexOutOfBoundsException e) {
			fail("No deberia lanzar la excepcion");
		}
		
		//Test get 3
	 	//lista.size>1
		lista.add(5);
		try {
			elem=lista.get(0);
			assertTrue(elem==3);
		}catch (IndexOutOfBoundsException e) {
			fail("No deberia lanzar la excepcion");
		}
	}

	@Test
	public void testAdd(){
		//Test add 4
		//lista.size()=0
		tamanho=lista.size();
		lista.add(1);
		tamanho1=lista.size();
		assertTrue((tamanho1-tamanho==1));
		
		//Test add 5
		//lista.size()=1
		tamanho=lista.size();
		lista.add(2);
		tamanho1=lista.size();
		assertTrue((tamanho1-tamanho==1));
		
		//Test add 6
		//lista.size()>1
		tamanho=lista.size();
		lista.add(3);
		lista.add(4);
		tamanho1=lista.size();
		assertTrue((tamanho1-tamanho==2));
	}

	@Test
	public void testRemove(){
		//Test remove 7
		//lista.size=0
		try{
			lista.remove(0);
			tamanho=lista.size();
			fail("No se ha lanzado la excepcion");
		}catch (IndexOutOfBoundsException e) {
			//Debe lanzarse la excepcion
		}
		
		//Test remove 8
		//lista.size=1
		lista.add(1);
		try{
			lista.remove(0);
			assertTrue(lista.size()==0);
		}catch (IndexOutOfBoundsException e) {
			fail("No deberia lanzar excepcion");
		}
		
		//Test remove 9
		//lista.size>1
		lista.add(1);
		lista.add(2);
		lista.add(3);
		tamanho=lista.size();
		try {
			lista.remove(1);
			tamanho1=lista.size();
			assertTrue((tamanho-tamanho1==1));
			assertTrue((lista.get(1)==3));
		}catch (IndexOutOfBoundsException e) {
			fail("No deberia lanzar excepcion");
		}
	}
	
	
	@Test
	public void testSize() {
		//Test size 10
		//lista.size()=0
		assertTrue(lista.size()==0);
		
		//Test size 11
		//lista.size()=1
		lista.add(1);
		assertTrue(lista.size()>0);
		
		//Test size 12
		//lista.size()>1
		lista.remove(0);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		assertTrue(lista.size()>0);
	}

	@Test
	public void testClear(){
		//Test clear 13
		//lista.size()=0
		lista.clear();
		assertTrue((lista.size()==0));
		
		//Test clear 14
		//lista.size()=1
		lista.add(1);
		lista.clear();
		assertTrue((lista.size()==0));
		
		//Test clear 15
		//lista.size()>1
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.clear();
		assertTrue((lista.size()==0));
	}

}

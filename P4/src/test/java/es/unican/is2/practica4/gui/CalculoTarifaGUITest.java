package es.unican.is2.practica4.gui;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.gui.CalculoTarifaGUI;

public class CalculoTarifaGUITest {

	private FrameFixture demo;

	@Before
	public void setUp() {
		CalculoTarifaGUI sut = new CalculoTarifaGUI();
		demo = new FrameFixture(sut);
		sut.setVisible(true);
	} 

	@After
	public void tearDown() {
		demo.cleanUp();
	}

	@Test
	public void test() {
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnCalcular").requireText("CALCULAR");

		try {

			// Caso de prueba correcto
			demo.textBox("txtFechaAlta").setText("11/07/2015");
			demo.textBox("txtFechaNacimiento").setText("11/07/1976");
			demo.textBox("txtConsumo").setText("8");
			// Sleeps para ralentizar la ejecuci�n
			Thread.sleep(2000);
			// Pulsamos el bot�n para calcular
			demo.button("btnCalcular").click();
			// Comprobamos la salida
			demo.textBox("txtPrecio").requireText("30.0");

			Thread.sleep(2000);

			// Caso de prueba con fecha incorrecta
			demo.textBox("txtFechaAlta").setText("2015/02/11");
			demo.textBox("txtFechaNacimiento").setText("2015");
			demo.textBox("txtConsumo").setText("8");
			Thread.sleep(2000);
			// Pulsamos el bot�n para calcular
			demo.button("btnCalcular").click();
			// Comprobamos la salida
			demo.textBox("txtPrecio").requireText("Fecha incorrecta");
			Thread.sleep(2000);

			// Caso de prueba con consumo incorrecta
			demo.textBox("txtFechaAlta").setText("11/07/2015");
			demo.textBox("txtFechaNacimiento").setText("11/07/1976");
			demo.textBox("txtConsumo").setText("");
			Thread.sleep(2000);
			// Pulsamos el bot�n para calcular
			demo.button("btnCalcular").click();
			// Comprobamos la salida
			demo.textBox("txtPrecio").requireText("Consumo no valido");
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

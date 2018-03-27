package es.unican.is2.practica3.Runner;

import java.io.IOException;

import es.unican.is2.practica3.controller.DespertadorBuzzAction;
import es.unican.is2.practica3.controller.DespertadorOffAction;
import es.unican.is2.practica3.controller.DespertadorOnAction;
import es.unican.is2.practica3.controller.DespertadorSnoozeAction;
import es.unican.is2.practica3.controller.DespertadorStopAction;
import es.unican.is2.practica3.model.Despertador;
import es.unican.is2.practica3.view.DespertadorGUI;

/**	
 * 	DespertadorRunner.java
 *	Clase para la creacion del MVC
 *	@author: Pablo Martinez Arana
 *	@version: 03/2018
 */
public class DespertadorRunner {
	/**
	 * Esta clase se encarga de crear el modelo, la vista y los controladores 
	 * (ademas de relacionar dichos controladores con la vista y el modelo)
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		try {
			Despertador model = new Despertador();
			/**
			 *  Sacamos una interfaz para comprobar el correcto funcionamiento de MVC
			 *  	- Dicha interfaz se encargara de la gestion del despertador 
			 */	
			DespertadorGUI view = new DespertadorGUI(model);
			view.setAlarmaOnAction(new DespertadorOnAction(model, view));
			view.setAlarmaOffAction(new DespertadorOffAction(model));
			view.setBuzzAction(new DespertadorBuzzAction(model));
			view.setStopAction(new DespertadorStopAction(model, view));
			view.setSnoozeAction(new DespertadorSnoozeAction(model, view));
			view.setVisible();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

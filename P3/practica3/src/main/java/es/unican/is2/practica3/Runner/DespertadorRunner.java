package es.unican.is2.practica3.Runner;

import java.io.IOException;

import es.unican.is2.practica3.controller.UsersController;
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
	 * Esta clase se encarga de crear el modelo, la vista y el controlador 
	 * (ademas de relacionar dicho controlador con la vista y el modelo)
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		try {
			Despertador model = new Despertador();
			/**
			 *  Sacamos una interfaz para comprobar el correcto funcionamiento de MVC
			 *  	- Dicha interfaz se encargara de la gestion del despertador 
			 */	
			DespertadorGUI view = new DespertadorGUI(model);
			UsersController controller = new UsersController(model, view);
			view.setVisible();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

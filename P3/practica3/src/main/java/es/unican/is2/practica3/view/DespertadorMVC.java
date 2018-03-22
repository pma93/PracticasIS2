package es.unican.is2.practica3.view;

import es.unican.is2.practica3.controller.DespertadorBuzzAction;
import es.unican.is2.practica3.controller.DespertadorOffAction;
import es.unican.is2.practica3.controller.DespertadorOnAction;
import es.unican.is2.practica3.controller.DespertadorSnoozeAction;
import es.unican.is2.practica3.controller.DespertadorStopAction;
import es.unican.is2.practica3.model.Despertador;

public class DespertadorMVC {

	public static void main(String[] args) {
		Despertador model = new Despertador();
		DespertadorGUI view = new DespertadorGUI(model);
		view.setAlarmaOnAction(new DespertadorOnAction(model, view));
		view.setAlarmaOffAction(new DespertadorOffAction(model, view));
		view.setBuzzAction(new DespertadorBuzzAction(model));
		view.setStopAction(new DespertadorStopAction(model, view));
		view.setSnoozeAction(new DespertadorSnoozeAction(model, view));
		view.setVisible();
	}

}

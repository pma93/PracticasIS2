package es.unican.is2.practica3.controller;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.practica3.model.Despertador;
import es.unican.is2.practica3.view.DespertadorGUI;

public class DespertadorStopAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	
	private Despertador model;
	private DespertadorGUI view;
	
	public DespertadorStopAction(Despertador model, DespertadorGUI view) 
	{
		this.model = model;
		this.view = view;
		putValue(Action.NAME, "Stop");
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		int h = Integer.parseInt(view.horaAlarma.getText());
		int m = Integer.parseInt(view.minAlarma.getText());
		Date fecha = new Date();
		fecha.setDate(fecha.getDate()+1);
		fecha.setHours(h);
		fecha.setMinutes(m);
		fecha.setSeconds(0);
		model.horaTemp(fecha);
		model.cambiaHora();
		model.signalStop();
	}

}

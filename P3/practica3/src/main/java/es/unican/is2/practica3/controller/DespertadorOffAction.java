package es.unican.is2.practica3.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.practica3.model.Despertador;
import es.unican.is2.practica3.view.DespertadorGUI;

public class DespertadorOffAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	
	private Despertador model;
	private DespertadorGUI view;
	
	public DespertadorOffAction(Despertador model, DespertadorGUI view) 
	{
		this.model = model;
		this.view = view;
		
		putValue(Action.NAME, "DespertadorOff");
	}
	public void actionPerformed(ActionEvent e) {
		model.signalAlarmaOff();
		view.clearAlarma();
	}
	
}

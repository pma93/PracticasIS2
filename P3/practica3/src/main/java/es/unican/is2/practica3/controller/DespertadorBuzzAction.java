package es.unican.is2.practica3.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.practica3.model.Despertador;

public class DespertadorBuzzAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	
	private Despertador model;
	
	public DespertadorBuzzAction(Despertador model) 
	{
		this.model = model;
		putValue(Action.NAME, "Buzz");
	}
	
	public void actionPerformed(ActionEvent e) {
		model.signalBuzz();
	}
}

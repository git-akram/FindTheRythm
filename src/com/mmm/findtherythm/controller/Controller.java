package com.mmm.findtherythm.controller;

import com.mmm.findtherythm.model.Model;

public class Controller {

	Model model;
	
	public Controller(Model model) {
		this.model = model;
	}
	
	public void clickSuccessAction() {
		model.nextMove(true);
	}
	
	public void clickFailAction() {
		model.nextMove(false);
	}
	
	public void terminerPartieAction() {
		model.quitPartie();
	}
		
}

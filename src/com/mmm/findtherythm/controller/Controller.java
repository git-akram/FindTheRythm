package com.mmm.findtherythm.controller;

import com.mmm.findtherythm.model.Model;

public class Controller {

	Model model;
	
	public Controller(Model model) {
		this.model = model;
	}
	
	public void clickSuccess() {
		model.nextMove(true);
	}
	
	public void clickFail() {
		model.nextMove(false);
	}
		
}

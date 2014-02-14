package com.mmm.findtherythm.model;

public class ButtonRythm {
	int id;
	boolean state;
	String image;
	public ButtonRythm(int id) {
		super();
		this.id = id;
		this.state = false;
		this.image = "img/button-png";
	}
	
	public int getId() {
		return id;
	}
	
	public boolean getState() {
		return state;
	}
	
	public String getImage() {
		return image;
	}
	
	public void enable() {
		state = true;
		image = "img/button-green.png";
	}
	
	public void disable() {
		state = false;
		image = "img/button-red.png";
	}
}

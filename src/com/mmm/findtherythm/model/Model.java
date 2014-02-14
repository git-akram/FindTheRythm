package com.mmm.findtherythm.model;

import java.util.ArrayList;

import com.mmm.findtherythm.services.Graphic;
import com.mmm.findtherythm.services.Sound;

public class Model implements Observable{
	private int score;
	private ArrayList<ButtonRythm> buttonRythmList;
	private Graphic graphic;
	private Sound sound;
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	public Model() {
		
	}
	
	public void startPartie() {
		this.buttonRythmList = new ArrayList<ButtonRythm>();
		ButtonRythm buttonRythm1 = new ButtonRythm(1);
		ButtonRythm buttonRythm2 = new ButtonRythm(2);
		ButtonRythm buttonRythm3 = new ButtonRythm(3);
		ButtonRythm buttonRythm4 = new ButtonRythm(4);
		ButtonRythm buttonRythm5 = new ButtonRythm(5);
		this.buttonRythmList.add(buttonRythm1);
		this.buttonRythmList.add(buttonRythm2);
		this.buttonRythmList.add(buttonRythm3);
		this.buttonRythmList.add(buttonRythm4);
		this.buttonRythmList.add(buttonRythm5);
		activateButtonRandomly(0);
		this.score = 0;
		this.graphic = new Graphic();
		this.sound = new Sound();
		notifyObserver();
	}
	
	public void quitPartie() {
		this.score = 0;
		buttonRythmList.clear();
	}

	public int getScore() {
		return score;
	}

	public ArrayList<ButtonRythm> getButtonRythm() {
		return buttonRythmList;
	}

	public Graphic getGraphic() {
		return graphic;
	}

	public Sound getSound() {
		return sound;
	}
	
	private void setFalseMoveImage() {
		graphic.setFalseImage();
		notifyObserver();
	}
	
	private void setBackgroundImage() {
		graphic.setBackgroundImage();
	}
	
	private void nextButton() {
		int bouttonActiveId = 0;
		for(ButtonRythm buttonRythm : buttonRythmList) {
			if(buttonRythm.getState())
				bouttonActiveId = buttonRythm.getId();
		}
		activateButtonRandomly(bouttonActiveId);	
	}
	
	private void activateButtonRandomly(int id) {
		int rand = 0;
		do {
			rand = (int) (Math.random() * 5) + 1;
		}while(rand == id);
		
		for(ButtonRythm buttonRythm : buttonRythmList) {
			if(buttonRythm.getId() == rand)
				buttonRythm.disable();
			else
				buttonRythm.enable();
		}
	}
	
	private void addScore() {
		score = score + 100;
	}
	
	private void deductScore() {
		score = score - 100;
	}
	
	public void nextMove(boolean move) {
		if(move) {
			addScore();
		}
		else {
			deductScore();
			setFalseMoveImage();
		}
		nextButton();
		notifyObserver();
	}

	@Override
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);	
	}

	@Override
	public void removeObserver() {
		listObserver = new ArrayList<Observer>();	
	}

	@Override
	public void notifyObserver() {
		for(Observer obs : listObserver)
		      obs.update();	
	}
}

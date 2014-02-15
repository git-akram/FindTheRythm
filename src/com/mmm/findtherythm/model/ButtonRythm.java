package com.mmm.findtherythm.model;

import com.mmm.findtherythm.R;

import android.graphics.drawable.Drawable;
import android.webkit.WebView.FindListener;

public class ButtonRythm {
	int id;
	boolean state; 
	public ButtonRythm(int id) {
		super();
		this.id = id;
		this.state = false;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean getState() {
		return state;
	}

	public void enable() {
		state = true;
	}
	
	public void disable() {
		state = false;
	}
}

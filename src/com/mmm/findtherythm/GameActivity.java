package com.mmm.findtherythm;

import com.mmm.findtherythm.model.Model;
import com.mmm.findtherythm.model.Observer;
import com.mmm.findtherythm.view.AnimationView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class GameActivity extends Activity implements Observer{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_game);
		
		AnimationView view = new AnimationView(this); 
		setContentView(view);
		
		ImageView image1 = (ImageView) findViewById(R.id.ImageView01);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public void update(Model model) {
		// TODO Auto-generated method stub
		
	}

}

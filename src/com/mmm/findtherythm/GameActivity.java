package com.mmm.findtherythm;

import com.mmm.findtherythm.model.Model;
import com.mmm.findtherythm.model.Observer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GameActivity extends Activity implements Observer{
	private static final String TAG = "GameActivity";
	private ImageButton back;
	private ImageView background;
	AnimationDrawable danceAnimation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "Starting Game Activity");
		setContentView(R.layout.activity_game);
		
		Log.i(TAG, "befor setting background");
		background = (ImageView) findViewById(R.id.background);
		background.setBackgroundResource(R.drawable.dance_animation);
		
		Log.i(TAG, "Setting animation");
		danceAnimation = (AnimationDrawable) background.getBackground();
		Log.i(TAG, "dance animation initialized <wth cast");
		danceAnimation.setCallback(background);
		Log.i(TAG, "Setting visible true");
		danceAnimation.setVisible(true, true);
		
	}
	
	
	@Override
	public void onWindowFocusChanged (boolean hasFocus) {
		Log.i(TAG, "Entering hasFocus : "+hasFocus);
		super.onWindowFocusChanged(hasFocus);
		
		if(hasFocus) {
			Log.i(TAG, "Starting animation");
			danceAnimation.start();
		}
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

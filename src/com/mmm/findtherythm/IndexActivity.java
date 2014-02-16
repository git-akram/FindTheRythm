package com.mmm.findtherythm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class IndexActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		
		// Component declaration
		Button buttonJouer = (Button) findViewById(R.id.buttonJouer);
		Button buttonScore = (Button) findViewById(R.id.buttonScore);
		Button buttonQuit = (Button) findViewById(R.id.buttonQuit);
		
		// Handler declaration
		buttonJouer.setOnClickListener(buttonJouerHandler);
		buttonScore.setOnClickListener(buttonScoreHandler);
		buttonQuit.setOnClickListener(buttonQuitHandler);
		
	}
	
	OnClickListener buttonJouerHandler = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(IndexActivity.this, GameActivity.class);
			startActivity(intent);
		}
		
	};
	
	OnClickListener buttonScoreHandler = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Redirect to Score Layout	
		}
		
	};
	
	OnClickListener buttonQuitHandler = new OnClickListener() {
		@Override
		public void onClick(View v) {
			System.exit(0);
		}	
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.index, menu);
		return true;
	}

}

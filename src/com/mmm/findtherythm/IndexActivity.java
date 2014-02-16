package com.mmm.findtherythm;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class IndexActivity extends Activity {
	
	MediaPlayer mMediaPlayer = new MediaPlayer();
	MediaPlayer mMediaPlayer2 = new MediaPlayer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
	

		// Component declaration
		Button buttonJouer = (Button) findViewById(R.id.buttonJouer);
		Button buttonScore = (Button) findViewById(R.id.buttonScore);

		mMediaPlayer2 = MediaPlayer.create(this, R.raw.sound1);
		mMediaPlayer2.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer2.setLooping(true);	
		Button btn = (Button) findViewById(R.id.button1);
		
		// Handler declaration
		buttonJouer.setOnClickListener(buttonJouerHandler);
		buttonScore.setOnClickListener(buttonScoreHandler);
	    btn.setOnClickListener(buttonHandler); 
		
		


	}
	
	OnClickListener buttonHandler = new OnClickListener() {
		@Override
        public void onClick(View v) {
        	//RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayoutid);
        	//rl.setBackgroundResource(R.drawable.op2);
        	 /*  Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
               Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
               r.play();*/
			mMediaPlayer.start();
			
        	
        }
	};

	OnClickListener buttonJouerHandler = new OnClickListener() {

		@Override
		public void onClick(View v) {
			//setContentView(R.layout.activity_game);	
			Intent intent = new Intent(IndexActivity.this, GameActivity.class);
			startActivity(intent);
			
			//mMediaPlayer2.start();
		}

	};

	OnClickListener buttonScoreHandler = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Redirect to Score Layout

		}

	};
	



	
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.index, menu);
		return true;
	}

}
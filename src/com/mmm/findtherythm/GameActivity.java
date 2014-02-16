package com.mmm.findtherythm;


import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;


public class GameActivity extends Activity {
	//private Timer myTimer;
	MediaPlayer mMediaPlayer = new MediaPlayer();
	MediaPlayer mMediaPlayer2 = new MediaPlayer();
	MediaPlayer mMediaPlayer3 = new MediaPlayer();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		Button btn = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		
		configSound();
		mMediaPlayer2.start();
    	oppaDance();
        
		btn.setOnClickListener(buttonHandler);
		btn2.setOnClickListener(buttonHandler2);
		}
		
	OnClickListener buttonHandler = new OnClickListener() {
		@Override
        public void onClick(View v) {
			mMediaPlayer.start();  	
        }
	};
	OnClickListener buttonHandler2 = new OnClickListener() {
		@Override
        public void onClick(View v) {
			mMediaPlayer3.start();  	
        }
	};
	

	public void oppaDance(){
		final RelativeLayout rl = (RelativeLayout) findViewById(R.id.layoutGameid);
        rl.postDelayed(new Runnable() {
            int i = 0;
            public void run() {
            	rl.setBackgroundResource(
                    i++ % 2 == 0 ?
                    		R.drawable.op2 :
                    		R.drawable.op1);
            	rl.postDelayed(this, 500);
            }
        }, 500);
	}
	public void configSound(){
		mMediaPlayer = MediaPlayer.create(this, R.raw.error);
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer.setLooping(false);
		mMediaPlayer.setVolume(100, 100);
		mMediaPlayer3 = MediaPlayer.create(this, R.raw.valid);
		mMediaPlayer3.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer3.setLooping(false);
		mMediaPlayer3.setVolume(100, 100);
		mMediaPlayer2 = MediaPlayer.create(this, R.raw.sound1);
		mMediaPlayer2.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer2.setLooping(true);
		mMediaPlayer.setVolume(20, 20);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}

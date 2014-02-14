package com.mmm.findtherythm.view;

import java.io.InputStream;

import com.mmm.findtherythm.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.os.SystemClock;
import android.view.View;

public class AnimationView extends View{
	
	private Movie myMovie;
	private InputStream myStream;
	private long myMoviestart;
	
	public AnimationView(Context context) {
		super(context);
		myStream = context.getResources().openRawResource(R.drawable.dance);
		myMovie=Movie.decodeStream(myStream);
	}
	
	@Override
    protected void onDraw(Canvas canvas) {
       canvas.drawColor(Color.TRANSPARENT);
       super.onDraw(canvas);
       final long now = SystemClock.uptimeMillis();

       if (myMoviestart == 0) {
          myMoviestart = now;
       }

       final int relTime = (int)((now - myMoviestart) % myMovie.duration());
       myMovie.setTime(relTime);
       myMovie.draw(canvas, this.getWidth()/2-20, this.getHeight()/2-40);
       this.invalidate();
    }

}

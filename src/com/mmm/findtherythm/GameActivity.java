package com.mmm.findtherythm;

//import java.util.Timer;



import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.mmm.findtherythm.controller.Controller;
import com.mmm.findtherythm.model.ButtonRythm;
import com.mmm.findtherythm.model.Model;
import com.mmm.findtherythm.model.Observer;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GameActivity extends Activity implements Observer{
	private static final String TAG = "GameActivity";
	
	ArrayList<ImageView> push;
	int score;
	Controller controlleur;
	int timeout1=0;
	Timer T;
	ButtonRythm enable_button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "start GameActivity");

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		//création des boutons
		Log.i(TAG, "création des boutons");
		push= new ArrayList<ImageView>();
		push.add((ImageView) findViewById(R.id.push1));
		push.add((ImageView) findViewById(R.id.push2));
		push.add((ImageView) findViewById(R.id.push3));
		push.add((ImageView) findViewById(R.id.push4));
		push.add((ImageView) findViewById(R.id.push5));
		
		//Intialisation du controlleur
		Log.i(TAG, "ajout de l'observateur");
		Model m = Factory.getInstance().getModel();
		m.addObserver(this);
		
		
		Log.i(TAG, "ajout du controlleur");
		controlleur = Factory.getInstance().getController();
		if(controlleur == null)
			Log.i(TAG, "controlleur null");
		//affectation des listeners
		for(int i=0; i<push.size(); i++)
			push.get(i).setOnClickListener(pushBouton);
		//Initialisation du score 
		//score = 0;
		T=new Timer();
		T.schedule(new TimerTask() {         
		        @Override
		        public void run() {
		            runOnUiThread(new Runnable()
		            {
		                @Override
		                public void run()
		                {
		                    //myTextView.setText("count="+count);
		                    timeout1++;                
		                }
		            });
		        }
		    }, 300000);
		

		
	}

	OnClickListener pushBouton = new OnClickListener() {
	
		@Override
		public void onClick(View boutonPushed) {
			// TODO Auto-generated method stub
			Log.i(TAG, "onClick button");
			for(int i=0; i< push.size(); i++){
				//Je cherche la correpondance du bouton cliqué dans la liste des views
				if(boutonPushed.getId() == push.get(i).getId())
				{
					//si on clique sur le bon bouton
					if(i == enable_button.getId()){
						if(timeout1 < 300000){
							controlleur.clickSuccessAction();
							T.cancel();
							timeout1 = 0;
						}
						else
							controlleur.clickFailAction();
						
					}
						
					//si on ne clique pas sur le bon bouton
					else
						controlleur.clickFailAction();
					break;
				}
				
			}
			
					
		}
		
	};
	
	public void Jouer()
	{
		//création des timeout
		/*Timer T=new Timer();
		T.schedule(new TimerTask() {         
		        @Override
		        public void run() {
		            runOnUiThread(new Runnable()
		            {
		                @Override
		                public void run()
		                {
		                    //myTextView.setText("count="+count);
		                    timeout1++;                
		                }
		            });
		        }
		    }, 300000);*/
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public void update(Model model) {
		Log.i(TAG, "update");
		updatePush(model);
		updateSound(model);
		updateGraphic(model);
		Log.i(TAG, "fin update");
	}
	
	private void updateGraphic(Model model) {
		
		
	}

	private void updateSound(Model model) {
		// TODO Auto-generated method stub
		
	}

	private void updatePush(Model model) {
		ArrayList<ButtonRythm> listBouton= model.getButtonRythm();
		for(int i=0; i<listBouton.size(); i++){
			Log.i(TAG, "push("+i+") = "+listBouton.get(i).getState());
			if(listBouton.get(i).getState() == true){
				push.get(i).setImageResource(R.drawable.button_green);
				enable_button = listBouton.get(i);
				//push.get(i).setBackgroundResource(R.drawable.button_green);
			}
			else
				push.get(i).setImageResource(R.drawable.button_red);
				//push.get(i).setBackgroundResource(R.drawable.button_red);
			
		}
		score = model.getScore();
		T.schedule(new TimerTask() {         
	        @Override
	        public void run() {
	            runOnUiThread(new Runnable()
	            {
	                @Override
	                public void run()
	                {
	                    //myTextView.setText("count="+count);
	                    timeout1++;                
	                }
	            });
	        }
	    }, 300000);
	}

}

package com.mmm.findtherythm;

//import java.util.Timer;



import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.mmm.findtherythm.controller.Controller;
import com.mmm.findtherythm.model.ButtonRythm;
import com.mmm.findtherythm.model.Model;
import com.mmm.findtherythm.model.Observer;
import com.mmm.findtherythm.view.AnimationView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class GameActivity extends Activity implements Observer{
	
	ArrayList<ImageView> push;
	int score;
	Controller controlleur;
	Timer timeout1; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("createGame");
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_game);
		
		AnimationView view = new AnimationView(this); 
		setContentView(view);
		
		//création des boutons
		push= new ArrayList<ImageView>();
		
		push.add((ImageView) findViewById(R.id.push1));
		push.add((ImageView) findViewById(R.id.push2));
		push.add((ImageView) findViewById(R.id.push3));
		push.add((ImageView) findViewById(R.id.push4));
		push.add((ImageView) findViewById(R.id.push5));
		
		//Intialisation du controlleur
		Factory.getInstance().getModel().addObserver(this);
		controlleur = Factory.getInstance().getController();
		
		
		
		//affectation des listeners
		for(int i=0; i<push.size(); i++)
			push.get(i).setOnClickListener(pushBouton);
		//Initialisation du score 
		score = 0;
		
		//création des timeout
		//timeout1 = new Timer();
		Factory.getInstance().getController().startGameAction();
	}

	OnClickListener pushBouton = new OnClickListener() {
	
		@Override
		public void onClick(View push) {
			// TODO Auto-generated method stub
			System.out.println("click");
			controlleur.clickSuccessAction();
		}
		
	};
	
	
	
	private void jouer()
	{
		while(true)
		{
			
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
		//parcours la liste des bouton 
		//si le bouton est true faire l'image success
		//si le bouton est false faire l'image failed
		// recharger le score
		ArrayList<ButtonRythm> listBouton= model.getButtonRythm();
			for(int i=0; i<listBouton.size(); i++){
				if(listBouton.get(1).getState() == true)
					push.get(i).setBackgroundResource(R.drawable.button_green);
				else
					push.get(i).setBackgroundResource(R.drawable.button_green);
			}
		
		score = model.getScore();
				
		
	}

}

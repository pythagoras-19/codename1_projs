/**
 * Game instantiates GameWorld() and gives the ability for user input to play the game.
 */

package com.mycompany.a1;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 

public class Game extends Form {
	
	private GameWorld gw;

	public Game() {
		// TODO Auto-generated constructor stub
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	public void play() {
		// TODO display using text fields  -- in appendix
		 Label myLabel=new Label("Enter a Command:"); 
		 this.addComponent(myLabel); 
		 final TextField myTextField=new TextField(); 
		 this.addComponent(myTextField); 
		 this.show(); 
		 
		 myTextField.addActionListener(new ActionListener(){ 
			 
			 public void actionPerformed(ActionEvent evt) { 
				 
				  String sCommand=myTextField.getText().toString(); 
				  myTextField.clear(); 
				  /**
				   * Getting user input to tell the GameWorld how to update.
				   */
				  if(sCommand.length() != 0) 
					  switch (sCommand.charAt(0)) { 
					  	case 'a': 
					  		System.out.println("Accelerate is applied!");
					  		gw.accelerate();  
					  		break;  
					  	case 'y':
					  		System.out.println("Exit confirmed!");
					  		System.exit(0);
					  	case 'n':
					  		System.out.println("Exit not confirmed!");
					  		break;
					  	case 'm':
					  		System.out.println("Map is applied!");
					  		gw.map();
					  		break;
					  	case 't':
					  		System.out.println("Tick is applied!");
					  		gw.tick();
					  		break;
					  	case 'b':
					  		System.out.println("Brake is applied!");
					  		gw.brake();
					  		break;
					  	case 'd':
					  		System.out.println("Display!");
					  		gw.display();
					  		break;
					  	case 'l':
					  		System.out.println("Changing heading of ant 5 degrees left!");
					  		gw.left();
					  		break;
					  	case 'r':
					  		System.out.println("Changing heading of ant 5 degrees right!");
					  		gw.right();
					  		break;
					  	case 'f':
					  		System.out.println("Collided with a FoodStation!");
					  		gw.collidedFoodStation();
					  		break;
					  	case 'g':
					  		System.out.println("Spider collided/gotten the Ant!");
					  		gw.collidedSpider();
					  		if (gw.getAntLivesLeft() == 0) {
					  			System.exit(0);
					  		}
					  		break;
					  	case 'x':
					  		System.out.println("Exit is applied!");
					  		gw.exit();
					  		break;
					  	case '1':
					  		System.out.println("Collided with flag 1!");
					  		gw.collidedFlag(1);
					  		break;
					  	case '2':
					  		System.out.println("Collided with flag 2!");
					  		gw.collidedFlag(2);
					  		break;
					  	case '3':
					  		System.out.println("Collided with flag 3!");
					  		gw.collidedFlag(3);
					  		break;
					  	case '4':
					  		System.out.println("Collided with flag 4!");
					  		gw.collidedFlag(4);
					  		break;
					  	case '5':
					  		System.out.println("Collided with flag 5!");
					  		gw.collidedFlag(5);
					  		break;
					  	case '6':
					  		System.out.println("Collided with flag 6!");
					  		gw.collidedFlag(6);
					  		break;
					  	case '7':
					  		System.out.println("Collided with flag 7!");
					  		gw.collidedFlag(7);
					  		break;
					  	case '8':
					  		System.out.println("Collided with flag 8!");
					  		gw.collidedFlag(8);
					  		break;
					  	case '9':
					  		System.out.println("Collided with flag 9!");
					  		gw.collidedFlag(9);
					  		break;
					  	default:
					  		System.out.println("Unrecognized input! Try again.");
					  		break;
					  	
					  } //switch 
			 } //actionPerformed 
		  } //new ActionListener() 
		 ); //addActionListener 
	} //play 
}

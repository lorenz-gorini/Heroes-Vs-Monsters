package heroes.animation;

import heroes.components.Account;
import heroes.components.Hero;
import heroes.components.Monster;
import heroes.components.Warrior;
import heroes.components.Wizard;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CharacterBtnClick implements EventHandler<MouseEvent>{
	Scene fightSc,enemySc;
	Stage window;
	Account user;
	Hero player;
	Monster enemy;
	public CharacterBtnClick(Stage window, Account user, Hero player, Monster enemy) {
		super();
		this.window = window;
		this.user = user;
		this.player = player;
		this.enemy = enemy;
	}
	public void handle(MouseEvent event) { 
  	  //TODO FROM INTERNET:
  	  //Suggested to redefine the method setOnMouseClicked in order to accept 
  	  //another argument like pickedHero (I don't think i is a good argument 
  	  //since the event happens after the loop is terminated)
  	  
  	  //Depending from the type chosen, I create the instance of pickedHero
	  	if (((CharacImage)event.getSource()).getImageChar() instanceof Warrior)
	  		  Main.setPlayer(new Warrior());
	  	else if (((CharacImage)event.getSource()).getImageChar() instanceof Wizard)
	  		Main.setPlayer(new Wizard());
	  	//Copy the value of the source clicked
	  	Main.setPlayer((Hero)(((CharacImage)event.getSource()).getImageChar()));  
	  	//TODO Control the Hero parsing because it may not be possible 
	  	//if it is not instantiated as Hero
	  	
	  	//it runs the two scenes from inside the event, in order to do something 
	  	//only once it received the value of the Hero, based on the click
	  	fightSc=Main.getGame().fight(user,window);
		enemySc=Main.getGame().showEnemy(enemy, window, fightSc);
		
	  	window.setScene(this.enemySc); 
	    window.show();
    }
	public Scene getFightSc() {
		return fightSc;
	}
	public void setFightSc(Scene fightSc) {
		this.fightSc = fightSc;
	} 
}

package heroes.animation;
	
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import heroes.components.Account;
import heroes.components.Hero;
import heroes.components.Monster;
import heroes.components.Sorcerer;
import heroes.components.Vampire;
import heroes.components.Warrior;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;


public class Main extends Application {
	/*
	 * I press space bar or click to pass the welcomeScene (title)
	 * loginScene to enter the user and password
	 * characterScene to choose your character
	 * fightScene to 
	 */
	Scene welcomeSc,loginSc,characterSc;
	private static Game f;
	public static Game getGame() {
		if (f == null)
			{
			  f = new Game();
			}
		return f; 
	}
	private static Hero player;
	private static Monster enemy;
	private static DisplayData show;
	public static DisplayData getDisplayData() {
		if (show == null)
			{
			  show = new DisplayData();
			}
		return show; 
	}
	@Override
	public void start(Stage window) throws IOException,Exception {
		
		//Declare variables in order to use the methods defined in the other files
		show=new DisplayData();
		f = new Game();
		
		//Populate the monsters List
		ArrayList<Monster> monsterList = new ArrayList<>();
		monsterList.add( new Sorcerer("Colui che non deve essere nominato"));
		monsterList.add( new Vampire("Dracula"));
		monsterList.add( new Vampire("The Dark Fly","darkFly.png"));
		monsterList.add( new Sorcerer("Nosferatu"));
		monsterList.add( new Sorcerer("Nonna", "Nonna.gif")); 
		
		//Declare variables for the game
		Account user=new Account(); 
		Main.setEnemy(f.pickAMonster(monsterList));
		
		//Create scene for everything
		characterSc=show.chooseCharacter(player,window,user,enemy);
		loginSc=show.userLogin(user,window,characterSc);
		
	//	AttackAnimation attAnim=new AttackAnimation();
		//ImageView playervsmonster=attAnim.attackMonsterAnimation(player,enemy);
		
		
	
	    //Setting title to the Stage 
	    window.setTitle("Libera Moena"); 
	    //Adding scene to the stage 
	    window.setScene(loginSc); 
	    //Displaying the contents of the stage 
	    window.show(); 
	    window.setFullScreen(true);
		
 }      
	
	public static Monster getEnemy() {
		return enemy;
	}

	public static void setEnemy(Monster enemy) {
		Main.enemy = enemy;
	}

	public static Hero getPlayer() {
		return player;
	}

	public static void setPlayer(Hero player) {
		Main.player = player;
	}

	public static void main(String[] args) throws IOException {
		launch(args);
	}
}

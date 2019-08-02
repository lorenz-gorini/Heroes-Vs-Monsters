
import heroes.components.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameOLD {
	
	/**
	 * This class is related to the game:
	 * this means it picks the enemies, shows them 
	 * and then it allows the real fight against them
	 */
	Random rnd=new Random();
	Scene enemySc,fightSc;
	Account user;
	Hero player;
	Monster enemy;
	public GameOLD(Random rnd, Scene enemySc, Scene fightSc, Account user, Hero player,Monster enemy) {
		super();
		this.rnd = rnd;
		this.enemySc = enemySc;
		this.fightSc = fightSc;
		this.user = user;
	}
	public GameOLD() {}
	public Monster pickAMonster(ArrayList<Monster> monsterList) {
		return monsterList.get(rnd.nextInt(monsterList.size()));
	}
	public Scene fight(Account userInput, Stage windowInput) {
		//Copy the static variable from the Main to this class
		this.player=Main.getPlayer();
		this.enemy=Main.getEnemy();
		//BorderPane to put everything in the middle
		BorderPane bPane = new BorderPane(); 
		bPane.setPadding(new Insets(20,20,20,20));
		 
		//Creating a Grid Pane 
  		GridPane upperGridPane = new GridPane();    
  	      
  	    //Setting size for the pane 
  	    upperGridPane.setMinSize(100, 100); 
  	    //Setting the padding  
  	    upperGridPane.setPadding(new Insets(10, 10, 10, 10)); 
  	    //Setting the vertical and horizontal gaps between the columns 
  	    upperGridPane.setVgap(15); 
  	    upperGridPane.setHgap(15);   
  	    upperGridPane.setLayoutX(200);
  	    upperGridPane.setLayoutY(200);
  	    upperGridPane.setAlignment(Pos.CENTER); 
  	    
		//Creating a Grid Pane 
		GridPane lowerGridPane = new GridPane();    
	      
	    //Setting size for the pane 
	    lowerGridPane.setMinSize(100, 100); 
	    //Setting the padding  
	    lowerGridPane.setPadding(new Insets(10, 10, 10, 10)); 
	    //Setting the vertical and horizontal gaps between the columns 
	    lowerGridPane.setVgap(15); 
	    lowerGridPane.setHgap(15);   
	    lowerGridPane.setLayoutX(200);
	    lowerGridPane.setLayoutY(200);
	    lowerGridPane.setAlignment(Pos.CENTER); 
	    
	    //Creating a Grid Pane 
  		GridPane totalGridPane = new GridPane();    
  	      
  	    //Setting size for the pane 
  		totalGridPane.setMinSize(100, 100); 
  	    //Setting the padding  
  		totalGridPane.setPadding(new Insets(10, 10, 10, 10)); 
  	    //Setting the vertical and horizontal gaps between the columns 
  		totalGridPane.setVgap(15); 
  		totalGridPane.setHgap(15);   
  		totalGridPane.setLayoutX(200);
  		totalGridPane.setLayoutY(200);
  		totalGridPane.setAlignment(Pos.CENTER); 
	    /*
	     * FIRST ROW
	     */
	    DropShadow ds = new DropShadow();
	    ds.setOffsetY(3.0f);
	    ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
	    
	    Text sceneTitle = new Text("LET'S FIGHT!");
	    sceneTitle.setFont(Font.font ("Verdana", 30));
	    sceneTitle.setFill(Color.RED);
	    sceneTitle.setEffect(ds);

	    Text playerPoints = new Text(new Integer(player.getHealthPoints()).toString());
	    playerPoints.setFont(Font.font ("Verdana", 30));
	    playerPoints.setFill(Color.RED);
	    
	    
	    Text monsterPoints = new Text(new Integer(enemy.getHealthPoints()).toString());
	    monsterPoints.setFont(Font.font ("Verdana", 30));
	    monsterPoints.setFill(Color.RED);
	    
	    Text playerTitle = new Text("Player");
	    playerTitle.setFont(Font.font ("Verdana", 30));
	    playerTitle.setFill(Color.RED);
	    
	    Text monsterTitle = new Text("Monster");
	    monsterTitle.setFont(Font.font ("Verdana", 30));
	    monsterTitle.setFill(Color.RED);
	    
	    CharacImage heroImage = new CharacImage();
	    heroImage=DisplayData.showBigImage(player);
	    
	    CharacImage monsterImage = new CharacImage();
	    monsterImage=DisplayData.showBigImage(enemy);
	    
	    /*		Let's Fight
	     * 1ST GRID:
	     *   player1		LIFEPOINTS		LIFEPOINTS		player2
	     *   				IMAGE			IMAGE	
	     * 2ND GRID:		
	     *   EQUIPMENT 										EQUIPMENT
	     *   1.numbered and you 		TEXT OF WHAT IS 
	     *   2.can choose by 			HAPPENING
	     *   3.typing					CENTERED
	     *   gridPane 2x1(above gridPane 1x4,
	     *   Below I create another gridPane 1x3)
	     *   
	     *   The player can save only at the end of the single fight.
	     */
	    
	    /*
	     * SECOND ROW for equipment
	     */
	    Text story = new Text();  //TODO Come vado a capo??!?!???!?!
	    story.setText("Welcome");
	    
	    /*
	     * Now I want to organize I TURNI of the match.
	     * Particulary, I will do a cycle where everytime I call enemy's attack (easy)
	     * and I listen to the user for the attack choice: until there is no response the program must wait.
	     * There is a KeyListener that shoud do the job. Is it possible? I could also set a timer 
	     * and after 4 seconds (let him think and read the enemy's attack) the user must decide:
	     * TimeUnit.SECONDS.sleep(4);
	     */
	    //_--------------------------------------------
	    
	    
	    //-----------------------------------------------------------------
	    //KeyListener
	    
	    
	    //ARRANGING ALL THE NODES in the grid 
	    upperGridPane.add(playerTitle, 0, 0);
	    upperGridPane.add(playerPoints, 1, 0);
	    upperGridPane.add(monsterPoints, 2, 0);
	    upperGridPane.add(monsterTitle, 3, 0);
	    upperGridPane.add(heroImage, 1, 1);
	    upperGridPane.add(monsterImage, 2, 1);
	    
	    lowerGridPane.add(story, 1, 0);
	    totalGridPane.add(upperGridPane, 0, 0);
	    totalGridPane.add(lowerGridPane, 0, 1);
	    bPane.setTop(sceneTitle);
	    bPane.setCenter(totalGridPane); 
	    
	    //Creating a scene object 
	    fightSc = new Scene(bPane,1800,950); 
		return fightSc;
	}
//	Trying to get some effects, linear gradients, ...
//    FROM CSS
//    sceneTitle.setId("titlefightSc");
//    FROM OTHERS
//    ColorInput effect = new ColorInput();
//    effect.setPaint(new LinearGradient(0, 0, 150, 150, true, CycleMethod.REPEAT, new Stop[] {
//                    new Stop(0, Color.RED),
//                    new Stop(1, Color.GREEN),
//                }));
//    bPane.setEffect(effect);
    
//    // object bounding box relative (proportional = true)
//    Stop[] stops = new Stop[] { new Stop(0, Color.GREEN), new Stop(1, Color.BLUE)};
//    LinearGradient lg1 = new LinearGradient(0, 0, fightSc.getWidth(), fightSc.getHeight(), true, CycleMethod.NO_CYCLE, stops);

	public Scene showEnemy(Monster enemy, Stage window, Scene fightSc) {
		//BorderPane to put everything in the middle
		BorderPane bPane = new BorderPane(); 
		bPane.setPadding(new Insets(20,20,20,20));
		//Creating a Grid Pane 
		GridPane gridPane = new GridPane();    
	      
	    //Setting size for the pane 
	    gridPane.setMinSize(1200, 700); 
	    //Setting the padding  
	    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
	    //Setting the vertical and horizontal gaps between the columns 
	    gridPane.setVgap(15); 
	    gridPane.setHgap(15);   
	    gridPane.setLayoutX(200);
	    gridPane.setLayoutY(200);
	    gridPane.setAlignment(Pos.CENTER); 
	    
	    CharacImage enemyImage = Main.show.showBigImage(enemy);
	    StartFightKeyEv fightKey=new StartFightKeyEv(fightSc, window);
	    
    	Label instruction= new Label("You selected "+Main.getPlayer().getName()
    		+ "/n Get ready to fight against "+enemyImage.getImageChar().toString());
    	
	    Label enemyTitle=new Label(enemyImage.getImageChar().toString());
	    Label enemyEquipment = new Label(enemy.equipmentToString());
	    Label goFightLabel = new Label("Press Enter or Space bar to start fighting...");
	    
	    //Arranging all the nodes in the grid 
	    bPane.setTop(instruction);
	    
	    gridPane.add(enemyImage,1, 0); 
	    gridPane.add(enemyTitle, 1, 1); 
	    gridPane.add(enemyEquipment, 1, 2);
	    gridPane.add(goFightLabel, 1,3);
	    
	    bPane.setCenter(gridPane); 
	     
	    //Creating a scene object 
	    enemySc = new Scene(bPane,1280,720); 
	    enemySc.setOnKeyPressed(fightKey);
	    
		return enemySc;
	}
	private void attack() {
		
	}
}

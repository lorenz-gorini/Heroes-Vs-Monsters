package heroes.animation;
import heroes.components.*;
import javafx.animation.AnimationTimer;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game {
	
	/**
	 * This class is related to the game:
	 * this means it picks the enemies, shows them 
	 * and then it allows the real fight against them
	 */
	Random random=new Random();
	
	Account user;
	Hero player;
	Monster enemy;
	static int selectedEquip;
	
	Scene enemySc,fightSc;
	private static ObservableList<String> story = FXCollections.observableArrayList();
	
	private boolean readyToAttack = true;
    private static final double ATTACK_DELAY = 2d; //3 seconds (d=double number) delay
    
	public Game(Random rnd, Scene enemySc, Scene fightSc, Account user, Hero player,Monster enemy) {
		super();
		random = new Random();
		this.random = rnd;
		this.enemySc = enemySc;
		this.fightSc = fightSc;
		this.user = user;
	}
	public Game() {super(); random = new Random(); story.add("Welcome \n");}
	public Monster pickAMonster(ArrayList<Monster> monsterList) {
		return monsterList.get(random.nextInt(monsterList.size()));
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
  	    upperGridPane.setMinSize(1500, 400); 
  	    //Setting the padding  
  	    upperGridPane.setPadding(new Insets(10, 10, 10, 10)); 
  	    //Setting the horizontal gaps between the columns 
  	    upperGridPane.setHgap(40);   
  	    //upperGridPane.setLayoutX(200);
  	    //upperGridPane.setLayoutY(200);
  	    upperGridPane.setAlignment(Pos.CENTER); 
	    upperGridPane.setGridLinesVisible(true);
  	    
		//Creating a Grid Pane 
		GridPane lowerGridPane = new GridPane();    
	      
	    //Setting size for the pane 
	    lowerGridPane.setMinSize(1500, 400); 
	    //Setting the padding  
	    lowerGridPane.setPadding(new Insets(10, 10, 10, 10)); 
	    //Setting the vertical and horizontal gaps between the columns  
	    lowerGridPane.setHgap(120);   
	    lowerGridPane.setLayoutX(200);
	    lowerGridPane.setLayoutY(200);
	    lowerGridPane.setAlignment(Pos.CENTER); 
	    lowerGridPane.setGridLinesVisible(true);
	    
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
	     * UPPER TABLE
	     */
	    
	    
	    //TITLE AND TRANSITION
	    Text sceneTitle = new Text("LET'S FIGHT!");
	    sceneTitle.setFont(Font.font ("Verdana", 30));
	    sceneTitle.setFill(Color.RED);
	    DropShadow ds = new DropShadow();
	    ds.setOffsetY(3.0f);
	    ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
	    sceneTitle.setEffect(ds);
	    sceneTitle.setTextAlignment(TextAlignment.CENTER);
	    FillTransition ft = new FillTransition(Duration.millis(3000), sceneTitle, Color.RED, Color.BLUE);
	    ft.setCycleCount(1);
	    ft.play();
	   
	    Text playerPoints = new Text(new Integer(player.getHealthPoints()).toString());
	    playerPoints.setFont(Font.font ("Verdana", 30));
	    //playerPoints.setFill(ft);
	    
	    
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
	    heroImage=DisplayData.showBigImage(player,100,100);
	    
	    CharacImage monsterImage = new CharacImage();
	    monsterImage=DisplayData.showBigImage(enemy,100,100);
	    
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
	     * LOWER TABLE for equipment
	     */
	    
	    Text enemyEquipText = new Text();  
	    enemyEquipText.setText(enemy.equipmentToString());
	    
	    Text playerEquipText = new Text(); 
	    playerEquipText.setText(player.equipmentToString());
	    /*
	     * Now I want to organize the rounds of the match.
	     * Particulary, I will do a cycle where everytime I call enemy's attack (easy)
	     * and I listen to the user for the attack choice: until there is no response the program must wait.
	     * There is a KeyListener that shoud do the job. Is it possible? I could also set a timer 
	     * and after 4 seconds (let him think and read the enemy's attack) the user must decide:
	     * TimeUnit.SECONDS.sleep(4);
	     */
	    
	    /*
	     * KEY LISTENER :
	     * all the scene listens to the key pressed to start the attack based on what you press
	     * 
	     * do{} while:
	     * during the loop I want to redraw/setText of the player and enemy LifePoints
	     */
	    
	    
	    Game.setStory("TEST\n");
	    lowerGridPane.add(Game.getStory(), 1, 0);
	    fightSc.setOnKeyPressed(new EventHandler<KeyEvent>() {
	    	@Override
            public void handle(KeyEvent ke) {
                try {
	            	selectedEquip=Integer.parseInt(ke.getCharacter());
	        		int i=0;
	        		if (selectedEquip<Main.getPlayer().getEquipment().size()) {
		        				singleAttack(selectedEquip, playerPoints, monsterPoints, upperGridPane, lowerGridPane);
	        			} 
	        		else Game.setStory("That was not a valid number!");
                } catch (NumberFormatException e) {
                	Game.setStory("That was not a valid number!");
                }
                lowerGridPane.add(Game.getStory(), 1, 0);
        		//TODO in realtà il secondo argomento di specialAttack si aspetta solo l'indice dell'arma, 
        		//però io potrei anche passargli tutta l'arma, anche se in effetti l'elenco di armi lui 
        		//la conosce attraverso l'oggetto che chiama il metodo specialAttact, cioè player.specialAttack
           
            }
        });
	    
	    //Creating a scene object 
	    fightSc = new Scene(bPane,1920,1080);
	    
	    //ARRANGING ALL THE NODES in the grid 
	    upperGridPane.add(playerTitle, 0, 0);
	    upperGridPane.add(playerPoints, 1, 0);
	    upperGridPane.add(monsterPoints, 2, 0);
	    upperGridPane.add(monsterTitle, 3, 0);
	    upperGridPane.add(heroImage, 1, 1);
	    upperGridPane.add(monsterImage, 2, 1);
	    
	    lowerGridPane.add(Game.getStory(), 1, 0);
	    lowerGridPane.add(playerEquipText,0,0);
	    lowerGridPane.add(enemyEquipText,2,0);
	    totalGridPane.add(upperGridPane, 0, 0);
	    totalGridPane.add(lowerGridPane, 0, 1);
	    bPane.setTop(sceneTitle);
	    bPane.setCenter(totalGridPane); 
	    
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
	    
	    CharacImage enemyImage = Main.getDisplayData().showBigImage(enemy,500,500);
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
	
    public void singleAttack(int selectedEquip,Text playerPoints,Text monsterPoints,
    									GridPane upperGridPane,	GridPane lowerGridPane) {
        if(readyToAttack) {
  
    		readyToAttack = false;
            //PLAYER ATTACK
    		Game.setStory(Main.getPlayer().specialAttack(Main.getEnemy(), selectedEquip));
    		upperGridPane.add(monsterPoints, 2, 0);
            lowerGridPane.add(Game.getStory(), 1, 0);
    		//ENEMY ATTACK
        	Game.setStory(Main.getEnemy().specialAttack(Main.getPlayer(), random.nextInt(Main.getEnemy().getEquipment().size())));
    		System.out.println("hit!");
    		upperGridPane.add(playerPoints, 1, 0);
            lowerGridPane.add(Game.getStory(), 1, 0);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(ATTACK_DELAY),
                e -> readyToAttack = true);
            Timeline reloadAttack = new Timeline(keyFrame);
            reloadAttack.play();
	        if (enemy.getHealthPoints()>0 && player.getHealthPoints()>0) { 	} 
	        else 
	        	if (enemy.getHealthPoints()<=0) {
		        	readyToAttack=false; 
		        	System.out.println("You defeated the enemy! Well Done!");}
				else {
					readyToAttack=false; 
					System.out.println("You have been defeated! YOU LOSE! Close the window to exit");
			}
        	//TODO This is the end of the single fight where you should go back and find another monster!
        	//(they could be randomly spread out on the grass every time, but maybe lowering in number-- !)
        }
    }
	public static ObservableList<String> getStory() {
		return story;
	}
	public static void setStory(String text) {
		Game.story.setText(Game.getStory()+"\n"+text+"\n");
	}
	
}




========================================================================================
GAME OLD


package heroes.animation;
import heroes.components.*;
import javafx.animation.AnimationTimer;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game {
	
	/**
	 * This class is related to the game:
	 * this means it picks the enemies, shows them 
	 * and then it allows the real fight against them
	 */
	Random random=new Random();
	
	Account user;
	Hero player;
	Monster enemy;
	static int selectedEquip;
	
	Scene enemySc,fightSc;
	static Label story;
	
	private boolean readyToAttack = true;
    private static final double ATTACK_DELAY = 2d;
    
	public Game(Random rnd, Scene enemySc, Scene fightSc, Account user, Hero player,Monster enemy) {
		super();
		random = new Random();
		this.random = rnd;
		this.enemySc = enemySc;
		this.fightSc = fightSc;
		this.user = user;
	}
	public Game() {super(); random = new Random(); story=new Label(); story.setText("Welcome \n");}
	public Monster pickAMonster(ArrayList<Monster> monsterList) {
		return monsterList.get(random.nextInt(monsterList.size()));
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
  	    upperGridPane.setMinSize(1500, 400); 
  	    //Setting the padding  
  	    upperGridPane.setPadding(new Insets(10, 10, 10, 10)); 
  	    //Setting the horizontal gaps between the columns 
  	    upperGridPane.setHgap(40);   
  	    //upperGridPane.setLayoutX(200);
  	    //upperGridPane.setLayoutY(200);
  	    upperGridPane.setAlignment(Pos.CENTER); 
	    upperGridPane.setGridLinesVisible(true);
  	    
		//Creating a Grid Pane 
		GridPane lowerGridPane = new GridPane();    
	      
	    //Setting size for the pane 
	    lowerGridPane.setMinSize(1500, 400); 
	    //Setting the padding  
	    lowerGridPane.setPadding(new Insets(10, 10, 10, 10)); 
	    //Setting the vertical and horizontal gaps between the columns  
	    lowerGridPane.setHgap(120);   
	    lowerGridPane.setLayoutX(200);
	    lowerGridPane.setLayoutY(200);
	    lowerGridPane.setAlignment(Pos.CENTER); 
	    lowerGridPane.setGridLinesVisible(true);
	    
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
	     * UPPER TABLE
	     */
	    
	    
	    //TITLE AND TRANSITION
	    Text sceneTitle = new Text("LET'S FIGHT!");
	    sceneTitle.setFont(Font.font ("Verdana", 30));
	    sceneTitle.setFill(Color.RED);
	    DropShadow ds = new DropShadow();
	    ds.setOffsetY(3.0f);
	    ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
	    sceneTitle.setEffect(ds);
	    sceneTitle.setTextAlignment(TextAlignment.CENTER);
	    FillTransition ft = new FillTransition(Duration.millis(3000), sceneTitle, Color.RED, Color.BLUE);
	    ft.setCycleCount(1);
	    ft.play();
	   
	    Text playerPoints = new Text(new Integer(player.getHealthPoints()).toString());
	    playerPoints.setFont(Font.font ("Verdana", 30));
	    //playerPoints.setFill(ft);
	    
	    
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
	    heroImage=DisplayData.showBigImage(player,100,100);
	    
	    CharacImage monsterImage = new CharacImage();
	    monsterImage=DisplayData.showBigImage(enemy,100,100);
	    
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
	     * LOWER TABLE for equipment
	     */
	    
	    Text enemyEquipText = new Text();  
	    enemyEquipText.setText(enemy.equipmentToString());
	    
	    Text playerEquipText = new Text(); 
	    playerEquipText.setText(player.equipmentToString());
	    /*
	     * Now I want to organize the rounds of the match.
	     * Particulary, I will do a cycle where everytime I call enemy's attack (easy)
	     * and I listen to the user for the attack choice: until there is no response the program must wait.
	     * There is a KeyListener that shoud do the job. Is it possible? I could also set a timer 
	     * and after 4 seconds (let him think and read the enemy's attack) the user must decide:
	     * TimeUnit.SECONDS.sleep(4);
	     */
	    
	    /*
	     * KEY LISTENER :
	     * all the scene listens to the key pressed to start the attack based on what you press
	     * 
	     * do{} while:
	     * during the loop I want to redraw/setText of the player and enemy LifePoints
	     */
	    //Creating a scene object 
	    fightSc = new Scene(bPane,1920,1080);
	    
	    //ARRANGING ALL THE NODES in the grid 
	    upperGridPane.add(playerTitle, 0, 0);
	    upperGridPane.add(playerPoints, 1, 0);
	    upperGridPane.add(monsterPoints, 2, 0);
	    upperGridPane.add(monsterTitle, 3, 0);
	    upperGridPane.add(heroImage, 1, 1);
	    upperGridPane.add(monsterImage, 2, 1);
	    
	    lowerGridPane.add(Game.getStory(), 1, 0);
	    lowerGridPane.add(playerEquipText,0,0);
	    lowerGridPane.add(enemyEquipText,2,0);
	    totalGridPane.add(upperGridPane, 0, 0);
	    totalGridPane.add(lowerGridPane, 0, 1);
	    bPane.setTop(sceneTitle);
	    bPane.setCenter(totalGridPane); 
	    
	    Game.setStory("TEST\n");
	    lowerGridPane.add(Game.getStory(), 1, 0);
	    fightSc.setOnKeyPressed(new EventHandler<KeyEvent>() {
	    	@Override
            public void handle(KeyEvent ke) {
                try {
	            	selectedEquip=Integer.parseInt(ke.getCharacter());
	        		int i=0;
	        		if (selectedEquip<Main.getPlayer().getEquipment().size()) {
		        				singleAttack(selectedEquip, playerPoints, monsterPoints, upperGridPane, lowerGridPane);
	        			} 
	        		else Game.setStory("That was not a valid number!");
                } catch (NumberFormatException e) {
                	Game.setStory("That was not a valid number!");
                }
                lowerGridPane.add(Game.getStory(), 1, 0);
        		//TODO in realtà il secondo argomento di specialAttack si aspetta solo l'indice dell'arma, 
        		//per? io potrei anche passargli tutta l'arma, anche se in effetti l'elenco di armi lui 
        		//la conosce attraverso l'oggetto che chiama il metodo specialAttact, cioè player.specialAttack
           
            }
        });
	    

	    
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
	    
	    CharacImage enemyImage = Main.getDisplayData().showBigImage(enemy,500,500);
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
	
    public void singleAttack(int selectedEquip,Text playerPoints,Text monsterPoints,
    									GridPane upperGridPane,	GridPane lowerGridPane) {
        if(readyToAttack) {
  
    		readyToAttack = false;
            //PLAYER ATTACK
    		Game.setStory(Main.getPlayer().specialAttack(Main.getEnemy(), selectedEquip));
    		upperGridPane.add(monsterPoints, 2, 0);
            lowerGridPane.add(Game.getStory(), 1, 0);
    		//ENEMY ATTACK
        	Game.setStory(Main.getEnemy().specialAttack(Main.getPlayer(), random.nextInt(Main.getEnemy().getEquipment().size())));
    		System.out.println("hit!");
    		upperGridPane.add(playerPoints, 1, 0);
            lowerGridPane.add(Game.getStory(), 1, 0);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(ATTACK_DELAY),
                e -> readyToAttack = true);
            Timeline reloadAttack = new Timeline(keyFrame);
            reloadAttack.play();
	        if (enemy.getHealthPoints()>0 && player.getHealthPoints()>0) { 	} 
	        else 
	        	if (enemy.getHealthPoints()<=0) {
		        	readyToAttack=false; 
		        	System.out.println("You defeated the enemy! Well Done!");}
				else {
					readyToAttack=false; 
					System.out.println("You have been defeated! YOU LOSE! Close the window to exit");
			}
        	//TODO This is the end of the single fight where you should go back and find another monster!
        	//(they could be randomly spread out on the grass every time, but maybe lowering in number-- !)
        }
    }
	public static Label getStory() {
		return story;
	}
	public static void setStory(String text) {
		Game.story.setText(Game.getStory()+"\n"+text+"\n");
	}
	
}









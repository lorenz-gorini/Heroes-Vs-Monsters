package heroes.animation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import heroes.components.Account;
import heroes.components.Character;
import heroes.components.Hero;
import heroes.components.Monster;
import heroes.components.Sorcerer;
import heroes.components.Vampire;
import heroes.components.Warrior;
import heroes.components.Wizard;
import javafx.application.Application;
import javafx.event.EventHandler;

import static javafx.application.Application.launch; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent; 

public class DisplayData {
	Scene scene2;
	Scene loginSc;
	int i;
	Hero pickedHero;
	public DisplayData() {super();}
	public Scene userLogin(Account user,Stage window,Scene characterSc) throws Exception{
	  //Instantiating the BorderPane class  
	  BorderPane bPane = new BorderPane();   
	  Text welcome = new Text("L'invasione di Moena");
	  
	  welcome.setStyle("-fx-font: normal bold 80px 'serif' ");
	  welcome.setFill(Color.BLUE);
	  
	  //creating label email 
      Text usernameText = new Text("Username");       
      
      //creating label password 
      Text passwordText = new Text("Password"); 
      /*
       * TODO Subsequently, I will write this value along with the username and the score 
       * in a file and I will check if it is the correct value
       * TODO method to seek in the file. 
       * Useful to find the username and: check the filePassword (allow the access) 
       * and user.setScore(fileScore).
       */
       
      //Creating Text Field for Username        
      TextField uservalue = new TextField();
      user.setName(uservalue.getText());
      
      //Creating TextField for password        
      PasswordField passwordvalue = new PasswordField(); 
      //TODO create a String for comparison with the actual Password .compareToIgnoreCase (?)
      String insertedPassword = passwordvalue.getText();

      //Creating Buttons 
      Button enterGamebtn = new Button("Enter the Game!"); 
      enterGamebtn.setOnMouseClicked((new EventHandler<MouseEvent>() { 
          public void handle(MouseEvent event) { 
              System.out.println("Hello World");  
              window.setScene(characterSc); 
              window.show();
           } 
        })); 
//        
//      Button button2=new Button("Go back");
//      button2.setOnAction(e-> window.setScene(loginSc));
//      StackPane layout2 = new StackPane();
//      layout2.getChildren().add(button2);
//      
//      scene2 = new Scene(layout2,1280,720);

      
      //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane 
      gridPane.setMinSize(400, 200); 
      
      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);   
      
//      gridPane.setLayoutX(50);
//      gridPane.setLayoutY(50);
      
      //Setting the Grid alignment 
      
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      gridPane.add(usernameText, 0, 0); 
      gridPane.add(uservalue, 1, 0); 
      gridPane.add(passwordText, 0, 1);       
      gridPane.add(passwordvalue, 1, 1); 
      gridPane.add(enterGamebtn, 0, 2); 
 
       
      //Styling nodes  
      enterGamebtn.setStyle("-fx-background-color: black; -fx-text-fill: white;"); 
       
      usernameText.setStyle("-fx-font: normal bold 20px 'serif' "); 
      passwordText.setStyle("-fx-font: normal bold 20px 'serif' ");  
      gridPane.setStyle("-fx-background-color: BEIGE;"); 
      
      bPane.setTop(welcome);
      bPane.setCenter(gridPane); 
      
      //Creating a scene object 
      loginSc = new Scene(bPane,800,300); 
      
      return loginSc;
	}
	public Scene chooseCharacter(Hero hero, Stage window, Account user, Monster enemy) {
		
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

		
		ArrayList<CharacImage> heroImages = new ArrayList<>();
		ArrayList<Label> heroTitle = new ArrayList<>();
		ArrayList<Label> heroEquipment = new ArrayList<>();
		ArrayList<Hero> heroesList = new ArrayList<>();
		
		heroesList.add( new Warrior("Leonida"));
		heroesList.add( new Wizard("Mago Merlino, signore di Fiabilandia"));
		
		Text instruction= new Text("Choose your hero by clicking on the image");
		
		CharacterBtnClick charSelected=new CharacterBtnClick(window, user, hero, enemy);
		
		//Show the two big characters, whom the user chooses
			for (i=0;i<heroesList.size();i++) {
				heroImages.add(showBigImage(heroesList.get(i),550,550));
			    //Arranging all the nodes in the grid 
			    gridPane.add(heroImages.get(i), i, 0); 
			    heroTitle.add(new Label(heroesList.get(i).toString()));
			    heroEquipment.add(new Label(heroesList.get(i).equipmentToString()));
			    gridPane.add(heroTitle.get(i), i, 1); 
			    gridPane.add(heroEquipment.get(i), i, 2);
			   
			    //pickedHerohandled.setEqual(((HeroImage)heroImages.get(i)).getImageHero());
			    heroImages.get(i).setOnMouseClicked(charSelected); 
			}
			
			/*
			 * Cerca di fare tutto da dentro il bottone/evento 
			 * altrimenti se non viene cliccato, lui non può andare avanti
			 
			if (charSelected.getPickedHero() instanceof Warrior)
		  		  pickedHero=new Warrior();
		  	  else if (charSelected.getPickedHero() instanceof Wizard)
		  		  pickedHero=new Wizard();
		  	  else pickedHero=new Warrior("ERROR");
		  	pickedHero=charSelected.getPickedHero();
				
				switch (option) {
				case 1: return heroesList.get(0);
				case 2:	return heroesList.get(1);
				default: option=0;
				*/
		
			
	      
	       
	      //gridPane.add(uservalue, 1, 0); 
	      //gridPane.add(passwordvalue, 1, 1); 
	      //gridPane.add(enterGamebtn, 0, 2); 
	      bPane.setTop(instruction);
	      bPane.setCenter(gridPane); 
	      
	      //Creating a scene object 
	      Scene characterSc = new Scene(bPane,1280,720); 
	      
	      return characterSc;
	}
	public static CharacImage showBigImage(Character character,int height,int width) {
		/**
		 * It return a HeroImage with the attribute Hero
		 */
		try {
			//Setting the image view
			Image image = new Image(new FileInputStream(character.getImagePath()));
			CharacImage heroImage = new CharacImage(image,character); 
		    heroImage.setX(50); 
		    heroImage.setY(50); 
		    heroImage.setFitHeight(550); 
		    heroImage.setFitWidth(550); 
		    heroImage.setPreserveRatio(true);
		    return heroImage;
		
		} catch (FileNotFoundException e) {
			System.out.println("Image file not found");
			e.printStackTrace();
			return null;
		}
	}
	public void MonsterPrint(ArrayList<Monster> monsterList) {
		// Not sure if this method is useful
		String str="";
		int i=0;
		for (Monster w:monsterList)
		{
			str+=i+"-  "+w.toString()+"\n";
			i++;
		}
		System.out.println(str);
	}
	public Hero pickACharacter(BufferedReader in) throws IOException {
		int option=0;
		ArrayList<Hero> heroesList = new ArrayList<>();
		heroesList.add( new Warrior("Leonida"));
		heroesList.add( new Wizard("Mago Merlino, signore di Fiabilandia"));
		do {
			try {
				System.out.println("You can choose among these characters:");
				for (int i=0;i<heroesList.size();i++) {
					System.out.println((i+1)+". "+heroesList.get(i));
					
				}
				System.out.print("Chosen num.: ");
				option=Integer.parseInt(in.readLine());
				switch (option) {
				case 1: return heroesList.get(0);
				case 2:	return heroesList.get(1);
				default: option=0;
				}
			} catch (NumberFormatException exception) {
				System.out.println("You input a wrong value. Please do it again");
				option =0;
			}
		} while (option==0);
		return null; //it should never get to this value
	}
	public void selectYourAccount(Account user,BufferedReader in)  {
		// TODO Auto-generated method stub
		System.out.println("Welcome! This is:\n"
				+ "Heroes vs Monsters \n\n"
				+ "What's your name Account?");
		try {
			user.setName(in.readLine());
		}  catch(IOException eccezioneLanciata ) {
			System.out.println("I could not get your name. "
					+ "Maybe you have some problem with input.Sorry");
		}
		user.getScoreSavedGame();
		System.out.println("Great! Good luck, "+user.getName()+"!"
				+ "\nYour current score is "+user.getScore()
				+"\nHave fun and kill them all");
	}

}

package heroes.animation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import heroes.components.Hero;
import heroes.components.Monster;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AttackAnimation {
	//Creating an image 
	
	public ImageView attackMonsterAnimation(Hero player, Monster enemy) {
		Image image;
		try {
			//Setting the image view
			image = new Image(new FileInputStream(player.getImagePath()));
			ImageView playerImage = new ImageView(image); 
		    playerImage.setX(250); 
		    playerImage.setY(370); 
		    playerImage.setFitHeight(100); 
		    playerImage.setFitWidth(100); 
		    playerImage.setPreserveRatio(true);
		    
			final Duration SEC_2 = Duration.millis(1000);
		    final Duration SEC_3 = Duration.millis(150);

		    PauseTransition pt = new PauseTransition(Duration.millis(1000));
		    
		    //Creating scale Transition 
		    ScaleTransition enlarge = new ScaleTransition(SEC_2); 
		    enlarge.setByY(1.5); 
		    enlarge.setByX(1.5); 
		    enlarge.setCycleCount(1); 
		    enlarge.setAutoReverse(false);
		    
		    TranslateTransition moveToOffence = new TranslateTransition(SEC_2);
		    moveToOffence.setFromX(-100f);
		    moveToOffence.setToX(300f);
		    moveToOffence.setCycleCount(1);
		    moveToOffence.setAutoReverse(true);
		    
		    //Creating Vibration on Attack
		    TranslateTransition vibrationOnAttack = new TranslateTransition(); 
		    vibrationOnAttack.setDuration(Duration.millis(150)); 
		    vibrationOnAttack.setByX(30); 
		    vibrationOnAttack.setCycleCount(8); 
		    vibrationOnAttack.setAutoReverse(true);
		    
		    FadeTransition blinkFade = new FadeTransition(SEC_3);
		    blinkFade.setFromValue(1.0f);
		    blinkFade.setToValue(0.3f);
		    blinkFade.setCycleCount(8);
		    blinkFade.setAutoReverse(true);
		    
		    TranslateTransition moveBack = new TranslateTransition(SEC_2);
		    moveBack.setFromX(300f);
		    moveBack.setToX(-100f);
		    moveBack.setCycleCount(1);
		    moveBack.setAutoReverse(true);
		    
		    ScaleTransition reduce = new ScaleTransition(SEC_2);
		    reduce.setByX(-0.66666);
		    reduce.setByY(-0.66666);
		    reduce.setCycleCount(1);
		    reduce.setAutoReverse(false);

		    //TODO verify the switch of Fade with vibrationOnAttack
		    SequentialTransition seqT = new SequentialTransition (playerImage, enlarge, 
		    		moveToOffence, vibrationOnAttack, pt, moveBack, reduce );
		    seqT.play();
		
		    return playerImage;
	
		} catch (FileNotFoundException e) {
			System.out.println("Image file not found");
			e.printStackTrace();
		}
		return null;
	}
}

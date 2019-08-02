package heroes.animation;
import heroes.components.Hero;
import heroes.components.Warrior;
import heroes.components.Wizard;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StartFightKeyEv implements EventHandler<KeyEvent>{
	Hero pickedHero;
	Scene fightSc;
	Stage window;
	StartFightKeyEv(Scene fightSc,Stage window) {
		this.fightSc=fightSc;
		this.window=window;
	}
	public void handle(KeyEvent ke) {
        //KeyCode kc = ke.getCode();
        if ((ke.getCode()==KeyCode.ENTER) || (ke.getCode()==KeyCode.SPACE) ) {
    	    System.out.println("Let's Fight!");
    	    window.setScene(this.fightSc); 
    	    window.show();
        }
    }
	public Hero getPickedHero() {
		return pickedHero;
	}
	public void setPickedHero(Hero pickedHero) {
		this.pickedHero = pickedHero;
	}
	public Scene getFightSc() {
		return fightSc;
	}
	public void setFightSc(Scene fightSc) {
		this.fightSc = fightSc;
	} 
}

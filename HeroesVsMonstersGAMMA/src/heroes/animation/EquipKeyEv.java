package heroes.animation;

import heroes.components.Hero;
import heroes.components.Warrior;
import heroes.components.Weapon;
import heroes.components.Wizard;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class EquipKeyEv implements EventHandler<KeyEvent> {
	
	public void handle(KeyEvent ke) {
        //KeyCode kc = ke.getCode();
		int selectedEquip=Integer.parseInt(ke.getCharacter());
		int i=0;
		do {
			if (selectedEquip < Main.getPlayer().getEquipment().size() )
			{
				Game.setStory(Main.getPlayer().specialAttack(Main.getEnemy(), selectedEquip));
				System.out.println("hit!");
				i++;
			} else System.out.println("The typed key was out of range \nChoose another one");
		}while (i==0);
		//TODO in realtà il secondo argomento di specialAttack si aspetta solo l'indice dell'arma, 
		//però io potrei anche passargli tutta l'arma, anche se in effetti l'elenco di armi lui 
		//la conosce attraverso l'oggetto che chiama il metodo specialAttact, cioè player.specialAttack
		
		System.out.println("Let's Fight!");
   
    }
}

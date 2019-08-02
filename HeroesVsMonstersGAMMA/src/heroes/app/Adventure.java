package heroes.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import heroes.animation.DisplayData;
import heroes.animation.Game;
import heroes.components.*;
import heroes.components.Character;

public class Adventure {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(isr);
		ArrayList<Monster> monsterList = new ArrayList<>();
		Account user=new Account();
		monsterList.add( new Sorcerer("Colui che non deve essere nominato"));
		monsterList.add( new Vampire("Dracula"));
		monsterList.add( new Vampire("The Dark Fly"));
		monsterList.add( new Sorcerer("Nosferatu"));
		monsterList.add( new Sorcerer("Nonna"));
		DisplayData play=new DisplayData();
		play.selectYourAccount(user,in);
		Hero player= play.pickACharacter(in);
		
		Game f = new Game();
		Monster enemy=f.pickAMonster(monsterList);
		System.out.println("Hi "+user.getName()+"\n your chosen Hero is "+player);
		System.out.println("Your enemy is...\n"+enemy.toString()+"\n"
				+ "Enemy's weapons: \n"+enemy.equipmentToString()+"\nGet ready to fight...");
		
		/*
		 * Mostro s = new Stregone();
		 * Now I can extract (unbox) the object s from the box Monster 
		 * to have all the Stregone skills, methods,..
		 * So I do:
		 * ((Stregone) s).lanciaIncantesimo();
		 * In order to understand if this is possible with no errors,
		 * then I ask if "  s instanceof Stregone  " and in that case 
		 * you do "lanciaIncantesimo()"
		 */
		
		/*
		 * 
		 */
	}
}

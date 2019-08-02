package heroes.app;

import java.io.BufferedReader;
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

public class Print {
	public Print() {super();}
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
		heroesList.add( new Warrior("Nobunaga, il samurai"));
		heroesList.add( new Wizard("Mago Merlino, signore di Fiabilandia"));
		do {
			try {
				System.out.println("You can choose among these characters:\n"
					+ "1. "+heroesList.get(0)
					+"\n2. "+heroesList.get(1)
					+"\nChosen num.: ");
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

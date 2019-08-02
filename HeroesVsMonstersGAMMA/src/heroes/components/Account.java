package heroes.components;

public class Account {
	String name;
	int score;
	public Account(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public Account() {
		super();
		this.name="NONAME";
		this.score=0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", score=" + score + "]";
	}
	public void getScoreSavedGame() {
		// TODO  I should find the name in a file and if there is, I should also 
		//read the score of that account (I should also save it before exiting 
		// the game!.."Do you want to save?")
		// I also have to create a Class Account and return an Account value
		
	}
}

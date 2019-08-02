package heroes.components;

import java.util.Random;



public abstract class Hero extends Character{
	
	public final static int ESCAPEDAMAGE=30;
	
	
	protected Hero() {
		super();
	}

	/*
	 * Maybe I could define this method
	 */
	private final float escapeChance=0.4f;

	private Random rnd=new Random();

	public boolean isEscaped() {
		Float box=0f;
		box=rnd.nextFloat();
		if (box>escapeChance) 
		{
			super.getsHit(ESCAPEDAMAGE);
			return true;
		}
		else
			return false;
	}

	public void setEqual(Hero hero) {
		this.name=hero.getName();
		this.setEquipment(hero.getEquipment());
		this.mana=hero.getMana();
		this.healthPoints=hero.getHealthPoints();
		this.setImagePath(hero.getImagePath());
	}	
	
}
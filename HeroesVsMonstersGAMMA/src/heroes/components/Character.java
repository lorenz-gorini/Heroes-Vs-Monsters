package heroes.components;

import java.util.ArrayList;

public abstract class Character implements Attackable {
	protected String name;
	protected int healthPoints,mana;
	protected ArrayList<Weapon> equipment;
	protected String imagePath;

	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	protected Character() {
		super();
		this.name = null;
		this.healthPoints = 0;
		this.mana = 0;
		this.equipment = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void normalAttack(Character m) {
		m.setHealthPoints(this.equipment.get(0).getValue());
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public ArrayList<Weapon> getEquipment() {
		return equipment;
	}
	public void setEquipment(ArrayList<Weapon> equipment) {
		this.equipment=equipment;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public void getsHit(int damage) {
		this.healthPoints = healthPoints-damage;
	}
	public void usesMana(int cost) {
		this.mana = mana-cost;
	}
	public boolean isAlive() {
		return healthPoints>0;
	}
	public abstract String toString();
	public String specialAttack(Character c,int chosenWeapon) {
		/**
		 * This method can perform a special attack.
		 * It accepts (Character m,int chosenWeapon) 
		 */
		Weapon w=this.equipment.get(chosenWeapon);
		this.usesMana(w.getManaCost());
		c.getsHit(w.getValue());
		String hits;
		if (this instanceof Vampire)
		{
			((Vampire)this).suckBloodAndRecover(w.getRecoverHP());
		}
		hits="gives a pat to the friend ";
		if (w.getValue()>39) { hits=" strongly hits "; }
		String str=this.getName()+hits+c.getName()+"\n "
				+ "with the powerful "+w.getName()+"\n"
				+c.getName()+" loses "+w.getValue()+" HP\n";
		return str;
	}
	public String equipmentToString() {
		String str = "";
		int i=0;
		str+="The equipment of "+name+" is:\n";
		for (Weapon w:equipment)
		{
			str+=i+"-  "+w.toString()+"\n";
			i++;
		}
		return str;
	}
}

package heroes.components;

public class Vampire extends Monster {
	public Vampire(String name)
	{
		super();
		super.setName(name);
		setEquipment();
		this.setHealthPoints(190);
		this.setMana(110);
		this.setImagePath("C:\\Users\\loreg\\Desktop\\LorenzoGamma\\"
				+ "HeroesVsMonstersFX\\src\\heroes\\components\\Drakula.jpg");
	}
	public Vampire(String name, String nameImage)
	{
		super();
		super.setName(name);
		setEquipment();
		this.setHealthPoints(190);
		this.setMana(110);
		this.setImagePath("C:\\Users\\loreg\\Desktop\\LorenzoGamma\\"
				+ "HeroesVsMonstersFX\\src\\heroes\\components\\"+nameImage);
	}
	/*
	 * Eventually I could also redefine the specialAttack method already defined in Character
	 * (without using if (this instance of Vampire)) , but it doesn't change so much
	 * (non-Javadoc)
	 * @see heroes.components.Character#specialAttack(heroes.components.Character, int)
	 /
	public String specialAttack(Character m,int chosenWeapon) {
		/**
		 * This method can perform a special attack.
		 * It accepts (Character m,int chosenWeapon) 
		 /
		Weapon w=this.equipment.get(chosenWeapon);
		this.usesMana(w.getManaCost());
		c.getsHit(w.getValue());
		String str=this.getName()+" is hit from "+c.getName()+"\n "
				+ "with the powerful "+w.getName()+"/n"
				+this.getName()+" loses "+w.getValue()+" HP/n";
		return str;
		this.setMana(equipment.get(chosenWeapon).getManaCost());
		
	}
*/
	public void suckBloodAndRecover(int recover)
	{
		this.setHealthPoints(healthPoints+recover);
	}
	
	private void setEquipment()
	{
		equipment.add(new Weapon("Palla di Fuoco",10,0,0));
		equipment.add(new Weapon("Sanguisuga",25,15,10));
		equipment.add(new Weapon("Morso della Morte",50,70,30));
		equipment.add(new Weapon("Bastone Maledetto",20,15,0));
	}

	@Override
	public String toString() {
		return "Vampire [name=" + name + ", healthPoints=" + healthPoints + ", mana=" + mana + "]";
	}

}

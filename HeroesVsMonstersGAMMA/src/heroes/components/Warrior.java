package heroes.components;

public class Warrior extends Hero {

	public Warrior(String name)
	{
		super();
		super.setName(name);
		setEquipment();
		this.setHealthPoints(250);
		this.setMana(120);
		imagePath="C:\\Users\\loreg\\Desktop\\LorenzoGamma\\HeroesVsMonstersFX"
				+ "\\src\\heroes\\components\\warrior.jpg";
	}
	public Warrior(){super();}
	
	private void setEquipment()
	{
		equipment.add(new Weapon("Scopa del Goblin",10,0));
		equipment.add(new Weapon("Pugnale Avvelenato",25,10));
		equipment.add(new Weapon("Spada Stregata a due mani",40,20));
		equipment.add(new Weapon("Lama Mistica di Orco",80,60));
		equipment.add(new Weapon("Padella della Nonna",30,12));
	}

	@Override
	public String toString() {
		return "Warrior [name=\"" + name + "\", healthPoints=" + healthPoints + ", mana=" + mana + "]";
	}
	
}

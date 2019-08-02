package heroes.components;


public class Sorcerer extends Monster {
	public Sorcerer(String name)
	{
		super();
		super.setName(name);
		setEquipment();
		this.setHealthPoints(170);
		this.setMana(120);
		this.setImagePath("C:\\Users\\loreg\\Desktop\\LorenzoGamma\\"
				+ "HeroesVsMonstersFX\\src\\heroes\\components\\Voldemort.jpg");
	}

	public Sorcerer(String name,String nameImage)
	{
		super();
		super.setName(name);
		setEquipment();
		this.setHealthPoints(170);
		this.setMana(120);
		this.setImagePath("C:\\Users\\loreg\\Desktop\\LorenzoGamma\\"
				+ "HeroesVsMonstersFX\\src\\heroes\\components\\"+nameImage);
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
		return "Sorcerer [name=" + name + ", healthPoints=" + healthPoints + ", mana=" + mana + "]";
	}
}

package heroes.components;

public class Wizard extends Hero{
	public Wizard(String name)
	{
		super();
		super.setName(name);
		setEquipment();
		this.setHealthPoints(160);
		this.setMana(150);
		super.setImagePath("C:\\Users\\loreg\\Desktop\\LorenzoGamma\\"
				+ "HeroesVsMonstersFX\\src\\heroes\\components\\MagoMerlino.jpg");
	}



	public Wizard() {
		super();
	}



	private void setEquipment()
	{
		equipment.add(new Weapon("Palla di Fuoco",10,0));
		equipment.add(new Weapon("Fulmine di Ghiaccio",25,15));
		equipment.add(new Weapon("Raggio di Sole",40,50));
		equipment.add(new Weapon("Pioggia Acida",30,45));
		equipment.add(new Weapon("Avada Kedavra",80,90));
	}

	@Override
	public String toString() {
		return "Wizard [name=\"" + name + "\", healthPoints=" + healthPoints + ", mana=" + mana + "]";
	}

}

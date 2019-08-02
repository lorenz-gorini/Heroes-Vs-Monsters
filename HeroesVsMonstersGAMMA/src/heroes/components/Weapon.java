package heroes.components;

public class Weapon {
	
	protected String name;
	protected int value,manaCost,recoverHP;
	public Weapon() {
		super();
	}

	public Weapon(String name, int value, int manaCost, int recoverHP) {
		super();
		this.name = name;
		this.value = value;
		this.manaCost = manaCost;
		this.recoverHP = recoverHP;
	}

	public Weapon(String name, int value, int manaCost) {
		super();
		this.name = name;
		this.value = value;
		this.manaCost = manaCost;
		this.recoverHP=0;
	}

	public int getRecoverHP() {
		return recoverHP;
	}

	protected void setRecoverHP(int recoverHP) {
		this.recoverHP = recoverHP;
	}

	public String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	protected void setValue(int value) {
		this.value = value;
	}
	public int getManaCost() {
		return manaCost;
	}
	protected void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	@Override
	public String toString() {
		return name + ", value=" + value + ", manaCost=" + manaCost + ", recoverHP=" + recoverHP;
	}
}

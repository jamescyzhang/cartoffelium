package cartoffelium.entity;

import cartoffelium.util.Describable;

public abstract class Entity extends Describable
{

	public int health = 100, mana = 100, energy = 100;
	public int mhealth = 100, mmana = 100, menergy = 100;
	public int hregen = 1, mregen = 1, eregen = 1;
	public int strength = 0, intelligence = 0, wisdom = 0, stamina = 0,
			dexterity = 0;

	public Entity()
	{
		super();
	}

	public Entity(String name, String description)
	{
		super(name, description);
	}

	public Entity(int health, int mana, int energy, int strength,
			int intelligence, int wisdom, int stamina, int dexterity)
	{
		super();
		this.mhealth = this.health = health;
		this.mmana = this.mana = mana;
		this.menergy = this.energy = energy;
		this.strength = strength;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.stamina = stamina;
		this.dexterity = dexterity;
	}

	public Entity(String name, String description, int health, int mana,
			int energy, int strength, int intelligence, int wisdom,
			int stamina, int dexterity)
	{
		super(name, description);
		this.mhealth = this.health = health;
		this.mmana = this.mana = mana;
		this.menergy = this.energy = energy;
		this.strength = strength;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.stamina = stamina;
		this.dexterity = dexterity;
	}

	public abstract int getPAtt();

	public abstract int getPDef();

	public abstract int getMAtt();

	public abstract int getMDef();

	public abstract int getSpeed();

}

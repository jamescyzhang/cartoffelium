package cartoffelium.entity;

import cartoffelium.util.Describable;

public abstract class Entity extends Describable
{

	public int health = 0, mana = 0, energy = 0;
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
		this.health = health;
		this.mana = mana;
		this.energy = energy;
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
		this.health = health;
		this.mana = mana;
		this.energy = energy;
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

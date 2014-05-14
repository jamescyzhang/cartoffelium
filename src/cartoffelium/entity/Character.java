package cartoffelium.entity;

public abstract class Character extends Entity
{
	
	public int race = Race.NA_CAT;
	public int cls = Class.WARRIOR;
	
	public int level;

	public Character()
	{
		super();
	}

	public Character(int health, int mana, int energy, int strength,
			int intelligence, int wisdom, int stamina, int dexterity)
	{
		super(health, mana, energy, strength, intelligence, wisdom, stamina, dexterity);
	}

	public Character(String name, String description, int health, int mana,
			int energy, int strength, int intelligence, int wisdom,
			int stamina, int dexterity)
	{
		super(name, description, health, mana, energy, strength, intelligence, wisdom,
				stamina, dexterity);
	}

	public Character(String name, String description)
	{
		super(name, description);
	}

	public Character(String name, String description, int health, int mana,
			int energy, int strength, int intelligence, int wisdom,
			int stamina, int dexterity, int race, int cls)
	{
		super(name, description, health, mana, energy, strength, intelligence,
				wisdom, stamina, dexterity);
		this.race = race;
		this.cls = cls;
		Race.endow(this, race);
		Class.endow(this, cls);
	}

	public Character(String name, String description, int race, int cls)
	{
		super(name, description);
		this.race = race;
		this.cls = cls;
		Race.endow(this, race);
		Class.endow(this, cls);
	}
	
	public void levelUp()
	{
		Class.endow(this, cls);
	}

}

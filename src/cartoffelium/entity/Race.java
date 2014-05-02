package cartoffelium.entity;

public class Race
{

	// FEDERATION
	public static final int FE_POTATO = 100; // hidden
	public static final int FE_HUMAN = 101;
	public static final int FE_WORGEN = 102;
	public static final int FE_PANDA = 103;
	public static final int FE_DWARF = 104;

	// ALLIANCE
	public static final int AL_KARTOFFEL = 300; // hidden
	public static final int AL_ORC = 301;
	public static final int AL_UNDEAD = 302;
	public static final int AL_VAMPIRE = 303;
	public static final int AL_GOBLIN = 304;

	// NON_ALIGNED
	public static final int NA_POTATO_KARTOFFEL_GOD_ARBITRATOR = 0;
	public static final int NA_DOG = 1002;
	public static final int NA_CAT = 1003;

	public static void endow(Entity entity, int race)
	{
		switch (race)
		{
		case NA_POTATO_KARTOFFEL_GOD_ARBITRATOR: // Das OP Klass.
			entity.health = Integer.MAX_VALUE;
			entity.mana = Integer.MAX_VALUE;
			entity.energy = Integer.MAX_VALUE;
			entity.mhealth = Integer.MAX_VALUE;
			entity.mmana = Integer.MAX_VALUE;
			entity.menergy = Integer.MAX_VALUE;
			entity.strength = Integer.MAX_VALUE;
			entity.intelligence = Integer.MAX_VALUE;
			entity.wisdom = Integer.MAX_VALUE;
			entity.stamina = Integer.MAX_VALUE;
			entity.dexterity = Integer.MAX_VALUE;
			entity.hregen = 100;
			entity.mregen = 100;
			entity.eregen = 100;
			break;
		case FE_HUMAN:
			entity.wisdom++;
			entity.intelligence++;
			break;
		case FE_WORGEN:
			entity.strength++;
			entity.dexterity++;
			entity.stamina++;
			entity.wisdom--;
			break;
		case FE_PANDA:
			entity.dexterity++;
			entity.stamina++;
			entity.strength++;
			entity.intelligence--;
			break;
		case FE_DWARF:
			entity.dexterity += 2;
			entity.wisdom++;
			entity.stamina--;
			break;
		case AL_ORC:
			entity.strength += 2;
			entity.stamina += 2;
			entity.wisdom--;
			entity.dexterity--;
			break;
		case AL_UNDEAD:
			entity.intelligence += 2;
			entity.dexterity++;
			entity.wisdom++;
			entity.stamina -= 2;
			break;
		case AL_VAMPIRE:
			entity.dexterity += 3;
			entity.strength -= 2;
			entity.intelligence++;
			break;
		case AL_GOBLIN:
			entity.dexterity += 2;
			entity.wisdom++;
			entity.stamina--;
			break;
		default:
			break;
		}
	}

}

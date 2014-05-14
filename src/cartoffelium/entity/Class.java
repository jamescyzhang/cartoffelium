package cartoffelium.entity;

public class Class
{
	public static final int WARRIOR = 100;
	public static final int MAGE = 101;
	public static final int WARLOCK = 102;
	public static final int ARCHER = 103;
	public static final int ROGUE = 104;
	public static final int MONK = 105;
	public static final int PRIEST = 106;
	public static final int DRUID = 107;

	public static void endow(Entity entity, int cls)
	{
		switch (cls)
		{
		case MONK:
			entity.stamina++;
		case WARRIOR:
			entity.strength++;
			entity.mhealth += 10;
		case ARCHER:
			entity.menergy += 10;
			break;
		case MAGE:
		case PRIEST:
		case WARLOCK:
			entity.intelligence++;
			entity.wisdom++;
		case DRUID:
			entity.mmana += 10;
			break;
		case ROGUE:
			entity.dexterity += 3;
		default:
			break;
		}

	}
}

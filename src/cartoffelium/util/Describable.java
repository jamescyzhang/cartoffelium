package cartoffelium.util;

public abstract class Describable
{

	public String name;
	public String description;

	public Describable(String name, String description)
	{
		super();
		this.name = name;
		this.description = description;
	}
	
	public Describable()
	{
		this("", "");
	}

	@Override
	public String toString()
	{
		return name + "\n" + description;
	}

}


public class Animal extends Box {
	
	//maxBoxTime is the maximum amount of time in days this animal is allowed to live in this box
	private int maxBoxTime;
	
	private String animalName;
	
	//default constructor
	public Animal()
	{
		maxBoxTime = 2;
	}
	
	//preferred constructor
	public Animal(Warehouse warehouse, String from, double weight, double destination, String animalName, int maxBoxTime)
	{
		super.setStats(warehouse, from, weight, destination);
		this.maxBoxTime = maxBoxTime;
		
	}
	
	//returns the parent box of this object
	@Override
	public Box getParent()
	{
		return super.getBox();
	}
	
	@Override
	public void deliverBox(double days)
	{
		if (days > maxBoxTime)
		{
			System.out.println("Womp Womp, " + this + " has died after spending " + (days - maxBoxTime) + " days too many in shipping!");
		}
	}
	
	@Override
	public void shipBox()
	{
		System.out.println("Bark Bark");
		super.shipBox();
	}
	
}

import java.util.ArrayList;

public class Warehouse{
	
   	
	private ArrayList<Box> inventory = new ArrayList<>();
	
	private String name;
	private int inventorySize;
	
	//Default Constructor
	public Warehouse()
	{
		this.name = "Default Warehouse";
		this.inventorySize = 1000;
	}
	
	//Preferred Constructor
	public Warehouse(String name, int inventorySize)
	{
		this.name = name;
		this.inventorySize = inventorySize;
	}
	
	//get name of this object
	public String getName()
	{
		return this.name;
	}
	
	//Adds a box to inventory if there is room
	public void addBox(Warehouse warehouse, String from, double weight, double destination)
	{
		if (inventory.size() >= inventorySize)
		{
			System.out.println("Inventory full, cannot take in order");
		}
		else
		{
			Box newestBox = new Box(warehouse, from, weight, destination);
			inventory.add(newestBox);	
		}
		
	}
	
	//Prints all items in inventory
	public void printInventory()
	{
		System.out.println(inventory.size() + " items in inventory");
		for (int i = 0; i < inventory.size(); i++)
		{
			System.out.println( (inventory.get(i)).toString() );
		}
	}

}
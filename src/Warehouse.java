import java.util.ArrayList;

public class Warehouse{
	
   	
	private ArrayList<Box> inventory = new ArrayList<>();
	private ArrayList<DeliveryVehicle> vehicles = new ArrayList<>();
	
	private String name;
	private int inventorySize;
	private int boxCount;
	
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
			boxCount++;
		}
		
	}
	
	public void addVehicle(double capacity, int speed)
	{
		DeliveryVehicle vehicle = new DeliveryVehicle(this, capacity, speed);
		vehicles.add(vehicle);
	}
	
	//sends specified box to available vehicle for delivery
	private void shipBox(Box box)
	{
		for (int i = 0; i < vehicles.size(); i++)
		{
			if (vehicles.get(i).getInventoryWeight() + box.getWeight() <= vehicles.get(i).getCapacity())
			{
				vehicles.get(i).addBox(box);
				boxCount--;
				box.shipBox();
				break;
			}

			else if (i == vehicles.size() - 1)
			{
				System.out.println("Box " + box.toString() + " cannot be shipped! Lack of delivery vehicles!");
			}
		}
		
		
	}
	
	//Ships all boxes possible
	public void shipAll()
	{
		for (int i = 0; i < inventory.size(); i++)
		{
			shipBox(inventory.get(i));
		}
		
		if(boxCount > 0)
		{
			System.out.println(boxCount + " boxes at " + name + " have not been shipped!");
		}
		else
		{
			System.out.println("All boxes at " + name + " have been shipped");
		}
		
		//creates tempInventory before removing boxes that have been shipped
		ArrayList<Box> tempInventory = new ArrayList<>();
		
		//remove boxes that have been shipped from inventory
		for (int i = 0; i < inventory.size(); i++)
		{
			if (inventory.get(i).getShipped())
			{
				tempInventory.add(inventory.get(i));
			}
		}
		
		//remove all items from inventory that have been shipped
		
		inventory.removeAll(tempInventory);
		printInventory();
		
	}
	
	public void hireDriver(String name, double hourlyPay)
	{
		if (vehicles.size() > 0)
		{
			for (int i = 0; i < vehicles.size(); i++)
			{
				if (vehicles.get(i).getDriver() == null)
				{
					vehicles.get(i).addDriver(name, hourlyPay);
					break;
				}
				else if (i == vehicles.size() - 1)
				{
					System.out.println("There is no need for any new drivers!");
				}
			}
		}
		else
		{
			System.out.println("There are no vehicles! Driver has not been hired!");
		}
	}
	
	public void deliverItems()
	{
		for (int i = 0; i < vehicles.size(); i++)
		{
			if (vehicles.get(i).getInventoryWeight() > 0)
			{
				vehicles.get(i).deliverItems();
			}
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
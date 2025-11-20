import java.util.ArrayList;

public class Warehouse{
	
   	
	private ArrayList<Box> inventory = new ArrayList<>();
	private ArrayList<DeliveryVehicle> vehicles = new ArrayList<>();
	
	private String name;
	private int inventorySize;
	private int boxCount;
	
	//Default Constructor
	/**
	 * 
	 */
	public Warehouse()
	{
		this.name = "Default Warehouse";
		this.inventorySize = 1000;
	}
	
	//Preferred Constructor
	/**
	 * @param name
	 * @param inventorySize
	 */
	public Warehouse(String name, int inventorySize)
	{
		this.name = name;
		this.inventorySize = inventorySize;
	}
	
	//get name of this object
	/**
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
	
	//Adds a box to inventory if there is room
	/**
	 * @param warehouse
	 * @param from
	 * @param weight
	 * @param destination
	 */
	public void addBox(Warehouse warehouse, String from, double weight, double destination)
	{
		//if the inventory is full, the box cannot be taken in, otherwise it is added to the inventory.
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
	
	//adds a box with an animal in it into the inventory
	/**
	 * @param warehouse
	 * @param from
	 * @param weight
	 * @param destination
	 * @param animalName
	 * @param maxBoxTime
	 */
	public void addAnimal(Warehouse warehouse, String from, double weight, double destination, String animalName, int maxBoxTime)
	{
		//if the inventory is full, the box containing the animal cannot be taken in, otherwise it is added to the inventory.
		if (inventory.size() >= inventorySize)
		{
			System.out.println("Inventory full, cannot take in order");
		}
		else
		{
			Box newestBox = new Animal(warehouse, from, weight, destination, animalName, maxBoxTime);
			inventory.add(newestBox);	
			boxCount++;
		}
	}
	
	//adds a new vehicle to the warehouse fleet
	/**
	 * @param capacity
	 * @param speed
	 */
	public void addVehicle(double capacity, int speed)
	{
		DeliveryVehicle vehicle = new DeliveryVehicle(this, capacity, speed);
		vehicles.add(vehicle);
	}
	
	//sends specified box to available vehicle for delivery
	/**
	 * @param box
	 */
	private void shipBox(Box box)
	{
		//goes through each vehicle and checks if it has enough room for more boxes
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
	
	//ships a box sent by a user
	/**
	 * 
	 */
	public void shipConsumerBox()
	{
		//goes through all boxes to find the one that had been sent in by the user.
		for (int i = 0; i < inventory.size(); i++)
		{
			if (inventory.get(i).getFrom() == "Consumer" && inventory.get(i).getShipped() == false)
			{
				shipBox(inventory.get(i));
			}
		}
		//removes the boxes sent in by the user.
		clearShippedBoxes();
	}
	
	//Ships all boxes possible
	/**
	 * 
	 */
	public void shipAll()
	{
		for (int i = 0; i < inventory.size(); i++)
		{
			shipBox(inventory.get(i));
		}
		//prints out the number of boxes that have been shipped
		if(boxCount > 0)
		{
			System.out.println(boxCount + " boxes at " + name + " have not been shipped!");
		}
		else
		{
			System.out.println("All boxes at " + name + " have been shipped");
		}
		
		clearShippedBoxes();
		
		
		
	}
	
	//removes all boxes in inventory that have been shipped.
	/**
	 * 
	 */
	public void clearShippedBoxes()
	{
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
	}
	
	/**
	 * @param name
	 * @param hourlyPay
	 */
	public void hireDriver(String name, double hourlyPay)
	{
		//looks for a vehicle with no driver, if the vehicle has no driver, the driver is added to the vehicle. Otherwise, the driver is not hired
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
		//prints out that driver has not been hired since there are no vehicles.
		else
		{
			System.out.println("There are no vehicles! Driver has not been hired!");
		}
	}
	
	//delivers all boxes loaded on the vehicles.
	/**
	 * 
	 */
	public void deliverItems()
	{
		for (int i = 0; i < vehicles.size(); i++)
		{
			//if the vehicle has no boxes loaded on it, the vehicle will not do anything
			if (vehicles.get(i).getInventoryWeight() > 0)
			{
				vehicles.get(i).deliverItems();
			}
		}
	}
	
	//Prints all items in inventory
	/**
	 * 
	 */
	public void printInventory()
	{
		System.out.println(inventory.size() + " items in inventory");
		for (int i = 0; i < inventory.size(); i++)
		{
			System.out.println( (inventory.get(i)).toString() );
		}
	}
	

}
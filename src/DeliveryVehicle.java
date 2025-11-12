import java.util.ArrayList;

public class DeliveryVehicle {
	
	//creates list that contains all boxes in inventory
	private ArrayList<Box> inventory = new ArrayList<>();
	
	//creates initial variables
	private Warehouse warehouse;
	private double inventoryWeight = 0.0;
	private double capacity;
	private int speed;
	
	private DeliveryDriver driver;
	
	//default constructor
	public DeliveryVehicle()
	{
		warehouse = null;
		capacity = 1000.0;
		speed = 60;
	}
	
	//preferred constructor
	public DeliveryVehicle(Warehouse warehouse, double capacity, int speed)
	{
		this.warehouse = warehouse;
		this.capacity = capacity;
		this.speed = speed;
	}
	
	//adds a box to the inventory if there is room and increases inventoryWeight.
	public void addBox(Box box)
	{
		if (inventoryWeight + box.getWeight() <= capacity)
		{
			inventory.add(box);
			inventoryWeight = inventoryWeight + box.getWeight();
		}
		else
		{
			System.out.println("No more room in Vehicle to add boxes!");
		}
		
	}
	
	//removes box from inventory and decreases inventory weight
	public void removeBox(Box box)
	{
		inventory.remove(box);
		inventoryWeight = inventoryWeight - box.getWeight();
	}

	//returns inventoryWeight
	public double getInventoryWeight()
	{
		return this.inventoryWeight;
	}
	
	//returns capacity
	public double getCapacity()
	{
		return this.capacity;
	}
	
	//get the delivery driver assigned to this vehicle
	public DeliveryDriver getDriver()
	{
		return driver;
	}
	
	//Create a new driver and assign it to this vehicle
	public void addDriver(String name, double hourlyPay)
	{
		DeliveryDriver driver = new DeliveryDriver(this, name, hourlyPay);
		this.driver = driver;
		//System.out.println(name + " has been hired for " + hourlyPay + "$ an hour");
	}
	
	//sends the vehicle out for delivery
	public void deliverItems()
	{
		ArrayList<Box> tempInventory = new ArrayList<>();
		
		double totalDistance = 0.0;
		double totalPay = 0.0;
		double voyageTime;
		
		for (int i = 0; i < inventory.size(); i++)
		{
			double days;
			Box box;
			double shippingCost;
			
			box = inventory.get(i);
			
			days = (double) box.getDestination() / speed / 24.0;
			days = Math.round(days * 100.0) / 100.0;
			
			shippingCost = driver.getPay() * (days * 24.0);
			shippingCost = Math.round(shippingCost * 100.0) / 100.0;
			
			tempInventory.add(box);
			
			totalDistance = totalDistance + box.getDestination();
			totalPay = totalPay + shippingCost;
			
			voyageTime = totalDistance / speed / 24.0;
			voyageTime = Math.round(voyageTime * 100.0) / 100.0;
			
			if(box.getFrom() == "Consumer")
			{
				System.out.println(box.toString() + " has been delivered in " + voyageTime + " days for $" + shippingCost);
			}
			
			
		}
		
		
		
		
		voyageTime = totalDistance / speed / 24.0;
		voyageTime = Math.round(voyageTime * 100.0) / 100.0;
		
		totalPay = Math.round(totalPay * 100.0) /100.0;
		
		
		
		//System.out.println(driver.getName() + " has completed his voyage in " + voyageTime + " days, making $" + String.format("" + totalPay));
		inventory.removeAll(tempInventory);
	}
	
	
}

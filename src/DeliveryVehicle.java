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
	/**
	 * 
	 */
	public DeliveryVehicle()
	{
		warehouse = null;
		capacity = 1000.0;
		speed = 60;
	}
	
	//preferred constructor
	/**
	 * @param warehouse
	 * @param capacity
	 * @param speed
	 */
	public DeliveryVehicle(Warehouse warehouse, double capacity, int speed)
	{
		this.warehouse = warehouse;
		this.capacity = capacity;
		this.speed = speed;
	}
	
	//adds a box to the inventory if there is room and increases inventoryWeight.
	/**
	 * @param box
	 */
	public void addBox(Box box)
	{
		//if the vehicle has enough room for the box, it is added
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
	/**
	 * @param box
	 */
	public void removeBox(Box box)
	{
		inventory.remove(box);
		inventoryWeight = inventoryWeight - box.getWeight();
	}

	//returns inventoryWeight
	/**
	 * @return
	 */
	public double getInventoryWeight()
	{
		return this.inventoryWeight;
	}
	
	//returns capacity
	/**
	 * @return
	 */
	public double getCapacity()
	{
		return this.capacity;
	}
	
	//get the delivery driver assigned to this vehicle
	/**
	 * @return
	 */
	public DeliveryDriver getDriver()
	{
		return driver;
	}
	
	//Create a new driver and assign it to this vehicle
	/**
	 * @param name
	 * @param hourlyPay
	 */
	public void addDriver(String name, double hourlyPay)
	{
		DeliveryDriver driver = new DeliveryDriver(this, name, hourlyPay);
		this.driver = driver;
		//System.out.println(name + " has been hired for " + hourlyPay + "$ an hour");
	}
	
	//sends the vehicle out for delivery
	/**
	 * 
	 */
	public void deliverItems()
	{
		ArrayList<Box> tempInventory = new ArrayList<>();
		
		double totalDistance = 0.0;
		double totalPay = 0.0;
		double voyageTime;
		
		//delivers each box individually
		for (int i = 0; i < inventory.size(); i++)
		{
			double days;
			Box box;
			double shippingCost;
			
			box = inventory.get(i);
			
			//sets the amount of time it took to deliver the box
			days = (double) box.getDestination() / speed / 24.0;
			days = Math.round(days * 100.0) / 100.0;
			
			//calculates the amount it cost to deliver the box
			shippingCost = driver.getPay() * (days * 24.0);
			shippingCost = Math.round(shippingCost * 100.0) / 100.0;
			
			//adds the box to the tempInventory to be removed after all boxes have been shipped
			tempInventory.add(box);
			
			//adds to the totalDistance and totalPay of this trip
			totalDistance = totalDistance + box.getDestination();
			totalPay = totalPay + shippingCost;
			
			//adds to the total amount of time this vehicle has been on its trip
			voyageTime = totalDistance / speed / 24.0;
			voyageTime = Math.round(voyageTime * 100.0) / 100.0;
			
			//prints a message saying the box has been delivered if it has been shipped by the user.
			if(box.getFrom() == "Consumer")
			{
				System.out.println(box.toString() + " has been delivered in " + voyageTime + " days for $" + shippingCost);
			}
			
			//tells the box it has been delivered
			box.deliverBox(days);
			
			
		}
		
		
		
		
		voyageTime = totalDistance / speed / 24.0;
		voyageTime = Math.round(voyageTime * 100.0) / 100.0;
		
		totalPay = Math.round(totalPay * 100.0) /100.0;
		
		
		
		//System.out.println(driver.getName() + " has completed his voyage in " + voyageTime + " days, making $" + String.format("" + totalPay));
		//removes all boxes that have been delivered from the inventory.
		inventory.removeAll(tempInventory);
	}
	
	
}

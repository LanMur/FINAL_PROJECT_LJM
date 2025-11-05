import java.util.ArrayList;

public class DeliveryVehicle {
	
	//creates list that contains all boxes in inventory
	private ArrayList<Box> inventory = new ArrayList<>();
	
	//creates initial variables
	private Warehouse warehouse;
	private double inventoryWeight = 0.0;
	private double capacity;
	private int speed;
	
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
	
	
}

import java.util.ArrayList;
import java.util.Random;


public class OnlineRetailer {
	
	Random random = new Random();
	
	private String name;
	private int ordersPerMonth;
	
	//Default Constructor
	public OnlineRetailer()
	{
		this.name = "Generic Online Retailer";
		this.ordersPerMonth = 10;
	}
	
	//Preferred Constructor
	public OnlineRetailer(String name, int ordersPerMonth)
	{
		this.name = name;
		this.ordersPerMonth = ordersPerMonth;
	}
	
	//adds a number of orders based on monthly orders to a warehouse
	public void testRetailer(Warehouse warehouse)
	{
		for(int i = 0; i < ordersPerMonth; i++)
		{
			warehouse.addBox(warehouse, name, random.nextDouble(1.0, 5.0), random.nextDouble(1.0, 1500.0));
		}	
		
		//warehouse.printInventory();
	}
}

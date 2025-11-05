import java.util.ArrayList;

public class Retailers {
	
	private ArrayList<OnlineRetailer> retailers = new ArrayList<>();
	
	//creates a new retailer and adds it to the retailers list
	public void createRetailer(String name, int ordersPerMonth)
	{
		OnlineRetailer onlineRetailer = new OnlineRetailer(name, ordersPerMonth);
		retailers.add(onlineRetailer);
	}
	
	//Adds boxes to warehouse inventory based on each retailers monthly output.
	public void testMonthly(Warehouse warehouse)
	{
		for (int i = 0; i < retailers.size(); i++)
		{
			retailers.get(i).testRetailer(warehouse);
		}
	}
	
}

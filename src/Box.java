
public class Box{
	//warehouse is the warehouse the box is stored in
	private Warehouse warehouse;
	
	//from is the name of the sender the package is coming from
	private String from;
	
	//weight is the weight of the package in pounds
	private double weight;
	
	//destination is the distance from warehouse to destination in miles
	private double destination;
	
	//Default Constructor
	public Box()
	{
		warehouse = null;
		name = "Unknown origin";
		weight = 1.0;
		destination = 500.0;
	}
	
	//Preferred Constructor
	public Box(Warehouse warehouse, String from, double weight, double destination)
	{
		this.warehouse = warehouse;
		this.from = from;
		
		this.weight = weight;
		this.weight = Math.round(this.weight * 100.0) / 100.0;
		
		this.destination = destination;
		this.destination = Math.round(this.destination * 100.0) / 100.0;
	}
	
	//Returns the name of the warehouse this box is located in
	public String getParent()
	{
		return warehouse.getName();
	}
	
	
	//prints out all details of this object
	@Override
	public String toString()
	{
		return ("Box: [" + "Warehouse: " + getParent() + " | Sender: " + from + " | Weight: " + weight + " lbs" + " | Destination: " + destination + " miles away" +  "]");
	}
}

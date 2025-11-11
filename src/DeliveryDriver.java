
public class DeliveryDriver{
	
	private DeliveryVehicle vehicle;
	private String name;
	private double hourlyPay;
	
	public DeliveryDriver()
	{
		name = "John Doe";
		hourlyPay = 10.0;
	}
	
	public DeliveryDriver(DeliveryVehicle vehicle, String name, double hourlyPay)
	{
		this.vehicle = vehicle;
		this.name = name;
		this.hourlyPay = hourlyPay;
	}
	
	public double getPay()
	{
		return hourlyPay;
	}
	
	public String getName()
	{
		return name;
	}
	
	
}

import java.util.Scanner;
import java.util.InputMismatchException;

public class Consumer {
	
	private boolean inConsumer = true;
	Scanner scnr = new Scanner(System.in);
	Retailers retailers = new Retailers();
	
	Warehouse warehouse = new Warehouse("Generic Warehouse", 100000);
	
	
	private String userInput;
	
	public Consumer()
	{
		for (int i = 0; i < 250; i++)
		{
			warehouse.addVehicle(3500, 60);
			warehouse.hireDriver("Generic Driver", 10.0);
		}
		
		
		retailers.createRetailer("Brilliant Plungers", 1030);
		retailers.createRetailer("Super Chess Boards", 1999);
		retailers.createRetailer("Johnson's Snake Oil", 1738);
		retailers.createRetailer("Sporting Goods Unlimited", 6969);
		retailers.createRetailer("Chinesium Junk", 25000);
		retailers.createRetailer("DOOFAFO's Amazon Store", 13405);
		
		
		while (inConsumer == true)
		{
			System.out.println("Please enter command. For list of commands, type \"help\"");
			
			userInput = scnr.next();
			
			switch(userInput)
			{
			case "exit":
				System.out.println("You have left the Consumer mode");
				inConsumer = false;
				break;
				
			case "help":
				System.out.println("Here is a list of commands");
				scnr.next();
				break;
				
			case "Wait":
				retailers.testMonthly(warehouse);
				warehouse.shipAll();
				warehouse.deliverItems();
				scnr.next();
				break;
				
			case "Ship":
				System.out.println("Please enter box weight");
				double weight = 0.0;
				double destination = 0.0;
				
				
				try
				{
					weight = scnr.nextDouble();
				}
				catch(InputMismatchException exception)
				{
					System.out.println("Please enter a number");
					scnr.next();
				}
				System.out.println("Please enter distance to destination");
				
				try
				{
					destination = scnr.nextDouble();
				}
				catch(InputMismatchException exception)
				{
					System.out.println("Please enter a number");
					scnr.next();
				}
	
				warehouse.addBox(warehouse, "Consumer", weight, destination);
				warehouse.shipConsumerBox();
				scnr.next();
				
			default:
				System.out.println("Command not found. Type \"help\" for a list of commands");
			}
			scnr.next();
			
		
		}
		
	}
}
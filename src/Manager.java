import java.util.Scanner;
import java.util.InputMismatchException;

public class Manager {
	
	private boolean inProgram = true;
	

	
	Retailers retailers = new Retailers();
	
	Warehouse warehouse = new Warehouse("Generic Warehouse", 100000);
	
	
	private String userInput;
	
	public Manager()
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
		
		System.out.println("Please enter command. For list of commands, type \"help\"");
		while (inProgram == true)
		{
			Scanner scnr = new Scanner(System.in);
			Scanner scnr2 = new Scanner(System.in);
		
			userInput = scnr.nextLine();
			userInput = userInput.toLowerCase();
			
			
			switch(userInput)
			{
			case "exit":
				System.out.println("You have left the Manager mode");
				inProgram = false;
				break;
				
			case "help":
				System.out.println("Here is a list of commands\n\n" + "help\tShows list of available commands\n" + "exit\tExits the program\n" + "wait\tAllows the program to run for 1 month\n" + "ship\tShips a new box to the default warehouse\n");
				
				break;
				
			case "wait":
				retailers.testMonthly(warehouse);
				warehouse.shipAll();
				warehouse.deliverItems();
		
				break;
				
			case "ship":
				System.out.println("Please enter box weight");
				double weight = 0.0;
				double destination = 0.0;
				
				
				try
				{
					weight = scnr2.nextDouble();
				}
				catch(InputMismatchException exception)
				{
					System.out.println("Please enter a number");
				}
				System.out.println("Please enter distance to destination");
				
				try
				{
					destination = scnr2.nextDouble();
				}
				catch(InputMismatchException exception)
				{
					System.out.println("Please enter a number");
				}
	
				warehouse.addBox(warehouse, "Manager", weight, destination);
				
				break;
				
			default:
					System.out.println("Command not found. Type \"help\" for a list of commands");
			}
		
		}
		
	}
}
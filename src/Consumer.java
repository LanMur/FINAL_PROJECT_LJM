import java.util.Scanner;
import java.util.InputMismatchException;

public class Consumer {
	
	private boolean inProgram = true;
	

	
	Retailers retailers = new Retailers();
	
	Warehouse warehouse = new Warehouse("Generic Warehouse", 100000);
	
	
	private String userInput;
	
	/**
	 * 
	 */
	public Consumer()
	{
		//adds vehicles and drivers to the warehouse
		for (int i = 0; i < 250; i++)
		{
			warehouse.addVehicle(3500, 60);
			warehouse.hireDriver("Generic Driver", 10.0);
		}
		
		//creates various retailers that will send boxes to the default warehouse
		retailers.createRetailer("Brilliant Plungers", 1030);
		retailers.createRetailer("Super Chess Boards", 1999);
		retailers.createRetailer("Johnson's Snake Oil", 1738);
		retailers.createRetailer("Sporting Goods Unlimited", 6969);
		retailers.createRetailer("Chinesium Junk", 25000);
		retailers.createRetailer("DOOFAFO's Amazon Store", 13405);
		
		//starts accepting inputs from user
		System.out.println("Please enter command. For list of commands, type \"help\"");
		while (inProgram == true)
		{
			Scanner scnr = new Scanner(System.in);
			Scanner scnr2 = new Scanner(System.in);
		
			//takes in a new input from the user and converts it to lower case
			userInput = scnr.nextLine();
			userInput = userInput.toLowerCase();
			
			//switch statement based on what the user has input
			switch(userInput)
			{
			
			//exits the program
			case "exit":
				System.out.println("You have left the program");
				inProgram = false;
				break;
				
			//prints a list of all available commands and their descriptions
			case "help":
				System.out.println("Here is a list of commands\n\n" + "help\tShows list of available commands\n" + "exit\tExits the program\n" + "wait\tAllows the program to run for 1 month\n" + "ship\tShips a new box to the default warehouse\nship animal\tShips a new box containing an animal to the default warehouse\n");
				
				break;
			
			//allows the program to simulate one month of activity in the warehouse
			case "wait":
				retailers.testMonthly(warehouse);
				warehouse.shipAll();
				warehouse.deliverItems();
		
				break;
				
			//Lets the user ship a box with specified destination and weight.
			case "ship":
				
				double weight = 0.0;
				double destination = 0.0;
				
				//user inputs weight of the box
				System.out.println("Please enter box weight");
				while(true)
				{
					try
					{
						weight = scnr2.nextDouble();
						break;
					}
					catch(InputMismatchException exception)
					{
						System.out.println("Please enter a number");
						scnr2.next();
					}
				}
				
				//user inputs the distance of the box to the destination
				System.out.println("Please enter distance to destination");
				
				while(true)
				{
					try
					{
						destination = scnr2.nextDouble();
						break;
					}
					catch(InputMismatchException exception)
					{
						System.out.println("Please enter a number");
						scnr2.next();
					}
				}
				
				//box is added to warehouse and shipped
				warehouse.addBox(warehouse, "Consumer", weight, destination);
				warehouse.shipConsumerBox();
				
				break;
			
			//lets the user ship a box containing a live animal
			case "ship animal":
				
				double animalWeight = 0.0;
				double animalDestination = 0.0;
				String animalName = "";
				int maxBoxTime = 0;
				
				//user inputs weight of the box
				System.out.println("Please enter box weight");
				
				while(true)
				{
					try
					{
						animalWeight = scnr2.nextDouble();
						break;
					}
					catch(InputMismatchException exception)
					{
						System.out.println("Please enter a number");
						scnr2.next();
					}
				}
				
				//user inputs the distance of the box to the destination
				System.out.println("Please enter distance to destination");
				
				while(true)
				{
					try
					{
						animalDestination = scnr2.nextDouble();
						break;
					}
					catch(InputMismatchException exception)
					{
						System.out.println("Please enter a number");
						scnr2.next();
					}
				}
				
				//user inputs the animals name
				System.out.println("Please enter animal's name");
				while(true)
				{
					try
					{
						animalName = scnr2.next();
						break;
					}
					catch(InputMismatchException exception)
					{
						System.out.println("Please enter animal Name");
					}
				}
				
				//user inputs the max time the animal is allowed in the box
				System.out.println("Please enter max time (in days) animal is allowed in box");
				
				while(true)
				{
					try
					{
						maxBoxTime = scnr2.nextInt();
						break;
					}
					catch(InputMismatchException exception)
					{
						System.out.println("Please enter a whole number");
						scnr2.next();
					}
				}
				
				//the animal and box is added to the warehouse and shipped
				warehouse.addAnimal(warehouse, "Consumer", animalWeight, animalDestination, animalName, maxBoxTime);
				warehouse.shipConsumerBox();
				
				break;
				
			//message plays if no command matches the user input
			default:
					System.out.println("Command not found. Type \"help\" for a list of commands");
			}
		
		}
		
	}
}
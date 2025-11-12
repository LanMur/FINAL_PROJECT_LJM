import java.util.Scanner;

public class Manager {
	
	private boolean inManager = true;
	Scanner scnr = new Scanner(System.in);
	
	
	
	private String userInput;
	
	public Manager()
	{
		while (inManager == true)
		{
			System.out.println("Please enter command. For list of commands, type \"help\"");
			
			userInput = scnr.next();
			
			switch(userInput)
			{
			case "exit":
				System.out.println("You have left the Manager");
				inManager = false;
				break;
				
			case "help":
				System.out.println("Here is a list of commands");
				break;
				
			default:
				System.out.println("A switch case error has occurred");
			}
		
		}
		
	}
}

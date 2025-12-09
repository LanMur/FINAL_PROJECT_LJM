import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scnr = new Scanner(System.in);
		
		Retailers retailers = new Retailers();
		
		System.out.println("Would you like to enter the program \"yes\" or \"no\"?");
		
		String userInput;
		boolean inMenu = true;
	
		Consumer consumer;
		
		//user selects which mode the program will run in
		while(inMenu == true)
		{
			userInput = scnr.next();
			userInput = userInput.toLowerCase();
			
			if (userInput.compareTo("yes") == 0 || userInput.compareTo("y") == 0)
			{
				System.out.println("Entered program");
				consumer = new Consumer();
			}
			else if (userInput.compareTo("no") == 0 || userInput.compareTo("n") == 0)
			{
				System.out.println("Have a good day\n");
			}
			
			else
			{
				System.out.println("Please enter either \"yes\" or \"no\"");
			}
			
		}
		
	}

}
